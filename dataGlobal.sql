INSERT INTO public.membre (id, nom, prenom, pseudo, encrypted_password, date_naissance, email, tel_mobile, date_inscription, biographie, code_postal, ville, enabled) VALUES (7, 'Marcesse', 'Julien', 'mjuju92', '$2a$10$13zmiREUVwEGkuHf211msuTK/GQkQ.mAyDL3wS/hy9bE98eRQkPh2', null, 'julien.marcesse@gmail.com', '0', null, null, 0, null, true);
INSERT INTO public.membre (id, nom, prenom, pseudo, encrypted_password, date_naissance, email, tel_mobile, date_inscription, biographie, code_postal, ville, enabled) VALUES (8, 'Mentor', 'Jacky', 'jacky59', '$2a$10$fn.JBJM7idE.EMIFU2RiX.Ej0UhctaJbYwy/lMCERO6q//46DFGdS', null, 'jack1985@google.fr', '0', null, null, 0, null, true);
INSERT INTO public.membre (id, nom, prenom, pseudo, encrypted_password, date_naissance, email, tel_mobile, date_inscription, biographie, code_postal, ville, enabled) VALUES (9, 'Marant', 'Arnaud', 'hokkos', '$2a$10$.hBACjymNOz0JiE5fRwZaeDqUVCTpGPXjZaxecKoskwB0WjxiEvoS', null, 'hokkos@hok.fr', '0', null, null, 0, null, true);
INSERT INTO public.membre (id, nom, prenom, pseudo, encrypted_password, date_naissance, email, tel_mobile, date_inscription, biographie, code_postal, ville, enabled) VALUES (10, 'TesteurNOM', 'TesteurPRENOM', 'test', '$2a$10$oBEmCOMGUreAMKzO8Whpduq3cA0T5HXYgUdpICHi3Tg99v4JxWzti', null, 'test@test.fr', '0', null, null, 0, null, true);
INSERT INTO public.membre (id, nom, prenom, pseudo, encrypted_password, date_naissance, email, tel_mobile, date_inscription, biographie, code_postal, ville, enabled) VALUES (11, 'Pagode', 'Lux', 'lux2015', '$2a$10$o1bJJGdonjj96KogzUZIEu9MarDfhMw0XFI1Xlq3DllKyCuFLu976', null, 'lux@lux.fr', '0', null, null, 0, null, true);
INSERT INTO public.membre (id, nom, prenom, pseudo, encrypted_password, date_naissance, email, tel_mobile, date_inscription, biographie, code_postal, ville, enabled) VALUES (12, 'Bully', 'Mercure', 'mercure1984', '$2a$10$IeUpx7fOGHlTb3aZbWbkl.zQq6aSLEj8OjpMss/h5aus.7uR2Gkka', null, 'mercure@debull.fr', '0', null, null, 0, null, true);
INSERT INTO public.membre (id, nom, prenom, pseudo, encrypted_password, date_naissance, email, tel_mobile, date_inscription, biographie, code_postal, ville, enabled) VALUES (13, 'GrimpeurDeOuf', 'Lucky', 'grimpeurdeOuf', '$2a$10$MyHUl/S0uSW1k8QUJOjgUe55ik5CJSv.rsrn3iIeudDZohwiAPnMK', null, 'luck@poutre.fr', '0', null, null, 0, null, true);


