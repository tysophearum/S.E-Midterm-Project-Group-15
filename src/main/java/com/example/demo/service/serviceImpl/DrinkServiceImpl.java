package com.example.demo.service.serviceImpl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Drink;
import com.example.demo.repository.DrinkRepository;
import org.springframework.util.StringUtils;
import com.example.demo.service.DrinkService;

@Service
public class DrinkServiceImpl implements DrinkService {
    private DrinkRepository drinkRepository;

    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        super();
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Drink saveDrink(Drink drink, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..") || fileName.isEmpty())
		{
			System.out.println("not a a valid file");
		}

        if(!drink.isEmpty()){
            try {
                drink.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return drinkRepository.save(drink);
        }
        else{
            return null;
        }
    }

    @Override
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    @Override
    public Drink getDrinkById(Integer id) {
        return drinkRepository.findById(id).get();
    }

    @Override
    public void deleteDrink(Integer id) {
        drinkRepository.deleteById(id);
    }

    @Override
    public Drink getFirstDrink() {
        return drinkRepository.findAll().get(0);
    }


    
    
}
