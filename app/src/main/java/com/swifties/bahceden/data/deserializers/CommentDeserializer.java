package com.swifties.bahceden.data.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.CustomerApi;
import com.swifties.bahceden.data.apis.ProducerApi;
import com.swifties.bahceden.data.apis.ProductApi;
import com.swifties.bahceden.models.Comment;
import com.swifties.bahceden.models.Customer;
import com.swifties.bahceden.models.Producer;
import com.swifties.bahceden.models.Product;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentDeserializer implements JsonDeserializer<Comment> {
    @Override
    public Comment deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        if (json.isJsonPrimitive())
        {
            return null;
        }

        Comment c = new Comment();

        JsonObject jObj= json.getAsJsonObject();
        int authorId = jObj.get("author").getAsInt();

        RetrofitService.getApi(ProductApi.class).getProductById(jObj.get("product").getAsInt()).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                c.setProduct(response.body());
                if (authorId == -1)
                    c.setAuthor(response.body().getProducer());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                throw new RuntimeException(t);
            }
        });

        if (authorId != -1)
        {
            RetrofitService.getApi(CustomerApi.class).getCustomerById(authorId).enqueue(new Callback<Customer>() {
                @Override
                public void onResponse(Call<Customer> call, Response<Customer> response) {
                    c.setAuthor(response.body());
                }

                @Override
                public void onFailure(Call<Customer> call, Throwable t) {
                    throw new RuntimeException(t);
                }
            });
        }
        else
        {
            c.setAuthor(c.getProduct().getProducer());
        }

        c.setMessage(jObj.get("message").getAsString());
        c.setCountOfLikes(jObj.get("countOfLikes").getAsInt());
        return c;
    }
}
