import com.guildedthorn.thornapi.ThornAPI;
import com.guildedthorn.thornapi.requests.bedrock.faction.DeleteBedrockFactionRequest;

public class BedrockFaction {
    
    private static ThornAPI api;
    
    public BedrockFaction(ThornAPI _api) {
        api = _api;
    }
    
    public static void DeleteFaction(String id) {
        DeleteBedrockFactionRequest request = new DeleteBedrockFactionRequest(api);
        request.execute(id);
    }
    
    
}
