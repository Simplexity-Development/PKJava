package pkjava.httprequests.get;

import com.google.gson.reflect.TypeToken;
import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.member.MemberObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unused") //Library, this is being used externally
public class GetGroupMemberList extends AbstractPKHttpRequest {
    
    
    public static List<MemberObject> requestGroupMembers(String authToken, String systemID, String groupID) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(pkAPIBase
                        + systems + "/"
                        + systemID + "/"
                        + groups + "/"
                        + groupID + "/"
                        + members))
                .GET()
                .header(authorization, authToken)
                .header(userAgentHeader, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = requestResponse.body();
        Type memberObjectListType = new TypeToken<ArrayList<MemberObject>>() {
        }.getType();
        return PKJava.getInstance().getGson().fromJson(responseBody, memberObjectListType);
    }
    
}
