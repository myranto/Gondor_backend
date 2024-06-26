package gondor.chic.ws_gondor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gondor.chic.ws_gondor.metier.modele.Client;

public interface UserRepository extends JpaRepository<Client, String>,
        JpaSpecificationExecutor<Client> {

    @Query(value = "select * from t_client where pseudo = :pseudo LIMIT 1", nativeQuery = true)
    Client rechercherClientParPseudo(@Param("pseudo") String pseudo);

    // Client rechercherParNumero(String numero);

}