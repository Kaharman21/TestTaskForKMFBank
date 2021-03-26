package kz.kazdream.testtaskforkmfbank.user_info.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_db")
class UserEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "firstname")
    val firstname: String,
    @ColumnInfo(name = "lastname")
    val lastname: String,
    @ColumnInfo(name = "iemaild")
    val email: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "userStatus")
    val userStatus: Int
)