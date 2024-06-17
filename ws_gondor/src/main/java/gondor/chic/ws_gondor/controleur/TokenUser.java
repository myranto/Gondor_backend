package gondor.chic.ws_gondor.controleur;

public class TokenUser {
    String token;
    String user;

    public String getToken() {
        return token;
    }

    public String getUser() {
        return user;
    }

    public TokenUser(String token, String user) {
        this.token = token;
        this.user = user;
    }
}
