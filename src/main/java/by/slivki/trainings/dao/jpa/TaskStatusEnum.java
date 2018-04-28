package by.slivki.trainings.dao.jpa;

public enum TaskStatusEnum {
    NOT_STARTED(1),
    IN_PROGRESS(2),
    FINISHED(3);

    private int i;

    TaskStatusEnum(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
