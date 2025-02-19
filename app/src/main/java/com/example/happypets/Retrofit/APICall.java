package com.example.happypets.Retrofit;

import com.example.happypets.Model.*;


import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import java.util.*;
public interface APICall {

   //to update a user
    @POST("/update/user")
    @Multipart
    Call<String> updateUser(@Header("Authorization") String token,@Part MultipartBody.Part image, @Part("user") User user);

    // creating new post request to sign up the user initially
    @POST("/register/user")
    Call<String> signupUser(@Body User user);

    // to login user
    @POST("/login/user")
    Call<LoginResponse> loginUser(@Body Login login);

    @GET("/get/user/{userId}")
    Call<User>getSpecificInUser(@Header ("Authorization") String token,@Path("userId") String userId);

    //get all user
    @GET("/get/all/users")
    Call<List<User>>getAllUser(@Header ("Authorization") String token);

    // to post a pet
    @POST("/post/pet/{userId}")
    @Multipart
    Call<String>postAPet(@Header ("Authorization") String token,@Path("userId") String userId, @Part MultipartBody.Part image, @Part("pet") Pet pet );

    //to get all posted pets
    @GET("/get/all/posted/pets/")
    Call<List<Pet>>getAllPostedPet(@Header ("Authorization") String token);

    //to get all posted pet of a specific user
    @GET("/get/all/posted/pet/{userId}")
    Call<List<Pet>>getAllPostedPetOfSpecificUser(@Header ("Authorization") String token,@Path("userId")String userId);


   //to get pets by category
    @GET("get/pets/category/{num}")
    Call<List<Pet>>getPetByCategory(@Header ("Authorization") String token,@Path("num") int num);

    @GET("/get/messages/{senderId}/{receiverId}")
    Call<List<ChatMessage>>getAllPreviousChats(@Header("Authorization") String token,@Path("senderId") String senderId,@Path("receiverId") String recipientId);

    @GET("/get/recently-posted/pets")
    Call<List<Pet>>getPopularPets(@Header("Authorization") String token);

    // find the specific pet
    @GET("/get/specific/pet/{userId}/{petId}")
    Call<Pet>getSpecificPet(@Header("Authorization") String token,@Path("userId") String userId,@Path("petId") String petId);

    // remove from favourite list
    @POST("/remove/from/favourite/list/{userId}/{petId}")
    Call<String>removeFromFavourite(@Header("Authorization") String token,@Path("userId") String userId,@Path("petId") String petId);

    // add pet to favourite list
    @POST("/add/to/favourite/{userId}/{petId}")
    Call<String>addToFavourite(@Header("Authorization") String token,@Path("userId") String userId,@Path("petId") String petId);

    // get all favourite pets of user
    @GET("/get/all/favourite/pets/{userId}")
    Call<List<Pet>>getAllFavouritePets(@Header("Authorization") String token,@Path("userId") String userId);

    // to delete the posted pet
   @DELETE("/delete/specific/pet/{petId}/{userId}")
   Call<String> deletePet(@Header("Authorization") String token,@Path("petId") String petId,@Path("userId") String userId);

   @POST("/generate/reset/password/token/{email}")
  Call<String> sendRecoveryEmail(@Path("email") String email);

   @POST("/user/reset/password")
  Call<ResetPassword> confirmedResetPassword(@Body ResetPassword resetPassword);
}
