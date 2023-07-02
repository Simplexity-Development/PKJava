package pkjava.system.switches;

import pkjava.system.member.MemberObject;

import java.util.List;
import java.util.UUID;

public class Fronters {
    private static Fronters instance;
    
    public Fronters() {
    }
    
    public static Fronters getInstance() {
        if (instance == null) instance = new Fronters();
        return instance;
    }
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