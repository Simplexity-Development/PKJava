package pkjava.httprequests.get;

import com.google.gson.reflect.TypeToken;
import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.member.MemberObject;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GetGroupMembers extends AbstractPKHttpRequest {
    
    private static GetGroupMembers instance;
    
    private GetGroupMembers() {
    }
    
    public static GetGroupMembers getInstance() {
        if (instance == null) instance = new GetGroupMembers();
        return instance;
    }
    
    public List<MemberObject> httpRequestGETGroupMembers(String systemID, String authToken, String groupID) throws IOException, InterruptedException {
        HttpRequest groupsRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + "/" + systemID + "/" + Endpoints.groupEndpoint + "/" + groupID + "/" + Endpoints.membersEndpoint))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, this.getUserAgent())
                .build();
        HttpResponse<String> requestResponse = this.getPkClient().send(groupsRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type memberObjectListType = new TypeToken<ArrayList<MemberObject>>() {
        }.getType();
        return PKJava.getInstance().getGson().fromJson(responseBody, memberObjectListType);
    }
    
}
