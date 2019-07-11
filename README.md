# swagger-java-client

Qume Sandbox API Documentation
- API version: 1.0
  - Build date: 2019-04-04T14:35:49.897-03:00[America/Sao_Paulo]

# Overview 

Qume provides APIs for accessing exchange features programmatically. By querying REST endpoints and/or connecting to 
WebSocket channels, developers can implement custom trading systems in any programming language capable of managing 
HTTP requests. 


Authenticated REST endpoints are used for transactional operations, such as:   

- Placing and cancelling orders   
- Managing positions   
- Querying historical data   
- Modifying leverage  

WebSocket channels provide real-time streams of information, including:   

- *Level-1* and *Level-2* order book data   
- Market statistics  


# REST API 

## Creating an API Key 

To use the REST API, you must generate a pair of unique API keys on the “Accounts” page of the sandbox website. 
Your *Public Key, Secret Key*, and *Passphrase* only appear once, so make sure they are safely stored before exiting the page.  

Example key generation output:    

- *Public Key*: ```“d284cb87-0b27-47f9-a82d-c43173ea7c87”```   
- *Secret Key*: ```“9ed4c73db9abae81d72f53e14cc4e842”```  
- *Passphrase*: ```“example_passphrase”```  

## Authentication Headers 

REST operations all require authentication. To authenticate a request, you must supply four HTTP headers:    

