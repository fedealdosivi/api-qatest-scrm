package Forum;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiForumMessages {

    @GET("forum")
    Call<PojoForumMessages> getForumMessages();

    @POST("forum")
    Call<SubForum> postSubForumMessage(@Body SubForum message);
}
