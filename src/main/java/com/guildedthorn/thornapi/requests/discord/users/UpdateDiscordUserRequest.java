package com.guildedthorn.thornapi.requests.discord.users;

import com.guildedthorn.thornapi.ThornAPI;
import com.guildedthorn.thornapi.requests.Request;
import com.guildedthorn.thornapi.responses.Response;
import com.guildedthorn.thornapi.utils.RequestTypes;
import com.guildedthorn.thornapi.utils.RichPresence;
import org.json.JSONObject;

public class UpdateDiscordUserRequest extends Request {

    public UpdateDiscordUserRequest(ThornAPI api) {
        super(api);
    }
    
    public void execute(String id, RichPresence presence) {
        JSONObject data = new JSONObject()
                .put("id", id)
                .put("details", presence.getDetails())
                .put("state", presence.getState())
                .put("b1label", presence.getButton1Label())
                .put("b1url", presence.getButton1Url())
                .put("b2label", presence.getButton2Url())
                .put("b2url", presence.getButton2Url());
        Request request = new Request(this.getApi())
                .endpoint("discord/users")
                .method(RequestTypes.PUT)
                .addBodyData(data);
        request.execute(res -> new Response(getApi(), getInputStream(), res.getResponseCode()));
    }
}
