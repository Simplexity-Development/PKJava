package pkjava.httprequests.get;

import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.groups.GroupObject;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetIndividualGroup extends AbstractPKHttpRequest {
    
    public static GroupObject requestIndividualGroup(String systemID, String groupID, String authToken) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systems + systemID + "/" + Endpoints.group + "/" + groupID))
                .GET()
                .header(RequestUtils.authorization, authToken)
                .header(RequestUtils.userAgent, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(systemRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        return PKJava.getInstance().getGson().fromJson(responseBody, GroupObject.class);
    }
    
}
