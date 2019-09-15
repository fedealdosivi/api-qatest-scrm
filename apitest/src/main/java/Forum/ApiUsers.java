package Forum;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface ApiUsers {

    @GET("users")
    Call<PojoUsers> getUsers();

    @POST("users")
    Call<User> postUser(@Body User user);

    @POST("/users/{username}")
    Response<String> sendMessage(@Path("username") String username, @Body String message);

    @GET("/users/{username}")
    Response<List<String>> getMessages(@Path("username") String username);
}
