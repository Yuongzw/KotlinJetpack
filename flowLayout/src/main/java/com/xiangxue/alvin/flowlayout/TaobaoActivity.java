package com.xiangxue.alvin.flowlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * author : zhiwen.yang
 * date   : 2019/12/30
 * desc   :
 */
public class TaobaoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    //应用
    String[] ITEM_NAMES = {"天猫", "聚划算", "天猫国际", "外卖", "天猫超市", "充值中心", "飞猪旅行", "领金币", "拍卖", "分类"};
    int[] IMG_URLS = {R.mipmap.ic_tian_mao, R.mipmap.ic_ju_hua_suan, R.mipmap.ic_tian_mao_guoji, R.mipmap.ic_waimai, R.mipmap.ic_chaoshi, R.mipmap.ic_voucher_center, R.mipmap.ic_travel, R.mipmap.ic_tao_gold, R.mipmap.ic_auction, R.mipmap.ic_classify};

    //    高颜值商品位
    int[] ITEM_URL = {R.mipmap.item1, R.mipmap.item2, R.mipmap.item3, R.mipmap.item4, R.mipmap.item5};
    int[] GRID_URL = {R.mipmap.flashsale1, R.mipmap.flashsale2, R.mipmap.flashsale3, R.mipmap.flashsale4};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taobao);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(virtualLayoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);//设置回收池
        viewPool.setMaxRecycledViews(0, 10);//设置回收池大小，支持十种不同的布局
        BaseDelegeteAdapter bannerAdapter = new BaseDelegeteAdapter(this, new LinearLayoutHelper(), R.layout.vlayout_banner, 1) {
            @Override
            public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("http://img.alicdn.com/tfs/TB1HFM9r7T2gK0jSZFkXXcIQFXa-520-280.jpg_q90_.webp");
                arrayList.add("https://img.alicdn.com/simba/img/TB1EDLvhYH1gK0jSZFwSuw7aXXa.jpg");
                arrayList.add("https://img.alicdn.com/simba/img/TB1_Dc.rND1gK0jSZFKSuwJrVXa.jpg");
                arrayList.add("https://img.alicdn.com/simba/img/TB1BZkwrYH1gK0jSZFwSuw7aXXa.jpg");
                arrayList.add("https://img.alicdn.com/tfs/TB14BYurHY1gK0jSZTEXXXDQVXa-520-280.png_q90_.webp");
                //绑定数据
                Banner banner = holder.getView(R.id.banner);
                //设置banner样式
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                //设置banner动画效果
                banner.setBannerAnimation(Transformer.DepthPage);
                //设置图片集合
                banner.setImages(arrayList);
                //设置标题集合
//            banner.setBannerTitles(titles);
                //设置自动轮播，默认为true
                banner.isAutoPlay(true);
                //设置轮播事件
                banner.setDelayTime(3000);
                //设置指示器位置
                banner.setIndicatorGravity(BannerConfig.CENTER);
                //设置加载接口
                banner.setImageLoader(new MyImageLoader());
                //监听点击事件
                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Toast.makeText(TaobaoActivity.this, "点击了第 " + position + " 张图片", Toast.LENGTH_SHORT).show();
                    }
                });
                //开始轮播
                banner.start();
            }
        };
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setPadding(0, 16, 0, 0);
//        gridLayoutHelper.setVGap(10);//设置子元素之间垂直的距离
//        gridLayoutHelper.setHGap(10);//设置子元素之间水平间距
        BaseDelegeteAdapter menuAdapter = new BaseDelegeteAdapter(this, gridLayoutHelper, R.layout.vlayout_menu, 10){
            @Override
            public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
                super.onBindViewHolder(holder, position);
                holder.setText(R.id.tv_menu_title_home, ITEM_NAMES[position] + "");
                holder.setImageResource(R.id.iv_menu_home, IMG_URLS[position]);
                holder.getView(R.id.ll_menu_home).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(TaobaoActivity.this, ITEM_NAMES[position], Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        BaseDelegeteAdapter newsAdapter = new BaseDelegeteAdapter(this, new LinearLayoutHelper(), R.layout.vlayout_news, 1) {
            @Override
            public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                MarqueeView marqueeView1 = holder.getView(R.id.marqueeView1);
                MarqueeView marqueeView2 = holder.getView(R.id.marqueeView2);
                List<String> info1 = new ArrayList<>();
                info1.add("天猫超时最近发大活动啦，快来抢");
                info1.add("没有最便宜，只有更便宜！");

                List<String> info2 = new ArrayList<>();
                info2.add("这个是用来搞笑的，不要在意这些小细节");
                info2.add("啦啦啦啦，我就是来搞笑的！");
//                marqueeView1.startWithList(info1);
//                marqueeView2.startWithList(info2);

                marqueeView1.startWithList(info1, R.anim.anim_bottom_in, R.anim.anim_top_out);
                marqueeView2.startWithList(info2, R.anim.anim_bottom_in, R.anim.anim_top_out);
                marqueeView1.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, TextView textView) {
                        Toast.makeText(TaobaoActivity.this, textView.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                marqueeView2.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, TextView textView) {
                        Toast.makeText(TaobaoActivity.this, textView.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        delegateAdapter.addAdapter(bannerAdapter);
        delegateAdapter.addAdapter(menuAdapter);
        delegateAdapter.addAdapter(newsAdapter);
        for (int i = 0; i < ITEM_URL.length; i++) {
            final int finalI = i;
            BaseDelegeteAdapter titleAdapter = new BaseDelegeteAdapter(this, new LinearLayoutHelper(), R.layout.vlayout_title, 1) {
                @Override
                public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
                    super.onBindViewHolder(holder, position);
                    holder.setImageResource(R.id.iv, ITEM_URL[finalI]);
                }
            };
            GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(2);
            BaseDelegeteAdapter gridAdapter = new BaseDelegeteAdapter(this, gridLayoutHelper1, R.layout.vlayout_grid, 4){
                @Override
                public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
                    super.onBindViewHolder(holder, position);
                    ImageView iv = holder.getView(R.id.iv);
                    Glide.with(TaobaoActivity.this)
                            .load(GRID_URL[position])
                            .into(iv);
                    iv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(TaobaoActivity.this, "item" + position, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            };
            delegateAdapter.addAdapter(titleAdapter);
            delegateAdapter.addAdapter(gridAdapter);
        }
        recyclerView.setAdapter(delegateAdapter);
    }

//    class BannerAdapter extends DelegateAdapter.Adapter<BaseViewHolder> {
//
//
//        private Context mContext;
//
//        public BannerAdapter(Context context) {
//            mContext = context;
//        }
//
//        @Override
//        public LayoutHelper onCreateLayoutHelper() {
//            return new LinearLayoutHelper();
//        }
//
//        @NonNull
//        @Override
//        public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            return new BaseViewHolder(LayoutInflater.from(mContext).inflate(R.layout.vlayout_banner, parent, false));
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
//            ArrayList<String> arrayList = new ArrayList<>();
//            arrayList.add("http://img.alicdn.com/tfs/TB1HFM9r7T2gK0jSZFkXXcIQFXa-520-280.jpg_q90_.webp");
//            arrayList.add("https://img.alicdn.com/simba/img/TB1EDLvhYH1gK0jSZFwSuw7aXXa.jpg");
//            arrayList.add("https://img.alicdn.com/simba/img/TB1_Dc.rND1gK0jSZFKSuwJrVXa.jpg");
//            arrayList.add("https://img.alicdn.com/simba/img/TB1BZkwrYH1gK0jSZFwSuw7aXXa.jpg");
//            arrayList.add("https://img.alicdn.com/tfs/TB14BYurHY1gK0jSZTEXXXDQVXa-520-280.png_q90_.webp");
//            //绑定数据
//            Banner banner = holder.getView(R.id.banner);
//            //设置banner样式
//            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
//            //设置banner动画效果
//            banner.setBannerAnimation(Transformer.DepthPage);
//            //设置图片集合
//            banner.setImages(arrayList);
//            //设置标题集合
////            banner.setBannerTitles(titles);
//            //设置自动轮播，默认为true
//            banner.isAutoPlay(true);
//            //设置轮播事件
//            banner.setDelayTime(3000);
//            //设置指示器位置
//            banner.setIndicatorGravity(BannerConfig.CENTER);
//            //设置加载接口
//            banner.setImageLoader(new MyImageLoader());
//            //监听点击事件
//            banner.setOnBannerListener(new OnBannerListener() {
//                @Override
//                public void OnBannerClick(int position) {
//                    Toast.makeText(mContext, "点击了第 " + position + " 张图片", Toast.LENGTH_SHORT).show();
//                }
//            });
//            //开始轮播
//            banner.start();
//        }
//
//        @Override
//        public int getItemCount() {
//            return 1;
//        }
//    }
}
