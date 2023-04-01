package com.example.simplenotesjetpackcompose.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.simplenotesjetpackcompose.data.AppDatabase
import com.example.simplenotesjetpackcompose.data.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Singleton
    @Provides
    fun provideNotesDao(db: AppDatabase) : NoteDao{
         return db.noteDao()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext con: Context) : AppDatabase{
        return Room.databaseBuilder(con,AppDatabase::class.java,"NoteDb").fallbackToDestructiveMigration().build()
    }

}