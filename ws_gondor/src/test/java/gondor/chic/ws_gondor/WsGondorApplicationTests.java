package gondor.chic.ws_gondor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import gondor.chic.ws_gondor.metier.ClientServiceImp;
import gondor.chic.ws_gondor.metier.ProduitManager;
import gondor.chic.ws_gondor.metier.metierRelationel.Client;

@SpringBootTest()
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WsGondorApplicationTests {

    @Autowired()
    private ProduitManager produitManager;
    @Autowired()
    private ClientServiceImp clientManager;

    @Test
    void contextLoads() {
    }

    // @Test
    // @Order(1)
    void ajouterProduit(){
        // Produit produit1 = new Produit(null,"PROD-QSDFM", "Figurine Lego Bilbo", new Float(30.5), false, 3, "");
        // Produit produit2 = new Produit(null,"PROD-QSEYH", "Anneau magique", new Float(120), true, 1, "");
        // Produit produit3 = new Produit(null,"PROD-QSEFG", "Arc + flèches(10)", new Float(50), false, 1, "");
        // List<Produit>produits = new ArrayList<Produit>();
        // produits.add(produit1);
        // produits.add(produit2);
        // produits.add(produit3);
        // produitManager.ajouterProduits(produits);
    } 
    
    // @Test
    // @Order(2)
    void rechercherProduitDuJour() {
        // Produit produit = this.produitManager.rechercherProduitDuJour();
        // assertNotNull(produit);
        // assertTrue(produit.getEstDuJour());
    }
    
    // @Test
    // @Order(3)
    void supprimerProduit() {
        // this.produitManager.supprimerTousLesProduits();
        // List<Produit>produits = this.produitManager.listerTousLesProduits();
        // assertEquals(produits.size(), 0);
    }

    @Test
    @Order(4)
    void chercherClientParPseudo(){
        String pseudo = "Bilbon";
        UserDetails userDetails = this.clientManager.loadUserByUsername(pseudo);
        assertEquals(userDetails.getUsername(), pseudo);
    }

    @Test
    @Order(4)
    void ajouterClient(){
        Client client = new Client("Pilou", "mdp", "Caleb", "Stonewall", "cabel@gmail.com", "path.jpg");
        clientManager.ajouterClient(client);
    }
}
