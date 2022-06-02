package com.example.application;

import Bookings.BookingProcessor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class Master extends Application {

    @Override
    public void start(Stage stage) throws IOException, ParseException {
        BookingProcessor.ProcessBooking();
        FXMLLoader fxmlLoader = new FXMLLoader(Master.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tsjechoreizen");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}