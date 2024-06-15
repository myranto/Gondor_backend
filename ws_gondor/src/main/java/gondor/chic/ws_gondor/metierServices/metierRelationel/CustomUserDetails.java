package gondor.chic.ws_gondor.metierServices.metierRelationel;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends Client implements UserDetails {

    private String username;
    private String password;

    public CustomUserDetails(Client byUsername) {
        this.username = byUsername.getPseudo();
        this.password = byUsername.getMotDePasse();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>(); // not required in our case
    }
}
