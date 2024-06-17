package gondor.chic.ws_gondor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import gondor.chic.ws_gondor.metier.metierRelationel.Produit;

public interface ProduitRepository extends JpaRepository<Produit, String>, 
        JpaSpecificationExecutor<Produit> {

    @Query(value = "select * from t_produit where estdujour = true LIMIT 1", nativeQuery = true)
    Produit rechercherProduitDuJour();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update t_produit set estDuJour=false where estDuJour=true", nativeQuery = true)
    void removeProduitDuJour();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update t_produit set estDuJour=true where reference=?1", nativeQuery = true)
    void setProduitDuJour(String reference); 

}
