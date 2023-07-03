package pkjava.httprequests;

import pkjava.PKJava;
import pkjava.system.AutoproxySettings;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetAutoproxySettings extends AbstractPKHttpRequest {
    
    private static GetAutoproxySettings instance;
    
    private GetAutoproxySettings() {
    }
    
    public static GetAutoproxySettings getInstance() {
        if (instance == null) instance = new GetAutoproxySettings();
        return instance;
    }
    
    public AutoproxySettings httpRequestGETSystem(String systemID, String authToken) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + "/" + systemID + "/" + Endpoints.autoproxyEndpoint))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, this.getUserAgent())
                .build();
        HttpResponse<String> requestResponse = this.getPkClient().send(systemRequest, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), AutoproxySettings.class);
    }
    
    
}
