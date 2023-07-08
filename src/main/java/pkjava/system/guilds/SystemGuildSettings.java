package pkjava.system.guilds;

@SuppressWarnings("unused") //Library, this is being used externally
public class SystemGuildSettings {
    
    private String guild_id;
    private boolean proxying_enabled;
    private String tag;
    private boolean tag_enabled;
    
    public String getGuild_id() {
        return guild_id;
    }
    
    public void setGuild_id(String guild_id) {
        this.guild_id = guild_id;
    }
    
    public boolean isProxying_enabled() {
        return proxying_enabled;
    }
    
    public void setProxying_enabled(boolean proxying_enabled) {
        this.proxying_enabled = proxying_enabled;
    }
    
    public String getTag() {
        return tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public boolean isTag_enabled() {
        return tag_enabled;
    }
    
    public void setTag_enabled(boolean tag_enabled) {
        this.tag_enabled = tag_enabled;
    }
}
