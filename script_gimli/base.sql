CREATE DATABASE gondor_chic;
CREATE USER gondor_chic WITH PASSWORD 'gondor_chic';
ALTER DATABASE gondor_chic OWNER TO gondor_chic;

CREATE TABLE Produit(
    id VARCHAR(10) PRIMARY KEY,
    reference VARCHAR(10) NOT NULL,
    libelle VARCHAR(35) NOT NULL,
    estDuJour BOOLEAN DEFAULT TRUE,
    prix FLOAT NOT NULL,
    quantiteEnStock INT4 NOT NULL,
    images TEXT
);

CREATE SEQUENCE sProduit;
CREATE SEQUENCE sProduitReference;
