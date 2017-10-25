package by.svkli.been;

import java.util.Date;

@Repository
public class MyRepository {

    public String getAppName() {
        return "Hello Spring App";
    }

    public Date getSystemDateTime() {
        return new Date();
    }
}
