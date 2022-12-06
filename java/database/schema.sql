BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE accounts (
    account_id SERIAL,
    user_id int NOT NULL,
    liked_movies varchar (1000),        
    disliked_movies varchar (1000),
    favorites varchar (1000),
    preferred_genre varchar (1000),
    CONSTRAINT PK_account_id PRIMARY KEY (account_id),
    CONSTRAINT FK_user_id FOREIGN KEY(user_id) REFERENCES users(user_id)

);

CREATE TABLE movies (
    movie_id int PRIMARY KEY,
    title varchar (200) NOT NULL,
    release_date date NULL,
    genre_id varchar (1000) NOT NULL,
    description text NULL,
    picture_path varchar(200) NULL
);

COMMIT TRANSACTION;
