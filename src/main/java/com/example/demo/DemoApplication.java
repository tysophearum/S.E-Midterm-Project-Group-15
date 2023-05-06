package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Addons;
import com.example.demo.model.Drink_size;
import com.example.demo.repository.AddonsRepository;
// import com.example.demo.repository.DrinkRepository;
import com.example.demo.repository.DrinkSizeRepository;
// import com.example.demo.service.DrinkSizeService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private DrinkSizeRepository drinkSizeRepository;

	@Autowired
	private AddonsRepository addonsRepository;

	@Override
	public void run(String... args) throws Exception {
		if(drinkSizeRepository.count() == 0){
			Drink_size drink_size_small = new Drink_size("small", (float) 0);
			Drink_size drink_size_medium = new Drink_size("medium", (float) 0.25);
			Drink_size drink_size_large = new Drink_size("large", (float) 0.5);
			
			drinkSizeRepository.save(drink_size_small);
			drinkSizeRepository.save(drink_size_medium);
			drinkSizeRepository.save(drink_size_large);
			
		}

		if(addonsRepository.count() == 0) {
			Addons cream = new Addons("cream", 1);
			Addons sugar25 = new Addons("sugar", 25);
			Addons sugar50 = new Addons("sugar", 50);
			Addons sugar75 = new Addons("sugar", 75);
			Addons sugar100 = new Addons("sugar", 100);
			
			addonsRepository.save(cream);
			addonsRepository.save(sugar25);
			addonsRepository.save(sugar50);
			addonsRepository.save(sugar75);
			addonsRepository.save(sugar100);
			
			
		}
	}

}
