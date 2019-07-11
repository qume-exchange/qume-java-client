# TradesApi

All URIs are relative to *https://api.qume.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTradesForUser**](TradesApi.md#getTradesForUser) | **GET** /trades | GET - Returns all historical trades for user

<a name="getTradesForUser"></a>
# **getTradesForUser**
> OrderbookTradesForUserResponse getTradesForUser()

GET - Returns all historical trades for user

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.TradesApi;

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

TradesApi apiInstance = new TradesApi();
try {
    OrderbookTradesForUserResponse result = apiInstance.getTradesForUser();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TradesApi#getTradesForUser");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**OrderbookTradesForUserResponse**](OrderbookTradesForUserResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)[PassPhraseKey](../README.md#PassPhraseKey)[SignatureKey](../README.md#SignatureKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

