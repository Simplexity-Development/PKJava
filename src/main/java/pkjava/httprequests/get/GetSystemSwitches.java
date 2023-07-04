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
    
    private static GetSystemSwitches instance;
    
    private GetSystemSwitches() {
    }
    
    public static GetSystemSwitches getInstance() {
        if (instance == null) instance = new GetSystemSwitches();
        return instance;
    }
    
    public Switches httpRequestGETSystemSwitches(String systemID, String authToken, int limit, String timestamp) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + "/" + systemID + "/" + Endpoints.switchesEndpoint + "?" + QueryStrings.beforeString + "=" + timestamp + "&" + QueryStrings.limitString + "=" + limit))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, this.getUserAgent())
                .build();
        HttpResponse<String> requestResponse = this.getPkClient().send(systemRequest, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), Switches.class);
    }
    
}
