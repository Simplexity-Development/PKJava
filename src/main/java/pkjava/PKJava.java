package pkjava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import pkjava.messages.MessageInfo;
import pkjava.system.AutoproxySettings;
import pkjava.system.SystemObject;
import pkjava.system.groups.GroupObject;
import pkjava.system.guilds.SystemGuildSettings;
import pkjava.system.member.MemberObject;
import pkjava.system.member.guilds.MemberGuildSettings;
import pkjava.system.settings.SystemSettings;
import pkjava.system.switches.Fronters;
import pkjava.system.switches.Switches;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused") /*Library, this is being used externally*/
public class PKJava {
    private final String pkAPIBase = "https://api.pluralkit.me/v2/";
    private final String authorization = "Authorization";
    private final String userAgentHeader = "User-Agent";
    private final String systems = "systems";
    private final String settings = "settings";
    private final String guilds = "guilds";
    private final String autoproxy = "autoproxy";
    private final String members = "members";
    private final String groups = "groups";
    private final String add = "add";
    private final String remove = "remove";
    private final String overwrite = "overwrite";
    private final String switches = "switches";
    private final String fronters = "fronters";
    private final String messages = "messages";
    private final String guild_id = "guild_id";
    private final String channel_id = "channel_id";
    private final String with_members = "with_members";
    private final String before = "before";
    private final String limit = "limit";
    
    public PKJava() {
        this.initializeDefaultPKJavaClient();
    }
    private HttpClient pkJavaClient;
    private String userAgent;
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .setLenient()
            .create();
    public void initializeDefaultPKJavaClient() {
        HttpClient httpClient = java.net.http.HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        setPkJavaClient(httpClient);
        setUserAgent("PKJava Library - Contact at https://github.com/Simplexity-Development/PKJava/issues");
    }
    public AutoproxySettings requestAutoproxySettings(String authToken, String systemID, String guildID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + autoproxy + "?"
                        + guild_id + "="
                        + guildID))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), AutoproxySettings.class);
    }
    public GroupObject requestGroup(String authToken, String systemID, String groupID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems
                        + systemID + "/"
                        + groups + "/"
                        + groupID))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        return gson.fromJson(responseBody, GroupObject.class);
    }
    
    public List<MemberObject> requestGroupMembers(String authToken, String systemID, String groupID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + groups + "/"
                        + groupID + "/"
                        + members))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type memberObjectListType = new TypeToken<ArrayList<MemberObject>>() {
        }.getType();
        return gson.fromJson(responseBody, memberObjectListType);
    }
    
    public MemberObject requestMember(String authToken, String systemID, String memberID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems
                        + systemID + "/"
                        + members + "/"
                        + memberID))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        return gson.fromJson(responseBody, MemberObject.class);
    }
    
    public List<GroupObject> requestMemberGroups(String authToken, String systemID, String memberID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + members + "/"
                        + memberID + "/"
                        + groups))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type groupObjectListType = new TypeToken<ArrayList<GroupObject>>() {
        }.getType();
        return gson.fromJson(responseBody, groupObjectListType);
    }
    
    public MemberGuildSettings requestMemberGuildSettings(String authToken, String systemID, String memberID, String guildID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + members + "/"
                        + memberID + "/"
                        + guilds + "/"
                        + guildID))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), MemberGuildSettings.class);
    }
    
    public List<MemberObject> requestMembers(String authToken, String systemID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + members))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type memberObjectListType = new TypeToken<ArrayList<MemberObject>>() {
        }.getType();
        return gson.fromJson(responseBody, memberObjectListType);
    }
    
    public MessageInfo requestMessageInfo(String messageID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + messages + "/"
                        + messageID))
                .GET()
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        return gson.fromJson(responseBody, MessageInfo.class);
    }
    
    public SystemObject requestSystem(String authToken, String systemID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), SystemObject.class);
    }
    
    public Fronters requestSystemFronters(String authToken, String systemID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + fronters))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), Fronters.class);
    }
    
    public List<GroupObject> requestSystemGroups(String authToken, String systemID, boolean withMembers) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + groups + "?"
                        + with_members + "="
                        + withMembers))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type groupObjectListType = new TypeToken<ArrayList<GroupObject>>() {
        }.getType();
        return gson.fromJson(responseBody, groupObjectListType);
    }
    
    public SystemGuildSettings requestSystemGuildSettings(String authToken, String systemID, String guildID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + guilds + "/"
                        + guildID))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), SystemGuildSettings.class);
    }
    
    public SystemSettings requestSystemSettings(String authToken, String systemID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + settings))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), SystemSettings.class);
    }
    
    public Switches requestSystemSwitches(String authToken, String systemID, int limit, String timestamp) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + switches + "?"
                        + before + "="
                        + timestamp + "&"
                        + limit + "="
                        + limit))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), Switches.class);
    }
    public HttpClient getPKJavaClient() {
        return pkJavaClient;
    }
    
    public void setPkJavaClient(HttpClient httpClient) {
        pkJavaClient = httpClient;
    }
    
    public Gson getGson() {
        return gson;
    }
    
    public String getUserAgent() {
        return userAgent;
    }
    
    public void setUserAgent(String newUserAgent) {
        userAgent = newUserAgent;
    }
}
