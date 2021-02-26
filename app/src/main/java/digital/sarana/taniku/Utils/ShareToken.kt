package digital.sarana.taniku.Utils

import android.content.Context
import androidx.fragment.app.FragmentActivity

fun loadToken(
    authToken: String,
    tokenType: String,
    accessToken: String,
    activity: FragmentActivity?
): String {
    val sharedPref = activity?.getSharedPreferences(authToken, Context.MODE_PRIVATE)
    val authtoken = sharedPref?.getString(tokenType, "Bearer")+" "+
            sharedPref?.getString(accessToken, "empty")
    return authtoken
}