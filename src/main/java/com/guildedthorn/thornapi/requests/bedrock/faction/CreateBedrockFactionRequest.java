package com.guildedthorn.thornapi.requests.bedrock.faction;

import com.guildedthorn.thornapi.ThornAPI;
import com.guildedthorn.thornapi.requests.Request;
import com.guildedthorn.thornapi.responses.Response;
import com.guildedthorn.thornapi.utils.RequestTypes;
import org.json.JSONObject;

public class CreateBedrockFactionRequest extends Request {
    
    private String ID;
    private String name;

    public CreateBedrockFactionRequest(ThornAPI api) {
        super(api);
    }

    public void execute() {
        JSONObject data = new JSONObject()
                .put("id", this.ID)
                .put("name", this.name)
                .put("level", 0)
                .put("xp", 0);
        Request request = new Request(getApi())
                .endpoint("bedrock/users")
                .method(RequestTypes.POST)
                .addBodyData(data);
        request.execute(res -> new Response(this.getApi(), request.getInputStream(), res.getResponseCode()));
    }
    
    public CreateBedrockFactionRequest setID(String id) {
        this.ID = id;
        return this;
    }
    
    public CreateBedrockFactionRequest setName(String name) {
        this.name = name;
        return this;
    }
}