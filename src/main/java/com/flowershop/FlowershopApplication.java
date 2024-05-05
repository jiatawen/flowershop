package com.flowershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlowershopApplication {

	public static void main(String[] args) {

		String proxy = "127.0.0.1";
        int port = 7897;
        System.setProperty("proxyType", "4");
        System.setProperty("proxyPort", Integer.toString(port));
        System.setProperty("proxyHost", proxy);
        System.setProperty("proxySet", "true");

		SpringApplication.run(FlowershopApplication.class, args);
	}

}
