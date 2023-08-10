package pkjava.system;

import java.util.UUID;


@SuppressWarnings("unused") /*Library, this is being used externally*/
public class SystemObject {
    
    private String id;
    private UUID uuid;
    private String name;
    private String description;
    private String tag;
    private String pronouns;
    private String avatar_url;
    private String banner;
    private String color;
    private String created;
    private SystemPrivacy privacy;
    /**
     * Get the name of the system object.
     *
     * @return String
     */
    
    public String getName() {
        return name;
    }
    /**
     * Set the name of the system object.
     *
     * @param name The name of the system object.
     */
    
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get the UUID of the system object.
     *
     * @return UUID
     */
    
    public UUID getUuid() {
        return uuid;
    }
    /**
     * Set the UUID of the system object.
     *
     * @param uuid The UUID of the system object.
     */
    
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    /**
     * Get the 5-character ID of the system object.
     *
     * @return String
     */
    
    public String getId() {
        return id;
    }
    /**
     * Set the 5-character ID of the system object.
     *
     * @param id The 5-character ID of the system object.
     */
    
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Get the description of the system object.
     *
     * @return String
     */
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getTag() {
        return tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public String getPronouns() {
        return pronouns;
    }
    
    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }
    
    public String getAvatar_url() {
        return avatar_url;
    }
    
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
    
    public String getBanner() {
        return banner;
    }
    
    public void setBanner(String banner) {
        this.banner = banner;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getCreated() {
        return created;
    }
    
    public void setCreated(String created) {
        this.created = created;
    }
    
    public SystemPrivacy getPrivacy() {
        return privacy;
    }
    
    public void setPrivacy(SystemPrivacy privacy) {
        this.privacy = privacy;
    }
}
