package us.onesquare.bastoji.model.utils;

public class ApplicationAddress {
	
	private 	String country;
	private 	String streetNumber;
	private     String streetName;
	private		String postalCode;
	private 	String city;
	
	public  ApplicationAddress (String co,String sNb, String sName,String pCode,String ci){
		
		country=co;
		streetNumber=sNb;
		streetName=sName;
		postalCode=pCode;
		city=ci;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
