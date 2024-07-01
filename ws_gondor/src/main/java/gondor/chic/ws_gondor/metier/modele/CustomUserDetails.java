package gondor.chic.ws_gondor.metier.modele;

import java.util.ArrayList;
import java.util.Collection;


public class CustomUserDetails extends Client {

    private String username;
    private String password;

    public CustomUserDetails(Client byUsername) {
        this.username = byUsername.getPseudo();
        this.password = byUsername.getMotDePasse();
    }

}
