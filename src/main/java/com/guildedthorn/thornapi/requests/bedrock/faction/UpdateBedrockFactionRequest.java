package com.guildedthorn.thornapi.requests.bedrock.faction;

import com.guildedthorn.thornapi.ThornAPI;
import com.guildedthorn.thornapi.requests.Request;
import com.guildedthorn.thornapi.responses.Response;
import com.guildedthorn.thornapi.utils.RequestTypes;

import java.util.function.Consumer;

public class UpdateBedrockFactionRequest extends Request {
    
    public UpdateBedrockFactionRequest(ThornAPI api) {
        super(api);

    }
    
    public void execute(Consumer<Response> callback) {
        
        Request request = new Request(getApi())
                .method(RequestTypes.PUT)
                .endpoint("bedrock/factions");
    }
}
