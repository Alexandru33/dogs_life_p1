DROP TABLE IF EXISTS dogs;
<<<<<<< HEAD
DROP TABLE IF EXISTS owners;

CREATE TABLE owners (
    owner_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);
=======
>>>>>>> feature/dogs_tdd

CREATE TABLE dogs (
    dog_id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
<<<<<<< HEAD
    age INT NOT NULL,
    owner_id INT NOT NULL,

    FOREIGN KEY (owner_id) REFERENCES owners (owner_id)
);
=======
    age INT NOT NULL
);

>>>>>>> feature/dogs_tdd
