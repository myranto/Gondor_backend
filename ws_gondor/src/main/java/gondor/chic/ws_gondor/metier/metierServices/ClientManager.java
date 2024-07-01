package gondor.chic.ws_gondor.metier.metierServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import gondor.chic.ws_gondor.metier.modele.Client;
import gondor.chic.ws_gondor.repository.UserRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
//public class ClientManager implements UserDetailsService {
public class ClientManager {

    @Autowired
    private UserRepository userRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private static final Logger logger = LoggerFactory.getLogger(ClientManager.class);

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////
////        logger.debug("Entering in loadUserByUsername Method...");
////        Client user = userRepository.rechercherClientParPseudo(username);
////
////        if (user == null) {
////            logger.error("Username not found: " + username);
////            throw new UsernameNotFoundException("could not found user..!!");
////        }
////        logger.info("User Authenticated Successfully..!!!");
////        return new CustomUserDetails(user);
//        return  null;
//    }
    public Client login(String username, String password) throws Exception {
        Client user = userRepository.rechercherClientParPseudo(username);
        if (user != null) {
            return user;
        }
         throw new Exception("could not found user"+username+"..!!");
    }
    public void ajouterClient(Client client){
        client.setMotdepasse(md5Hash(client.getMotDePasse()));
        this.userRepository.save(client);
    }
    public static String md5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] hashBytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte hashByte : hashBytes) {
                sb.append(Integer.toString((hashByte & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
