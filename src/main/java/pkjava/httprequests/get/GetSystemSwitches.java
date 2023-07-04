package pkjava.httprequests.get;

import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.switches.Switches;
import pkjava.utils.Endpoints;
import pkjava.utils.QueryStrings;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetSystemSwitches extends AbstractPKHttpRequest {
    
    public static Switches requestSystemSwitches(String systemID, String authToken, int limit, String timestamp) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systems + "/" + systemID + "/" + Endpoints.switches + "?" + QueryStrings.before + "=" + timestamp + "&" + QueryStrings.limit + "=" + limit))
                .GET()
                .header(RequestUtils.authorization, authToken)
                .header(RequestUtils.userAgent, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(systemRequest, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), Switches.class);
    }
    
}
