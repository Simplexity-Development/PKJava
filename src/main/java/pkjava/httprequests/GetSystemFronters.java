package pkjava.httprequests;

import pkjava.PKJava;
import pkjava.system.switches.Fronters;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetSystemFronters extends AbstractPKHttpRequest{
    
    private static GetSystemFronters instance;
    
    private GetSystemFronters() {
    }
    
    public static GetSystemFronters getInstance() {
        if (instance == null) instance = new GetSystemFronters();
        return instance;
    }
    
    public Fronters httpRequestGETSystemFronters(String systemID, String authToken) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + "/" + systemID + "/" + Endpoints.frontersEndpoint))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, this.getUserAgent())
                .build();
        HttpResponse<String> requestResponse = this.getPkClient().send(systemRequest, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), Fronters.class);
    }
    
}
