package com.swifties.bahceden.data;

import com.google.gson.Gson;
import com.swifties.bahceden.models.Product;

public class Parser {
    public static Product parseProduct (String productString)
    {
        Gson gson = new Gson();
        Product product = gson.fromJson(productString, Product.class);
        return product;
    }
    public static void parseProduct (String productString, Product product)
    {
        Product newProduct = parseProduct(productString);
        product.setId(newProduct.getId());
        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        product.setUnitType(newProduct.getUnitType());
        product.setPricePerUnit(newProduct.getPricePerUnit());
        product.setProducer(newProduct.getProducer(false));
        product.setAmountInStock(newProduct.getAmountInStock());
        product.setImageURL(newProduct.getImageURL());
    }
}
