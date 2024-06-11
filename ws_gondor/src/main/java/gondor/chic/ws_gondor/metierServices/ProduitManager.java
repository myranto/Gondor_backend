package gondor.chic.ws_gondor.metierServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gondor.chic.ws_gondor.metierServices.metierRelationel.Produit;
import gondor.chic.ws_gondor.repository.ProduitRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service()
public class ProduitManager {
    private final ProduitRepository produitRepository;

    @Autowired()
    public ProduitManager(ProduitRepository produitRepository){
        this.produitRepository = produitRepository;
    }

    public Produit rechercherProduitDuJour(){
        Produit produitDuJour = this.produitRepository.rechercherProduitDuJour();
        return produitDuJour;
    }

    // for test purposes
    public Produit ajouterProduit(Produit produit){
        return this.produitRepository.save(produit);
    }

    public List<Produit>ajouterProduits(List<Produit>produits){
        return this.produitRepository.saveAll(produits);
    }

    public List<Produit> listerTousLesProduits() {
        return this.produitRepository.findAll();
    }

    public void supprimerTousLesProduits() {
        this.produitRepository.deleteAll();
    }
}
