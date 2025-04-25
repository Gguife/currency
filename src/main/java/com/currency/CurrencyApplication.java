package com.currency;

import com.currency.client.ExchangeRateClient;
import com.currency.controller.CurrencyController;
import com.currency.model.request.CurrencyConversionRequest;
import com.currency.service.CurrencyConverterService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CurrencyApplication {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ExchangeRateClient rateClient = new ExchangeRateClient();
		CurrencyConverterService service = new CurrencyConverterService(rateClient);
		CurrencyController controller = new CurrencyController(service);

		System.out.println("Welcome to gguife currency converter =)\n" +
							"---------------------------------------------\n" +
							"CURRENCIES MENU\n" +
							"1) United States Dollar: USD\n" +
							"2) Brazilian Real: BRL\n" +
							"3) Euro: EUR\n" +
							"4) Canadian Dollar: CAD\n" +
							"5) China: CNY\n" +
							"----------------------------------------------\n");

		System.out.println("Enter the source currency: ");
		String fromCurrency = scanner.nextLine().toUpperCase();
		System.out.println("Enter the target currency: ");
		String toCurrency = scanner.nextLine().toUpperCase();
		System.out.println("Enter the amount to convert: ");
		double amount = scanner.nextDouble();

		try {
			CurrencyConversionRequest request = new CurrencyConversionRequest(fromCurrency, toCurrency, amount);
			controller.convertCurrency(request);
		}catch(RuntimeException e) {
			System.out.println("Error: " + e.getMessage() + ". Please check the currency codes and try again.");
		}
	}

}
