package com.hanzw.order.service;

import com.hanzw.order.domain.ProductOrder;

public interface IOrderService {

    public ProductOrder save(int userId, int productId);
}
