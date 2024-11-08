package com.example.flipdeal.controller;

import com.example.flipdeal.FlipDealApplication;
import com.example.flipdeal.client.FlipDealClient;
import com.example.flipdeal.constant.PromotionSet;
import com.example.flipdeal.dataTransferObject.DiscountDetails;
import com.example.flipdeal.dataTransferObject.Product;
import com.example.flipdeal.service.FlipDealService;
import com.example.flipdeal.service.PromotionStrategy;
import com.example.flipdeal.utils.Common;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/apply-promotion", produces = MediaType.APPLICATION_JSON_VALUE)
public class FlipDealController {

    @Autowired
    private FlipDealService flipDealService;

    @RequestMapping( value = {"/{promotionType}"}, method = {RequestMethod.GET} )
    public List<Product> applyPromostionController(@PathVariable String promotionType) {

        return flipDealService.applyPermotion(promotionType);
    }

}

/*
Note : hum direct call nhi kerge, application ek bar he run hoga , chalta rhega
        hum chalte application m he value pass kerdege bar bar run hi kerge.

 */

