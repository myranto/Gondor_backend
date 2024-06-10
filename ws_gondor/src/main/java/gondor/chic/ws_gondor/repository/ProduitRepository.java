package gondor.chic.ws_gondor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gondor.chic.ws_gondor.metierServices.metierRelationel.Produit;

public interface ProduitRepository extends JpaRepository<Produit, String>, 
        JpaSpecificationExecutor<Produit> {

    @Query(value = "select * from t_produit where est_du_jour = true", nativeQuery = true)
    Produit rechercherProduitDuJour();

}
