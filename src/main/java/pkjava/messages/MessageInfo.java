package pkjava.messages;

import pkjava.system.SystemObject;
import pkjava.system.member.MemberObject;

public class MessageInfo {
    
    private String timestamp;
    private String id;
    private String original;
    private String sender;
    private String channel;
    private String guild;
    private SystemObject system;
    private MemberObject member;
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getOriginal() {
        return original;
    }
    
    public void setOriginal(String original) {
        this.original = original;
    }
    
    public String getSender() {
        return sender;
    }
    
    public void setSender(String sender) {
        this.sender = sender;
    }
    
    public String getChannel() {
        return channel;
    }
    
    public void setChannel(String channel) {
        this.channel = channel;
    }
    
    public String getGuild() {
        return guild;
    }
    
    public void setGuild(String guild) {
        this.guild = guild;
    }
    
    public SystemObject getSystem() {
        return system;
    }
    
    public void setSystem(SystemObject system) {
        this.system = system;
    }
    
    public MemberObject getMember() {
        return member;
    }
    
    public void setMember(MemberObject member) {
        this.member = member;
    }
}
