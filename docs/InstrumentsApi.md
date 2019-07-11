# InstrumentsApi

All URIs are relative to *https://api.qume.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllMarketStats**](InstrumentsApi.md#getAllMarketStats) | **GET** /instruments | GET - Returns all contracts
[**getCurrentIndexPrice**](InstrumentsApi.md#getCurrentIndexPrice) | **GET** /instruments/{symbol}/indexPrice | GET - Returns the index price for a given contract
[**getCurrentMarkPrice**](InstrumentsApi.md#getCurrentMarkPrice) | **GET** /instruments/{symbol}/markPrice | GET - Returns the mark price for a given contract
[**getFundingRate**](InstrumentsApi.md#getFundingRate) | **GET** /instruments/{symbol}/fundingRate | GET - Returns the instantaneous funding rate for a given contract
[**getMarket**](InstrumentsApi.md#getMarket) | **GET** /instruments/{symbol} | GET - Returns market statistics for a given contract
[**getOrdersForMarket**](InstrumentsApi.md#getOrdersForMarket) | **GET** /instruments/{symbol}/orderbook | GET - Returns open orders for a given contract

<a name="getAllMarketStats"></a>
# **getAllMarketStats**
> OrderbookGetAllMarketStatsResponse getAllMarketStats()

GET - Returns all contracts

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.InstrumentsApi;

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
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**OrderbookGetAllMarketStatsResponse**](OrderbookGetAllMarketStatsResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCurrentIndexPrice"></a>
# **getCurrentIndexPrice**
> PricesGetCurrentIndexPriceResponse getCurrentIndexPrice(symbol)

GET - Returns the index price for a given contract

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.InstrumentsApi;

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **symbol** | [**String**](.md)| Contract symbol (i.e. BTCUSDQ) |

### Return type

[**PricesGetCurrentIndexPriceResponse**](PricesGetCurrentIndexPriceResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)[PassPhraseKey](../README.md#PassPhraseKey)[SignatureKey](../README.md#SignatureKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCurrentMarkPrice"></a>
# **getCurrentMarkPrice**
> PricesGetCurrentMarkPriceResponse getCurrentMarkPrice(symbol)

GET - Returns the mark price for a given contract

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.InstrumentsApi;

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **symbol** | [**String**](.md)| Contract symbol (i.e. BTCUSDQ) |

### Return type

[**PricesGetCurrentMarkPriceResponse**](PricesGetCurrentMarkPriceResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)[PassPhraseKey](../README.md#PassPhraseKey)[SignatureKey](../README.md#SignatureKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getFundingRate"></a>
# **getFundingRate**
> PricesGetFundingRateResponse getFundingRate(symbol)

GET - Returns the instantaneous funding rate for a given contract

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.InstrumentsApi;

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **symbol** | [**String**](.md)| Contract symbol (i.e. BTCUSDQ) |

### Return type

[**PricesGetFundingRateResponse**](PricesGetFundingRateResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMarket"></a>
# **getMarket**
> MarketGetMarketResponse getMarket(symbol)

GET - Returns market statistics for a given contract

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.InstrumentsApi;

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **symbol** | [**String**](.md)| Contract symbol (i.e. BTCUSDQ) |

### Return type

[**MarketGetMarketResponse**](MarketGetMarketResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getOrdersForMarket"></a>
# **getOrdersForMarket**
> OrderbookGetOrdersForMarketResponse getOrdersForMarket(symbol)

GET - Returns open orders for a given contract

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.InstrumentsApi;

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **symbol** | [**String**](.md)| Contract symbol (i.e. BTCUSDQ) |

### Return type

[**OrderbookGetOrdersForMarketResponse**](OrderbookGetOrdersForMarketResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

