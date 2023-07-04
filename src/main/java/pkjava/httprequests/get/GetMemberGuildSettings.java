package pkjava.httprequests.get;

import pkjava.PKJava;
import pkjava.httprequests.AbstractPKHttpRequest;
import pkjava.system.member.guilds.MemberGuildSettings;
import pkjava.utils.Endpoints;
import pkjava.utils.RequestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetMemberGuildSettings extends AbstractPKHttpRequest {
    
    private static GetMemberGuildSettings instance;
    
    private GetMemberGuildSettings() {
    }
    
    public static GetMemberGuildSettings getInstance() {
        if (instance == null) instance = new GetMemberGuildSettings();
        return instance;
    }
    
    public MemberGuildSettings httpRequestGETMemberGuildSettings(String systemID, String authToken, String guildID, String memberID) throws IOException, InterruptedException {
        HttpRequest memberGuildSettingsRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systemsEndpoint + "/" + systemID + "/" + Endpoints.membersEndpoint + "/" + memberID + "/" + Endpoints.guildEndpoint + "/" + guildID))
                .GET()
                .header(RequestUtils.authorizationHeader, authToken)
                .header(RequestUtils.userAgentHeader, this.getUserAgent())
                .build();
        HttpResponse<String> requestResponse = this.getPkClient().send(memberGuildSettingsRequest, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), MemberGuildSettings.class);
    }
    
}
