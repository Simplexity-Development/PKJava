package pkjava.utils;

import org.json.JSONObject;
import pkjava.system.SystemPrivacy;

public class JSONObjectNullChecks {
    private static JSONObjectNullChecks instance;
    public JSONObjectNullChecks(){}
    public static JSONObjectNullChecks getInstance() {
        if (instance == null) instance = new JSONObjectNullChecks();
        return instance;
    }
    
    public String nullStringCheck(JSONObject jsonObject, String key){
        String string = "";
        if (jsonObject.isNull(key)) {
            return string;
        }
        string = jsonObject.getString(key);
        return string;
    }
    
    public Integer nullIntegerCheck(JSONObject jsonObject, String key){
        Integer integer = null;
        if (jsonObject.isNull(key)) {
            return integer;
        }
        integer = jsonObject.getInt(key);
        return integer;
    }
    
    
}
