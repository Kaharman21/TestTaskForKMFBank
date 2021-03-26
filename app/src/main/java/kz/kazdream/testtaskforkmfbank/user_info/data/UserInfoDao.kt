package kz.kazdream.testtaskforkmfbank.user_info.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kz.kazdream.testtaskforkmfbank.user_info.data.model.UserEntity

@Dao
interface UserInfoDao {

    @Query("SELECT * FROM users_db WHERE username == :userName")
    suspend fun getUser(userName: String): UserEntity

    @Insert
    suspend fun insertUser(user: UserEntity)
}