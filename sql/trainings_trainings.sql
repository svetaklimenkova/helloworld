CREATE TABLE trainings.trainings
(
    trainingId int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title varchar(52) NOT NULL,
    description text NOT NULL,
    categoryId int(11),
    forWhom varchar(255) NOT NULL,
    goal varchar(255) NOT NULL,
    maxParticipants int(11) NOT NULL,
    userId int(11) NOT NULL,
    CONSTRAINT fk_trainings_category FOREIGN KEY (categoryId) REFERENCES categories (categoryId),
    CONSTRAINT fk_trainings_user FOREIGN KEY (userId) REFERENCES users (userId)
);
CREATE INDEX fk_trainings_category_idx ON trainings.trainings (categoryId);
CREATE INDEX fk_trainings_user_idx ON trainings.trainings (userId);
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('Training', 'description', 1, 'All', 'No goal', 20, 7);
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('hd training', 'vriov', 3, 'revgfs', 'rves', 2, 7);
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('dhfbf training', 'vriov', 1, 'revgfs', 'rves', 2, 7);
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('hd training', 'vriov', 3, 'revgfs', 'rves', 2, 7);
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('fjtj training', 'vriov', 3, 'revgfs', 'rves', 2, 7);
INSERT INTO trainings.trainings (title, description, categoryId, forWhom, goal, maxParticipants, userId) VALUES ('hed training', '7u,fj', 1, 'revgfs', 'rves', 2, 7);