package com.svs.markupui.view.adapters;

import android.view.View;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;
import com.svs.markupui.R;

class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

    View itemView;
    ImageView imgBanner;
    //   ImageView imageGifContainer;
    // TextView textViewDescription;

    public SliderAdapterVH(View itemView) {
        super(itemView);
        imgBanner = itemView.findViewById(R.id.imgBanner);
        //imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
        //textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
        this.itemView = itemView;
    }
}