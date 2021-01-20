package com.svs.markupui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smarteist.autoimageslider.SliderAnimations
import com.svs.markupui.R
import com.svs.markupui.view.activities.MainHome
import com.svs.markupui.view.adapters.BannerSliderAdapter
import com.svs.markupui.models.BannerAd
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (context as MainHome).changeStatusBarColour(2)
        init()

    }

    private fun init(){
        showLoader(false)
        initSliderBannerHeader(getDummyBanners())
    }

    fun getDummyBanners():ArrayList<BannerAd>{
        var list :  ArrayList<BannerAd> = ArrayList()
        list.add(BannerAd("","https://images.pexels.com/photos/3183183/pexels-photo-3183183.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","",""))
        list.add(BannerAd("","https://images.indianexpress.com/2020/04/Work-from-home-759.jpg","",""))
        list.add(BannerAd("","https://img.etimg.com/thumb/width-640,height-480,imgsize-890916,resizemode-1,msid-74745305/wealth/earn/coronavirus-and-worklife-tips-to-make-working-from-home-easy/cowfh.jpg","",""))
        return list
    }

    private fun initSliderBannerHeader(listSlider: ArrayList<BannerAd>) {
        try{
            imageSlider.setSliderAdapter(
                BannerSliderAdapter(context, listSlider)
            )
            imageSlider.startAutoCycle()
            // imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM)
            imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)

        }catch (e:Exception){

        }

    }



    private fun showLoader(b: Boolean) {

        try{
            if(b){
                loadingLayout.visibility= View.VISIBLE
                contentLayout.visibility=View.INVISIBLE
            }else{
                loadingLayout.visibility= View.GONE
                contentLayout.visibility=View.VISIBLE
            }
        }catch (e:Exception){

        }


    }




}
