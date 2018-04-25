CREATE TABLE trainings.stages
(
    stageId int(11) PRIMARY KEY NOT NULL,
    stageName varchar(128) NOT NULL,
    trainingId int(11) NOT NULL,
    CONSTRAINT fk_training_stage FOREIGN KEY (trainingId) REFERENCES trainings (trainingId)
);
CREATE INDEX fk_training_stage_idx ON trainings.stages (trainingId);