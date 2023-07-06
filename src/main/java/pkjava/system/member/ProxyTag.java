package pkjava.system.member;

/**
 * The type Proxy tag.
 */
@SuppressWarnings("unused") //Library, this is being used externally
public class ProxyTag {
    
    private String prefix;
    private String suffix;
    
    /**
     * Gets prefix.
     *
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }
    
    /**
     * Gets suffix.
     *
     * @return the suffix
     */
    public String getSuffix() {
        return suffix;
    }
    
    /**
     * Sets prefix.
     *
     * @param prefixTag the prefix tag
     */
    public void setPrefix(String prefixTag) {
        this.prefix = prefixTag;
    }
    
    /**
     * Sets suffix.
     *
     * @param suffixTag the suffix tag
     */
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