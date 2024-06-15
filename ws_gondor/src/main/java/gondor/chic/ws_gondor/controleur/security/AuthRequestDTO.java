package gondor.chic.ws_gondor.controleur.security;

public class AuthRequestDTO {

    private String username;
    private String password;

    public String getUsername(){
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
