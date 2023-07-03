package pkjava.httprequests;

import pkjava.system.SystemObject;
import pkjava.system.SystemPrivacy;
import org.json.JSONObject;
import pkjava.utils.Endpoints;
import pkjava.utils.JSONObjectNullChecks;
import pkjava.utils.Keys;
import pkjava.utils.RequestUtils;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.UUID;

public class GetSystem {
    private static GetSystem instance;
    
    private GetSystem() {
    }
    
    public static GetSystem getInstance() {
        if (instance == null) instance = new GetSystem();
        return instance;
    }
    public SystemObject httpRequestGETSystem(HttpClient client, String systemID, String authToken, String userAgent) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + systemID))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = client.send(systemRequest, HttpResponse.BodyHandlers.ofString());
        JSONObject requestBody = new JSONObject(requestResponse.body());
        SystemObject requestedSystem = new SystemObject();
        requestedSystem.setId(requestBody.getString(Keys.idKey));
        requestedSystem.setUuid(UUID.fromString(requestBody.getString(Keys.uuidKey)));
        requestedSystem.setName(JSONObjectNullChecks.getInstance().nullStringCheck(requestBody, Keys.nameKey));
        requestedSystem.setDescription(JSONObjectNullChecks.getInstance().nullStringCheck(requestBody, Keys.descriptionKey));
        requestedSystem.setTag(JSONObjectNullChecks.getInstance().nullStringCheck(requestBody, Keys.tagKey));
        requestedSystem.setPronouns(JSONObjectNullChecks.getInstance().nullStringCheck(requestBody, Keys.pronounsKey));
        requestedSystem.setAvatar_url(JSONObjectNullChecks.getInstance().nullStringCheck(requestBody, Keys.avatarURLKey));
        requestedSystem.setBanner(JSONObjectNullChecks.getInstance().nullStringCheck(requestBody, Keys.bannerKey));
        requestedSystem.setColor(JSONObjectNullChecks.getInstance().nullStringCheck(requestBody, Keys.colorKey));
        requestedSystem.setCreated(JSONObjectNullChecks.getInstance().nullStringCheck(requestBody, Keys.createdKey));
        requestedSystem.setPrivacy(getSystemPrivacyFromBody(requestBody));
        return requestedSystem;
    }
    
    private SystemPrivacy getSystemPrivacyFromBody(JSONObject requestBody){
        Map<String, Object> privacyMap = JSONObjectNullChecks.getInstance().nullMapCheck(requestBody, Keys.privacyKey);
        if (privacyMap == null || privacyMap.isEmpty()) {
            return null;
        }
        SystemPrivacy systemPrivacy = new SystemPrivacy();
        systemPrivacy.setDescription_privacy((String) privacyMap.get(Keys.descriptionPrivacyKey));
        systemPrivacy.setPronoun_privacy((String) privacyMap.get(Keys.pronounPrivacyKey));
        systemPrivacy.setMember_list_privacy((String) privacyMap.get(Keys.memberListPrivacyKey));
        systemPrivacy.setGroup_list_privacy((String) privacyMap.get(Keys.groupListPrivacyKey));
        systemPrivacy.setFront_privacy((String) privacyMap.get(Keys.frontPrivacyKey));
        systemPrivacy.setFront_history_privacy((String) privacyMap.get(Keys.frontHistoryPrivacyKey));
        return systemPrivacy;
    }
    
    
}
