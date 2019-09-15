package Tests;

import Forum.PojoForumMessages;
import Forum.ApiForumMessages;
import Forum.SubForum;
import okhttp3.OkHttpClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestMessages {

    private static ApiForumMessages apiForumMessages;

    @BeforeClass
    public static void setup(){
        OkHttpClient c = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-testing-conference.herokuapp.com/v1.0/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(c)
                .build();

        apiForumMessages = retrofit.create(ApiForumMessages.class);

    }

    @AfterClass
    public static void cleanup(){

    }

    @Test
    public void validateListForumMessages() throws IOException {
        Response<PojoForumMessages> response = apiForumMessages.getForumMessages().execute();
        assertEquals(200, response.code());
    }

    //Retorna 409 pero lo agrega a la lista exitosamente.
    @Test
    public void validateCreatingForumMessages() throws IOException {
        Response<SubForum> response = apiForumMessages.postSubForumMessage(new SubForum("Testing", "Curso 1Python API REST" ,"Vaya profesor más aburrido")).execute();
        assertEquals(200, response.code());
    }

}
