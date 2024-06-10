package gondor.chic.ws_gondor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atMost;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gondor.chic.ws_gondor.metierServices.ProduitManager;
import gondor.chic.ws_gondor.metierServices.metierRelationel.Produit;

@SpringBootTest()
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WsGondorApplicationTests {

    @Autowired()
    private ProduitManager produitManager;

    @Test
    void contextLoads() {
    }

    @Test
    @Order(1)
    void ajouterProduit(){
        Produit produit1 = new Produit(null, "Figurine Lego Bilbo", new Float(30.5), false, 3);
        Produit produit2 = new Produit(null, "Anneau magique", new Float(120), true, 1);
        Produit produit3 = new Produit(null, "Arc + flèches(10)", new Float(50), false, 1);
        List<Produit>produits = new ArrayList<Produit>();
        produits.add(produit1);
        produits.add(produit2);
        produits.add(produit3);
        produitManager.ajouterProduits(produits);
    }
    
    @Test
    @Order(2)
    void rechercherProduitDuJour() {
        Produit produit = this.produitManager.rechercherProduitDuJour();
        assertNotNull(produit);
        assertTrue(produit.getEstDuJour());
    }
    
    @Test
    @Order(3)
    void supprimerProduit() {
        this.produitManager.supprimerTousLesProduits();
        List<Produit>produits = this.produitManager.listerTousLesProduits();
        assertEquals(produits.size(), 0);
    }
}
