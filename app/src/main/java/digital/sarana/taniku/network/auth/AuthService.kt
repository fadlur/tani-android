package digital.sarana.taniku.network.auth

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {
    @FormUrlEncoded
    @POST("/api/login")
    suspend fun submitLogin(@Field("email") email: String,
                            @Field("password") password: String): LoginRespon

    @FormUrlEncoded
    @POST("/api/register")
    suspend fun submitRegister(@Field("email") email:String,
                               @Field("name") name:String,
                               @Field("password") password:String,
                               @Field("role") role: String,
                               @Field("phone") phone:String): RegisterRespon
}

object AuthAPI {
    val authService: AuthService by lazy {
        retrofit.create(AuthService::class.java)
    }
}