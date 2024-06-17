CREATE DATABASE gondor_chic;
CREATE USER gondor_chic WITH PASSWORD 'gondor_chic';
ALTER DATABASE gondor_chic OWNER TO gondor_chic;

CREATE TABLE t_produit(
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
-- new script

CREATE TABLE t_client(
                         numero VARCHAR(10) PRIMARY KEY,
                         pseudo VARCHAR(35) NOT NULL,
                         motDePasse TEXT NOT NULL,
                         nom VARCHAR(35) NOT NULL,
                         prenom VARCHAR(35) NOT NULL,
                         email VARCHAR(50) NOT NULL,
                         profil text NOT NULL
);
CREATE SEQUENCE sClient;

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE OR REPLACE FUNCTION hash_password(password text) RETURNS text AS $$
BEGIN
    RETURN crypt(password, gen_salt('bf'));
END;
$$ LANGUAGE plpgsql VOLATILE STRICT SECURITY DEFINER;


