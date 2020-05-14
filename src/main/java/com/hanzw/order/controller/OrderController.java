package com.hanzw.order.controller;


import com.hanzw.order.domain.ProductOrder;
import com.hanzw.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private IOrderService IOrderService;

    @RequestMapping("save")
    public Object save (@RequestParam("user_id") int userId, @RequestParam("product_id") int productId){
        return IOrderService.save(userId, productId);
    }
}
