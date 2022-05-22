package ProjectBackend.Model.users;

public class UserIdentifier {
    private Integer userID;
    private String APIKey;

    public UserIdentifier(Integer userID, String APIKey) {
        this.userID = userID;
        this.APIKey = APIKey;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getAPIKey() {
        return APIKey;
    }

    public void setAPIKey(String APIKey) {
        this.APIKey = APIKey;
    }
}
