package pkjava.httprequests.get;

import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.switches.Switches;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@SuppressWarnings("unused") //Library, this is being used externally
public class GetSystemSwitches extends AbstractPKHttpRequest {
    
    public static Switches requestSystemSwitches(String authToken, String systemID, int limit, String timestamp) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + switches + "?"
                        + before + "="
                        + timestamp + "&"
                        + limit + "="
                        + limit))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(request, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), Switches.class);
    }
    
}
