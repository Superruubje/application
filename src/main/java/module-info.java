module com.example.application {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.Controllers to javafx.fxml;
    exports com.example.Controllers;
    exports Bookings;
    opens Bookings to javafx.fxml;
    exports Calculators;
    opens Calculators to javafx.fxml;
}