package by.slivki.trainings.exception;

public class ErrorCode {
    // application
    public static final int APPLICATION_TO_DELETE_SHOULD_NOT_BE_IN_PROGRESS = 1000;

    // category
    public static final int CATEGORY_ALREADY_EXIST = 2000;
    public static final int CATEGORY_UNDER_TRAINING = 2001;

    // trainings
    public static final int TRAINING_CLOSED = 3000;
    public static final int USER_ALREADY_IN_TRAINING = 3001;
    public static final int USER_DO_NOT_IN_TRAINING = 3002;

    // enum
    public static final int STATUS_NOT_FOUND = 4000;

    // user
    public static final int USER_USERNAME_IS_NOT_FREE = 5000;
}
