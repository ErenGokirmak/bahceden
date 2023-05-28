package com.swifties.bahceden.data.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.swifties.bahceden.data.RetrofitService;
import com.swifties.bahceden.data.apis.CustomerApi;
import com.swifties.bahceden.models.Category;
import com.swifties.bahceden.models.Comment;
import com.swifties.bahceden.models.Customer;
import com.swifties.bahceden.models.Producer;
import com.swifties.bahceden.models.Product;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDeserializer implements JsonDeserializer<Product> {
    @Override
    public Product deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Product p = new Product();
        JsonObject jObj = json.getAsJsonObject();

        p.setId(jObj.get("id").getAsInt());
        p.setName(jObj.get("name").getAsString());
        p.setDescription(jObj.get("description").getAsString());
        p.setCategory(context.deserialize(jObj.get("category"), Category.class));
        p.setUnitType(context.deserialize(jObj.get("unitType"), Product.UnitType.class));
        p.setPricePerUnit(jObj.get("pricePerUnit").getAsInt());
        p.setProducer(context.deserialize(jObj.get("producer"), Producer.class));
        p.setImageURL(jObj.get("imageURL").getAsString());
        p.setAmountInStock(jObj.get("availableAmount").getAsInt());
        p.setRating(jObj.get("rating").getAsDouble());

        JsonElement commentObjs = jObj.get("comments");

        if (commentObjs.isJsonArray())
        {
            List<Comment> comments = new ArrayList<>();
            p.setComments(comments);
            for (JsonObject commentObject : commentObjs.getAsJsonArray().asList().stream().map(JsonElement::getAsJsonObject).collect(Collectors.toList()))
            {
                Comment c = new Comment();
                comments.add(c);
                c.setId(commentObject.get("id").getAsInt());
                c.setProduct(p);
                c.setMessage(commentObject.get("message").getAsString());
                c.setCountOfLikes(commentObject.get("countOfLikes").getAsInt());
                JsonElement parentElement = commentObject.get("parent");
                if (parentElement != null && !parentElement.isJsonNull())
                {
                    int parentId = parentElement.getAsInt();
                    for (Comment comm: comments)
                    {
                        if (comm.getId() == parentId)
                            comm.setChildComment(c);
                    }
                }
                int authorId = commentObject.get("author").getAsInt();
                if (authorId == -1)
                {
                    c.setAuthor(p.getProducer());
                }
                else
                {
//                    RetrofitService.getApi(CustomerApi.class).getCustomerById(authorId).enqueue(new Callback<Customer>() {
//                        @Override
//                        public void onResponse(Call<Customer> call, Response<Customer> response) {
//                            assert response.body() != null;
//                            c.setAuthor(response.body());
//                        }
//
//                        @Override
//                        public void onFailure(Call<Customer> call, Throwable t) {
//                            throw new RuntimeException(t);
//                        }
//                    });
                }
            }
        }

        return p;
    }
}
