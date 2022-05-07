import com.guildedthorn.thornapi.ThornAPI;
import com.guildedthorn.thornapi.requests.discord.users.UpdateDiscordUserRequest;
import com.guildedthorn.thornapi.responses.Response;
import com.guildedthorn.thornapi.utils.RichPresence;
import org.json.JSONObject;

public final class Discord {
    
    private static ThornAPI api;
    
    public Discord(ThornAPI _api) {
        api = _api;
    }
    
    public static void updateUser(String id, String details, String state, String b1label, String b1url, String b2label, String b2url) {
        UpdateDiscordUserRequest request = new UpdateDiscordUserRequest(api);
        RichPresence presence = new RichPresence();
        request.execute(id, presence);
    } 
    
}
