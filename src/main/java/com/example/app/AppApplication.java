package com.example.app;

import com.example.app.model.Ingredient;
import com.example.app.model.Ingredient.Type;
import com.example.app.repository.IngredientRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AppApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}

	@Bean
	public ApplicationRunner dataLoader(IngredientRepository repository) {
		return args -> {
			repository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
			repository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
			repository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
			repository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
			repository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
			repository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
			repository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
			repository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
			repository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
			repository.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
		};
	}

}
