package com.lakshya.ecommerce.eventdrivensystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lakshya.ecommerce.eventdrivensystem.processed.OrderProcessed;



@SpringBootApplication
public class EventdrivensystemApplication {
	private static final String FLAG_FILE_NAME = "relationship_built.flag";
	public static void main(String[] args) {
		SpringApplication.run(EventdrivensystemApplication.class, args);
		Path flagPath = Paths.get(FLAG_FILE_NAME);

        if (Files.exists(flagPath)) {
            System.out.println("Marker file found. Relationships are already built. Skipping...");
        } else {
            System.out.println("Starting one-time relationship build...");
			
            try {
				OrderProcessed processor = new OrderProcessed();
                List<String> productIdPool = processor.getCatagoryMap();
                processor.processEcommerce(productIdPool);
                Files.createFile(flagPath);
                System.out.println("Success! Marker file created: " + FLAG_FILE_NAME);
            } catch (IOException e) {
                System.err.println("Could not create marker file: " + e.getMessage());
            }
            
        }

        System.out.println("Application is now running normally.");
	}

}
