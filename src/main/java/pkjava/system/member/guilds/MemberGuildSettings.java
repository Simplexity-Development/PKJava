package pkjava.system.member.guilds;

/**
 * The type Member guild settings.
 */
@SuppressWarnings("unused") //Library, this is being used externally
public class MemberGuildSettings {
    private String guild_id;
    private String display_name;
    private String avatar_url;
    
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
     * Gets display name.
     *
     * @return the display name
     */
    public String getDisplay_name() {
        return display_name;
    }
    
    /**
     * Sets display name.
     *
     * @param display_name the display name
     */
    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
    
    /**
     * Gets avatar url.
     *
     * @return the avatar url
     */
    public String getAvatar_url() {
        return avatar_url;
    }
    
    /**
     * Sets avatar url.
     *
     * @param avatar_url the avatar url
     */
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
