# OrdersApi

All URIs are relative to *https://api.qume.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addOrder**](OrdersApi.md#addOrder) | **POST** /orders | POST - Places an order
[**cancelOrder**](OrdersApi.md#cancelOrder) | **PUT** /orders/{orderId} | PUT - Cancels an active order
[**getOrder**](OrdersApi.md#getOrder) | **GET** /orders/{orderId} | GET - Returns the status of a given order
[**getOrdersForUser**](OrdersApi.md#getOrdersForUser) | **GET** /orders | GET - Returns all active orders for user

<a name="addOrder"></a>
# **addOrder**
> OrderbookAddOrderResponse addOrder(body)

POST - Places an order

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OrdersApi;

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

OrdersApi apiInstance = new OrdersApi();
OrderbookAddOrderRequest body = new OrderbookAddOrderRequest(); // OrderbookAddOrderRequest | Order fields
try {
    OrderbookAddOrderResponse result = apiInstance.addOrder(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrdersApi#addOrder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**OrderbookAddOrderRequest**](OrderbookAddOrderRequest.md)| Order fields |

### Return type

[**OrderbookAddOrderResponse**](OrderbookAddOrderResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)[PassPhraseKey](../README.md#PassPhraseKey)[SignatureKey](../README.md#SignatureKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="cancelOrder"></a>
# **cancelOrder**
> OrderbookCancelOrderResponse cancelOrder(orderId)

PUT - Cancels an active order

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OrdersApi;

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

OrdersApi apiInstance = new OrdersApi();
String orderId = "orderId_example"; // String | The unique ID of the order
try {
    OrderbookCancelOrderResponse result = apiInstance.cancelOrder(orderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrdersApi#cancelOrder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | [**String**](.md)| The unique ID of the order |

### Return type

[**OrderbookCancelOrderResponse**](OrderbookCancelOrderResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)[PassPhraseKey](../README.md#PassPhraseKey)[SignatureKey](../README.md#SignatureKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getOrder"></a>
# **getOrder**
> OrderbookGetOrderResponse getOrder(orderId)

GET - Returns the status of a given order

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OrdersApi;

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

OrdersApi apiInstance = new OrdersApi();
String orderId = "orderId_example"; // String | The unique ID of the order
try {
    OrderbookGetOrderResponse result = apiInstance.getOrder(orderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrdersApi#getOrder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | [**String**](.md)| The unique ID of the order |

### Return type

[**OrderbookGetOrderResponse**](OrderbookGetOrderResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)[PassPhraseKey](../README.md#PassPhraseKey)[SignatureKey](../README.md#SignatureKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getOrdersForUser"></a>
# **getOrdersForUser**
> OrderbookOrdersForUserResponse getOrdersForUser()

GET - Returns all active orders for user

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.OrdersApi;

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

OrdersApi apiInstance = new OrdersApi();
try {
    OrderbookOrdersForUserResponse result = apiInstance.getOrdersForUser();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrdersApi#getOrdersForUser");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**OrderbookOrdersForUserResponse**](OrderbookOrdersForUserResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)[PassPhraseKey](../README.md#PassPhraseKey)[SignatureKey](../README.md#SignatureKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

