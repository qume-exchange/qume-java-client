# PositionsApi

All URIs are relative to *https://api.qume.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**leverageSet**](PositionsApi.md#leverageSet) | **PUT** /positions/{symbol}/leverage | PUT - Edit leverage for a given position

<a name="leverageSet"></a>
# **leverageSet**
> OrderbookLeverageSetResponse leverageSet(body, symbol)

PUT - Edit leverage for a given position

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.PositionsApi;

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

PositionsApi apiInstance = new PositionsApi();
OrderbookLeverageSetRequest body = new OrderbookLeverageSetRequest(); // OrderbookLeverageSetRequest | 
String symbol = "symbol_example"; // String | Contract symbol for the market within which the user holds an isolated margin position
try {
    OrderbookLeverageSetResponse result = apiInstance.leverageSet(body, symbol);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PositionsApi#leverageSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**OrderbookLeverageSetRequest**](OrderbookLeverageSetRequest.md)|  |
 **symbol** | [**String**](.md)| Contract symbol for the market within which the user holds an isolated margin position |

### Return type

[**OrderbookLeverageSetResponse**](OrderbookLeverageSetResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)[PassPhraseKey](../README.md#PassPhraseKey)[SignatureKey](../README.md#SignatureKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

