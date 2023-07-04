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

    
    public static List<MemberObject> requestGroupMembers(String systemID, String authToken, String groupID) throws IOException, InterruptedException {
        HttpRequest groupsRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systems + "/" + systemID + "/" + Endpoints.group + "/" + groupID + "/" + Endpoints.members))
                .GET()
                .header(RequestUtils.authorization, authToken)
                .header(RequestUtils.userAgent, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(groupsRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type memberObjectListType = new TypeToken<ArrayList<MemberObject>>() {
        }.getType();
        return PKJava.getInstance().getGson().fromJson(responseBody, memberObjectListType);
    }
    
}
