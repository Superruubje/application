package Calculator;

import Bookings.Booking;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Bookings.Booking.bookings;

public class Calculator {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("M-d-yy");
    private static double profitsTotal;

    public static Double profits(int i,int y) throws ParseException {
       double profits = 0.0;

        //Month and Year
        Date[][] startDate = new Date[4][12];
        Date[][] endDate = new Date[4][12];

        startDate[0][0] = dateFormat.parse("1-1-19");
        startDate[0][1] = dateFormat.parse("2-1-19");
        startDate[0][2] = dateFormat.parse("3-1-19");
        startDate[0][3] = dateFormat.parse("4-1-19");
        startDate[0][4] = dateFormat.parse("5-1-19");
        startDate[0][5] = dateFormat.parse("6-1-19");
        startDate[0][6] = dateFormat.parse("7-1-19");
        startDate[0][7] = dateFormat.parse("8-1-19");
        startDate[0][8] = dateFormat.parse("9-1-19");
        startDate[0][9] = dateFormat.parse("10-1-19");
        startDate[0][10] = dateFormat.parse("11-1-19");
        startDate[0][11] = dateFormat.parse("12-1-19");

        startDate[1][0] = dateFormat.parse("1-1-20");
        startDate[1][1] = dateFormat.parse("2-1-20");
        startDate[1][2] = dateFormat.parse("3-1-20");
        startDate[1][3] = dateFormat.parse("4-1-20");
        startDate[1][4] = dateFormat.parse("5-1-20");
        startDate[1][5] = dateFormat.parse("6-1-20");
        startDate[1][6] = dateFormat.parse("7-1-20");
        startDate[1][7] = dateFormat.parse("8-1-20");
        startDate[1][8] = dateFormat.parse("9-1-20");
        startDate[1][9] = dateFormat.parse("10-1-20");
        startDate[1][10] = dateFormat.parse("11-1-20");
        startDate[1][11] = dateFormat.parse("12-1-20");

        startDate[2][0] = dateFormat.parse("1-1-21");
        startDate[2][1] = dateFormat.parse("2-1-21");
        startDate[2][2] = dateFormat.parse("3-1-21");
        startDate[2][3] = dateFormat.parse("4-1-21");
        startDate[2][4] = dateFormat.parse("5-1-21");
        startDate[2][5] = dateFormat.parse("6-1-21");
        startDate[2][6] = dateFormat.parse("7-1-21");
        startDate[2][7] = dateFormat.parse("8-1-21");
        startDate[2][8] = dateFormat.parse("9-1-21");
        startDate[2][9] = dateFormat.parse("10-1-21");
        startDate[2][10] = dateFormat.parse("11-1-21");
        startDate[2][11] = dateFormat.parse("12-1-21");

        startDate[3][0] = dateFormat.parse("1-1-22");
        startDate[3][1] = dateFormat.parse("2-1-22");
        startDate[3][2] = dateFormat.parse("3-1-22");
        startDate[3][3] = dateFormat.parse("4-1-22");
        startDate[3][4] = dateFormat.parse("5-1-22");
        startDate[3][5] = dateFormat.parse("6-1-22");
        startDate[3][6] = dateFormat.parse("7-1-22");
        startDate[3][7] = dateFormat.parse("8-1-22");
        startDate[3][8] = dateFormat.parse("9-1-22");
        startDate[3][9] = dateFormat.parse("10-1-22");
        startDate[3][10] = dateFormat.parse("11-1-22");
        startDate[3][11] = dateFormat.parse("12-1-22");

        //end dates
        endDate[0][0] = dateFormat.parse("1-31-19");
        endDate[0][1] = dateFormat.parse("2-28-19");
        endDate[0][2] = dateFormat.parse("3-31-19");
        endDate[0][3] = dateFormat.parse("4-30-19");
        endDate[0][4] = dateFormat.parse("5-31-19");
        endDate[0][5] = dateFormat.parse("6-30-19");
        endDate[0][6] = dateFormat.parse("7-31-19");
        endDate[0][7] = dateFormat.parse("8-31-19");
        endDate[0][8] = dateFormat.parse("9-30-19");
        endDate[0][9] = dateFormat.parse("10-31-19");
        endDate[0][10] = dateFormat.parse("11-30-19");
        endDate[0][11] = dateFormat.parse("12-31-19");

        endDate[1][0] = dateFormat.parse("1-31-20");
        endDate[1][1] = dateFormat.parse("2-29-20");
        endDate[1][2] = dateFormat.parse("3-31-20");
        endDate[1][3] = dateFormat.parse("4-30-20");
        endDate[1][4] = dateFormat.parse("5-31-20");
        endDate[1][5] = dateFormat.parse("6-30-20");
        endDate[1][6] = dateFormat.parse("7-31-20");
        endDate[1][7] = dateFormat.parse("8-31-20");
        endDate[1][8] = dateFormat.parse("9-30-20");
        endDate[1][9] = dateFormat.parse("10-31-20");
        endDate[1][10] = dateFormat.parse("11-30-20");
        endDate[1][11] = dateFormat.parse("12-31-20");

        endDate[2][0] = dateFormat.parse("1-31-21");
        endDate[2][1] = dateFormat.parse("2-28-21");
        endDate[2][2] = dateFormat.parse("3-31-21");
        endDate[2][3] = dateFormat.parse("4-30-21");
        endDate[2][4] = dateFormat.parse("5-31-21");
        endDate[2][5] = dateFormat.parse("6-30-21");
        endDate[2][6] = dateFormat.parse("7-31-21");
        endDate[2][7] = dateFormat.parse("8-31-21");
        endDate[2][8] = dateFormat.parse("9-30-21");
        endDate[2][9] = dateFormat.parse("10-31-21");
        endDate[2][10] = dateFormat.parse("11-30-21");
        endDate[2][11] = dateFormat.parse("12-31-21");

        endDate[3][0] = dateFormat.parse("1-31-22");
        endDate[3][1] = dateFormat.parse("2-28-22");
        endDate[3][2] = dateFormat.parse("3-31-22");
        endDate[3][3] = dateFormat.parse("4-30-22");
        endDate[3][4] = dateFormat.parse("5-31-22");
        endDate[3][5] = dateFormat.parse("6-30-22");
        endDate[3][6] = dateFormat.parse("7-31-22");
        endDate[3][7] = dateFormat.parse("8-31-22");
        endDate[3][8] = dateFormat.parse("9-30-22");
        endDate[3][9] = dateFormat.parse("10-31-22");
        endDate[3][10] = dateFormat.parse("11-30-22");
        endDate[3][11] = dateFormat.parse("12-31-22");

        for (Booking booking: bookings) {
            if (booking.getStartDate().getTime() >= startDate[i][y].getTime() && booking.getStartDate().getTime() <= endDate[i][y].getTime()) {
                    profits = profits + booking.getTotalPayedPrice() - booking.getTotalCosts();
            }
        }
        return profits;
    }


