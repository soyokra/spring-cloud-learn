package com.soyokra.product.api.controller.response;

import com.soyokra.product.domain.model.ProductModel;
import lombok.Data;

@Data
public class ProductResponse {
    ProductModel product;
}
