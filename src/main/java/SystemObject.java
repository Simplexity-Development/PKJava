import java.util.UUID;

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
    private SystemPrivacyObject privacy;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public UUID getUuid() {
        return uuid;
    }
    
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
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
    
    public SystemPrivacyObject getPrivacy() {
        return privacy;
    }
    
    public void setPrivacy(SystemPrivacyObject privacy) {
        this.privacy = privacy;
    }
}
