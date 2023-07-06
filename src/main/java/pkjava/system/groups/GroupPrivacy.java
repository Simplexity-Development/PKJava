package pkjava.system.groups;

/**
 * The type Group privacy.
 */
@SuppressWarnings("unused") //Library, this is being used externally
public class GroupPrivacy {
    private String name_privacy;
    private String description_privacy;
    private String icon_privacy;
    private String list_privacy;
    private String metadata_privacy;
    private String visibility;
    
    /**
     * Gets visibility.
     *
     * @return the visibility
     */
    public String getVisibility() {
        return visibility;
    }
    
    /**
     * Gets name privacy.
     *
     * @return the name privacy
     */
    public String getName_privacy() {
        return name_privacy;
    }
    
    /**
     * Gets description privacy.
     *
     * @return the description privacy
     */
    public String getDescription_privacy() {
        return description_privacy;
    }
    
    /**
     * Gets icon privacy.
     *
     * @return the icon privacy
     */
    public String getIcon_privacy() {
        return icon_privacy;
    }
    
    /**
     * Gets list privacy.
     *
     * @return the list privacy
     */
    public String getList_privacy() {
        return list_privacy;
    }
    
    /**
     * Gets metadata privacy.
     *
     * @return the metadata privacy
     */
    public String getMetadata_privacy() {
        return metadata_privacy;
    }
    
    /**
     * Sets visibility.
     *
     * @param new_visibility the new visibility
     */
    public void setVisibility(String new_visibility) {
        this.visibility = new_visibility;
    }
    
    /**
     * Sets name privacy.
     *
     * @param name_privacy the name privacy
     */
    public void setName_privacy(String name_privacy) {
        this.name_privacy = name_privacy;
    }
    
    /**
     * Sets description privacy.
     *
     * @param description_privacy the description privacy
     */
    public void setDescription_privacy(String description_privacy) {
        this.description_privacy = description_privacy;
    }
    
    /**
     * Sets metadata privacy.
     *
     * @param metadata_privacy the metadata privacy
     */
    public void setMetadata_privacy(String metadata_privacy) {
        this.metadata_privacy = metadata_privacy;
    }
    
    
    /**
     * Sets icon privacy.
     *
     * @param icon_privacy the icon privacy
     */
    public void setIcon_privacy(String icon_privacy) {
        this.icon_privacy = icon_privacy;
    }
    
    
    /**
     * Sets list privacy.
     *
     * @param list_privacy the list privacy
     */
    public void setList_privacy(String list_privacy) {
        this.list_privacy = list_privacy;
    }
}