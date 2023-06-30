package system.groups;

public class GroupPrivacy {
    
    private String name_privacy;
    private String description_privacy;
    private String icon_privacy;
    private String list_privacy;
    private String metadata_privacy;
    private String visibility;
    
    public String getVisibility() {
        return visibility;
    }
    
    public String getName_privacy() {
        return name_privacy;
    }
    
    public String getDescription_privacy() {
        return description_privacy;
    }
    
    public String getIcon_privacy() {
        return icon_privacy;
    }
    
    public String getList_privacy() {
        return list_privacy;
    }
    
    public String getMetadata_privacy() {
        return metadata_privacy;
    }
    
    public void setVisibility(String new_visibility) {
        this.visibility = new_visibility;
    }
    
    public void setName_privacy(String name_privacy) {
        this.name_privacy = name_privacy;
    }
    
    public void setDescription_privacy(String description_privacy) {
        this.description_privacy = description_privacy;
    }
    
    public void setMetadata_privacy(String metadata_privacy) {
        this.metadata_privacy = metadata_privacy;
    }
    
    
    public void setIcon_privacy(String icon_privacy) {
        this.icon_privacy = icon_privacy;
    }
    
    
    public void setList_privacy(String list_privacy) {
        this.list_privacy = list_privacy;
    }
}