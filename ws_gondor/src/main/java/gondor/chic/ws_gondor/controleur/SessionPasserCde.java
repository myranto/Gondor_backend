package gondor.chic.ws_gondor.controleur;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gondor.chic.ws_gondor.controleur.security.AuthRequestDTO;
import gondor.chic.ws_gondor.metier.metierServices.ClientManager;
import gondor.chic.ws_gondor.metier.metierServices.ProduitManager;
import gondor.chic.ws_gondor.metier.modele.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
@CrossOrigin
public class SessionPasserCde {
    @SuppressWarnings("unused")
    private final ProduitManager produitService;
    private final ObjectMapper objectMapper = new ObjectMapper(); // TODO autowire
    private final ClientManager serviceImp;
    @Autowired
    public SessionPasserCde(ProduitManager produitService, ClientManager serviceImp) {
        this.produitService = produitService;
        this.serviceImp = serviceImp;
    }
    @PostMapping("/login")
    public ResponseEntity<?> AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO){
        try {
            Client login = serviceImp.login(authRequestDTO.getUsername(), authRequestDTO.getPassword());
            return ResponseEntity.ok(login);
        }catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/du-jour")
    public ResponseEntity<?> getProduitDuJour() {
        try {
            //return this.objectMapper.writeValueAsString(this.produitService.rechercherProduitDuJour());
            return ResponseEntity.ok(this.produitService.rechercherProduitDuJour());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getProduits() {
        try {
            return ResponseEntity.ok(this.produitService.listerTousLesProduits());
           // return this.objectMapper.writeValueAsString(this.produitService.listerTousLesProduits());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            //return "error";
        }
    }
}
