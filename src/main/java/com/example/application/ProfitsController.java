package com.example.application;

import Bookings.Booking;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static Bookings.Booking.bookings;


public class ProfitsController implements Initializable {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("M-d-yy");
	//Selection Profits

	@FXML ListView<Date> Year;
	@FXML ListView<String> summerRegion;
	@FXML ListView<String> winterRegion;
	@FXML ListView<String> Accommodation;
	@FXML Label MyLabel;
	@FXML Button Load;

	public Date CurrentYear;
	public String CurrentSummerRegion;
	public String CurrentWinterRegion;
	public String CurrentAccommodation;
	Date[] date = new Date[4];
	String[] summerRegions = {"Praag","Noord Bohemen","Oost Bohemen","Zuid Bohemen","West Bohemen","Centraal Bohemen","Reuzengebergte","Slowakije","Moravië"};
	String[] winterRegions = {"Ertsgebergte","Reuzengebergte","Boheemse woud"};
	//Selection
	public void ConstructDates() throws ParseException {

		date[0]= dateFormat.parse("1-1-19");
		date[1]= dateFormat.parse("1-1-20");
		date[2]= dateFormat.parse("1-1-21");
		date[3]= dateFormat.parse("1-1-22");

	}
	public void Destructor(){
		Year.getItems().clear();
		summerRegion.getItems().clear();
		winterRegion.getItems().clear();
	}
	public void Constructor(){
		Year.getItems().addAll(date);
		summerRegion.getItems().addAll(summerRegions);
		winterRegion.getItems().addAll(winterRegions);
	}
	public void yearSelection(){
		double selectedProfits = 0.0;
		for (Booking booking : bookings) {
			if (booking.getStartDate().getYear() == CurrentYear.getYear()){
				selectedProfits = selectedProfits + booking.getTotalPayedPrice() - booking.getTotalCosts();
			}
			String a = NumberFormat.getCurrencyInstance(Locale.ITALY).format(selectedProfits);
			MyLabel.setText(String.valueOf(a));
		}
	}
	public void summerSelection(){
		Accommodation.getItems().clear();
		double selectedProfits = 0.0;
		for (Booking booking : bookings) {
			if (booking.getStartDate().getYear() == CurrentYear.getYear()){
				if (booking.getAccommodationRegion().equals(CurrentSummerRegion)){

					selectedProfits = selectedProfits + booking.getTotalPayedPrice() - booking.getTotalCosts();
					Accommodation.getItems().add(booking.getAccommodationName());

				}
			}
		}
		String a = NumberFormat.getCurrencyInstance(Locale.ITALY).format(selectedProfits);
		MyLabel.setText(String.valueOf(a));
	}
	public void winterSelection(){
		Accommodation.getItems().clear();
		double selectedProfits = 0.0;
		for (Booking booking : bookings) {
			if (booking.getStartDate().getYear() == CurrentYear.getYear()){
				if (booking.getAccommodationRegion().equals(CurrentWinterRegion)){
					selectedProfits = selectedProfits + booking.getTotalPayedPrice() - booking.getTotalCosts();
					Accommodation.getItems().add(booking.getAccommodationName());
				}
			}
		}
		String a = NumberFormat.getCurrencyInstance(Locale.ITALY).format(selectedProfits);
		MyLabel.setText(String.valueOf(a));
	}
	public void accommodationSelection(){
		double selectedProfits = 0.0;
		for (Booking booking : bookings) {
			if (booking.getStartDate().getYear() == CurrentYear.getYear()){
					if(booking.getAccommodationName().equals(CurrentAccommodation)){
						selectedProfits = selectedProfits + booking.getTotalPayedPrice() - booking.getTotalCosts();
					}
			}
		}
		String a = NumberFormat.getCurrencyInstance(Locale.ITALY).format(selectedProfits);
		MyLabel.setText(String.valueOf(a));
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		try {ConstructDates();}
		catch (ParseException e) {throw new RuntimeException(e);}

		Destructor();
		Constructor();

		//Select jaar
		Year.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Date>() {
			@Override
			public void changed(ObservableValue<? extends Date> observableValue, Date date, Date t1) {

				CurrentYear = Year.getSelectionModel().getSelectedItem();
				yearSelection();

				// -2 Select Region
				summerRegion.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
						CurrentSummerRegion = summerRegion.getSelectionModel().getSelectedItem();
						summerSelection();
						//-4 select  accommodation
						Accommodation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
								CurrentAccommodation = Accommodation.getSelectionModel().getSelectedItem();
								accommodationSelection();
							}
						});
					}
				});
				// -3 Select Region
				winterRegion.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
						CurrentWinterRegion = winterRegion.getSelectionModel().getSelectedItem();
						winterSelection();

						//-4 select  accommodation
						Accommodation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
								CurrentAccommodation = Accommodation.getSelectionModel().getSelectedItem();
								accommodationSelection();
							}
						});
					}
				});


			}
		});
	}

	//Menu
	private Stage stage;
	private Scene scene;


	public void switchToHome(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Greetings!");
		stage.setScene(scene);
		stage.show();
	}
	public void switchToProfits(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profits.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Greetings!");
		stage.setScene(scene);
		stage.show();
	}
	public void Close(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profits.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Greetings!");
		stage.setScene(scene);
		stage.close();
	}

}
