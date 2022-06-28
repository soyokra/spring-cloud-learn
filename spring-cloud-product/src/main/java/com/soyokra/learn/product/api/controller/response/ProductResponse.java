package com.soyokra.learn.product.api.controller.response;

import com.soyokra.learn.product.domain.model.ProductModel;
import lombok.Data;

@Data
public class ProductResponse {
    ProductModel product;
}
