package gondor.chic.ws_gondor.metierServices.metierRelationel;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name="T_PRODUIT")
public class Produit {
    @Id()
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "varchar")
    private String reference;
    @Column(columnDefinition = "varchar")
    private String libelle;
    @Column(columnDefinition = "double precision")
    private Float prix;
    @Column(columnDefinition = "boolean")
    private Boolean estDuJour;
    @Column(columnDefinition = "integer")
    private Integer quantiteEnStock;

    public Produit(){}

    public Produit(
        String reference,
        String libelle,
        Float prix,
        Boolean estDuJour,
        Integer quantiteEnStock
    ){
        this.reference = reference;
        this.libelle = libelle;
        this.prix = prix;
        this.estDuJour = estDuJour;
        this.quantiteEnStock = quantiteEnStock;
    }

    public Boolean getEstDuJour(){
        return this.estDuJour;
    }
}
