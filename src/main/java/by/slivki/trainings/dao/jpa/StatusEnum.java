package by.slivki.trainings.dao.jpa;

import by.slivki.trainings.exception.ErrorCode;
import by.slivki.trainings.exception.RestException;

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

    public static StatusEnum fromI(int i) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getI() == i) {
                return statusEnum;
            }
        }
        throw new RestException(ErrorCode.STATUS_NOT_FOUND);
    }
}
