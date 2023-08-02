module com.example.sakancom {
    requires java.sql;
    requires junit;
    requires io.cucumber.junit;
    requires io.cucumber.java;
    opens sakancom.loginFeature;
    exports sakancom.loginFeature;
}