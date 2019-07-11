# OrderbookOrder

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ts** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**id** | **String** |  |  [optional]
**price** | **String** |  |  [optional]
**qty** | **String** | Remaining unfilled quantity of order. For an order_new action, this value always equals the original placed quantity: if the order is partially/completely filled immediately, a subsequent order_change/order_delete action will be included in the same OrderbookUpdate indicating the order&#x27;s resting state. |  [optional]
**userId** | **String** |  |  [optional]
**asset** | **String** |  |  [optional]
**symbol** | **String** |  |  [optional]
**side** | [**OrderbookSide**](OrderbookSide.md) |  |  [optional]
**originalQty** | **String** |  |  [optional]
**type** | [**OrderbookOrderType**](OrderbookOrderType.md) |  |  [optional]
**timeInForce** | [**OrderbookTimeInForce**](OrderbookTimeInForce.md) |  |  [optional]
**postOnly** | **Boolean** |  |  [optional]
**triggerType** | [**OrderbookStopOrderTrigger**](OrderbookStopOrderTrigger.md) |  |  [optional]
**triggerPrice** | **String** |  |  [optional]
