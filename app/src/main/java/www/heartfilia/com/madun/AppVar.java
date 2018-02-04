package www.heartfilia.com.madun;

/**
 * Created by heartfilia on 04/02/2018.
 */

public class AppVar {
    public static final String LOGIN_URL = "http://192.168.43.15/madun2/crud/login.php";
    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";
}
