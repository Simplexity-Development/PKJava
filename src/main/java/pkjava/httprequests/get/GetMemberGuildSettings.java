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
    
    
    public static MemberGuildSettings requestMemberGuildSettings(String systemID, String authToken, String guildID, String memberID) throws IOException, InterruptedException {
        HttpRequest memberGuildSettingsRequest = HttpRequest.newBuilder(URI.create(RequestUtils.pkAPIBase + Endpoints.systems + "/" + systemID + "/" + Endpoints.members + "/" + memberID + "/" + Endpoints.guilds + "/" + guildID))
                .GET()
                .header(RequestUtils.authorization, authToken)
                .header(RequestUtils.userAgent, getUserAgent())
                .build();
        HttpResponse<String> requestResponse = getPkClient().send(memberGuildSettingsRequest, HttpResponse.BodyHandlers.ofString());
        return PKJava.getInstance().getGson().fromJson(requestResponse.body(), MemberGuildSettings.class);
    }
    
}
