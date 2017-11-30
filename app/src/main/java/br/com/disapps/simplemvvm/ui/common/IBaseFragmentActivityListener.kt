package br.com.disapps.simplemvvm.ui.common

import android.support.v4.app.Fragment

/**
 * Created by diefferson on 29/11/2017.
 */
interface IBaseFragmentActivityListener {

    fun setTitle(title: String)

    fun setDisplayHomeAsUpEnabled()

    fun replaceFragment(fragment: Fragment)

    fun replaceAndBackStackFragment(fragment: Fragment)

    //fun replaceAndBackStackFragment(fragment: Fragment, animated: Boolean)
}
