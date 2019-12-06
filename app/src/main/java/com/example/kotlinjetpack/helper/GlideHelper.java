package com.example.kotlinjetpack.helper;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.kotlinjetpack.R;

/**
 * author : zhiwen.yang
 * date   : 2019/12/3
 * desc   :
 */
public class GlideHelper {

    /**
     * mv_vm xml 传入url 加载图片
     * imageUrl 为xml中 的命名
     *
     * @param iv  imageView
     * @param url 图片路径
     */
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView iv, String url) {
        Glide.with(iv.getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(iv);
    }
}
