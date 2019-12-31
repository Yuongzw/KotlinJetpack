package com.xiangxue.alvin.flowlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

/**
 * author : zhiwen.yang
 * date   : 2019/12/31
 * desc   :
 */
public class BaseDelegeteAdapter extends DelegateAdapter.Adapter<BaseViewHolder> {
    private LayoutHelper layoutHelper;
    private int count = -1;
    private int layoutId = -1;
    private Context context;
    private int viewTypeItem = -1;

    public BaseDelegeteAdapter(Context context, LayoutHelper layoutHelper, int layoutId, int count) {
        this.layoutHelper = layoutHelper;
        this.count = count;
        this.layoutId = layoutId;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseViewHolder(LayoutInflater.from(context).inflate(layoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return count;
    }
}
