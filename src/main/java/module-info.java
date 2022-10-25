module com.example.appedp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires java.net.http;
    requires org.postgresql.jdbc;
    requires commons.email;
    requires com.google.gson;
    requires java.annotation;
    requires java.management;


opens com.example.apiCalorie;
    opens com.example.appedp to javafx.fxml;
    opens com.example.apiBmi;

    exports com.example.appedp;
    exports com.example.apiCalorie;
    opens com.example.function;

}