package BekhrUzBEK.valyutakursi
import retrofit2.Call
import retrofit2.http.GET

interface Retrofitservice {

    @GET("json")
    fun getAllTodo():Call<List<MyValyuta>>
}