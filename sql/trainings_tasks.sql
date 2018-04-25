CREATE TABLE trainings.tasks
(
    taskId int(11) PRIMARY KEY NOT NULL,
    taskName varchar(255) NOT NULL,
    stageId int(11) NOT NULL,
    CONSTRAINT fk_stage_task FOREIGN KEY (stageId) REFERENCES stages (stageId)
);
CREATE INDEX fk_stage_task_idx ON trainings.tasks (stageId);