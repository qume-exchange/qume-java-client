/*
 * Qume Sandbox API Documentation
 *  # Overview > Qume provides APIs for accessing exchange features programmatically. By querying REST endpoints and/or connecting to WebSocket channels, developers can implement custom trading systems in any programming language capable of managing HTTP requests.  Authenticated REST endpoints are used for transactional operations, such as:   - Placing and cancelling orders   - Managing positions   - Querying historical data   - Modifying leverage  WebSocket channels provide real-time streams of information, including:   - *Level-1* and *Level-2* order book data   - Market statistics  # REST API ## Creating an API Key To use the REST API, you must generate a pair of unique API keys on the “Accounts” page of the sandbox website. Your *Public Key, Secret Key*, and *Passphrase* only appear once, so make sure they are safely stored before exiting the page.  Example key generation output:    - *Public Key*: ```“d284cb87-0b27-47f9-a82d-c43173ea7c87”```   - *Secret Key*: ```“9ed4c73db9abae81d72f53e14cc4e842”```   - *Passphrase*: ```“example_passphrase”```  ## Authentication Headers REST operations all require authentication. To authenticate a request, you must supply four HTTP headers:    - ```X-QUME-SIGNATURE```: See [Generate Authentication String](#/introduction/rest-api/generate-authentication-string).   - ```X-QUME-TIMESTAMP```: The Unix timestamp (also called Unix epoch or Unix time) in milliseconds. The server will deny requests with a timestamp that is more than 10 seconds old.   - ```X-QUME-PASSPHRASE```: The unique passphrase that you chose in order to generate your API keys.   - ```X-QUME-API-KEY```: Your Public API Key.  ## Generate Authentication String In order to generate ```X-QUME-SIGNATURE```, you must perform the following steps:    1. Concatenate *request body + Unix timestamp + path*.        <br>        *Example Output*: ```{“foo”:”bar”}1538524732000/v1/orders```        <br>    3. Generate a HMAC-SHA-256 using the result from step 1 and your API Secret Key.   4. Hex-encode the output.    **NOTES**   - All request bodies should be valid JSON with content type ```application/json```   - If the request body is ```{}```, treat it as an empty string   - Include the ```/v1``` prefix in the path   - The Unix timestamp must be in milliseconds  ## Example A shell script for placing a limit order via REST with authentication:    ```   #!/bin/bash   pubkey=\"$YOUR_PUBLIC_API_KEY_HERE\"   privkey=\"$YOUR_PRIVATE_API_KEY_HERE\"   pass=\"$YOUR_API_KEY_PASSPHRASE_HERE\"    timestamp=\"$(($(date +'%s') * 1000))\"   body='{ \"symbol\": \"BTCUSDQ\", \"side\": \"BUY\", \"qty\": 100, \"price\": 1000.00, \"type\": \"LIMIT\", \"TimeInForce\": \"UNTIL_CANCEL\", \"PostOnly\": false }'   path='/v1/orders'    message=$(printf '%s%s%s' \"$body\" \"$timestamp\" \"$path\")    sig=$(printf '%s' \"$message\" | openssl dgst -sha256 -hmac \"$privkey\" -binary | od -A n -t x1 | tr -d '\\n ')    curl \"https://api.qume.io${path}\"     -H \"Content-Type: application/json\"     -H \"X-QUME-API-KEY: ${pubkey}\"     -H \"X-QUME-SIGNATURE: ${sig}\"     -H \"X-QUME-TIMESTAMP: ${timestamp}\"     -H \"X-QUME-PASSPHRASE: ${pass}\"     -d \"$body\"   ```   # WebSockets > Subscribe to real-time data streams (“topics”) ## Subscribe   To subscribe to a topic, simply open a websocket connection to ```wss://websocket.qume.io/public``` then send a message specifying the desired topic.    - *Example subscription message*: ```{ \"topic\" : \"l2/BTCUSDQ\" }```    To unsubscribe, simply close the websocket connection.  ## Topics ### Level-1 (Ticker) Publishes a message every time a new trade occurs.  *Topic Name:* ```l1/BTCUSDQ```  Example message:    ```   {     \"TopicName\": \"l1/BTCUSDQ\",     \"Message\": {       \"Symbol\": \"BTCUSDQ\",       \"Qty\": 4,       \"Price\": 25954,       \"Ts\": {         \"seconds\": 1552098314,         \"nanos\": 834534238       }     }   }   ```   ### Level-2 (Orderbook) Publishes a new message when the order book changes. Each message contains the top-50 price levels on each side of the order book.  *Topic name*: ```l2/BTCUSDQ```  Example message:    ```   {     \"TopicName\": \"l2/BTCUSDQ\",     \"Message\": {       \"MarketId\": \"BTCUSDQ\",       \"Buys\": [{\"Price\" : 300, \"Size\" : 1}, ...],       \"Sells\": [{\"Price\" : 310, \"Size\" : 4}, ...]     }   }   ```   ### Market Statistics Streams various market statistics.  *Topic name*: ```stats/BTCUSDQ```  Example message:    ```   {     \"TopicName\": \"stats/BTCUSDQ\",     \"Message\": {       \"Symbol\": \"BTCUSDQ\",       \"Price\": 300,       \"High\": 350,       \"Low\": 250,       \"Change\": 25,       \"Volume\": 2     }   }   ```
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;

/**
 * PricesGetCurrentMarkPriceResponse
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-04T14:35:49.897-03:00[America/Sao_Paulo]")public class PricesGetCurrentMarkPriceResponse {

  @SerializedName("markPrice")
  private Double markPrice = null;
  public PricesGetCurrentMarkPriceResponse markPrice(Double markPrice) {
    this.markPrice = markPrice;
    return this;
  }

  

  /**
  * Get markPrice
  * @return markPrice
  **/
  @Schema(description = "")
  public Double getMarkPrice() {
    return markPrice;
  }
  public void setMarkPrice(Double markPrice) {
    this.markPrice = markPrice;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PricesGetCurrentMarkPriceResponse pricesGetCurrentMarkPriceResponse = (PricesGetCurrentMarkPriceResponse) o;
    return Objects.equals(this.markPrice, pricesGetCurrentMarkPriceResponse.markPrice);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(markPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricesGetCurrentMarkPriceResponse {\n");
    
    sb.append("    markPrice: ").append(toIndentedString(markPrice)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
