package pkjava.httprequests;

import pkjava.PKJava;
import pkjava.system.guilds.SystemGuildSettings;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetSystemGuildSettings extends AbstractPKHttpRequest {
    
    private static GetSystemGuildSettings instance;
    
    private GetSystemGuildSettings() {
    }
    
    public static GetSystemGuildSettings getInstance() {
        if (instance == null) instance = new GetSystemGuildSettings();
        return instance;
    }
    
    public SystemGuildSettings httpRequestGETSystemFronters(String systemID, String authToken, String guildID) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + "/" + systemID + "/" + Endpoints.guildEndpoint + "/" + guildID))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, this.getUserAgent())
                .build();
        HttpResponse<String> requestResponse = this.getPkClient().send(systemRequest, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), SystemGuildSettings.class);
    }
    
}
