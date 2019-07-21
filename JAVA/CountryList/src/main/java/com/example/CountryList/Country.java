package com.example.CountryList;

public class Country {
	
	private String countryCode = "NCC";
	private String countryName = "NCN";
	private int countryPopulation = 0;
	private String continent = "NC";

	public Country(String countryCode, String countryName, String continent, int countryPopulation) {

		this.countryCode = countryCode;
		this.countryName = countryName;
		this.countryPopulation = countryPopulation;
		this.continent = continent;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getCountryPopulation() {
		return countryPopulation;
	}

	public void setCountryPopulation(int countryPopulation) {
		this.countryPopulation = countryPopulation;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	@Override
	public String toString() {
		return getCountryCode() + "             " + getCountryName() + "    " + getCountryPopulation() + "    "
				+ getContinent();
	}


}
