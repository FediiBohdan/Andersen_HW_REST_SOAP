create schema andersen;

alter schema andersen owner to postgres;

create table if not exists country
(
	id smallserial not null
		constraint country_pkey
			primary key,
	name varchar(100)
);

alter table country owner to postgres;

create table if not exists city
(
	id bigserial not null
		constraint city_pkey
			primary key,
	name varchar(100),
	lat varchar(11),
	lon varchar(11),
	country_id smallint
		constraint city_country_id_fkey
			references country
);

alter table city owner to postgres;

create table if not exists "user"
(
	id bigserial not null
		constraint user_pkey
			primary key,
	name varchar(30),
	email varchar(255),
	country_id smallint
		constraint user_country_id_fkey
			references country,
	city_id bigint
		constraint user_city_id_fkey
			references city,
	dateoflastupdate timestamp,
	dateofcreation timestamp,
	isdeleted boolean
);

alter table "user" owner to postgres;

