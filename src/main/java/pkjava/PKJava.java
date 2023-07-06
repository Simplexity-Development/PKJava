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

/**
 * The type Pk java.
 */
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
    
    /**
     * Instantiates a new Pk java.
     */
    public PKJava() {
        this.initializeDefaultPKJavaClient();
    }
    
    private HttpClient pkJavaClient;
    private String userAgent = "PKJava Library - Contact at https://github.com/Simplexity-Development/PKJava/issues";
    private String authToken;
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .setLenient()
            .create();
    
    /**
     * Initialize default pk java client. Uses "userAgent"
     */
    public void initializeDefaultPKJavaClient() {
        HttpClient httpClient = java.net.http.HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        setPkJavaClient(httpClient);
        setUserAgent(userAgent);
    }
    
    /**
     * The Http request builder, includes "authToken" and "userAgent"
     */
    public HttpRequest.Builder httpRequestBuilder = HttpRequest.newBuilder()
            .GET()
            .header(authorization, authToken)
            .header(userAgentHeader, userAgent);
    
    /**
     * Gets supplied system's autoproxy settings for the supplied guild
     *
     * @param systemID the system's 5-character id or UUID
     * @param guildID the guild id
     *
     * @return the autoproxy settings
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public AutoproxySettings requestAutoproxySettings(String systemID, String guildID) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + autoproxy + "?"
                        + guild_id + "="
                        + guildID))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), AutoproxySettings.class);
    }
    
    /**
     * Request group information
     *
     * @param systemID the system's 5-character id or UUID
     * @param groupID the group's id
     *
     * @return the group object
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public GroupObject requestGroup(String systemID, String groupID) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems
                        + systemID + "/"
                        + groups + "/"
                        + groupID))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        return gson.fromJson(responseBody, GroupObject.class);
    }
    
    /**
     * Request group members list.
     *
     * @param systemID the system's 5-character id or UUID
     * @param groupID the group id
     *
     * @return the list
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public List<MemberObject> requestGroupMembers(String systemID, String groupID) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + groups + "/"
                        + groupID + "/"
                        + members))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type memberObjectListType = new TypeToken<ArrayList<MemberObject>>() {
        }.getType();
        return gson.fromJson(responseBody, memberObjectListType);
    }
    
    /**
     * Request member member object.
     *
     * @param systemID the system's 5-character id or UUID
     * @param memberID the member id
     *
     * @return the member object
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public MemberObject requestMember(String systemID, String memberID) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems
                        + systemID + "/"
                        + members + "/"
                        + memberID))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        return gson.fromJson(responseBody, MemberObject.class);
    }
    
    /**
     * Request member groups list.
     *
     * @param systemID the system's 5-character id or UUID
     * @param memberID the member id
     *
     * @return the list
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public List<GroupObject> requestMemberGroups(String systemID, String memberID) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + members + "/"
                        + memberID + "/"
                        + groups))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type groupObjectListType = new TypeToken<ArrayList<GroupObject>>() {
        }.getType();
        return gson.fromJson(responseBody, groupObjectListType);
    }
    
    /**
     * Request member guild settings member guild settings.
     *
     * @param systemID the system's 5-character id or UUID
     * @param memberID the member id
     * @param guildID the guild id
     *
     * @return the member guild settings
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public MemberGuildSettings requestMemberGuildSettings(String systemID, String memberID, String guildID) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + members + "/"
                        + memberID + "/"
                        + guilds + "/"
                        + guildID))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), MemberGuildSettings.class);
    }
    
    /**
     * Request members list.
     *
     * @param systemID the system's 5-character id or UUID
     *
     * @return the list
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public List<MemberObject> requestMembers(String systemID) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + members))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type memberObjectListType = new TypeToken<ArrayList<MemberObject>>() {
        }.getType();
        return gson.fromJson(responseBody, memberObjectListType);
    }
    
    /**
     * Request message info message info.
     *
     * @param messageID the message id
     *
     * @return the message info
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public MessageInfo requestMessageInfo(String messageID) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + messages + "/"
                        + messageID))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        return gson.fromJson(responseBody, MessageInfo.class);
    }
    
    /**
     * Request system system object.
     *
     * @param systemID the system's 5-character id or UUID
     *
     * @return the system object
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public SystemObject requestSystem(String systemID) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), SystemObject.class);
    }
    
    /**
     * Request system fronters fronters.
     *
     * @param systemID the system's 5-character id or UUID
     *
     * @return the fronters
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public Fronters requestSystemFronters(String systemID) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + fronters))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), Fronters.class);
    }
    
    /**
     * Request system groups list.
     *
     * @param systemID the system's 5-character id or UUID
     * @param withMembers the with members
     *
     * @return the list
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public List<GroupObject> requestSystemGroups(String systemID, boolean withMembers) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + groups + "?"
                        + with_members + "="
                        + withMembers))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type groupObjectListType = new TypeToken<ArrayList<GroupObject>>() {
        }.getType();
        return gson.fromJson(responseBody, groupObjectListType);
    }
    
    /**
     * Request system guild settings system guild settings.
     *
     * @param systemID the system's 5-character id or UUID
     * @param guildID the guild id
     *
     * @return the system guild settings
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public SystemGuildSettings requestSystemGuildSettings(String systemID, String guildID) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + guilds + "/"
                        + guildID))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), SystemGuildSettings.class);
    }
    
    /**
     * Request system settings system settings.
     *
     * @param systemID the system's 5-character id or UUID
     *
     * @return the system settings
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public SystemSettings requestSystemSettings(String systemID) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + settings))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), SystemSettings.class);
    }
    
    /**
     * Request system switches switches.
     *
     * @param systemID the system's 5-character id or UUID
     * @param limit the limit
     * @param timestamp the timestamp
     *
     * @return the switches
     *
     * @throws IOException the io exception
     * @throws InterruptedException the interrupted exception
     */
    public Switches requestSystemSwitches(String systemID, int limit, String timestamp) throws IOException, InterruptedException {
        HttpRequest request = httpRequestBuilder.uri(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + switches + "?"
                        + before + "="
                        + timestamp + "&"
                        + limit + "="
                        + limit))
                .build();
        HttpResponse<String> requestResponse = pkJavaClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(requestResponse.body(), Switches.class);
    }
    
    /**
     * Gets pk java client.
     *
     * @return the pk java client
     */
    public HttpClient getPKJavaClient() {
        return pkJavaClient;
    }
    
    /**
     * Sets pk java client.
     *
     * @param httpClient the http client
     */
    public void setPkJavaClient(HttpClient httpClient) {
        pkJavaClient = httpClient;
    }
    
    /**
     * Gets gson.
     *
     * @return the gson
     */
    public Gson getGson() {
        return gson;
    }
    
    /**
     * Gets user agent.
     *
     * @return the user agent
     */
    public String getUserAgent() {
        return userAgent;
    }
    
    /**
     * Sets auth token.
     *
     * @param newAuthToken the new auth token
     */
    public void setAuthToken(String newAuthToken) {
        authToken = newAuthToken;
    }
    
    /**
     * Sets user agent.
     *
     * @param newUserAgent the new user agent
     */
    public void setUserAgent(String newUserAgent) {
        userAgent = newUserAgent;
    }
}
