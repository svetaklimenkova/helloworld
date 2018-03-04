package by.slivki.trainings.dao.jpa;

public enum RoleEnum {
    ADMIN(1),
    TRAINER(2),
    USER(3);

    private int i;

    RoleEnum(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
