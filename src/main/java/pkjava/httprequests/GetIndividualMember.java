package pkjava.httprequests;

import pkjava.PKJava;
import pkjava.system.member.MemberObject;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetIndividualMember {
    
    private static GetIndividualMember instance;
    
    private GetIndividualMember() {
    }
    
    public static GetIndividualMember getInstance() {
        if (instance == null) instance = new GetIndividualMember();
        return instance;
    }
    
    public MemberObject httpRequestGETMember(HttpClient client, String systemID, String memberID, String authToken, String userAgent) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + systemID + "/" + Endpoints.membersEndpoint + "/" + memberID))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = client.send(systemRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        return PKJava.getInstance().getGson().fromJson(responseBody, MemberObject.class);
    }
    
}
