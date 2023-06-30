package system.settings;

public class SystemSettings {
    private String timezone;
    private boolean pings_enabled;
    private Integer latch_timeout;
    private boolean member_default_private;
    private boolean group_default_private;
    private boolean show_private_info;
    private int member_limit;
    private int group_limit;
    
    public String getTimezone() {
        return timezone;
    }
    
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    
    public boolean isPings_enabled() {
        return pings_enabled;
    }
    
    public void setPings_enabled(boolean pings_enabled) {
        this.pings_enabled = pings_enabled;
    }
    
    public Integer getLatch_timeout() {
        return latch_timeout;
    }
    
    public void setLatch_timeout(Integer latch_timeout) {
        this.latch_timeout = latch_timeout;
    }
    
    public boolean isMember_default_private() {
        return member_default_private;
    }
    
    public void setMember_default_private(boolean member_default_private) {
        this.member_default_private = member_default_private;
    }
    
    public boolean isGroup_default_private() {
        return group_default_private;
    }
    
    public void setGroup_default_private(boolean group_default_private) {
        this.group_default_private = group_default_private;
    }
    
    public boolean isShow_private_info() {
        return show_private_info;
    }
    
    public void setShow_private_info(boolean show_private_info) {
        this.show_private_info = show_private_info;
    }
    
    public int getMember_limit() {
        return member_limit;
    }
    
    public void setMember_limit(int member_limit) {
        this.member_limit = member_limit;
    }
    
    public int getGroup_limit() {
        return group_limit;
    }
    
    public void setGroup_limit(int group_limit) {
        this.group_limit = group_limit;
    }
}
