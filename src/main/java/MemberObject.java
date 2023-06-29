public class MemberObject {
    
    private String id;
    private String uuid;
    private String name;
    private String display_name;
    private String color;
    private String birthday;
    private String avatar_url;
    private String webhook_url;
    private String banner;
    private String description;
    private Integer created;
    private ProxyTagObject proxy_tags;
    private boolean keep_proxy;
    private Boolean autoproxy_enabled;
    private Integer message_count;
    private Integer last_message_timestamp;
    private MemberPrivacyObject privacy;
    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getUuid() {
        return uuid;
    }
    
    public void setUuid(String uuid) {
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
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getBirthday() {
        return birthday;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public String getAvatar_url() {
        return avatar_url;
    }
    
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
    
    public String getWebhook_url() {
        return webhook_url;
    }
    
    public void setWebhook_url(String webhook_url) {
        this.webhook_url = webhook_url;
    }
    
    public String getBanner() {
        return banner;
    }
    
    public void setBanner(String banner) {
        this.banner = banner;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Integer getCreated() {
        return created;
    }
    
    public void setCreated(Integer created) {
        this.created = created;
    }
    
    public ProxyTagObject getProxy_tags() {
        return proxy_tags;
    }
    
    public void setProxy_tags(ProxyTagObject proxy_tags) {
        this.proxy_tags = proxy_tags;
    }
    
    public boolean isKeep_proxy() {
        return keep_proxy;
    }
    
    public void setKeep_proxy(boolean keep_proxy) {
        this.keep_proxy = keep_proxy;
    }
    
    public Boolean getAutoproxy_enabled() {
        return autoproxy_enabled;
    }
    
    public void setAutoproxy_enabled(Boolean autoproxy_enabled) {
        this.autoproxy_enabled = autoproxy_enabled;
    }
    
    public Integer getMessage_count() {
        return message_count;
    }
    
    public void setMessage_count(Integer message_count) {
        this.message_count = message_count;
    }
    
    public Integer getLast_message_timestamp() {
        return last_message_timestamp;
    }
    
    public void setLast_message_timestamp(Integer last_message_timestamp) {
        this.last_message_timestamp = last_message_timestamp;
    }
    
    public MemberPrivacyObject getPrivacy() {
        return privacy;
    }
    
    public void setPrivacy(MemberPrivacyObject memberPrivacy) {
        this.privacy = memberPrivacy;
    }
}
