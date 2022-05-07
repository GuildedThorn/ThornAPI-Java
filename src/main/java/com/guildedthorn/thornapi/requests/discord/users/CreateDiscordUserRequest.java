package com.guildedthorn.thornapi.requests.discord.users;

import com.guildedthorn.thornapi.ThornAPI;
import com.guildedthorn.thornapi.requests.Request;
import com.guildedthorn.thornapi.responses.Response;
import com.guildedthorn.thornapi.utils.RequestTypes;
import org.json.JSONObject;

public class CreateDiscordUserRequest extends Request {
    
    private String id;
    
    public CreateDiscordUserRequest(ThornAPI api) {
        super(api);
    }
    
    public void execute() {
        JSONObject data = new JSONObject()
                .put("id", getID());
        Request request = new Request(this.getApi())
                .endpoint("discord/users")
                .method(RequestTypes.POST)
                .addBodyData(data);
        request.execute(res -> new Response(getApi(), getInputStream(), res.getResponseCode()));
    }
    
    private String getID() {
        return this.id;
    }
    
    public CreateDiscordUserRequest setID(String id) {
        this.id = id;
        return this;
    }
    
}
