package com.james.favorite.di

import android.content.Context
import com.james.soccerplayers.di.FavoriteSoccerPlayerDependencies
import com.james.favorite.FavoriteSoccerPlayerFragment
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteSoccerPlayerDependencies::class])
interface FavoriteSoccerPlayerComponent  {

    fun inject(favoriteSoccerPlayerFragment: FavoriteSoccerPlayerFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance ctx: Context): Builder
        fun appDependencies(favoriteSoccerPlayerDependencies: FavoriteSoccerPlayerDependencies): Builder
        fun build(): FavoriteSoccerPlayerComponent
    }

}