package manager;

import java.util.ResourceBundle;

public class Config {
    private static Config instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "config";
    public static final String MAIN = "MAIN";
    public static final String ADDUSER = "ADDUSERS";
    public static final String ALLUSERS = "ALLUSERS";
    public static final String ALLDISCIPLINES = "ALLDISCIPLINES";
    public static final String ADDMARK = "ADDMARK";
    public static final String LOGIN = "LOGIN";
    public static final String ADDDISCIPLINEFORUSER = "ADDDISCIPLINEFORUSER";
    public static final String REGISTERUSER = "REGISTERUSER";
    public static final String USERDISCIPLINES = "USERDISCIPLINES";


    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }
    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}