INSERT INTO dogs (dog_id, name, age) VALUES (1, 'Einstein', 3);
INSERT INTO dogs (dog_id, name, age) VALUES (2, 'Kaya', 5);
INSERT INTO dogs (dog_id, name, age) VALUES (3, 'Lassie', 7);

INSERT INTO owners (owner_id, name) VALUES ( 1, 'Steve');
INSERT INTO owners (owner_id, name) VALUES ( 2, 'Robert');
INSERT INTO owners (owner_id, name) VALUES ( 3, 'Ana');

INSERT INTO dog_n_owners (id , dog_owner , dog) VALUES ( 1, 'Steve', 'Einstein' );
INSERT INTO dog_n_owners (id , dog_owner , dog) VALUES ( 2, 'Steve', 'Kaya' );
INSERT INTO dog_n_owners (id , dog_owner , dog) VALUES ( 3, 'Robert', 'Lassie' );
