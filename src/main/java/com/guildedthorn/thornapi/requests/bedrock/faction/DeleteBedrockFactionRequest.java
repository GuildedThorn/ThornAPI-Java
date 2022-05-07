package com.guildedthorn.thornapi.requests.bedrock.faction;

import com.guildedthorn.thornapi.ThornAPI;
import com.guildedthorn.thornapi.requests.Request;
import com.guildedthorn.thornapi.responses.Response;
import com.guildedthorn.thornapi.utils.RequestTypes;

import java.util.function.Consumer;

public class DeleteBedrockFactionRequest extends Request {
    
    public DeleteBedrockFactionRequest(ThornAPI api) {
        super(api);
    }
    
    public void execute(String id) {
        Request request = new Request(getApi())
                .endpoint("bedrock/factions/{id}")
                .addReplacement("{id}", id)
                .method(RequestTypes.DELETE);
        request.execute(res -> new Response(getApi(), getInputStream(), res.getResponseCode()));
    }
}
