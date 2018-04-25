CREATE TABLE trainings.participantstasks
(
    taskId int(11) NOT NULL,
    userId int(11) NOT NULL,
    taskStatusId int(11) NOT NULL,
    CONSTRAINT fk_task_task FOREIGN KEY (taskId) REFERENCES tasks (taskId),
    CONSTRAINT fk_user_user FOREIGN KEY (userId) REFERENCES users (userId),
    CONSTRAINT fk_taskstatus_taskstatus FOREIGN KEY (taskStatusId) REFERENCES taskstatuses (taskStatusId)
);
CREATE INDEX fk_taskstatus_taskstatus_idx ON trainings.participantstasks (taskStatusId);
CREATE INDEX fk_task_task_idx ON trainings.participantstasks (taskId);
CREATE INDEX fk_user_user_idx ON trainings.participantstasks (userId);