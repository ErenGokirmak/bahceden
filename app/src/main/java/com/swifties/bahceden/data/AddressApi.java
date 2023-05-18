package com.swifties.bahceden.data;

import com.swifties.bahceden.models.Address;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AddressApi {
    @GET("addresses/{addressId}")
    Call<Address> getAddressById(@Path("addressId") int addressId);

}
