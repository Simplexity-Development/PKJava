package pkjava.httprequests;

import org.json.JSONArray;
import org.json.JSONObject;
import pkjava.system.member.MemberObject;
import pkjava.utils.Endpoints;
import pkjava.utils.JSONObjectNullChecks;
import pkjava.utils.Keys;
import pkjava.utils.RequestUtils;

import java.io.IOException;
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
        HttpRequest systemRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + systemID + Endpoints.membersListEndpoint))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, userAgent)
                .build();
        HttpResponse<String> requestResponse = client.send(systemRequest, HttpResponse.BodyHandlers.ofString());
        JSONArray requestBody = new JSONArray(requestResponse.body());
        List<MemberObject> requestedMembers = new ArrayList<>();
        for (Object receivedObject : requestBody) {
            JSONObject receivedMember = (JSONObject) receivedObject;
            MemberObject memberObject = new MemberObject();
            memberObject.setId(receivedMember.getString(Keys.idKey));
            memberObject.setUuid(receivedMember.getString(Keys.uuidKey));
            memberObject.setName(receivedMember.getString(Keys.nameKey));
            memberObject.setDisplay_name(JSONObjectNullChecks.getInstance().nullStringCheck(receivedMember, Keys.displayNameKey));
            requestedMembers.add(memberObject);
        }
        return requestedMembers;
        
        
    }
    
}
