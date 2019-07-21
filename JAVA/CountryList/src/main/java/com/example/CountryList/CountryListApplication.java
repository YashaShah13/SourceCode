package com.example.CountryList;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class CountryListApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(CountryListApplication.class, args);
		
		
		
		CountryRepo countryRepo= context.getBean(CountryRepo.class);
		
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

					countryRepo.addCountry(country);

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
					countryRepo.removeCountry(countryCode);

				}
					break;

				case 'p': {
					
					valid = true;
					countryRepo.printCountries();

				}
					break;

				case 'g': {
					
					valid = true;
					System.out.println("Enter Country Code:");
					countryCode = input.nextLine().toUpperCase();

					Country country = countryRepo.getCountry(countryCode);
		
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
