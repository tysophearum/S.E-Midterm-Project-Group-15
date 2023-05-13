package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Current_product_order;
import com.example.demo.repository.CurrentProductOrderRepository;
import com.example.demo.service.CurrentProductOrderService;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductSizeService;

@Service
public class CurrentProductOrderImpl implements CurrentProductOrderService {
    private CurrentProductOrderRepository currentDrinkOrderRepository;
    private ProductService productService;
    private ProductSizeService drinkSizeService;

    public CurrentProductOrderImpl(CurrentProductOrderRepository currentDrinkOrderRepository, ProductService productService, ProductSizeService drinkSizeService) {
        super();
        this.currentDrinkOrderRepository = currentDrinkOrderRepository;
        this.productService = productService;
        this.drinkSizeService = drinkSizeService;
    }

    @Override
    public List<Current_product_order> getAllOrders() {
        return currentDrinkOrderRepository.findAll();
    }

    @Override
    public Current_product_order saveOrder(Current_product_order current_drink_order) {
        return currentDrinkOrderRepository.save(current_drink_order);
    }

    @Override
    public Current_product_order getOrderById(Integer id) {
        return currentDrinkOrderRepository.findById(id).get();
    }

    @Override
    public void deleteOrder(Integer id) {
        currentDrinkOrderRepository.deleteById(id);;
    }

    @Override
    public String getAllOrderIds() {
        String ids = "";
        for(Current_product_order order: currentDrinkOrderRepository.findAll()){
            ids = ids + order.getId() + ",";
        }
        ids = ids.substring(0, ids.length()-1);
        return ids;
    }

    @Override
    public Float getTotalPrice() {
        Float totalPrice = (float) 0;
        for(Current_product_order order: currentDrinkOrderRepository.findAll()){
            Float orderAmount = (float) order.getAmount();
            Float orderPrice = productService.getProductById( order.getProduct_id() ).getPrice();
            Float orderSizePrice = drinkSizeService.getSizeById(order.getSize_id()).getPrice();
            totalPrice = totalPrice + ( ( ( orderPrice + orderSizePrice ) * orderAmount ) );
        }
        return totalPrice;
    }

    @Override
    public void deleteAllOrders() {
        currentDrinkOrderRepository.deleteAll();;
    }
    
    
}
