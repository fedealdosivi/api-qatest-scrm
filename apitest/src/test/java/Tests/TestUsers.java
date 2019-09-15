package Tests;

import Forum.*;
import okhttp3.OkHttpClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TestUsers {

    private static ApiUsers apiUsers;

    @BeforeClass
    public static void setup(){
        OkHttpClient c = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-testing-conference.herokuapp.com/v1.0/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(c)
                .build();

        apiUsers = retrofit.create(ApiUsers.class);
    }

    @AfterClass
    public static void cleanup(){

    }

    @Test
    public void validateUsersList() throws IOException {
        Response<PojoUsers> response = apiUsers.getUsers().execute();
        assertEquals(200, response.code());
    }

    //Retorna 409 pero hace el post exitosamente, verificarlo despues en la lista.
    @Test
    public void validateCreatingQAUser() throws IOException{
        User usuario = new UserBuilder().withRole("QA").build();
        Response<User> response = apiUsers.postUser(usuario).execute();
        assertEquals(200, response.code());
    }

    @Test
    public void validateSendingPrivateMessages() throws IOException{

        User sender = new UserBuilder().withRole("QA").build();
        User receiver = new UserBuilder().withRole("QA").build();
        apiUsers.postUser(sender).execute();
        apiUsers.postUser(receiver).execute();

        OkHttpClient c = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor(sender.getUsername(), sender.getPassword()))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-testing-conference.herokuapp.com/v1.0/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(c)
                .build();

        ApiUsers api = retrofit.create(ApiUsers.class);

        Response<String> response = api.sendMessage(receiver.getUsername(), "hola");
        assertEquals(200, response.code());
    }

    @Test
    public void validateListPrivateMessages() throws IOException{
        User user = new UserBuilder().withRole("QA").build();
        apiUsers.postUser(user).execute();

        OkHttpClient c = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor(user.getUsername(), user.getPassword()))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-testing-conference.herokuapp.com/v1.0/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(c)
                .build();

        ApiUsers api = retrofit.create(ApiUsers.class);

        Response<List<String>> response = api.getMessages(user.getUsername());
        assertEquals(200, response.code());

    }
}
