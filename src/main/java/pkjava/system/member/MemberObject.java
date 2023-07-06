package pkjava.system.member;

import java.util.List;

/**
 * The type Member object.
 */
@SuppressWarnings("unused") //Library, this is being used externally
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
    private String created;
    private List<ProxyTag> proxy_tags;
    private boolean keep_proxy;
    private Boolean autoproxy_enabled;
    private Integer message_count;
    private String last_message_timestamp;
    private MemberPrivacy privacy;
    
    
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
    public String getUuid() {
        return uuid;
    }
    
    /**
     * Sets uuid.
     *
     * @param uuid the uuid
     */
    public void setUuid(String uuid) {
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
     * Gets birthday.
     *
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }
    
    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
    
    /**
     * Gets webhook url.
     *
     * @return the webhook url
     */
    public String getWebhook_url() {
        return webhook_url;
    }
    
    /**
     * Sets webhook url.
     *
     * @param webhook_url the webhook url
     */
    public void setWebhook_url(String webhook_url) {
        this.webhook_url = webhook_url;
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
     * Gets created.
     *
     * @return the created
     */
    public String getCreated() {
        return created;
    }
    
    /**
     * Sets created.
     *
     * @param created the created
     */
    public void setCreated(String created) {
        this.created = created;
    }
    
    /**
     * Gets proxy tags.
     *
     * @return the proxy tags
     */
    public List<ProxyTag> getProxy_tags() {
        return proxy_tags;
    }
    
    /**
     * Sets proxy tags.
     *
     * @param proxy_tags the proxy tags
     */
    public void setProxy_tags(List<ProxyTag> proxy_tags) {
        this.proxy_tags = proxy_tags;
    }
    
    /**
     * Is keep proxy boolean.
     *
     * @return the boolean
     */
    public boolean isKeep_proxy() {
        return keep_proxy;
    }
    
    /**
     * Sets keep proxy.
     *
     * @param keep_proxy the keep proxy
     */
    public void setKeep_proxy(boolean keep_proxy) {
        this.keep_proxy = keep_proxy;
    }
    
    /**
     * Gets autoproxy enabled.
     *
     * @return the autoproxy enabled
     */
    public Boolean getAutoproxy_enabled() {
        return autoproxy_enabled;
    }
    
    /**
     * Sets autoproxy enabled.
     *
     * @param autoproxy_enabled the autoproxy enabled
     */
    public void setAutoproxy_enabled(Boolean autoproxy_enabled) {
        this.autoproxy_enabled = autoproxy_enabled;
    }
    
    /**
     * Gets message count.
     *
     * @return the message count
     */
    public Integer getMessage_count() {
        return message_count;
    }
    
    /**
     * Sets message count.
     *
     * @param message_count the message count
     */
    public void setMessage_count(Integer message_count) {
        this.message_count = message_count;
    }
    
    /**
     * Gets last message timestamp.
     *
     * @return the last message timestamp
     */
    public String getLast_message_timestamp() {
        return last_message_timestamp;
    }
    
    /**
     * Sets last message timestamp.
     *
     * @param last_message_timestamp the last message timestamp
     */
    public void setLast_message_timestamp(String last_message_timestamp) {
        this.last_message_timestamp = last_message_timestamp;
    }
    
    /**
     * Gets privacy.
     *
     * @return the privacy
     */
    public MemberPrivacy getPrivacy() {
        return privacy;
    }
    
    /**
     * Sets privacy.
     *
     * @param memberPrivacy the member privacy
     */
    public void setPrivacy(MemberPrivacy memberPrivacy) {
        this.privacy = memberPrivacy;
    }
}
