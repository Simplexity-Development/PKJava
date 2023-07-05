package pkjava.httprequests.get;

import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.switches.Fronters;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@SuppressWarnings("unused") //Library, this is being used externally
public class GetSystemFronters extends AbstractPKHttpRequest {
    
    
    public static Fronters requestSystemFronters(String authToken, String systemID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + fronters))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(request, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), Fronters.class);
    }
    
}
