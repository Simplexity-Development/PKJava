package pkjava.httprequests;

import pkjava.PKJava;

import java.net.http.HttpClient;

public abstract class AbstractPKHttpRequest {
    
    public static final HttpClient pkClient = PKJava.getInstance().getPKJavaClient();
    public static final String userAgent = PKJava.getInstance().getUserAgent();
    public static final String pkAPIBase = "https://api.pluralkit.me/v2/";
    public static final String authorization = "Authorization";
    public static final String userAgentHeader = "User-Agent";
    public static final String systems = "systems";
    public static final String settings = "settings";
    public static final String guilds = "guilds";
    public static final String autoproxy = "autoproxy";
    public static final String members = "members";
    public static final String groups = "groups";
    public static final String add = "add";
    public static final String remove = "remove";
    public static final String overwrite = "overwrite";
    public static final String switches = "switches";
    public static final String fronters = "fronters";
    public static final String messages = "messages";
    public static final String guild_id = "guild_id";
    public static final String channel_id = "channel_id";
    public static final String with_members = "with_members";
    public static final String before = "before";
    public static final String limit = "limit";
    
    public static HttpClient getPkClient() {
        return pkClient;
    }
    
    public static String getUserAgent() {
        return userAgent;
    }
}
