package ru.lifehacker.testapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        PostEntity::class
    ],
    version = 1
)
@TypeConverters(IntTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postsDao(): PostsDao
}