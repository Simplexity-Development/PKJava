package pkjava.system.groups;

import java.util.UUID;

/**
 * The type Group object.
 */
@SuppressWarnings("unused") //Library, this is being used externally
public class GroupObject {
    private String id;
    private UUID uuid;
    private String name;
    private String display_name;
    private String description;
    private String icon;
    private String banner;
    private String color;
    private GroupPrivacy privacy;
    
    
    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Gets uuid.
     *
     * @return the uuid
     */
    public UUID getUuid() {
        return uuid;
    }
    
    /**
     * Sets uuid.
     *
     * @param uuid the uuid
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    
    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Gets icon.
     *
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }
    
    /**
     * Sets icon.
     *
     * @param icon the icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    /**
     * Gets banner.
     *
     * @return the banner
     */
    public String getBanner() {
        return banner;
    }
    
    /**
     * Sets banner.
     *
     * @param banner the banner
     */
    public void setBanner(String banner) {
        this.banner = banner;
    }
    
    /**
     * Gets color.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Gets privacy.
     *
     * @return the privacy
     */
    public GroupPrivacy getPrivacy() {
        return privacy;
    }
    
    /**
     * Sets privacy.
     *
     * @param groupPrivacy the group privacy
     */
    public void setPrivacy(GroupPrivacy groupPrivacy) {
        this.privacy = groupPrivacy;
    }
}
