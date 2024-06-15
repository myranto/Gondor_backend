package gondor.chic.ws_gondor.metierServices.metierRelationel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name = "t_client")
public class Client {
    @Id()
    @Column(columnDefinition = "varchar(10)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Client(String numero ,String pseudo ,String motdepasse ,String nom ,String prenom ,String email ,String profil){
        this.numero = numero;
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
