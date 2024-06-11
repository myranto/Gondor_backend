package gondor.chic.ws_gondor.metierServices.metierRelationel;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name="t_produit")
public class Produit {
    @Id()
    @Column(columnDefinition = "varchar")
    private String id;
    @Column(columnDefinition = "varchar")
    private String reference;
    @Column(columnDefinition = "varchar")
    private String libelle;
    @Column(columnDefinition = "double precision")
    private Float prix;
    @Column(columnDefinition = "boolean")
    private Boolean estdujour;
    @Column(columnDefinition = "integer")
    private Integer quantiteenstock;
    @Column(columnDefinition = "text")
    private String images;

    public Produit(){}

    public Produit(String id,
        String reference,
        String libelle,
        Float prix,
        Boolean estdujour,
        Integer quantiteenstock,
        String images
    ){
        this.id=id;
        this.reference = reference;
        this.libelle = libelle;
        this.prix = prix;
        this.estdujour = estdujour;
        this.quantiteenstock = quantiteenstock;
        this.images=images;
    }

    public Boolean getEstDuJour(){
        return this.estdujour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Boolean getEstdujour() {
        return estdujour;
    }

    public void setEstdujour(Boolean estdujour) {
        this.estdujour = estdujour;
    }

    public Integer getQuantiteenstock() {
        return quantiteenstock;
    }

    public void setQuantiteenstock(Integer quantiteenstock) {
        this.quantiteenstock = quantiteenstock;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
