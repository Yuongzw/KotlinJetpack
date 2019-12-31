package com.xiangxue.alvin.flowlayout;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author : zhiwen.yang
 * date   : 2019/12/30
 * desc   :
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> views;
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        views = new SparseArray<>();
    }

    public BaseViewHolder setText(@IdRes int viewId, String str){
        TextView textView = getView(viewId);
        textView.setText(str);
        return this;
    }

    public BaseViewHolder setTextColor(@IdRes int viewId, @ColorInt int textColor) {
        TextView textView = getView(viewId);
        textView.setTextColor(textColor);
        return this;
    }

    public BaseViewHolder setImageResource(@IdRes int viewId, @DrawableRes int imageResId){
        ImageView imageView = getView(viewId);
        imageView.setImageResource(imageResId);
        return this;
    }

    public  <T extends View> T getView(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}
