package pkjava.system.settings;

/**
 * The type System settings.
 */
@SuppressWarnings("unused") //Library, this is being used externally
public class SystemSettings {
    private String timezone;
    private boolean pings_enabled;
    private Integer latch_timeout;
    private boolean member_default_private;
    private boolean group_default_private;
    private boolean show_private_info;
    private int member_limit;
    private int group_limit;
    
    /**
     * Gets timezone.
     *
     * @return the timezone
     */
    public String getTimezone() {
        return timezone;
    }
    
    /**
     * Sets timezone.
     *
     * @param timezone the timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    
    /**
     * Is pings enabled boolean.
     *
     * @return the boolean
     */
    public boolean isPings_enabled() {
        return pings_enabled;
    }
    
    /**
     * Sets pings enabled.
     *
     * @param pings_enabled the pings enabled
     */
    public void setPings_enabled(boolean pings_enabled) {
        this.pings_enabled = pings_enabled;
    }
    
    /**
     * Gets latch timeout.
     *
     * @return the latch timeout
     */
    public Integer getLatch_timeout() {
        return latch_timeout;
    }
    
    /**
     * Sets latch timeout.
     *
     * @param latch_timeout the latch timeout
     */
    public void setLatch_timeout(Integer latch_timeout) {
        this.latch_timeout = latch_timeout;
    }
    
    /**
     * Is member default private boolean.
     *
     * @return the boolean
     */
    public boolean isMember_default_private() {
        return member_default_private;
    }
    
    /**
     * Sets member default private.
     *
     * @param member_default_private the member default private
     */
    public void setMember_default_private(boolean member_default_private) {
        this.member_default_private = member_default_private;
    }
    
    /**
     * Is group default private boolean.
     *
     * @return the boolean
     */
    public boolean isGroup_default_private() {
        return group_default_private;
    }
    
    /**
     * Sets group default private.
     *
     * @param group_default_private the group default private
     */
    public void setGroup_default_private(boolean group_default_private) {
        this.group_default_private = group_default_private;
    }
    
    /**
     * Is show private info boolean.
     *
     * @return the boolean
     */
    public boolean isShow_private_info() {
        return show_private_info;
    }
    
    /**
     * Sets show private info.
     *
     * @param show_private_info the show private info
     */
    public void setShow_private_info(boolean show_private_info) {
        this.show_private_info = show_private_info;
    }
    
    /**
     * Gets member limit.
     *
     * @return the member limit
     */
    public int getMember_limit() {
        return member_limit;
    }
    
    /**
     * Sets member limit.
     *
     * @param member_limit the member limit
     */
    public void setMember_limit(int member_limit) {
        this.member_limit = member_limit;
    }
    
    /**
     * Gets group limit.
     *
     * @return the group limit
     */
    public int getGroup_limit() {
        return group_limit;
    }
    
    /**
     * Sets group limit.
     *
     * @param group_limit the group limit
     */
    public void setGroup_limit(int group_limit) {
        this.group_limit = group_limit;
    }
}
