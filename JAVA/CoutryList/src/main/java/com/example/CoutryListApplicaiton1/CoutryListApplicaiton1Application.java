package com.example.CoutryListApplicaiton1;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CoutryListApplicaiton1Application {

	public static void main(String[] args) {
		
		SpringApplication.run(CoutryListApplicaiton1Application.class, args);
		
		
		CountryRepo list = new CountryRepo();
		String countryCode; // Key
		String countryName;
		String continent;
		int countryPopulation;

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("------------WELCOME TO COUTRYLIST----------- ");

		boolean contnue = true;
		while (contnue) {

			System.out.println();

			System.out.println("Enter a to add country: ");
			System.out.println("Enter d to delete country: ");
			System.out.println("Enter p to print all country");
			System.out.println("Enter g to get country");
			System.out.println("Enter e to exit");

			Scanner input = new Scanner(System.in);

			boolean valid = false;
			
			while (valid == false) {	
				System.out.println("Enter your choice:");
				char choice = input.nextLine().charAt(0);

				switch (choice) {
				case 'a': {
					
					valid = true;

					System.out.println("Enter Country Code:");
					countryCode = input.nextLine().toUpperCase();

					System.out.println("Enter Country Name:");
					countryName = input.nextLine().toUpperCase();

					System.out.println("Enter Continent Name:");
					continent = input.nextLine().toUpperCase();

					System.out.println("Enter Country Population:");

					countryPopulation = input.nextInt();
					Country country = new Country(countryCode, countryName, continent, countryPopulation);

					list.addCountry(country);

				}
					break;

				case 'e': {
					
					valid = true;
					contnue = false;
					System.out.println("Thank you..:");
				}
					break;

				case 'd': {
					
					valid = true;
					System.out.println("Enter Country Code:");
					countryCode = input.nextLine().toUpperCase();
					list.removeCountry(countryCode);

				}
					break;

				case 'p': {
					
					valid = true;
					list.printCountries();

				}
					break;

				case 'g': {
					
					valid = true;
					System.out.println("Enter Country Code:");
					countryCode = input.nextLine().toUpperCase();

					Country country = list.getCountry(countryCode);
		
					if (country != null) {
						System.out.println("Countrycode: " + country.getCountryCode() + "\nCountryname: "
								+ country.getCountryName() + "\nPopulation: " + country.getCountryPopulation()
								+ "\nContinent: " + country.getContinent());
					} else {
						System.out.print("No such Countrycode.. try again");
					}
				}

				default: {
					System.out.println("Enter your choice from available option only");
				}
				}

			}
		}

	}

}
