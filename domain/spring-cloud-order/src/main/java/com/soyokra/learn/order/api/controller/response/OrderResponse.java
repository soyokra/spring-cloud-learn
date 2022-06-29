package com.soyokra.learn.order.api.controller.response;

import com.soyokra.learn.order.domain.model.OrderModel;
import lombok.Data;

@Data
public class OrderResponse {
    private OrderModel order;
}
