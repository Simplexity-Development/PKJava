package pkjava.httprequests.get;

import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.guilds.SystemGuildSettings;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetSystemGuildSettings extends AbstractPKHttpRequest {
    
    
    public static SystemGuildSettings requestSystemGuildSettings(String systemID, String authToken, String guildID) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systems + "/" + systemID + "/" + Endpoints.guilds + "/" + guildID))
                .GET()
                .header(RequestUtils.authorization, authToken)
                .header(RequestUtils.userAgent, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(systemRequest, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), SystemGuildSettings.class);
    }
    
}
