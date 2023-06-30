package system;

public class AutoproxySettings {
    private AutoproxyMode autoproxy_mode;
    private String autoproxy_member;
    private String last_latch_timestamp;
    
    public AutoproxyMode getAutoproxy_mode() {
        return autoproxy_mode;
    }
    
    public void setAutoproxy_mode(AutoproxyMode autoproxy_mode) {
        this.autoproxy_mode = autoproxy_mode;
    }
    
    public String getAutoproxy_member() {
        return autoproxy_member;
    }
    
    public void setAutoproxy_member(String autoproxy_member) {
        this.autoproxy_member = autoproxy_member;
    }
    
    public String getLast_latch_timestamp() {
        return last_latch_timestamp;
    }
    
    public void setLast_latch_timestamp(String last_latch_timestamp) {
        this.last_latch_timestamp = last_latch_timestamp;
    }
}
