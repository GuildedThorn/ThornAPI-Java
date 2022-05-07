package com.guildedthorn.thornapi.requests.discord.users;

import com.guildedthorn.thornapi.ThornAPI;
import com.guildedthorn.thornapi.requests.Request;
import com.guildedthorn.thornapi.responses.Response;
import com.guildedthorn.thornapi.utils.RequestTypes;

import java.util.function.Consumer;

public class GetDiscordUserRequest extends Request {

    public GetDiscordUserRequest(ThornAPI api) {
        super(api);
    }

    public void execute(String id) {
       Request request = new Request(getApi())
               .endpoint("discord/users/{id}")
               .method(RequestTypes.GET)
               .addReplacement("{id]", id);
       request.execute(res -> new Response(this.getApi(), request.getInputStream(), res.getResponseCode()));
    }
}
