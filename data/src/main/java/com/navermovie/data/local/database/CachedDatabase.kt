package com.navermovie.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.navermovie.data.local.ActorTypeConverter
import com.navermovie.data.local.ArticleTypeConverter
import com.navermovie.data.local.dao.CachedActorDao
import com.navermovie.data.local.dao.CachedArticleDao
import com.navermovie.data.local.dao.CachedStoryDao
import com.navermovie.data.local.dto.CachedActorImageEntity
import com.navermovie.data.local.dto.CachedArticleEntity
import com.navermovie.data.local.dto.CachedStoryEntity

@Database(
    entities = [CachedActorImageEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ActorTypeConverter::class)
abstract class CachedActorDatabase : RoomDatabase() {

    abstract fun CachedActorDao(): CachedActorDao

    companion object {
        fun getInstance(context: Context): CachedActorDatabase = Room
            .databaseBuilder(context, CachedActorDatabase::class.java, "cached_actor.db")
            .build()
    }
}

@Database(
    entities = [CachedArticleEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ArticleTypeConverter::class)
abstract class CachedArticleDatabase : RoomDatabase() {

    abstract fun CachedArticleDao(): CachedArticleDao

    companion object {
        fun getInstance(context: Context): CachedArticleDatabase = Room
            .databaseBuilder(context, CachedArticleDatabase::class.java, "cached_article.db")
            .build()
    }
}


@Database(
    entities = [CachedStoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CachedStoryDatabase : RoomDatabase() {

    abstract fun CachedStoryDao(): CachedStoryDao

    companion object {
        fun getInstance(context: Context): CachedStoryDatabase = Room
            .databaseBuilder(context, CachedStoryDatabase::class.java, "cached_story.db")
            .build()
    }
}