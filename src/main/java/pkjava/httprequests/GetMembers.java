package pkjava.httprequests;

import com.google.gson.reflect.TypeToken;
import pkjava.PKJava;
import pkjava.system.member.MemberObject;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GetMembers {
    
    private static GetMembers instance;
    
    private GetMembers() {
    }
    
    public static GetMembers getInstance() {
        if (instance == null) instance = new GetMembers();
        return instance;
    }
    
    public List<MemberObject> httpRequestGETMember(HttpClient client, String systemID, String authToken, String userAgent) throws IOException, InterruptedException {
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + "/" + systemID + "/" + Endpoints.membersEndpoint))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = client.send(systemRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type memberObjectListType = new TypeToken<ArrayList<MemberObject>>() {
        }.getType();
        return PKJava.getInstance().getGson().fromJson(responseBody, memberObjectListType);
    }
    
}
