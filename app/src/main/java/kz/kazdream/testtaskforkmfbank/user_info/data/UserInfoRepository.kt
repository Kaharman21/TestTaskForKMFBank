package kz.kazdream.testtaskforkmfbank.user_info.data

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.kazdream.testtaskforkmfbank.common.model.User
import kz.kazdream.testtaskforkmfbank.common.retrofit.RetrofitModule
import kz.kazdream.testtaskforkmfbank.user_info.data.model.UserEntity
import retrofit2.Response

private const val DEFAULT_USERNAME = ""
private const val DEFAULT_FIRSTNAME = ""
private const val DEFAULT_LASTNAME = ""
private const val DEFAULT_EMAIL = ""
private const val DEFAULT_PASSWORD = ""
private const val DEFAULT_PHONE = ""
private const val DEFAULT_USERSTATUS = 0

class UserInfoRepository(context: Context) {

    private val usersDB = UserInfoDataBase.create(context)
//
//    suspend fun getUserInfo(username: String): Response<User>{
//        return RetrofitModule.retrofitApi.getUserInfo(username)
//    }

    suspend fun getUserInfoNew(
        success: (User?) -> Unit,
        fail: (String?) -> Unit,
        username: String,
        scope: CoroutineScope
    ) {
        scope.launch {
            var response = RetrofitModule.retrofitApi.getUserInfo(username)

            if (response.isSuccessful){
                val user = response.body()
                addUserToDB(user!!)
                success(getUserInfoFromDB(user.username))
            } else {
                fail(response.message())
            }

        }
    }

    private suspend fun getUserInfoFromDB(username: String): User = withContext(Dispatchers.IO){
        val userEntity = usersDB.userInfoDao.getUser(username)
        toUser(userEntity)
    }

    private suspend fun addUserToDB(user: User) {
        withContext(Dispatchers.IO){
            val userEntity = toUserEntity(user)
            usersDB.userInfoDao.insertUser(userEntity)
        }
    }

    private fun toUser(userEntity: UserEntity?) = User(
        username = userEntity?.username ?: DEFAULT_USERNAME,
        firstname = userEntity?.firstname ?: DEFAULT_FIRSTNAME,
        lastname = userEntity?.lastname ?: DEFAULT_LASTNAME,
        email = userEntity?.email ?: DEFAULT_EMAIL,
        password = userEntity?.password ?: DEFAULT_PASSWORD,
        phone = userEntity?.phone ?: DEFAULT_PHONE,
        userStatus = userEntity?.userStatus ?: DEFAULT_USERSTATUS
    )

    private fun toUserEntity(user: User?) = UserEntity(
        username = user?.username ?: DEFAULT_USERNAME,
        firstname = user?.firstname ?: DEFAULT_FIRSTNAME,
        lastname = user?.lastname ?: DEFAULT_LASTNAME,
        email = user?.email ?: DEFAULT_EMAIL,
        password = user?.password ?: DEFAULT_PASSWORD,
        phone = user?.phone ?: DEFAULT_PHONE,
        userStatus = user?.userStatus ?: DEFAULT_USERSTATUS
    )
}