package com.example.application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import static Calculators.RegionProfitsCalculator.*;


public class ProfitsController implements Initializable {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("M-d-yy");
	//Selection Profits

	@FXML ListView<Date> Year;
	@FXML ListView<String> summerRegion;
	@FXML ListView<String> winterRegion;
	@FXML ListView<String> Accommodation;
	@FXML Label MyLabel;

	public Date CurrentYear;
	public String CurrentSummerRegion;
	public String CurrentWinterRegion;
	public String CurrentAccommodation;
	Date[] date = new Date[4];
	String[] summerRegions = {"Praag","Noord Bohemen","Oost Bohemen","Zuid Bohemen","West Bohemen","Centraal Bohemen","Reuzengebergte","Slowakije","Moravië"};
	String[] winterRegions = {"Ertsgebergte","Reuzengebergte","Boheemse woud"};
	//Selection

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

	//Selection methods
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
				MyLabel.setText(String.valueOf(yearSelection(CurrentYear)));

				// -2 Select Region
				summerRegion.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
						CurrentSummerRegion = summerRegion.getSelectionModel().getSelectedItem();
						MyLabel.setText(summerSelection(CurrentYear, CurrentSummerRegion, Accommodation));

						//-4 select  accommodation
						Accommodation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
								CurrentAccommodation = Accommodation.getSelectionModel().getSelectedItem();
								MyLabel.setText(String.valueOf(accommodationSelection(CurrentYear, CurrentAccommodation)));
							}
						});
					}
				});
				// -3 Select Region
				winterRegion.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
						CurrentWinterRegion = winterRegion.getSelectionModel().getSelectedItem();
						MyLabel.setText(winterSelection(CurrentYear, CurrentWinterRegion, Accommodation));

						//-4 select  accommodation
						Accommodation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
							@Override
							public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
								CurrentAccommodation = Accommodation.getSelectionModel().getSelectedItem();
								MyLabel.setText(String.valueOf(accommodationSelection(CurrentYear, CurrentAccommodation)));
							}
						});
					}
				});


			}
		});
	}

}
