package com.xqx.native_simple_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home2.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class HomeActivity : AppCompatActivity() {

    val fragments = arrayListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val adt = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        adt.syncState()
        bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.index->hideOthersFragment(fragments[0])
                R.id.serach->hideOthersFragment(fragments[1])
                R.id.center->hideOthersFragment(fragments[2])
                R.id.news->hideOthersFragment(fragments[3])
                R.id.mine->hideOthersFragment(fragments[4])
            }
            true
        }
        initFragment()
    }

    private fun initFragment() {
        fragments.add(BlankFragment.newInstance("主页", ""))
        fragments.add(BlankFragment.newInstance("地图", ""))
        fragments.add(BlankFragment.newInstance("功能", ""))
        fragments.add(BlankFragment.newInstance("通讯", ""))
        fragments.add(BlankFragment.newInstance("群组", ""))
        hideOthersFragment(fragments[0])
    }


    private fun hideOthersFragment(showFragment: Fragment) {
        val mTransaction = supportFragmentManager.beginTransaction()
        if(!showFragment.isAdded){
            mTransaction.add(R.id.frameLayout, showFragment)
        }
        for (fragment: Fragment in fragments) {
            if (showFragment == fragment) {
                mTransaction.show(fragment)
            } else {
                mTransaction.hide(fragment)
            }
        }
        mTransaction.commit()
    }

}