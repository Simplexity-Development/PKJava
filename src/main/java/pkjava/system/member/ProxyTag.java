package pkjava.system.member;

@SuppressWarnings("unused") //Library, this is being used externally
public class ProxyTag {
    
    private String prefix;
    private String suffix;
    
    public String getPrefix() {
        return prefix;
    }
    
    public String getSuffix() {
        return suffix;
    }
    
    public void setPrefix(String prefixTag) {
        this.prefix = prefixTag;
    }
    
    public void setSuffix(String suffixTag) {
        this.suffix = suffixTag;
    }
    @Override
    public String toString() {
        String proxyTagsString = "";
        if (prefix != null) {
            proxyTagsString += prefix;
        }
        proxyTagsString += "text";
        if (suffix != null) {
            proxyTagsString += suffix;
        }
        return proxyTagsString;
    }
}