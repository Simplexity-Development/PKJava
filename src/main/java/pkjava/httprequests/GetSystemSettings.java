package pkjava.httprequests;

import org.json.JSONObject;
import pkjava.system.settings.SystemSettings;
import pkjava.utils.Endpoints;
import pkjava.utils.JSONObjectNullChecks;
import pkjava.utils.Keys;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetSystemSettings {
    private static GetSystemSettings instance;
    
    private GetSystemSettings() {
    }
    
    public static GetSystemSettings getInstance() {
        if (instance == null) instance = new GetSystemSettings();
        return instance;
    }
    
    public SystemSettings httpRequestGETSystemSettings(HttpClient client, String systemID, String authToken, String userAgent) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + systemID + Endpoints.settingsEndpoint))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = client.send(systemRequest, HttpResponse.BodyHandlers.ofString());
        JSONObject requestBody = new JSONObject(requestResponse.body());
        SystemSettings requestedSystemSettings = new SystemSettings();
        requestedSystemSettings.setTimezone(requestBody.getString(Keys.timezoneKey));
        requestedSystemSettings.setPings_enabled(requestBody.getBoolean(Keys.pingsEnabledKey));
        requestedSystemSettings.setLatch_timeout(JSONObjectNullChecks.getInstance().nullIntegerCheck(requestBody, Keys.latchTimeoutKey));
        requestedSystemSettings.setMember_default_private(requestBody.getBoolean(Keys.memberDefaultPrivateKey));
        requestedSystemSettings.setGroup_default_private(requestBody.getBoolean(Keys.groupDefaultPrivateKey));
        requestedSystemSettings.setShow_private_info(requestBody.getBoolean(Keys.showPrivateInfoKey));
        requestedSystemSettings.setMember_limit(requestBody.getInt(Keys.memberLimitKey));
        requestedSystemSettings.setGroup_limit(requestBody.getInt(Keys.groupLimitKey));
        return requestedSystemSettings;
    }
    
}
