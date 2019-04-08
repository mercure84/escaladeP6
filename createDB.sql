create table membre
(
	id serial not null
		constraint membre_pkey
			primary key,
	nom varchar(30) not null,
	prenom varchar(30) not null,
	pseudo varchar(30) not null,
	encrypted_password varchar(128) not null,
	date_naissance date,
	email varchar(255) not null,
	tel_mobile varchar(12),
	date_inscription date,
	biographie varchar(255),
	code_postal integer,
	ville varchar(255),
	enabled boolean default true not null
);

alter table membre owner to postgres;

create unique index membre_email_uindex
	on membre (email);

create unique index membre_pseudo_uindex
	on membre (pseudo);

create table topo
(
	id serial not null
		constraint topo_pkey
			primary key,
	nom varchar(100) not null,
	description varchar(255),
	membre_id integer not null
		constraint fktopo448590
			references membre,
	disponible boolean,
	a_valider boolean,
	difficulte varchar,
	fichier bytea,
	departement integer,
	nb_voies integer,
	nom_fichier varchar(50)
);

alter table topo owner to postgres;

create table voie
(
	id serial not null
		constraint voie_pkey
			primary key,
	nom varchar(255) not null,
	topo_id integer not null
		constraint voie_topo_id_fk
			references topo,
	difficulte integer,
	longueur integer,
	nom_site varchar(250)
);

alter table voie owner to postgres;

create table emprunt
(
	id serial not null
		constraint emprunts_pkey
			primary key,
	date_emprunt date,
	date_fin_emprunt date,
	topo_id integer not null
		constraint fkemprunts354870
			references topo,
	membre_id integer not null
		constraint fkemprunts763494
			references membre,
	en_cours boolean default true
);

alter table emprunt owner to postgres;

create table app_role
(
	role_id serial not null
		constraint app_role_pk
			primary key,
	role_name varchar(30) not null
		constraint app_role_uk
			unique
);

alter table app_role owner to postgres;

create table user_role
(
	id serial not null,
	membre_id integer not null
		constraint user_role_membre_id_fk
			references membre,
	role_id integer not null
		constraint user_role_fk2
			references app_role,
	constraint user_role_uk
		unique (membre_id, role_id)
);

alter table user_role owner to postgres;

create table persistent_logins
(
	username varchar(64) not null,
	series varchar(64) not null
		constraint persistent_logins_pkey
			primary key,
	token varchar(64) not null,
	last_used timestamp not null
);

alter table persistent_logins owner to postgres;

create table commentaire
(
	memo varchar(1000) not null,
	membre_id integer not null
		constraint commentaire_membre_id_fk
			references membre,
	topo_id integer
		constraint commentaire_topo_id_fk
			references topo,
	date timestamp,
	visible boolean default true,
	id serial not null
		constraint commentaire_pk
			primary key
);

alter table commentaire owner to postgres;

create unique index commentaire_id_uindex_2
	on commentaire (id);

