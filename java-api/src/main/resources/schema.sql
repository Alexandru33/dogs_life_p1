DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS owners;
DROP TABLE IF EXISTS dog_n_owners;


CREATE TABLE dogs (
    dog_id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE owners (

    owner_id INT NOT NULL,
    name VARCHAR(250) NOT NULL

);

CREATE TABLE dog_n_owners (

    id INT NOT NULL ,
    dog_owner VARCHAR(250) NOT NULL,
    dog VARCHAR(250) NOT NULL
);