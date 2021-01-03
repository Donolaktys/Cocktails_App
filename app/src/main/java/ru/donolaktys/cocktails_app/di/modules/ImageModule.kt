package ru.donolaktys.cocktails_app.di.modules

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.donolaktys.cocktails_app.mvp.model.image.IImageLoader
import ru.donolaktys.cocktails_app.ui.image.GlideImageLoader
import javax.inject.Singleton

@Module
class ImageModule {

    @Singleton
    @Provides
    fun loadImage() : IImageLoader<ImageView> = GlideImageLoader()
}