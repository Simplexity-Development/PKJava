package pkjava.system.groups;

import java.util.UUID;
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
    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public UUID getUuid() {
        return uuid;
    }
    
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDisplay_name() {
        return display_name;
    }
    
    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
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
    
    public GroupPrivacy getPrivacy() {
        return privacy;
    }
    
    public void setPrivacy(GroupPrivacy groupPrivacy) {
        this.privacy = groupPrivacy;
    }
}
