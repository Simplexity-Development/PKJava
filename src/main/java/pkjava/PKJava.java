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
    private String userAgent = "PKJava Library - Contact at https://github.com/Simplexity-Development/PKJava/issues";
    private String authToken;
    /**
     * The Gson object for serializing and deserializing JSON.
     */
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .setLenient()
            .create();
    /**
     * Initializes the default PKJava client with default settings.
     * <br>Uses "userAgent"
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
     * The builder for creating HTTP requests.
     * <br>Uses "authToken" and "userAgent"
     */
    public HttpRequest.Builder httpRequestBuilder = HttpRequest.newBuilder()
            .GET()
            .header(authorization, authToken)
            .header(userAgentHeader, userAgent);
    /**
     * Sends a request to get the autoproxy settings for a system and guild.
     *
     * @param systemID The ID of the system.
     * @param guildID  The ID of the guild.
     * @return The autoproxy settings.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get a group by ID.
     *
     * @param systemID The ID of the system.
     * @param groupID  The ID of the group.
     * @return The group object.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get the members of a group.
     *
     * @param systemID The ID of the system.
     * @param groupID  The ID of the group.
     * @return The list of member objects.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get a member by ID.
     *
     * @param systemID  The ID of the system.
     * @param memberID  The ID of the member.
     * @return The member object.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get the groups a member belongs to.
     *
     * @param systemID The ID of the system.
     * @param memberID The ID of the member.
     * @return The list of group objects.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get the guild settings for a member.
     *
     * @param systemID The ID of the system.
     * @param memberID The ID of the member.
     * @param guildID  The ID of the guild.
     * @return The member guild settings.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get all members of a system.
     *
     * @param systemID The ID of the system.
     * @return The list of member objects.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get the message info for a message ID.
     *
     * @param messageID The ID of the message.
     * @return The message info.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get the system info for a system ID.
     *
     * @param systemID The ID of the system.
     * @return The system object.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get the fronters of a system.
     *
     * @param systemID The ID of the system.
     * @return The fronters object.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get the system groups for a system.
     *
     * @param systemID     The ID of the system.
     * @param withMembers  Whether to include members in the response.
     * @return The list of group objects.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get the guild settings for a system in a guild.
     *
     * @param systemID The ID of the system.
     * @param guildID  The ID of the guild.
     * @return The system guild settings.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get the system settings for a system.
     *
     * @param systemID The ID of the system.
     * @return The system settings.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Sends a request to get the system switches for a system.
     *
     * @param systemID  The ID of the system.
     * @param limit     The maximum number of switches to retrieve.
     * @param timestamp The timestamp to retrieve switches before.
     * @return The switches object.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
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
     * Gets the PKJava client.
     *
     * @return The PKJava client.
     */
    public HttpClient getPKJavaClient() {
        return pkJavaClient;
    }
    /**
     * Sets the PKJava client.
     *
     * @param httpClient The PKJava client to set.
     */
    public void setPkJavaClient(HttpClient httpClient) {
        pkJavaClient = httpClient;
    }
    /**
     * Gets the Gson object.
     *
     * @return The Gson object.
     */
    public Gson getGson() {
        return gson;
    }
    /**
     * Gets the user agent.
     *
     * @return The user agent.
     */
    public String getUserAgent() {
        return userAgent;
    }
    /**
     * Sets the authentication token.
     *
     * @param newAuthToken The new authentication token to set.
     */
    public void setAuthToken(String newAuthToken) {
        authToken = newAuthToken;
    }
    /**
     * Sets the user agent.
     *
     * @param newUserAgent The new user agent to set.
     */
    public void setUserAgent(String newUserAgent) {
        userAgent = newUserAgent;
    }
}
