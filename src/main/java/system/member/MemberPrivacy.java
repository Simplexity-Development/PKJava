package system.member;

public class MemberPrivacy {
    
    private String visibility;
    private String name_privacy;
    private String description_privacy;
    private String birthday_privacy;
    private String pronoun_privacy;
    private String avatar_privacy;
    private String metadata_privacy;
    
    public String getVisibility() {
        return visibility;
    }
    
    public String getName_privacy() {
        return name_privacy;
    }
    
    public String getDescription_privacy() {
        return description_privacy;
    }
    
    public String getBirthday_privacy() {
        return birthday_privacy;
    }
    
    public String getPronoun_privacy() {
        return pronoun_privacy;
    }
    
    public String getAvatar_privacy() {
        return avatar_privacy;
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
    
    public void setBirthday_privacy(String birthday_privacy) {
        this.birthday_privacy = birthday_privacy;
    }
    
    public void setAvatar_privacy(String avatar_privacy) {
        this.avatar_privacy = avatar_privacy;
    }
    
    public void setPronoun_privacy(String pronoun_privacy) {
        this.pronoun_privacy = pronoun_privacy;
    }
    
    public void setMetadata_privacy(String metadata_privacy) {
        this.metadata_privacy = metadata_privacy;
    }
}