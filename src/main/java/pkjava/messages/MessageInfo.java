package pkjava.messages;

import pkjava.system.SystemObject;
import pkjava.system.member.MemberObject;

/**
 * The type Message info.
 */
@SuppressWarnings("unused") //Library, this is being used externally
public class MessageInfo {
    
    private String timestamp;
    private String id;
    private String original;
    private String sender;
    private String channel;
    private String guild;
    private SystemObject system;
    private MemberObject member;
    
    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }
    
    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
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
     * Gets original.
     *
     * @return the original
     */
    public String getOriginal() {
        return original;
    }
    
    /**
     * Sets original.
     *
     * @param original the original
     */
    public void setOriginal(String original) {
        this.original = original;
    }
    
    /**
     * Gets sender.
     *
     * @return the sender
     */
    public String getSender() {
        return sender;
    }
    
    /**
     * Sets sender.
     *
     * @param sender the sender
     */
    public void setSender(String sender) {
        this.sender = sender;
    }
    
    /**
     * Gets channel.
     *
     * @return the channel
     */
    public String getChannel() {
        return channel;
    }
    
    /**
     * Sets channel.
     *
     * @param channel the channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }
    
    /**
     * Gets guild.
     *
     * @return the guild
     */
    public String getGuild() {
        return guild;
    }
    
    /**
     * Sets guild.
     *
     * @param guild the guild
     */
    public void setGuild(String guild) {
        this.guild = guild;
    }
    
    /**
     * Gets system.
     *
     * @return the system
     */
    public SystemObject getSystem() {
        return system;
    }
    
    /**
     * Sets system.
     *
     * @param system the system
     */
    public void setSystem(SystemObject system) {
        this.system = system;
    }
    
    /**
     * Gets member.
     *
     * @return the member
     */
    public MemberObject getMember() {
        return member;
    }
    
    /**
     * Sets member.
     *
     * @param member the member
     */
    public void setMember(MemberObject member) {
        this.member = member;
    }
}
