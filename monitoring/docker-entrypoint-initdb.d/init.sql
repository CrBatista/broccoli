CREATE TABLE users (
	name varchar(255) primary_key,
	password varchar(255),
	role varchar(255)
);

INSERT INTO users (name, password, role) VALUES ('broccoli',  'fb8da64f829e8fc7b40a665758c069e6', 'ADMIN');