package com.example.application;

import Bookings.Booking;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static Bookings.Booking.bookings;


public class ProfitsController {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("M-d-yy");
	//Selection Profits

	@FXML ListView<Date> Year;
	@FXML ListView<String> Term;
	@FXML ListView<String> Region;
	@FXML ListView<String> Accommodation;
	@FXML Label MyLabel;
	@FXML Button Load;

	public Date CurrentYear;
	public String CurrentTerm;
	public String CurrentRegion;
	public String CurrentAccommodation;
	Date[] date = new Date[4];
	String[] term = {"Lente-Zomer-Herfst","Winter"};
	//Selection
	public void ConstructDates() throws ParseException {

		date[0]= dateFormat.parse("1-1-19");
		date[1]= dateFormat.parse("1-1-20");
		date[2]= dateFormat.parse("1-1-21");
		date[3]= dateFormat.parse("1-1-22");

	}

	public void LoadData(ActionEvent event){
		try {ConstructDates();}
		catch (ParseException e) {throw new RuntimeException(e);}
		Year.getItems().addAll(date);
		Term.getItems().addAll(term);
		Year.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Date>() {
			@Override
			public void changed(ObservableValue<? extends Date> observableValue, Date date, Date t1) {

				CurrentYear = Year.getSelectionModel().getSelectedItem();


				//Select jaar

				double profitsTotal = 0.0;
				for (Booking booking : bookings) {
					if (booking.getStartDate().getYear() == CurrentYear.getYear()){
						profitsTotal = profitsTotal + booking.getTotalPayedPrice() - booking.getTotalCosts();
					}
					String s = NumberFormat.getCurrencyInstance(Locale.ITALY).format(profitsTotal);
					MyLabel.setText(String.valueOf(s));
				}
				//Select periode
				Term.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
						Region.getItems().clear();
						CurrentTerm = Term.getSelectionModel().getSelectedItem();


						if(CurrentTerm.equals("Lente-Zomer-Herfst")){
							String[] region = {"Praag","Centraal Bohemen","Zuid Bohemen","West Bohemen","Noord Bohemen", "Reuzengebergte","Slowakije","Moravië","Oost Bohemen"};
							Region.getItems().addAll(region);
							Region.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
								@Override
								public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
									CurrentRegion = Region.getSelectionModel().getSelectedItem();
									Accommodation.getItems().clear();
									double profitsTotalRS = 0.0;

									for (Booking booking : bookings) {
										if (booking.getStartDate().getYear() == CurrentYear.getYear()){
											if (booking.getAccommodationRegion().equals(CurrentRegion)){
												profitsTotalRS = profitsTotalRS + booking.getTotalPayedPrice() - booking.getTotalCosts();

												Accommodation.getItems().addAll(booking.getAccommodationName());
												Accommodation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
													@Override
													public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
														double profitsTotalACC = 0.0;
														CurrentAccommodation = Region.getSelectionModel().getSelectedItem();
														if (CurrentAccommodation.equals(booking.getAccommodationRegion())) {

															profitsTotalACC = booking.getTotalPayedPrice() - booking.getTotalCosts();
															String y = NumberFormat.getCurrencyInstance(Locale.ITALY).format(profitsTotalACC);
															MyLabel.setText(String.valueOf(y));
														}
													}
												});
											}
										}
										String z = NumberFormat.getCurrencyInstance(Locale.ITALY).format(profitsTotalRS);
										MyLabel.setText(String.valueOf(z));
									}

								}
							});


						} else if (CurrentTerm.equals("Winter")) {
							String[] region = {"Ertsgebergte","Reuzengebergte","Boheemse woud"};
							Region.getItems().addAll(region);

							Region.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

								@Override
								public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
									CurrentRegion = Region.getSelectionModel().getSelectedItem();
									Accommodation.getItems().clear();
									double profitsTotalRW = 0.0;
									for (Booking booking : bookings) {
										if (booking.getStartDate().getYear() == CurrentYear.getYear()){
											if (booking.getAccommodationRegion().equals(CurrentRegion)){
												profitsTotalRW = profitsTotalRW + booking.getTotalPayedPrice() - booking.getTotalCosts();

												Accommodation.getItems().addAll(booking.getAccommodationName());
												Accommodation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
													@Override
													public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
														double profitsTotalACD = 0.0;
														CurrentAccommodation = Region.getSelectionModel().getSelectedItem();
														if (CurrentAccommodation.equals(booking.getAccommodationRegion())) {

															profitsTotalACD = booking.getTotalPayedPrice() - booking.getTotalCosts();
															String a = NumberFormat.getCurrencyInstance(Locale.ITALY).format(profitsTotalACD);
															MyLabel.setText(String.valueOf(a));
														}
													}
												});
											}
										}
										String t = NumberFormat.getCurrencyInstance(Locale.ITALY).format(profitsTotalRW);
										MyLabel.setText(String.valueOf(t));
									}
								}
							});
						}
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
