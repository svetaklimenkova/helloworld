package by.slivki.trainings.dao.jpa;

public enum RoleEnum {
    ROLE_ADMIN(1),
    ROLE_TRAINER(2),
    ROLE_USER(3);

    private int i;

    RoleEnum(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
