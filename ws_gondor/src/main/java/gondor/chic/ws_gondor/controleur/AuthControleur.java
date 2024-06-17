package gondor.chic.ws_gondor.controleur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.web.bind.annotation.*;

import gondor.chic.ws_gondor.controleur.security.AuthRequestDTO;
import gondor.chic.ws_gondor.controleur.security.JwtService;
import gondor.chic.ws_gondor.metier.ClientServiceImp;

@RestController
@RequestMapping(path = "/")
@CrossOrigin("*")
public class AuthControleur {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;

    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImp.class);


    @PostMapping("/login")
    public TokenUser AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        logger.debug("user authenticated",authentication.getCredentials());
        if(authentication.isAuthenticated()){
            System.out.println("connecter avec success");
        return new TokenUser(authentication.getName(),jwtService.GenerateToken(authRequestDTO.getUsername())); //.build();
        // return JwtResponseDTO.builder()
        //         .accessToken(jwtService.GenerateToken(authRequestDTO.getUsername()).build();
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
//        return "connected";
    }
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody AuthRequestDTO authRequestDTO){
//        return ResponseEntity.ok(authRequestDTO);
//    }
}