- ```X-QUME-SIGNATURE```: See [Generate Authentication String](#/introduction/rest-api/generate-authentication-string).   
- ```X-QUME-TIMESTAMP```: The Unix timestamp (also called Unix epoch or Unix time) in milliseconds. The server will deny requests with a timestamp that is more than 10 seconds old.   
- ```X-QUME-PASSPHRASE```: The unique passphrase that you chose in order to generate your API keys.   
- ```X-QUME-API-KEY```: Your Public API Key.  

## Generate Authentication String 

In order to generate ```X-QUME-SIGNATURE```, you must perform the following steps:    

1. Concatenate *request body + Unix timestamp + path*.        <br>        *Example Output*: ```{“foo”:”bar”}1538524732000/v1/orders```        <br>    
1. Generate a HMAC-SHA-256 using the result from step 1 and your API Secret Key.   
1. Hex-encode the output.    

**NOTES**
 
- All request bodies should be valid JSON with content type ```application/json```   
- If the request body is ```{}```, treat it as an empty string   
- Include the ```/v1``` prefix in the path   
- The Unix timestamp must be in milliseconds  


## Example 

A shell script for placing a limit order via REST with authentication:    

```   
#!/bin/bash   

pubkey=\"$YOUR_PUBLIC_API_KEY_HERE\"   
privkey=\"$YOUR_PRIVATE_API_KEY_HERE\"   
pass=\"$YOUR_API_KEY_PASSPHRASE_HERE\"    
timestamp=\"$(($(date +'%s') * 1000))\"   

body='{ \"symbol\": \"BTCUSDQ\", \"side\": \"BUY\", \"qty\": 100, \"price\": 1000.00, \"type\": \"LIMIT\", \"TimeInForce\": \"UNTIL_CANCEL\", \"PostOnly\": false }'   
path='/v1/orders'   

message=$(printf '%s%s%s' \"$body\" \"$timestamp\" \"$path\")    

sig=$(printf '%s' \"$message\" | openssl dgst -sha256 -hmac \"$privkey\" -binary | od -A n -t x1 | tr -d '\\n ')    

curl \"https://api.qume.io${path}\"     
-H \"Content-Type: application/json\"    
-H \"X-QUME-API-KEY: ${pubkey}\"     
-H \"X-QUME-SIGNATURE: ${sig}\"     
-H \"X-QUME-TIMESTAMP: ${timestamp}\"     
-H \"X-QUME-PASSPHRASE: ${pass}\"     
-d \"$body\"   
```   

# WebSockets 
 
> Subscribe to real-time data streams (“topics”) 

## Subscribe   

To subscribe to a topic, simply open a websocket connection to ```wss://websocket.qume.io/public``` then send a message specifying the desired topic.    

- *Example subscription message*: ```{ \"topic\" : \"l2/BTCUSDQ\" }```    

To unsubscribe, simply close the websocket connection.  

## Topics 

### Level-1 (Ticker) 

Publishes a message every time a new trade occurs.  

*Topic Name:* ```l1/BTCUSDQ```  

Example message:    
```   
{     \"TopicName\": 
        \"l1/BTCUSDQ\",     
            \"Message\": {       
                \"Symbol\": \"BTCUSDQ\",       
                \"Qty\": 4,       
                \"Price\": 25954,      
                 \"Ts\": {         
                    \"seconds\": 1552098314,         
                    \"nanos\": 834534238       
                    }     
                }   
            }   
   ```   
   
### Level-2 (Orderbook) 

Publishes a new message when the order book changes. Each message contains the top-50 price levels on each side of the order book.  

*Topic name*: ```l2/BTCUSDQ```  
Example message:    
```   
{
    \"TopicName\": \"l2/BTCUSDQ\",     
    \"Message\": {       
        \"MarketId\": \"BTCUSDQ\",       
        \"Buys\": [{\"Price\" : 300, \"Size\" : 1}, ...],       
        \"Sells\": [{\"Price\" : 310, \"Size\" : 4}, ...]     }   }   
  ```   
    
### Market Statistics 
  
Streams various market statistics. 

*Topic name*: ```stats/BTCUSDQ```  
Example message:    
```   
{     
\"TopicName\": \"stats/BTCUSDQ\",     
\"Message\": {       
    \"Symbol\": \"BTCUSDQ\",       
    \"Price\": 300,       
    \"High\": 350,       
    \"Low\": 250,       
    \"Change\": 25,       
    \"Volume\": 2     
    }   
}   
```

*Automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>io.swagger</groupId>
  <artifactId>swagger-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/swagger-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.InstrumentsApi;

import java.io.File;
import java.util.*;

public class InstrumentsApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        InstrumentsApi apiInstance = new InstrumentsApi();
        try {
            OrderbookGetAllMarketStatsResponse result = apiInstance.getAllMarketStats();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InstrumentsApi#getAllMarketStats");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.InstrumentsApi;

import java.io.File;
import java.util.*;

public class InstrumentsApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure API key authorization: PassPhraseKey
        ApiKeyAuth PassPhraseKey = (ApiKeyAuth) defaultClient.getAuthentication("PassPhraseKey");
        PassPhraseKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //PassPhraseKey.setApiKeyPrefix("Token");

        // Configure API key authorization: SignatureKey
        ApiKeyAuth SignatureKey = (ApiKeyAuth) defaultClient.getAuthentication("SignatureKey");
        SignatureKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //SignatureKey.setApiKeyPrefix("Token");

        InstrumentsApi apiInstance = new InstrumentsApi();
        String symbol = "symbol_example"; // String | Contract symbol (i.e. BTCUSDQ)
        try {
            PricesGetCurrentIndexPriceResponse result = apiInstance.getCurrentIndexPrice(symbol);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InstrumentsApi#getCurrentIndexPrice");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.InstrumentsApi;

import java.io.File;
import java.util.*;

public class InstrumentsApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        // Configure API key authorization: PassPhraseKey
        ApiKeyAuth PassPhraseKey = (ApiKeyAuth) defaultClient.getAuthentication("PassPhraseKey");
        PassPhraseKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //PassPhraseKey.setApiKeyPrefix("Token");

        // Configure API key authorization: SignatureKey
        ApiKeyAuth SignatureKey = (ApiKeyAuth) defaultClient.getAuthentication("SignatureKey");
        SignatureKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //SignatureKey.setApiKeyPrefix("Token");

        InstrumentsApi apiInstance = new InstrumentsApi();
        String symbol = "symbol_example"; // String | Contract symbol (i.e. BTCUSDQ)
        try {
            PricesGetCurrentMarkPriceResponse result = apiInstance.getCurrentMarkPrice(symbol);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InstrumentsApi#getCurrentMarkPrice");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.InstrumentsApi;

import java.io.File;
import java.util.*;

public class InstrumentsApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        InstrumentsApi apiInstance = new InstrumentsApi();
        String symbol = "symbol_example"; // String | Contract symbol (i.e. BTCUSDQ)
        try {
            PricesGetFundingRateResponse result = apiInstance.getFundingRate(symbol);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InstrumentsApi#getFundingRate");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.InstrumentsApi;

import java.io.File;
import java.util.*;

public class InstrumentsApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        InstrumentsApi apiInstance = new InstrumentsApi();
        String symbol = "symbol_example"; // String | Contract symbol (i.e. BTCUSDQ)
        try {
            MarketGetMarketResponse result = apiInstance.getMarket(symbol);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InstrumentsApi#getMarket");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.InstrumentsApi;

import java.io.File;
import java.util.*;

public class InstrumentsApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: ApiKey
        ApiKeyAuth ApiKey = (ApiKeyAuth) defaultClient.getAuthentication("ApiKey");
        ApiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //ApiKey.setApiKeyPrefix("Token");

        InstrumentsApi apiInstance = new InstrumentsApi();
        String symbol = "symbol_example"; // String | Contract symbol (i.e. BTCUSDQ)
        try {
            OrderbookGetOrdersForMarketResponse result = apiInstance.getOrdersForMarket(symbol);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InstrumentsApi#getOrdersForMarket");
            e.printStackTrace();
        }
    }
}
```

## Documentation for API Endpoints

All URIs are relative to *https://api.qume.io/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*InstrumentsApi* | [**getAllMarketStats**](docs/InstrumentsApi.md#getAllMarketStats) | **GET** /instruments | GET - Returns all contracts
*InstrumentsApi* | [**getCurrentIndexPrice**](docs/InstrumentsApi.md#getCurrentIndexPrice) | **GET** /instruments/{symbol}/indexPrice | GET - Returns the index price for a given contract
*InstrumentsApi* | [**getCurrentMarkPrice**](docs/InstrumentsApi.md#getCurrentMarkPrice) | **GET** /instruments/{symbol}/markPrice | GET - Returns the mark price for a given contract
*InstrumentsApi* | [**getFundingRate**](docs/InstrumentsApi.md#getFundingRate) | **GET** /instruments/{symbol}/fundingRate | GET - Returns the instantaneous funding rate for a given contract
*InstrumentsApi* | [**getMarket**](docs/InstrumentsApi.md#getMarket) | **GET** /instruments/{symbol} | GET - Returns market statistics for a given contract
*InstrumentsApi* | [**getOrdersForMarket**](docs/InstrumentsApi.md#getOrdersForMarket) | **GET** /instruments/{symbol}/orderbook | GET - Returns open orders for a given contract
*OrdersApi* | [**addOrder**](docs/OrdersApi.md#addOrder) | **POST** /orders | POST - Places an order
*OrdersApi* | [**cancelOrder**](docs/OrdersApi.md#cancelOrder) | **PUT** /orders/{orderId} | PUT - Cancels an active order
*OrdersApi* | [**getOrder**](docs/OrdersApi.md#getOrder) | **GET** /orders/{orderId} | GET - Returns the status of a given order
*OrdersApi* | [**getOrdersForUser**](docs/OrdersApi.md#getOrdersForUser) | **GET** /orders | GET - Returns all active orders for user
*PositionsApi* | [**leverageSet**](docs/PositionsApi.md#leverageSet) | **PUT** /positions/{symbol}/leverage | PUT - Edit leverage for a given position
*TradesApi* | [**getTradesForUser**](docs/TradesApi.md#getTradesForUser) | **GET** /trades | GET - Returns all historical trades for user
*WalletsApi* | [**getPositionsByUser**](docs/WalletsApi.md#getPositionsByUser) | **GET** /wallets/{asset}/positions | GET - For a given asset, returns all positions for which margin is posted in that asset
*WalletsApi* | [**getWalletByUser**](docs/WalletsApi.md#getWalletByUser) | **GET** /wallets/{asset} | GET - Returns the balance for a given asset in user&#x27;s wallet
*WalletsApi* | [**getWallets**](docs/WalletsApi.md#getWallets) | **GET** /wallets | GET - Returns all wallets for user

## Documentation for Models

 - [MarketGetMarketResponse](docs/MarketGetMarketResponse.md)
 - [MarketMarket](docs/MarketMarket.md)
 - [OrderbookAddOrderRequest](docs/OrderbookAddOrderRequest.md)
 - [OrderbookAddOrderResponse](docs/OrderbookAddOrderResponse.md)
 - [OrderbookCancelOrderResponse](docs/OrderbookCancelOrderResponse.md)
 - [OrderbookGetAllMarketStatsResponse](docs/OrderbookGetAllMarketStatsResponse.md)
 - [OrderbookGetOrderResponse](docs/OrderbookGetOrderResponse.md)
 - [OrderbookGetOrderResponseErrorCode](docs/OrderbookGetOrderResponseErrorCode.md)
 - [OrderbookGetOrdersForMarketResponse](docs/OrderbookGetOrdersForMarketResponse.md)
 - [OrderbookGetOrdersForMarketResponseErrorCode](docs/OrderbookGetOrdersForMarketResponseErrorCode.md)
 - [OrderbookLeverageSetRequest](docs/OrderbookLeverageSetRequest.md)
 - [OrderbookLeverageSetResponse](docs/OrderbookLeverageSetResponse.md)
 - [OrderbookMarketStats](docs/OrderbookMarketStats.md)
 - [OrderbookOrder](docs/OrderbookOrder.md)
 - [OrderbookOrderType](docs/OrderbookOrderType.md)
 - [OrderbookOrdersForUserResponse](docs/OrderbookOrdersForUserResponse.md)
 - [OrderbookOrdersForUserResponseErrorCode](docs/OrderbookOrdersForUserResponseErrorCode.md)
 - [OrderbookSide](docs/OrderbookSide.md)
 - [OrderbookStopOrderTrigger](docs/OrderbookStopOrderTrigger.md)
 - [OrderbookTimeInForce](docs/OrderbookTimeInForce.md)
 - [OrderbookTrade](docs/OrderbookTrade.md)
 - [OrderbookTradesForUserResponse](docs/OrderbookTradesForUserResponse.md)
 - [OrderbookTradesForUserResponseErrorCode](docs/OrderbookTradesForUserResponseErrorCode.md)
 - [PricesGetCurrentIndexPriceResponse](docs/PricesGetCurrentIndexPriceResponse.md)
 - [PricesGetCurrentMarkPriceResponse](docs/PricesGetCurrentMarkPriceResponse.md)
 - [PricesGetFundingRateResponse](docs/PricesGetFundingRateResponse.md)
 - [PricesValueWithTs](docs/PricesValueWithTs.md)
 - [WalletContract](docs/WalletContract.md)
 - [WalletGetPositionsResponse](docs/WalletGetPositionsResponse.md)
 - [WalletPosition](docs/WalletPosition.md)
 - [WalletPositionMap](docs/WalletPositionMap.md)
 - [WalletWalletState](docs/WalletWalletState.md)
 - [WalletWalletSummary](docs/WalletWalletSummary.md)
 - [WalletWallets](docs/WalletWallets.md)

## Documentation for Authorization

Authentication schemes defined for the API:
### ApiKey

- **Type**: API key
- **API key parameter name**: X-QUME-API-KEY
- **Location**: HTTP header

### PassPhraseKey

- **Type**: API key
- **API key parameter name**: X-QUME-PASSPHRASE
- **Location**: HTTP header

### SignatureKey

- **Type**: API key
- **API key parameter name**: X-QUME-SIGNATURE
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author


