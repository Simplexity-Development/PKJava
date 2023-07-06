package pkjava.system.switches;

import java.util.List;
import java.util.UUID;

/**
 * The type Switches.
 */
@SuppressWarnings("unused") //Library, this is being used externally
public class Switches {
    private UUID id;
    private String timestamp;
    private List<String> members;
    
    /**
     * Gets id.
     *
     * @return the id
     */
    public UUID getId() {
        return id;
    }
    
    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(UUID id) {
        this.id = id;
    }
    
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
     * Gets members.
     *
     * @return the members
     */
    public List<String> getMembers() {
        return members;
    }
    
    /**
     * Sets members.
     *
     * @param members the members
     */
    public void setMembers(List<String> members) {
        this.members = members;
    }
}
