package pkjava.httprequests;

import pkjava.PKJava;
import pkjava.system.SystemObject;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetSystem {
    
    private static GetSystem instance;
    
    private GetSystem() {
    }
    
    public static GetSystem getInstance() {
        if (instance == null) instance = new GetSystem();
        return instance;
    }
    
    public SystemObject httpRequestGETSystem(HttpClient client, String systemID, String authToken, String userAgent) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + "/" + systemID))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = client.send(systemRequest, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), SystemObject.class);
    }
    
    
}
