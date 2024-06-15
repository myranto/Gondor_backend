package gondor.chic.ws_gondor.metierServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import gondor.chic.ws_gondor.metierServices.metierRelationel.Client;
import gondor.chic.ws_gondor.metierServices.metierRelationel.CustomUserDetails;
import gondor.chic.ws_gondor.repository.UserRepository;

@Component
public class ClientServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImp.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.debug("Entering in loadUserByUsername Method...");
        Client user = userRepository.rechercherClientParPseudo(username);
        
        if (user == null) {
            logger.error("Username not found: " + username);
            throw new UsernameNotFoundException("could not found user..!!");
        }
        logger.info("User Authenticated Successfully..!!!");
        return new CustomUserDetails(user);
    }

    public void ajouterClient(Client client){
        client.setMotdepasse(bCryptPasswordEncoder.encode(client.getMotDePasse()));
        this.userRepository.save(client);
    }
}
