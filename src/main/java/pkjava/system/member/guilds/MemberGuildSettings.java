package pkjava.system.member.guilds;
@SuppressWarnings("unused") //Library, this is being used externally
public class MemberGuildSettings {
    private String guild_id;
    private String display_name;
    private String avatar_url;
    
    public String getGuild_id() {
        return guild_id;
    }
    
    public void setGuild_id(String guild_id) {
        this.guild_id = guild_id;
    }
    
    public String getDisplay_name() {
        return display_name;
    }
    
    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
    
    public String getAvatar_url() {
        return avatar_url;
    }
    
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
