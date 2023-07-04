package pkjava.httprequests.get;

import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.SystemObject;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetSystem extends AbstractPKHttpRequest {
    
    
    public static SystemObject requestSystem(String systemID, String authToken) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systems + "/" + systemID))
                .GET()
                .header(RequestUtils.authorization, authToken)
                .header(RequestUtils.userAgent, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(systemRequest, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), SystemObject.class);
    }
    
    
}
