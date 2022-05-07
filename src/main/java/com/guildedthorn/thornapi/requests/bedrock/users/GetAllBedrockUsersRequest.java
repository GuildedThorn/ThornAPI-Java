package com.guildedthorn.thornapi.requests.bedrock.users;

import com.guildedthorn.thornapi.ThornAPI;
import com.guildedthorn.thornapi.requests.Request;
import com.guildedthorn.thornapi.responses.Response;
import com.guildedthorn.thornapi.utils.RequestTypes;
import org.json.JSONObject;

import java.util.function.Consumer;

public class GetAllBedrockUsersRequest extends Request {
    
    public GetAllBedrockUsersRequest(ThornAPI api) {
        super(api);
    }
    
    public void execute(JSONObject data) {
        Request request = new Request(getApi())
                .endpoint("bedrock/users")
                .method(RequestTypes.POST)
                .addBodyData(data);
        request.execute(res -> new Response(this.getApi(), request.getInputStream(), res.getResponseCode()));
    }
}
