package by.slivki.trainings.dao.jpa;

public enum ApplicationTypeEnum {
    TRAINER(1),
    PASSWORD(2);

    private int i;

    ApplicationTypeEnum(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
