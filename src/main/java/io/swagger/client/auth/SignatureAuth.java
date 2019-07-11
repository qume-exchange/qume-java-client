package io.swagger.client.auth;

import com.google.gson.Gson;
import com.google.common.base.Strings;
import com.google.common.hash.Hashing;
import io.swagger.client.Pair;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class SignatureAuth extends ApiKeyAuth implements Authentication {

    private Gson gson = new Gson();

    public SignatureAuth(String location, String paramName) {
        super(location, paramName);
    }

    @Override
    public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams, Object body, String path) {

        String timestamp = Long.toString(Timestamp.from(Instant.now()).getTime());
        String message = (body != null ? gson.toJson(body) : "") + timestamp + "/v1" + path;
        String signature = Hashing.hmacSha256(getApiKey().getBytes()).hashString(message, StandardCharsets.UTF_8).toString();

        headerParams.put("X-QUME-TIMESTAMP", timestamp);
        headerParams.put(getParamName(), signature);

    }
}
