package gondor.chic.ws_gondor.metier.metierRelationel;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name = "t_client")
public class Client {
    @Id
    @GeneratedValue(generator = "custom-id")
//    eto koa nisoloiko metier le metierServices
//    @GenericGenerator(name = "custom-id", strategy = "gondor.chic.ws_gondor.metierServices.metierRelationel.CustomIdGenerator")
    @GenericGenerator(name = "custom-id", strategy = "gondor.chic.ws_gondor.metier.metierRelationel.CustomIdGenerator")
    private String numero;
    @Column(columnDefinition = "varchar(35)")
    private String pseudo;
    @Column(columnDefinition = "TEXT")
    private String motdepasse;
    @Column(columnDefinition = "VARCHAR(35)")
    private String nom;
    @Column(columnDefinition = "VARCHAR(35)")
    private String prenom;
    @Column(columnDefinition = "VARCHAR(50)")
    private String email;
    @Column(columnDefinition = "text")
    private String profil;

    public Client(String pseudo ,String motdepasse ,String nom ,String prenom ,String email ,String profil){
        this.pseudo = pseudo;
        this.motdepasse = motdepasse;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.profil = profil;
    }

    public Client(){}

    public String getPseudo(){
        return this.pseudo;
    }

    public String getMotDePasse(){
        return this.motdepasse;
    }

    public void setMotdepasse(String motdepasse){
        this.motdepasse = motdepasse;
    }
}
