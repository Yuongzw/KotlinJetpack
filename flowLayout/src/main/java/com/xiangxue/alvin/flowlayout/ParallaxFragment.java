package com.xiangxue.alvin.flowlayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * author : zhiwen.yang
 * date   : 2019/12/26
 * desc   :
 */
public class ParallaxFragment extends Fragment {

    private List<View> ParallaxViews = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int layoutId = 0;
        if (bundle != null) {
            layoutId = bundle.getInt("layoutId");
        }
        ParallaxLayoutInflater layoutInflater = new ParallaxLayoutInflater(inflater, getActivity(), this);
        return layoutInflater.inflate(layoutId, null);
    }

    public List<View> getParallaxViews() {
        return ParallaxViews;
    }
}
