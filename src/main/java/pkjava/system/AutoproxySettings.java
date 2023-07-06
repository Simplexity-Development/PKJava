package pkjava.system;

/**
 * The type Autoproxy settings.
 */
@SuppressWarnings("unused") //Library, this is being used externally
public class AutoproxySettings {
    private AutoproxyMode autoproxy_mode;
    private String autoproxy_member;
    private String last_latch_timestamp;
    
    /**
     * Gets autoproxy mode.
     *
     * @return the autoproxy mode
     */
    public AutoproxyMode getAutoproxy_mode() {
        return autoproxy_mode;
    }
    
    /**
     * Sets autoproxy mode.
     *
     * @param autoproxy_mode the autoproxy mode
     */
    public void setAutoproxy_mode(AutoproxyMode autoproxy_mode) {
        this.autoproxy_mode = autoproxy_mode;
    }
    
    /**
     * Gets autoproxy member.
     *
     * @return the autoproxy member
     */
    public String getAutoproxy_member() {
        return autoproxy_member;
    }
    
    /**
     * Sets autoproxy member.
     *
     * @param autoproxy_member the autoproxy member
     */
    public void setAutoproxy_member(String autoproxy_member) {
        this.autoproxy_member = autoproxy_member;
    }
    
    /**
     * Gets last latch timestamp.
     *
     * @return the last latch timestamp
     */
    public String getLast_latch_timestamp() {
        return last_latch_timestamp;
    }
    
    /**
     * Sets last latch timestamp.
     *
     * @param last_latch_timestamp the last latch timestamp
     */
    public void setLast_latch_timestamp(String last_latch_timestamp) {
        this.last_latch_timestamp = last_latch_timestamp;
    }
}
