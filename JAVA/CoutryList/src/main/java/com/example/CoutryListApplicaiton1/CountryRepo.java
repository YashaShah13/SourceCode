package com.example.CoutryListApplicaiton1;

import java.util.Map;
import java.util.TreeMap;

public class CountryRepo {

	private Map<String, Country> countries;

	public CountryRepo() {

		this.countries = new TreeMap<String, Country>();
	}

	public boolean addCountry(Country country) {

		// TODO Auto-generated method stub
		String countryCode = country.getCountryCode();

		if (countries.containsKey(countryCode)) {
			System.out.println("Key already exixts... Try again...");
			return false;
		} else {
			countries.put(countryCode, country);
			System.out.println("Insert Successful");
			return true;
		}
	}

	public boolean removeCountry(String countryCode) {
		// TODO Auto-generated method stub

		if (countries.isEmpty()) {
			System.out.println("List is Empty..");
			return false;
		}
		if (!countries.containsKey(countryCode)) {
			System.out.println("No such Key.. Try again...");
			return false;
		} else {
			countries.remove(countryCode);
			System.out.println("Remove successful..!");
			return true;
		}

	}

	public void printCountries() {
		// TODO Auto-generated method stub

		if (countries.isEmpty()) {
			System.out.println("List is Empty..");
		} else {
			System.out.println("COUNTRYCODE  " + "COUNTRYNAME  " + "POPULATION  " + "CONTINENT");
			
			for (String countryCode : countries.keySet()) {
				System.out.println(countries.get(countryCode));
			}
		}

	}

	public Country getCountry(String countryCode) throws NullPointerException {
		// TODO Auto-generated method stub
		Country country = countries.get(countryCode);
		return country;

	}

}
