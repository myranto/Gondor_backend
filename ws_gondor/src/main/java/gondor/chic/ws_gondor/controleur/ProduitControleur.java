package gondor.chic.ws_gondor.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gondor.chic.ws_gondor.metier.ProduitManager;

// @RequestMapping(path = "api/v1/produits")
@RestController
@RequestMapping(path = "/")
@CrossOrigin
public class ProduitControleur {
    @SuppressWarnings("unused")
    private final ProduitManager produitService;
    private final ObjectMapper objectMapper = new ObjectMapper(); // TODO autowire

    @Autowired
    public ProduitControleur(ProduitManager produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/du-jour")
    public String getProduitDuJour() {
        try {
            return this.objectMapper.writeValueAsString(this.produitService.rechercherProduitDuJour());
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/")
    public String getProduits() {
        try {
            return this.objectMapper.writeValueAsString(this.produitService.listerTousLesProduits());
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }
}
