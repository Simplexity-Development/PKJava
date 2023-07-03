package pkjava.httprequests;

import pkjava.PKJava;
import pkjava.system.switches.Switches;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetSystemSwitches extends AbstractPKHttpRequest {
    
    private static GetSystemSwitches instance;
    
    private GetSystemSwitches() {
    }
    
    public static GetSystemSwitches getInstance() {
        if (instance == null) instance = new GetSystemSwitches();
        return instance;
    }
    
    public Switches httpRequestGETSystemFronters(String systemID, String authToken) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + "/" + systemID + "/" + Endpoints.switchesEndpoint))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, this.getUserAgent())
                .build();
        HttpResponse<String> requestResponse = this.getPkClient().send(systemRequest, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), Switches.class);
    }
    
}