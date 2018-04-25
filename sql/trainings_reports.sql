CREATE TABLE trainings.reports
(
    reportId int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userId int(11) NOT NULL,
    taskId int(11) NOT NULL,
    message text NOT NULL,
    statusId int(11) NOT NULL,
    CONSTRAINT fk_report_user FOREIGN KEY (userId) REFERENCES users (userId),
    CONSTRAINT fk_report_task FOREIGN KEY (taskId) REFERENCES tasks (taskId),
    CONSTRAINT fk_report_status FOREIGN KEY (statusId) REFERENCES statuses (statusId)
);
CREATE INDEX fk_report_status_idx ON trainings.reports (statusId);
CREATE INDEX fk_report_task_idx ON trainings.reports (taskId);
CREATE INDEX fk_report_user_idx ON trainings.reports (userId);