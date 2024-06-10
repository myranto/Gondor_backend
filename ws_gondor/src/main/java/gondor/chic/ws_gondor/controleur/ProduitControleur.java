package gondor.chic.ws_gondor.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gondor.chic.ws_gondor.metierServices.ProduitManager;

// @RequestMapping(path = "api/v1/produits")
@RestController
@RequestMapping(path = "/")
public class ProduitControleur {
    @SuppressWarnings("unused")
    private final ProduitManager produitService;
    private final ObjectMapper objectMapper = new ObjectMapper(); // TODO autowire

    @Autowired
    public ProduitControleur(ProduitManager produitService) {
        this.produitService = produitService;
    }

    @GetMapping()
    public String getProduitDuJour() {
        try {
            return this.objectMapper.writeValueAsString(this.produitService.rechercherProduitDuJour());
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }
}
