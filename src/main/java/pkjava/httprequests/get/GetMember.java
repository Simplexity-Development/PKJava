package pkjava.httprequests.get;

import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.member.MemberObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@SuppressWarnings("unused") //Library, this is being used externally
public class GetMember extends AbstractPKHttpRequest {
    
    public static MemberObject requestMember(String authToken, String systemID, String memberID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems
                        + systemID + "/"
                        + members + "/"
                        + memberID))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        return PKJava.getInstance().getGson().fromJson(responseBody, MemberObject.class);
    }
    
}