    public static double totalSum2019() throws ParseException {
        Date start = dateFormat.parse("1-1-19");
        Date end = dateFormat.parse("12-31-19");
        profitsTotal = 0.0;
        for (Booking booking : bookings) {
            if (booking.getStartDate().getTime() >= start.getTime() && booking.getStartDate().getTime() <= end.getTime()) {
                profitsTotal = profitsTotal + booking.getTotalPayedPrice() - booking.getTotalCosts();

            }
        }

        return profitsTotal;
    }
    public static double totalSum2020() throws ParseException {
        Date start = dateFormat.parse("1-1-20");
        Date end = dateFormat.parse("12-31-20");
        profitsTotal= 0.0;
        for (Booking booking : bookings) {
            if (booking.getStartDate().getTime() >= start.getTime() && booking.getStartDate().getTime() <= end.getTime()) {
                profitsTotal = profitsTotal + booking.getTotalPayedPrice() - booking.getTotalCosts();

            }
        }

        return profitsTotal;
    }
    public static double totalSum2021() throws ParseException {
        Date start = dateFormat.parse("1-1-21");
        Date end = dateFormat.parse("12-31-21");
        profitsTotal= 0.0;
        for (Booking booking : bookings) {
            if (booking.getStartDate().getTime() >= start.getTime() && booking.getStartDate().getTime() <= end.getTime()) {
                profitsTotal = profitsTotal + booking.getTotalPayedPrice() - booking.getTotalCosts();

            }
        }

        return profitsTotal;
    }
    public static double totalSum2022() throws ParseException {
        Date start = dateFormat.parse("1-1-22");
        Date end = dateFormat.parse("12-31-22");
        profitsTotal= 0.0;
        for (Booking booking : bookings) {
            if (booking.getStartDate().getTime() >= start.getTime() && booking.getStartDate().getTime() <= end.getTime()) {
                profitsTotal = profitsTotal + booking.getTotalPayedPrice() - booking.getTotalCosts();

            }
        }

        return profitsTotal;
    }
    public static double totalSum() throws ParseException {
        Date start = dateFormat.parse("1-1-01");
        Date end = dateFormat.parse("12-31-22");
        profitsTotal= 0.0;
        for (Booking booking : bookings) {
            if (booking.getStartDate().getTime() >= start.getTime() && booking.getStartDate().getTime() <= end.getTime()) {
                profitsTotal = profitsTotal + booking.getTotalPayedPrice() - booking.getTotalCosts();

            }
        }

        return profitsTotal;
    }
}
