package pkjava.httprequests.get;

import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.groups.GroupObject;
import pkjava.system.member.MemberObject;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetIndividualGroup extends AbstractPKHttpRequest {
    
    private static GetIndividualGroup instance;
    
    private GetIndividualGroup() {
    }
    
    public static GetIndividualGroup getInstance() {
        if (instance == null) instance = new GetIndividualGroup();
        return instance;
    }
    
    public GroupObject httpRequestGETIndividualGroup(String systemID, String groupID, String authToken) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + systemID + "/" + Endpoints.groupEndpoint + "/" + groupID))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, this.getUserAgent())
                .build();
        HttpResponse<String> requestResponse = this.getPkClient().send(systemRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        return PKJava.getInstance().getGson().fromJson(responseBody, GroupObject.class);
    }
    
}
