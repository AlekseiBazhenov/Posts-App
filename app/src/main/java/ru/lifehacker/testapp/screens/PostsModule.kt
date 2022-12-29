package ru.lifehacker.testapp.screens

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface PostsModule {
    @Binds
    fun providePostsRepository(repository: PostsRepositoryImpl): PostsRepository
}