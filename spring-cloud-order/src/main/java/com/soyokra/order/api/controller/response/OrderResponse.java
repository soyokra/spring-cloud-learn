package com.soyokra.order.api.controller.response;

import com.soyokra.order.api.domain.model.OrderModel;
import lombok.Data;

@Data
public class OrderResponse {
    private OrderModel order;
}