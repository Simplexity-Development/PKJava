package pkjava.system.switches;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused") //Library, this is being used externally
public class Switches {
    private UUID id;
    private String timestamp;
    private List<String> members;
    
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
    
    public List<String> getMembers() {
        return members;
    }
    
    public void setMembers(List<String> members) {
        this.members = members;
    }
}
