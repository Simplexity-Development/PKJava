package pkjava.system.guilds;

/**
 * The type System guild settings.
 */
@SuppressWarnings("unused") //Library, this is being used externally
public class SystemGuildSettings {
    
    private String guild_id;
    private boolean proxying_enabled;
    private String tag;
    private boolean tag_enabled;
    
    /**
     * Gets guild id.
     *
     * @return the guild id
     */
    public String getGuild_id() {
        return guild_id;
    }
    
    /**
     * Sets guild id.
     *
     * @param guild_id the guild id
     */
    public void setGuild_id(String guild_id) {
        this.guild_id = guild_id;
    }
    
    /**
     * Is proxying enabled boolean.
     *
     * @return the boolean
     */
    public boolean isProxying_enabled() {
        return proxying_enabled;
    }
    
    /**
     * Sets proxying enabled.
     *
     * @param proxying_enabled the proxying enabled
     */
    public void setProxying_enabled(boolean proxying_enabled) {
        this.proxying_enabled = proxying_enabled;
    }
    
    /**
     * Gets tag.
     *
     * @return the tag
     */
    public String getTag() {
        return tag;
    }
    
    /**
     * Sets tag.
     *
     * @param tag the tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    /**
     * Is tag enabled boolean.
     *
     * @return the boolean
     */
    public boolean isTag_enabled() {
        return tag_enabled;
    }
    
    /**
     * Sets tag enabled.
     *
     * @param tag_enabled the tag enabled
     */
    public void setTag_enabled(boolean tag_enabled) {
        this.tag_enabled = tag_enabled;
    }
}
