package com.svs.markupui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.svs.markupui.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.svs.markupui.view.fragments.*
import kotlinx.android.synthetic.main.activity_main_home.*


class MainHome : AppCompatActivity() {
    lateinit var pagerAdapter: PagerAdapter
    var CURRENT_FRAGMENT_ID=0
    lateinit var fragmentList:ArrayList<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        getHomeFragments()
        initSlides()
        initBottomNavMenu()

        initCLicks()

        try{
            val fragId = intent.getStringExtra("fragId")
            openFragmentById(fragId!!)
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    fun changeStatusBarColour(type:Int){
        // val window: Window = window
        //   window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        when(type){
            1->{
                window.statusBarColor = ContextCompat.getColor(applicationContext,R.color.status_bar_color)
            }
            2->{
                window.statusBarColor = ContextCompat.getColor(applicationContext,R.color.status_bar_color)
            }
        }

    }


    private fun initCLicks(){

    }

    fun openFragmentById(fragId:String){
        when(fragId.toInt()){
            0->{
                bottomNav.selectedItemId = R.id.item_0
                pager.currentItem=0
            }
            1->{
                bottomNav.selectedItemId = R.id.item_1
                pager.currentItem=1
            }
            2->{
                bottomNav.selectedItemId = R.id.item_2
                pager.currentItem=2
            }
            3->{
                bottomNav.selectedItemId = R.id.item_3
                pager.currentItem=3
            }
            4->{
                bottomNav.selectedItemId = R.id.item_4
                pager.currentItem=4
            }

        }

    }



    private fun initBottomNavMenu(){
        bottomNav.selectedItemId = R.id.item_0
        pager.currentItem=0
        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.item_0 -> {

                    pager.currentItem=0
                    return@OnNavigationItemSelectedListener true
                }
                R.id.item_1->{
                    pager.currentItem=1
                    return@OnNavigationItemSelectedListener true
                }
                R.id.item_2->{
                    pager.currentItem=2
                    return@OnNavigationItemSelectedListener true
                }

                R.id.item_3->{
                    pager.currentItem=3
                    return@OnNavigationItemSelectedListener true
                }
                R.id.item_4->{
                    pager.currentItem=4
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }

        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }


    fun slideOpenHome(){
        bottomNav.selectedItemId = R.id.item_0
        pager.currentItem=0
    }



    private fun initSlides(){
        pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        pager.adapter=pagerAdapter
        pager.currentItem=0

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {


            }
            override fun onPageSelected(position: Int) {
                CURRENT_FRAGMENT_ID = position

                when (position) {
                    0 -> {
                        bottomNav.selectedItemId = R.id.item_0
                    }
                    1 -> {
                        bottomNav.selectedItemId = R.id.item_1
                    }
                    2 ->{
                        bottomNav.selectedItemId = R.id.item_2
                    }
                    3 -> {
                        bottomNav.selectedItemId = R.id.item_3
                    }
                    4 -> {
                        bottomNav.selectedItemId = R.id.item_4
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    inner class ScreenSlidePagerAdapter(fm: FragmentManager?) :
        FragmentStatePagerAdapter(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
    {

        override fun getItem(position: Int): Fragment { //return new ScreenSlidePageFragment();
            CURRENT_FRAGMENT_ID = position
            // appUtils.toast("$CURRENT_FRAGMENT_ID")
            return getHomeFragments()[position]
        }


        override fun getCount(): Int {
            return fragmentList.size
        }
    }


    fun openFragment(fragment: Fragment) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
        )
        ft.replace(R.id.mainLayout, fragment)
        ft.commit()
    }

    fun getHomeFragments():ArrayList<Fragment>{

        fragmentList = ArrayList()
        fragmentList.add(HomeFragment())
        fragmentList.add(CalenderFragment())
        fragmentList.add(ShopFragment())
        fragmentList.add(WalletFragment())
        fragmentList.add(MenuFragment())

        return fragmentList
    }

    override fun onBackPressed() {
        // super.onBackPressed()
        if(pager.currentItem!=0){
            slideOpenHome()
        }else{
            finish()
        }
    }
}
