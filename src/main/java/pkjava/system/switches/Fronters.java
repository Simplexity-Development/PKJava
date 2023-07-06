package pkjava.system.switches;

import pkjava.system.member.MemberObject;

import java.util.List;
import java.util.UUID;

/**
 * The type Fronters.
 */
@SuppressWarnings("unused") //Library, this is being used externally
public class Fronters {
    private UUID id;
    private String timestamp;
    private List<MemberObject> members;
    
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
    public List<MemberObject> getMembers() {
        return members;
    }
    
    /**
     * Sets members.
     *
     * @param members the members
     */
    public void setMembers(List<MemberObject> members) {
        this.members = members;
    }
}
