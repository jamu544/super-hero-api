package android.com.jumpco.io.superheroapi;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;

@GlideModule
public class MyAppGlideModule extends AppGlideModule {

    @Override
    public void applyOptions(@NonNull  Context context, @NonNull GlideBuilder builder) {
        //Glide default Bitmap Format is set to RGB_565 since
        //consumed just 50% memory footprint compared to ARGB_8888
        //Increase memory usage for quality with
        super.applyOptions(context, builder);
        builder.setDefaultRequestOptions(new RequestOptions().format(DecodeFormat.PREFER_ARGB_8888));
    }
}
