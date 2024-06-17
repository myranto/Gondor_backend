package gondor.chic.ws_gondor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import gondor.chic.ws_gondor.metier.metierRelationel.Produit;

public interface ProduitRepository extends JpaRepository<Produit, String>,
        JpaSpecificationExecutor<Produit> {

    @Query(value = "select * from t_produit where estdujour = true LIMIT 1", nativeQuery = true)
    Produit rechercherProduitDuJour();

}
