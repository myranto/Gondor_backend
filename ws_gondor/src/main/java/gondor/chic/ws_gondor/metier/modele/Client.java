package gondor.chic.ws_gondor.metier.modele;

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
    @GenericGenerator(name = "custom-id", strategy = "gondor.chic.ws_gondor.metier.modele.CustomIdGenerator")
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public void setMotdepasse(String motdepasse){
        this.motdepasse = motdepasse;
    }
}
