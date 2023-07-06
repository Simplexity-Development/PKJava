package pkjava.system;

import java.util.UUID;


/**
 * The type System object.
 */
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
     * Gets SystemObject's name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets SystemObject's name.
     * <br>100 character limit
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets SystemObject's uuid.
     *
     * @return the uuid
     */
    public UUID getUuid() {
        return uuid;
    }
    
    /**
     * Sets SystemObject's uuid.
     *
     * @param uuid the uuid
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    
    /**
     * Gets SystemObject's 5-character id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    /**
     * Sets SystemObject's 5-character id.
     *
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Gets SystemObject's description.
     *
     * @return String description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets SystemObject's description.
     * <br>1000 character limit
     *
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Gets SystemObject's tag.
     *
     * @return String tag
     */
    public String getTag() {
        return tag;
    }
    
    /**
     * Sets SystemObject's tag.
     * <br>79 character limit
     *
     * @param tag String
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    /**
     * Gets SystemObject's SystemObject's pronouns.
     *
     * @return String pronouns
     */
    public String getPronouns() {
        return pronouns;
    }
    
    /**
     * Sets SystemObject's SystemObject's pronouns.
     * <br>100 character limit
     *
     * @param pronouns String
     */
    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }
    
    /**
     * Gets SystemObject's avatar url.
     *
     * @return String avatar url
     */
    public String getAvatar_url() {
        return avatar_url;
    }
    
    /**
     * Sets SystemObject's avatar url.
     * <br>256 character limit, must be a publicly accessible
     *
     * @param avatar_url the avatar url
     */
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
    
    /**
     * Gets SystemObject's banner.
     *
     * @return the banner
     */
    public String getBanner() {
        return banner;
    }
    
    /**
     * Sets SystemObject's banner url.
     * <br>256 character limit, must be a publicly accessible
     *
     * @param banner String
     */
    public void setBanner(String banner) {
        this.banner = banner;
    }
    
    /**
     * Gets SystemObject's color.
     * <br>6 character hex code, without leading #
     *
     * @return String color
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Sets SystemObject's color.
     * <br>6 character hex code, without leading #
     *
     * @param color the color
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Gets SystemObject's datetime of creation
     *
     * @return String created
     */
    public String getCreated() {
        return created;
    }
    
    /**
     * Sets SystemObject's  datetime of creation
     *
     * @param created String
     */
    public void setCreated(String created) {
        this.created = created;
    }
    
    /**
     * Gets SystemObject's corresponding SystemPrivacy object.
     *
     * @return SystemPrivacy privacy
     */
    public SystemPrivacy getPrivacy() {
        return privacy;
    }
    
    /**
     * Sets SystemObject's corresponding SystemPrivacy object.
     *
     * @param privacy SystemPrivacy
     */
    public void setPrivacy(SystemPrivacy privacy) {
        this.privacy = privacy;
    }
}
