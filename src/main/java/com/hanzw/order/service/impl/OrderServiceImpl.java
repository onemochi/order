package com.hanzw.order.service.impl;

import com.hanzw.order.domain.ProductOrder;
import com.hanzw.order.service.IOrderService;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ProductOrder save(int userId, int productId) {
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://PRODUCT-SERVICE/api/v1/product/find?id=" + productId, Map.class);
        Map<String,Object> body = forEntity.getBody();

        System.out.println(body + "<<<<<<============");

        ProductOrder p = new ProductOrder();
        p.setCreateTime(new Date());
        p.setUserId(userId);
        p.setTradeNo(UUID.randomUUID().toString());
        p.setProductName(body.get("name").toString());
        return p;
    }
}
