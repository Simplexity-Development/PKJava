package pkjava.utils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
    
    public Map<String, Object> nullMapCheck(JSONObject jsonObject, String key){
        Map<String, Object> map = new HashMap<>();
        if (jsonObject.isNull(key)) {
            return map;
        }
        map = jsonObject.toMap();
        return map;
    }
    
    
}
