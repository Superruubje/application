package com.example.application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import static Calculator.Calculator.*;
import static Calculator.Calculator.profits;


public class HomeController {

	@FXML Button Loadbtn2019;
	@FXML Button Loadbtn2020;
	@FXML Button Loadbtn2021;
	@FXML Button Loadbtn2022;
	@FXML Button Loadbtn;

	@FXML LineChart<String, Double> profitLine;
	
	@FXML private Label labelCounter;

	String[] months = {"Januari","Februari","Maart","April","Mei","Juni","Juli","Augustus","September","Oktober","November","December"};

	@FXML
	private void handleButtonAction2022() throws ParseException {
		profitLine.getData().clear();
		XYChart.Series<String, Double> series = new XYChart.Series<>();

		for (int y = 0; y <= 11; y++){
				series.getData().add(new XYChart.Data<>(months[y], profits(3,y)));
		}


		double d = totalSum2022();
		String s = NumberFormat.getCurrencyInstance(Locale.ITALY).format(d);

		series.setName("Winsten van 2022");

		profitLine.getData().add(series);
		labelCounter.setText("Totalen winsten 2022: " + s);
	}
	@FXML
	private void handleButtonAction2021() throws ParseException {
		profitLine.getData().clear();
		XYChart.Series<String, Double> series = new XYChart.Series<>();

		for (int y = 0; y <= 11; y++){
			series.getData().add(new XYChart.Data<>(months[y], profits(2,y)));
		}

		double d = totalSum2021();
		String s = NumberFormat.getCurrencyInstance(Locale.ITALY).format(d);

		series.setName("Winsten van 2021");

		profitLine.getData().add(series);
		labelCounter.setText("Totalen winsten 2021: " + s);
	}
	@FXML
	private void handleButtonAction2020() throws ParseException {
		profitLine.getData().clear();
		XYChart.Series<String, Double> series = new XYChart.Series<>();

		for (int y = 0; y <= 11; y++){
			series.getData().add(new XYChart.Data<>(months[y], profits(1,y)));
		}

		double d = totalSum2020();
		String s = NumberFormat.getCurrencyInstance(Locale.ITALY).format(d);


		series.setName("Winsten van 2020");

		profitLine.getData().add(series);
		labelCounter.setText("Totalen winsten 2020: " + s);
	}
	@FXML
	private void handleButtonAction2019() throws ParseException {
		profitLine.getData().clear();
		XYChart.Series<String, Double> series = new XYChart.Series<>();

		for (int y = 0; y <= 11; y++){
			series.getData().add(new XYChart.Data<>(months[y], profits(0,y)));
		}

		double d = totalSum2019();
		String s = NumberFormat.getCurrencyInstance(Locale.ITALY).format(d);

		series.setName("Winsten van 2019");

		profitLine.getData().add(series);
		labelCounter.setText("Totalen winsten 2019: " + s);
	}
	@FXML
	private void handleButtonAction() throws ParseException {
		profitLine.getData().clear();
		XYChart.Series<String, Double> series1 = new XYChart.Series<>();
		XYChart.Series<String, Double> series2 = new XYChart.Series<>();
		XYChart.Series<String, Double> series3 = new XYChart.Series<>();
		XYChart.Series<String, Double> series4 = new XYChart.Series<>();


		for (int y = 0; y <= 11; y++) {
			series1.getData().add(new XYChart.Data<>(months[y], profits(3, y)));
			series2.getData().add(new XYChart.Data<>(months[y], profits(2, y)));
			series3.getData().add(new XYChart.Data<>(months[y], profits(1, y)));
			series4.getData().add(new XYChart.Data<>(months[y], profits(0, y)));
		}

		double d = totalSum();
		String s = NumberFormat.getCurrencyInstance(Locale.ITALY).format(d);


		series1.setName("2019");
		series2.setName("2020");
		series3.setName("2021");
		series4.setName("2022");

		profitLine.getData().add(series1);
		profitLine.getData().add(series2);
		profitLine.getData().add(series3);
		profitLine.getData().add(series4);
		labelCounter.setText("Totalen winsten: " + s);
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
		stage.close();
	}
	
	
}
