-- INSERT INTO t_produit VALUES
--     ('PRD'||nextval('sProduit'),'REF'||nextval('sProduitReference'),'Baton enchanté de Lumos',TRUE, 500, 10, 'assets/products/Enchanted-wand-of-lumos.webp'),
--     ('PRD'||nextval('sProduit'),'REF'||nextval('sProduitReference'),'Potion d''éternel jeunesse',TRUE, 500, 8, 'assets/products/Potion-of-eternal-youth.webp'),
--     ('PRD'||nextval('sProduit'),'REF'||nextval('sProduitReference'),'Crystak mythique',TRUE, 500, 10, 'assets/products/Mystic-crystal-orb.webp'),
--     ('PRD'||nextval('sProduit'),'REF'||nextval('sProduitReference'),'Elixir d''invisibilité',TRUE, 200, 5, 'assets/products/Elixir-of-invisibility.webp'),
--     ('PRD'||nextval('sProduit'),'REF'||nextval('sProduitReference'),'Dictionnaire des sociers',TRUE, 400, 2, 'assets/products/Sorcerers-spellbook.webp'),
--     ('PRD'||nextval('sProduit'),'REF'||nextval('sProduitReference'),'Amulette de protection',TRUE, 400, 4, 'assets/products/Amulet-of-protection.webp'),
--     ('PRD'||nextval('sProduit'),'REF'||nextval('sProduitReference'),'Balai de sorcier',TRUE, 250, 2, 'assets/products/Witchs-broomstick.webp'),
--     ('PRD'||nextval('sProduit'),'REF'||nextval('sProduitReference'),'Plume du phoenix',TRUE, 150, 5, 'assets/products/Phoenix-feather-quill.webp')
-- ;
-- new script with bcript

INSERT INTO t_client VALUES
                         ('CL'||nextval('sClient'), 'Frodon', hash_password('frondon123'), 'Sacquet', 'Frodon', 'frodon.sacquet@gmail.com','assets/clients/frodon.jpg'),
                         ('CL'||nextval('sClient'), 'Sam', hash_password('sam123'), 'Gamegie', 'Samsagace', 'sam.gamedie@gmail.com','assets/clients/sam.jpeg'),
                         ('CL'||nextval('sClient'), 'Pippin', hash_password('pipin123'), 'Toucque', 'Peregrin', 'peregrin.toucque@gmail.com','assets/clients/pippin.jpg'),
                         ('CL'||nextval('sClient'), 'Merry', hash_password('merry123'), 'Brandebouc', 'Meriadoc', 'meriadoc.brandebouc@gmail.com','assets/clients/merry.jpg'),
                         ('CL'||nextval('sClient'), 'Bilbon', hash_password('bilbon123'), 'Sacquet', 'Bilbon', 'bilbon.sacquet@gmail.com','assets/clients/biblon.webp'),
                         ('CL'||nextval('sClient'), 'Roi Elrond', hash_password('elrond123'), 'Peredhel', 'Elrond', 'elrond.peredhel@gmail.com','assets/clients/elrond.jpg'),
                         ('CL'||nextval('sClient'), 'Sauron', hash_password('sauron123'), 'Mairon', 'Sauron', 'mairon.sauron@gmail.com','assets/clients/sauron.jpg')
;