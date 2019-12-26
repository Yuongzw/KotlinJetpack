package com.xiangxue.alvin.flowlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

/**
 * author : zhiwen.yang
 * date   : 2019/12/26
 * desc   :
 */
public class ParallaxLayoutInflater extends LayoutInflater {
    private static final String TAG = "ParallaxLayoutInflater";
    private ParallaxFragment fragment;
    private String[] sClassPrefix = {
            "android.widget.",
            "android.view."
    };
    private int[] attrIds =  {
            R.attr.a_in,
            R.attr.a_out,
            R.attr.x_in,
            R.attr.x_out,
            R.attr.y_in,
            R.attr.y_out
    };

    protected ParallaxLayoutInflater(LayoutInflater original, Context newContext, ParallaxFragment fragment) {
        super(original, newContext);
        this.fragment = fragment;
        setFactory2(new ParallaxFactory(this));
    }

    @Override
    public LayoutInflater cloneInContext(Context newContext) {
        return new ParallaxLayoutInflater(this, newContext, fragment);
    }

    class ParallaxFactory implements LayoutInflater.Factory2 {

        private LayoutInflater inflater;

        public ParallaxFactory(LayoutInflater inflater) {
            this.inflater = inflater;
        }

        @SuppressLint("ResourceType")
        @Override
        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            Log.w(TAG, name);
            View view;
            view = crateView(name, context, attrs);
            if (view != null) {
                TypedArray a = context.obtainStyledAttributes(attrs, attrIds);
                if (a != null && a.length() > 0) {
                    ParallaxViewTag tag = new ParallaxViewTag();
                    tag.alphaIn = a.getFloat(0, 0f);//第一个参数表示在int数组中的索引，第二个参数为默认值
                    tag.alphaOut = a.getFloat(1, 0f);
                    tag.xIn = a.getFloat(2, 0f);
                    tag.xOut = a.getFloat(3, 0f);
                    tag.yIn = a.getFloat(4, 0f);
                    tag.yOut = a.getFloat(5, 0f);
                    view.setTag(R.id.parallax_view_tag, tag);
                    a.recycle();
                }
                fragment.getParallaxViews().add(view);
            }
            return view;
        }

        @Override
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            return null;
        }

        private View crateView(String name, Context context, AttributeSet attrs) {
            try {
                if (name.contains(".")) {
                    return inflater.createView(name, null, attrs);
                } else {
                    for (String classPrefix : sClassPrefix) {
                        View view = inflater.createView(name, classPrefix, attrs);
                        if (view != null) {
                            return view;
                        }
                    }
                }
            } catch (Exception e) {
                return null;
            }
            return null;
        }
    }


}
