package com.example.viewpagerwithdotindicator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {
    private lateinit var view_pager2:ViewPager2

    private var titleList= mutableListOf<String>()
    private var descList= mutableListOf<String>()
    private var imageList= mutableListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postToList()
        view_pager2=findViewById(R.id.view_pager2)

        view_pager2.adapter=ViewPagerAdapter(titleList,descList,imageList)
        view_pager2.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        val indicator=findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager2)

        val btn_fake_swipe=findViewById<Button>(R.id.btn_fake_swipe)
        btn_fake_swipe.setOnClickListener {

            view_pager2.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }

        }

    }

    private fun addToList(title:String,description:String,image:Int)
    {
        titleList.add(title)
        descList.add(description)
        imageList.add(image)

    }

    private fun postToList()
    {
        for(i in 1..5)
        {
            addToList("Title $i","Description $i", R.drawable.girl3)

        }
    }
}