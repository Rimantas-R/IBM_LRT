package lt.r.lrtlive;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lt.r.lrtlive.services.ParserService;

@SpringBootApplication
public class LrtliveApplication {

	public static void main(String[] args) {
		SpringApplication.run(LrtliveApplication.class, args);
		System.out.println("Hello there");
		try {
			new ParserService().stoutP();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
