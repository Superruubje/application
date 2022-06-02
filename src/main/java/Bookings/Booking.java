package Bookings;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Booking {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("M-d-yy");
    //Variables: ;
	public static List<Booking> bookings = new ArrayList<>();

    //Booking variables
	@JsonProperty("iD")
	private int iD;

	@JsonProperty("totalPayedPrice")
	private Double totalPayedPrice;

    //Accommodation variables:
	@JsonProperty("accommodationName")
	private String accommodationName;

	@JsonProperty("accommodationAddress")
	private String accommodationAddress;

	@JsonProperty("accommodationRegion")
	private String accommodationRegion;

	@JsonProperty("totalCosts")
	private Double totalCosts;

    //Costumer variables:
	@JsonProperty("costumerName")
	private String costumerName;

	@JsonProperty("costumerAddress")
	private String costumerAddress;

	@JsonProperty("costumerCountry")
	private String costumerCountry;

	@JsonProperty("ValutaCode")
	public String ValutaCode;
    //Date Variables:
	@JsonFormat(pattern = "M-d-yy", shape = JsonFormat.Shape.STRING)
	private Date startDate;

	@JsonFormat(pattern = "M-d-yy", shape = JsonFormat.Shape.STRING)
	private Date endDate;


	//Constructors:

	public Booking(int iD, Double totalPayedPrice, String accommodationName, String accommodationAddress, String accommodationRegion, Double totalCosts, String costumerName, String costumerAddress, String costumerCountry,String valutaCode, Date startDate, Date endDate) {
		this.iD = iD;
		this.totalPayedPrice = totalPayedPrice;
		this.accommodationName = accommodationName;
		this.accommodationAddress = accommodationAddress;
		this.accommodationRegion = accommodationRegion;
		this.totalCosts = totalCosts;
		this.costumerName = costumerName;
		this.costumerAddress = costumerAddress;
		this.costumerCountry = costumerCountry;
		this.ValutaCode = valutaCode;
		this.startDate = startDate;
		this.endDate = endDate;
		addBookingToArray(this);
	}

	public Booking() {

	}

	public void addBookingToArray(Booking booking) {
		// TODO Auto-generated method stub
		bookings.add(booking);
	}

	//Getters and setters

	public int getiD() {return iD;}
	public Double getTotalPayedPrice() {return totalPayedPrice;}
	public String getAccommodationName() {return accommodationName;}
	public String getAccommodationAddress() {return accommodationAddress;}
	public String getAccommodationRegion() {return accommodationRegion;}
	public Double getTotalCosts() {return totalCosts;}
	public String getCostumerName() {return costumerName;}
	public String getCostumerAddress() {return costumerAddress;}
	public String getCostumerCountry() {return costumerCountry;}
	public Date getStartDate() {return startDate;}
	public Date getEndDate() {return endDate;}
	public String getValutaCode() {return ValutaCode;}

	public void setiD(int iD) {this.iD = iD;}
	public void setTotalPayedPrice(Double totalPayedPrice) {this.totalPayedPrice = totalPayedPrice;}
	public void setAccommodationName(String accommodationName) {this.accommodationName = accommodationName;}
	public void setAccommodationAddress(String accommodationAddress) {this.accommodationAddress = accommodationAddress;}
	public void setAccommodationRegion(String accommodationRegion) {this.accommodationRegion = accommodationRegion;}
	public void setTotalCosts(Double totalCosts) {this.totalCosts = totalCosts;}
	public void setCostumerName(String costumerName) {this.costumerName = costumerName;}
	public void setCostumerAddress(String costumerAddress) {this.costumerAddress = costumerAddress;}
	public void setCostumerCountry(String costumerCountry) {this.costumerCountry = costumerCountry;}
	public void setValutaCode(String valutaCode) {this.ValutaCode = valutaCode;}
	public void setStartDate(Date startDate) {this.startDate = startDate;}
	public void setEndDate(Date endDate) {this.endDate = endDate;}
}


