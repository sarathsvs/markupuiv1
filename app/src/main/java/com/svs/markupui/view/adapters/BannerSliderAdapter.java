package com.svs.markupui.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.svs.markupui.R;
import com.svs.markupui.models.BannerAd;

import java.util.ArrayList;

public class BannerSliderAdapter extends SliderViewAdapter<SliderAdapterVH> {

    private Context context;
    private ArrayList<BannerAd> mSliderItems = new ArrayList<>();

    public BannerSliderAdapter(Context context, ArrayList<BannerAd> list) {
        this.context = context;
        this.mSliderItems=list;
    }

    public void renewItems(ArrayList<BannerAd> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(BannerAd sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        BannerAd sliderItem = mSliderItems.get(position);

       // viewHolder.textViewDescription.setText(sliderItem.getDescription());
      //  viewHolder.textViewDescription.setTextSize(16);
      //  viewHolder.textViewDescription.setTextColor(Color.WHITE);
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getBanner_image())
                .fitCenter()
                .into(viewHolder.imgBanner);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
       // return 5;
    }



}
