package pkjava.httprequests.get;

import com.google.gson.reflect.TypeToken;
import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.groups.GroupObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unused") //Library, this is being used externally
public class GetMemberGroupList extends AbstractPKHttpRequest {
    
    public static List<GroupObject> requestMemberGroups(String authToken, String systemID, String memberID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + members + "/"
                        + memberID + "/"
                        + groups))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type groupObjectListType = new TypeToken<ArrayList<GroupObject>>() {
        }.getType();
        return PKJava.getInstance().getGson().fromJson(responseBody, groupObjectListType);
    }
    
}
