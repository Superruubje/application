module com.example.application {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.application to javafx.fxml;
    exports com.example.application;
    exports Bookings;
    opens Bookings to javafx.fxml;
    exports Calculator;
    opens Calculator to javafx.fxml;
}