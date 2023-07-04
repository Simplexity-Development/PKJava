package pkjava.httprequests.get;

import com.google.gson.reflect.TypeToken;
import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.groups.GroupObject;
import pkjava.utils.Endpoints;
import pkjava.utils.QueryStrings;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GetSystemGroups extends AbstractPKHttpRequest {
    
    private static GetSystemGroups instance;
    
    private GetSystemGroups() {
    }
    
    public static GetSystemGroups getInstance() {
        if (instance == null) instance = new GetSystemGroups();
        return instance;
    }
    
    public List<GroupObject> httpRequestGETSystemGroups(String systemID, String authToken, boolean withMembers) throws IOException, InterruptedException {
        HttpRequest groupsRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + "/" + systemID + "/" + Endpoints.groupEndpoint + "?" + QueryStrings.withMembersString + "=" + withMembers))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, this.getUserAgent())
                .build();
        HttpResponse<String> requestResponse = this.getPkClient().send(groupsRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type groupObjectListType = new TypeToken<ArrayList<GroupObject>>() {
        }.getType();
        return PKJava.getInstance().getGson().fromJson(responseBody, groupObjectListType);
    }
    
}
