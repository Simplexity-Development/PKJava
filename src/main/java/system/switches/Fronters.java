package system.switches;

import system.member.MemberObject;

import java.util.List;
import java.util.UUID;

public class Fronters {
    private UUID id;
    private String timestamp;
    private List<MemberObject> members;
    
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public List<MemberObject> getMembers() {
        return members;
    }
    
    public void setMembers(List<MemberObject> members) {
        this.members = members;
    }
}
