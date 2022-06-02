package Bookings;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static Bookings.Booking.bookings;

public class BookingProcessor {

    public static void ProcessBooking() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("G:\\Java\\application\\src\\main\\java\\Bookings\\DataJson.json");
        List<Booking> bookingList =  objectMapper.readValue(jsonFile, new TypeReference<List<Booking>>() {});
        for (Booking booking: bookingList) {
            bookings.add(booking);
        }
    }
}



