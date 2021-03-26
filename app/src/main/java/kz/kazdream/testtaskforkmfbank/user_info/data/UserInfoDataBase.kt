package kz.kazdream.testtaskforkmfbank.user_info.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kz.kazdream.testtaskforkmfbank.user_info.data.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserInfoDataBase: RoomDatabase() {

    abstract val userInfoDao: UserInfoDao

    companion object {
        fun create(applicationContext: Context): UserInfoDataBase =
            Room.databaseBuilder(
                applicationContext,
                UserInfoDataBase::class.java,
                "users.db"
            )
                .fallbackToDestructiveMigration()
                .build()
    }

}