package com.swifties.bahceden.data;

import com.swifties.bahceden.models.Address;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AddressApi {

    /**
     * Retrieves the address (if it exists) from
     * the backend with the given id
     *
     * @param addressId id of the address
     * @return the address
     */
    @GET("addresses/{addressId}")
    Call<Address> getAddressById(@Path("addressId") int addressId);

    /**
     * Deletes the address (if it exists) from
     * the backend with the given id
     *
     * @param addressId id of the address
     * @return a success message if the deletion was successful
     */
    @DELETE("addresses/{addressId}")
    Call<String> deleteAddressById(@Path("addressId") int addressId);

}
