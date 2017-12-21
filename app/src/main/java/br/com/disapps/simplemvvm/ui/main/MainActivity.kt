package br.com.disapps.simplemvvm.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import br.com.disapps.homepet.util.extensions.startActivity
import br.com.disapps.simplemvvm.R
import br.com.disapps.simplemvvm.ui.common.BaseFragment
import br.com.disapps.simplemvvm.ui.common.BaseFragmentActivity
import br.com.disapps.simplemvvm.ui.home.HomeFragment
import br.com.disapps.simplemvvm.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_container.*
import kotlinx.android.synthetic.main.include_toolbar.*

class MainActivity : BaseFragmentActivity(), NavigationView.OnNavigationItemSelectedListener {

    override val viewModelClass: Class<out ViewModel>
        get() = MainViewModel::class.java

    override val activityTag: String
        get() = MainActivity::class.java.simpleName

    override val activityName: String
        get() = getString(R.string.main)

    override val activityLayout: Int
        get() = R.layout.activity_main

    override val container: FrameLayout
        get() = vContainer

    override val toolbar: Toolbar
        get() = vToolbar

    override val initialFragment: BaseFragment
        get() = HomeFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDrawer()
    }

    private fun setupDrawer(){
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, vToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)

        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
               startActivity(LoginActivity::class.java)
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
