package com.example.flipdeal.service;

import com.example.flipdeal.client.FlipDealClient;
import com.example.flipdeal.dataTransferObject.DiscountDetails;
import com.example.flipdeal.dataTransferObject.Product;
import com.example.flipdeal.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class FlipDealService {

    private Map<String,PromotionStrategy> promotionStrateges;

    private FlipDealClient flipDealClient;

    public FlipDealService(FlipDealClient flipDealClient, Map<String, PromotionStrategy> promotionStrateges) {
        this.flipDealClient = flipDealClient;
        this.promotionStrateges = promotionStrateges;
    }

    public List<Product> applyPermotion(String promotionType){

        List<Product> products = null;
        try {
            products = flipDealClient.fatchProductsDetails();

            Map<String, Object> currencyExchange = flipDealClient.fatchINRDetails();
            List<Product> updatedProducts = Common.changeCurrenyToINR(products, currencyExchange);
            PromotionStrategy promotionStrategy = getPromotionStrategy(promotionType);


            for (Product product : updatedProducts) {

                DiscountDetails discount = promotionStrategy.claculateDiscountFromPermotion(product);
                product.setDiscount(discount);
                System.out.println("Product Category "+ product.getCategory()+" Product price "+product.getPrice()+" Discoumnt "+discount.getDiscountAmount()+" Discount Tag "+ discount.getDiscountTag());

            }
            return products;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    private PromotionStrategy getPromotionStrategy(String promotionType){

        if(promotionStrateges.containsKey(promotionType)){
            return promotionStrateges.get(promotionType);
        }

        throw new RuntimeException("No PermotionType");

    }

}