INSERT INTO public.app_role (role_id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.app_role (role_id, role_name) VALUES (2, 'ROLE_USER');
INSERT INTO public.app_role (role_id, role_name) VALUES (3, 'ROLE_BANNI');


INSERT INTO public.user_role (id, membre_id, role_id) VALUES (6, 8, 2);
INSERT INTO public.user_role (id, membre_id, role_id) VALUES (7, 9, 2);
INSERT INTO public.user_role (id, membre_id, role_id) VALUES (8, 10, 2);
INSERT INTO public.user_role (id, membre_id, role_id) VALUES (9, 11, 2);
INSERT INTO public.user_role (id, membre_id, role_id) VALUES (10, 12, 2);
INSERT INTO public.user_role (id, membre_id, role_id) VALUES (11, 13, 2);
INSERT INTO public.user_role (id, membre_id, role_id) VALUES (5, 7, 1);

INSERT INTO public.topo (id, nom, description, membre_id, disponible, a_valider, difficulte, fichier, departement, nb_voies, nom_fichier) VALUES (12, 'Colline de la maison dans la prairie', 'aucune difficulté sur ce site qui est tout plat', 8, true, false, 'intermediaire', null, 16, 28, 'Colline de la maison dans la prairie');
INSERT INTO public.topo (id, nom, description, membre_id, disponible, a_valider, difficulte, fichier, departement, nb_voies, nom_fichier) VALUES (3, 'Tour d''Isengard', 'maison de Saruman ! attention très dangereux', 7, true, false, 'expert', null, 75, 3, 'Tour d''Isengard');
INSERT INTO public.topo (id, nom, description, membre_id, disponible, a_valider, difficulte, fichier, departement, nb_voies, nom_fichier) VALUES (9, 'Topo du testeur', 'un topo factice pour les besoins d''un testeur', 10, true, false, 'facile', null, 10, 55, 'Topo du testeur');
INSERT INTO public.topo (id, nom, description, membre_id, disponible, a_valider, difficulte, fichier, departement, nb_voies, nom_fichier) VALUES (6, 'Acroporas des poissons anges', 'insane !!!', 7, false, false, 'facile', null, 12, 7, 'Acroporas des poissons anges');
INSERT INTO public.topo (id, nom, description, membre_id, disponible, a_valider, difficulte, fichier, departement, nb_voies, nom_fichier) VALUES (10, 'Mur de Pandemonium', 'à la porte des enfers', 10, true, false, 'facile', null, 30, 5, 'Mur de Pandemonium');
INSERT INTO public.topo (id, nom, description, membre_id, disponible, a_valider, difficulte, fichier, departement, nb_voies, nom_fichier) VALUES (8, 'Pylone des protoss', 'Avec la fonction rappel de masse activée', 13, true, false, 'facile', null, 90, 5, 'Pylone des protoss');
INSERT INTO public.topo (id, nom, description, membre_id, disponible, a_valider, difficulte, fichier, departement, nb_voies, nom_fichier) VALUES (7, 'Sequoia du destin', 'remake de la montagne du destin', 12, false, false, 'facile', null, 19, 5, 'Sequoia du destin');
INSERT INTO public.topo (id, nom, description, membre_id, disponible, a_valider, difficulte, fichier, departement, nb_voies, nom_fichier) VALUES (4, 'Arbre à chats', 'pour les petits et grands, mais mieux vaut être un félin !', 11, true, false, 'intermediaire', null, 68, 8, 'Arbre à chats');
INSERT INTO public.topo (id, nom, description, membre_id, disponible, a_valider, difficulte, fichier, departement, nb_voies, nom_fichier) VALUES (5, 'Falaise de Batman', 'à la sortie de la grotte dîte batcave', 7, true, false, 'expert', null, 11, 19, 'Falaire de Batman');
INSERT INTO public.topo (id, nom, description, membre_id, disponible, a_valider, difficulte, fichier, departement, nb_voies, nom_fichier) VALUES (11, 'Topo des Araignées', 'Repaire des réprouvés de Sylvanas Coursevent', 7, true, false, 'expert', null, 75, 6, 'Topo des Araignées');

INSERT INTO public.voie (id, nom, topo_id, difficulte, longueur, nom_site) VALUES (1, 'Voie de Gandalf', 3, 2, 50, '');
INSERT INTO public.voie (id, nom, topo_id, difficulte, longueur, nom_site) VALUES (2, 'Voie des hobbits', 3, 5, 60, '');
INSERT INTO public.voie (id, nom, topo_id, difficulte, longueur, nom_site) VALUES (3, 'Aiur', 3, 3, 48, '');
INSERT INTO public.voie (id, nom, topo_id, difficulte, longueur, nom_site) VALUES (4, 'Branche nord', 4, 1, 27, '');
INSERT INTO public.voie (id, nom, topo_id, difficulte, longueur, nom_site) VALUES (5, 'Voie de Test', 9, 5, 30, '');
INSERT INTO public.voie (id, nom, topo_id, difficulte, longueur, nom_site) VALUES (6, 'Voie de Test 2', 9, 3, 64, '');
INSERT INTO public.voie (id, nom, topo_id, difficulte, longueur, nom_site) VALUES (7, 'VoieA', 5, 5, 60, '');
INSERT INTO public.voie (id, nom, topo_id, difficulte, longueur, nom_site) VALUES (8, 'Voie 9 trois quart', 5, 5, 46, 'Poudlard');
INSERT INTO public.voie (id, nom, topo_id, difficulte, longueur, nom_site) VALUES (9, 'Une Voie au hasard', 12, 5, 199, '');

INSERT INTO public.commentaire (memo, membre_id, topo_id, date, visible, id) VALUES ('Attention j''ai croisé Gandalf la dernière fois que j''ai été sur ce spot !', 7, 3, '2019-04-08 20:45:35.014000', false, 12);
INSERT INTO public.commentaire (memo, membre_id, topo_id, date, visible, id) VALUES ('Attention regroupement de poissons chats ici...', 10, 6, '2019-04-08 20:47:35.907000', false, 13);
INSERT INTO public.commentaire (memo, membre_id, topo_id, date, visible, id) VALUES ('Site vraiment pas très intéressant...', 10, 4, '2019-04-08 20:48:17.489000', false, 14);
INSERT INTO public.commentaire (memo, membre_id, topo_id, date, visible, id) VALUES ('ma', 10, 7, '2019-04-08 20:48:26.894000', false, 15);
INSERT INTO public.commentaire (memo, membre_id, topo_id, date, visible, id) VALUES ('mais qui a créé ce topo !!! faut arrêter de regarder le seigneur des anneaux', 10, 7, '2019-04-08 20:48:42.567000', false, 16);
INSERT INTO public.commentaire (memo, membre_id, topo_id, date, visible, id) VALUES ('Pareil... Gandalf m''a coursé sur 300 mètres...', 10, 3, '2019-04-08 20:53:19.933000', false, 17);
INSERT INTO public.commentaire (memo, membre_id, topo_id, date, visible, id) VALUES ('il y avait des zergs quand j''y suis allé !', 11, 8, '2019-04-08 20:57:41.092000', false, 18);
INSERT INTO public.commentaire (memo, membre_id, topo_id, date, visible, id) VALUES ('cool ce topo ! ', 7, 9, '2019-04-08 21:35:42.100000', false, 19);
INSERT INTO public.commentaire (memo, membre_id, topo_id, date, visible, id) VALUES ('il y a des scorpions aussi !', 7, 11, '2019-04-08 21:56:23.087000', false, 20);
INSERT INTO public.commentaire (memo, membre_id, topo_id, date, visible, id) VALUES ('ne pas y aller si vous avez peur des insectes en gros...', 7, 11, '2019-04-08 21:56:35.378000', false, 21);

INSERT INTO public.emprunt (id, date_emprunt, date_fin_emprunt, topo_id, membre_id, en_cours) VALUES (12, '2019-04-08', '2019-05-03', 7, 7, true);
INSERT INTO public.emprunt (id, date_emprunt, date_fin_emprunt, topo_id, membre_id, en_cours) VALUES (13, '2019-04-08', '2019-04-14', 6, 10, true);
INSERT INTO public.emprunt (id, date_emprunt, date_fin_emprunt, topo_id, membre_id, en_cours) VALUES (11, '2019-04-08', '2019-04-08', 5, 7, false);