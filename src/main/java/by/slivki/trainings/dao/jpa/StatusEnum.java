package by.slivki.trainings.dao.jpa;

public enum StatusEnum {
    IN_PROGRESS(1),
    ACCEPTED(2),
    REJECTED(3);

    private int i;

    StatusEnum(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
