# WalletsApi

All URIs are relative to *https://api.qume.io/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPositionsByUser**](WalletsApi.md#getPositionsByUser) | **GET** /wallets/{asset}/positions | GET - For a given asset, returns all positions for which margin is posted in that asset
[**getWalletByUser**](WalletsApi.md#getWalletByUser) | **GET** /wallets/{asset} | GET - Returns the balance for a given asset in user&#x27;s wallet
[**getWallets**](WalletsApi.md#getWallets) | **GET** /wallets | GET - Returns all wallets for user

<a name="getPositionsByUser"></a>
# **getPositionsByUser**
> WalletGetPositionsResponse getPositionsByUser(asset)

GET - For a given asset, returns all positions for which margin is posted in that asset

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WalletsApi;

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

WalletsApi apiInstance = new WalletsApi();
String asset = "asset_example"; // String | The name of the asset (i.e. BTC)
try {
    WalletGetPositionsResponse result = apiInstance.getPositionsByUser(asset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WalletsApi#getPositionsByUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset** | [**String**](.md)| The name of the asset (i.e. BTC) |

### Return type

[**WalletGetPositionsResponse**](WalletGetPositionsResponse.md)

### Authorization

[ApiKey](../README.md#ApiKey)[PassPhraseKey](../README.md#PassPhraseKey)[SignatureKey](../README.md#SignatureKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getWalletByUser"></a>
# **getWalletByUser**
> WalletWalletState getWalletByUser(asset)

GET - Returns the balance for a given asset in user&#x27;s wallet

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WalletsApi;

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

WalletsApi apiInstance = new WalletsApi();
String asset = "asset_example"; // String | The name of the asset (i.e. BTC)
try {
    WalletWalletState result = apiInstance.getWalletByUser(asset);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WalletsApi#getWalletByUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset** | [**String**](.md)| The name of the asset (i.e. BTC) |

### Return type

[**WalletWalletState**](WalletWalletState.md)

### Authorization

[ApiKey](../README.md#ApiKey)[PassPhraseKey](../README.md#PassPhraseKey)[SignatureKey](../README.md#SignatureKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getWallets"></a>
# **getWallets**
> WalletWallets getWallets()

GET - Returns all wallets for user

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WalletsApi;

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

WalletsApi apiInstance = new WalletsApi();
try {
    WalletWallets result = apiInstance.getWallets();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WalletsApi#getWallets");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**WalletWallets**](WalletWallets.md)

### Authorization

[ApiKey](../README.md#ApiKey)[PassPhraseKey](../README.md#PassPhraseKey)[SignatureKey](../README.md#SignatureKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

