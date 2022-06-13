package Calculators;

import Bookings.Booking;
import javafx.scene.control.ListView;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import static Bookings.Booking.bookings;

public class RegionProfitsCalculator {

    public static String yearSelection(Date currentYear){
        Date selectedYear = currentYear;
        double selectedProfits = 0.0;
        for (Booking booking : bookings) {
            if (booking.getStartDate().getYear() == selectedYear.getYear()){
                selectedProfits = selectedProfits + booking.getTotalPayedPrice() - booking.getTotalCosts();
            }
        }
        String a = NumberFormat.getCurrencyInstance(Locale.ITALY).format(selectedProfits);

        return a;
    }
    public static String summerSelection(Date currentYear, String currentSummerRegion, ListView<String> accommodation){

        Date selectedYear = currentYear;
        String selectedRegion = currentSummerRegion;
        ListView<String> Accommodation = accommodation;
        Accommodation.getItems().clear();
        double selectedProfits = 0.0;
        for (Booking booking : bookings) {
            if (booking.getStartDate().getYear() == selectedYear.getYear()){
                if (booking.getAccommodationRegion().equals(selectedRegion)){

                    selectedProfits = selectedProfits + booking.getTotalPayedPrice() - booking.getTotalCosts();
                    Accommodation.getItems().add(booking.getAccommodationName());

                }
            }
        }
        Accommodation.getItems().sorted();
        String a = NumberFormat.getCurrencyInstance(Locale.ITALY).format(selectedProfits);

        return a;
    }
    public static String winterSelection(Date currentYear, String currentSummerRegion, ListView<String> accommodation){

        Date selectedYear = currentYear;
        String selectedRegion = currentSummerRegion;
        ListView<String> Accommodation = accommodation;
        Accommodation.getItems().clear();
        double selectedProfits = 0.0;
        for (Booking booking : bookings) {
            if (booking.getStartDate().getYear() == selectedYear.getYear()){
                if (booking.getAccommodationRegion().equals(selectedRegion)){

                    selectedProfits = selectedProfits + booking.getTotalPayedPrice() - booking.getTotalCosts();
                    Accommodation.getItems().add(booking.getAccommodationName());

                }
            }
        }
        Accommodation.getItems().sorted();
        String a = NumberFormat.getCurrencyInstance(Locale.ITALY).format(selectedProfits);

        return a;
    }
    public static String accommodationSelection(Date currentYear, String currentAccommodation){
        Date selectedYear = currentYear;
        String selectedAccommodation = currentAccommodation;
        double selectedProfits = 0.0;
        for (Booking booking : bookings) {
            if (booking.getStartDate().getYear() == selectedYear.getYear()){
                if(booking.getAccommodationName().equals(selectedAccommodation)){
                    selectedProfits = selectedProfits + booking.getTotalPayedPrice() - booking.getTotalCosts();
                }
            }
        }
        String a = NumberFormat.getCurrencyInstance(Locale.ITALY).format(selectedProfits);
        return a;
    }

}
