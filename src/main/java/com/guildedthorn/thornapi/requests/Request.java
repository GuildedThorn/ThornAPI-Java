package com.guildedthorn.thornapi.requests;

import com.guildedthorn.thornapi.ThornAPI;
import com.guildedthorn.thornapi.responses.Response;
import com.guildedthorn.thornapi.utils.RequestTypes;
import org.json.JSONObject;

import java.io.IOException;;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer; 

public class Request {
    
    private final ThornAPI api;

    private String url;

    private JSONObject bodyData;
    
    private RequestTypes method;
    
    private InputStream inputStream;

    private final Map<String, String> arguments =
            new HashMap<>();
    
    private final Map<String, String> replacements =
            new HashMap<>();
    
    public Request(ThornAPI api) {
        this.api = api;
    }

    public Request endpoint(String endpoint) {
        this.url = ThornAPI.ENDPOINT_URL + endpoint;
        return this;
    }

    public Request method(RequestTypes method) {
        this.method = method;
        return this;
    }

    public Request addArgument(String key, String value) {
        this.arguments.put(key, value);
        return this;
    }
    
    public Request addReplacement(String key, String value) {
        this.replacements.put(key, value);
        return this;
    }
    
    public Request addBodyData(JSONObject data) {
        this.bodyData = data;
        return this;
    }
    
    public void execute(Consumer<Response> callback) {
        try {
            URL url = this.buildUrl();
            if (url == null) {
                callback.accept(null);
                return;
            }
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(this.method.toString());
            connection.setRequestProperty("Content-Type","application/json");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", this.api.getBearerToken());
            
            if (Objects.equals(connection.getRequestMethod(), RequestTypes.POST.toString())) {
                if (!this.bodyData.isEmpty()) {
                    OutputStream os = connection.getOutputStream();
                    os.write(this.bodyData.toString().getBytes(), 0, this.bodyData.toString().getBytes().length);
                }
            }
            Response response = new Response(this.api, connection.getInputStream(), connection.getResponseCode());
            callback.accept(response);
            inputStream = connection.getInputStream();
            connection.disconnect();
        } catch (IOException e) {
            callback.accept(new Response(this.api, InputStream.nullInputStream(), 404));
        }
    }
    
    private URL buildUrl() {
        try {
            boolean firstArguement = true;
            StringBuilder builder = new StringBuilder(this.url);
            for (Map.Entry<String, String> entry : this.arguments.entrySet()) {
                if (firstArguement) {
                    builder.append("?");
                    firstArguement = false;
                } else builder.append("&");
                builder.append(entry.getKey()).append("=").append(entry.getValue());
            }
            var update = "";
            for (Map.Entry<String, String> entry : this.replacements.entrySet()) {
                update = url.replace(entry.getKey(), entry.getValue());
            }
            return new URL(!update.isEmpty() ? update : builder.toString());
        } catch (MalformedURLException e) {e.printStackTrace();}
        return null;
    }
    
    public ThornAPI getApi() {
        return this.api;
    }
    
    public InputStream getInputStream() {
        return this.inputStream;
    }
}
