package pkjava.httprequests.get;

import com.google.gson.reflect.TypeToken;
import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.groups.GroupObject;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GetMemberGroups extends AbstractPKHttpRequest {
    
    public static List<GroupObject> requestMemberGroups(String systemID, String authToken, String memberID) throws IOException, InterruptedException {
        HttpRequest groupsRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systems + "/" + systemID + "/" + Endpoints.members + "/" + memberID + "/" + Endpoints.group))
                .GET()
                .header(RequestUtils.authorization, authToken)
                .header(RequestUtils.userAgent, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(groupsRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type groupObjectListType = new TypeToken<ArrayList<GroupObject>>() {
        }.getType();
        return PKJava.getInstance().getGson().fromJson(responseBody, groupObjectListType);
    }
    
}
