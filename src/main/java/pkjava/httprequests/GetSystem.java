package pkjava.httprequests;

import pkjava.PKJava;
import pkjava.system.SystemObject;
import pkjava.system.SystemPrivacy;
import org.jetbrains.annotations.Nullable;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;

public class GetSystem {
    private static GetSystem instance;
    
    private GetSystem() {
    }
    
    public static GetSystem getInstance() {
        if (instance == null) instance = new GetSystem();
        return instance;
    }
    public SystemObject httpRequestGETSystem(HttpClient client, String systemID, @Nullable String authToken) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(PKJava.getInstance().getPkAPIBase() + "systems/" + systemID))
                .GET()
                .header(PKJava.getInstance().getPKAuthorizationHeader(), authToken)
                .build();
        HttpResponse<String> requestResponse = client.send(systemRequest, HttpResponse.BodyHandlers.ofString());
        JSONObject requestBody = HTTP.toJSONObject(requestResponse.body());
        SystemObject requestedSystem = new SystemObject();
        requestedSystem.setId(requestBody.getString("id"));
        requestedSystem.setUuid(UUID.fromString(requestBody.getString("uuid")));
        requestedSystem.setName(requestBody.getString("name"));
        requestedSystem.setDescription(requestBody.getString("description"));
        requestedSystem.setTag(requestBody.getString("rag"));
        requestedSystem.setPronouns(requestBody.getString("pronouns"));
        requestedSystem.setAvatar_url(requestBody.getString("avatar_url"));
        requestedSystem.setBanner(requestBody.getString("banner"));
        requestedSystem.setColor(requestBody.getString("color"));
        requestedSystem.setCreated(requestBody.getString("created"));
        requestedSystem.setPrivacy(getSystemPrivacyFromBody(requestBody));
        return requestedSystem;
    }
    
    private SystemPrivacy getSystemPrivacyFromBody(JSONObject requestBody){
        String privacyString = requestBody.getString("privacy");
        if (privacyString == null || privacyString.isEmpty()) {
            return null;
        }
        JSONArray systemPrivacyJSON = requestBody.getJSONArray("privacy");
        SystemPrivacy systemPrivacy = new SystemPrivacy();
        systemPrivacy.setDescription_privacy(systemPrivacyJSON.getString(0));
        systemPrivacy.setPronoun_privacy(systemPrivacyJSON.getString(1));
        systemPrivacy.setMember_list_privacy(systemPrivacyJSON.getString(2));
        systemPrivacy.setGroup_list_privacy(systemPrivacyJSON.getString(3));
        systemPrivacy.setFront_privacy(systemPrivacyJSON.getString(4));
        systemPrivacy.setFront_history_privacy(systemPrivacyJSON.getString(5));
        return systemPrivacy;
    }
}
