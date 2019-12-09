package tr.org.open.seruvent.citybugs.model;

import java.io.Serializable;

/**
 * Bu class'ın amacı mobil uygulamalardan gelen isteği parse etmek içindir
 */
public class AuthRequest implements Serializable {

    private int appId;
    private String accessToken;
    private String appUserId;

    //need default constructor for JSON Parsing
    public AuthRequest()
    {

    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }
}
