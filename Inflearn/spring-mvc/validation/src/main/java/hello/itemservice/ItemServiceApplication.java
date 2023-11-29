package hello.itemservice;

import hello.itemservice.web.validation.ItemValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@SpringBootApplication
public class ItemServiceApplication{

	public static void main(String[] args) {
		Locale.setDefault(Locale.KOREA);
		SpringApplication.run(ItemServiceApplication.class, args);
	}
}
