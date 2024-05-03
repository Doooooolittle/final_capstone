DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS castle CASCADE;
DROP TABLE IF EXISTS img;
DROP TABLE IF EXISTS visit CASCADE;
DROP TABLE IF EXISTS itinerary CASCADE;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


CREATE TABLE castle (
	castle_id serial primary key,
	castle_name varchar(50) NOT NULL,
	castle_banner_photo varchar(250) NOT NULL,
	short_desc varchar(250) NOT NULL,
	long_desc text,
	address varchar(255) NOT NULL,
	longitude varchar(50),
	latitude varchar(50),
	site_url varchar(255),
	map_location text,
	region text
);


CREATE TABLE img (
 	img_id serial primary key,
	castle_id int,
 	img_name varchar(50) NOT NULL,
 	img_path varchar(255) NOT NULL,
 	CONSTRAINT FK_img FOREIGN KEY(castle_id) REFERENCES castle(castle_id)
 );


CREATE TABLE visit (
	visit_id SERIAL PRIMARY KEY,
	username varchar(50),
	castle_id int,
	visit_date date,
	CONSTRAINT FK_visit_user FOREIGN KEY(username) REFERENCES users(username),
	CONSTRAINT FK_visit_castle FOREIGN KEY(castle_id) REFERENCES castle(castle_id)
);