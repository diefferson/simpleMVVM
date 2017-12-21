package br.com.disapps.simplemvvm.ui.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import br.com.disapps.simplemvvm.R
import br.com.disapps.simplemvvm.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by diefferson on 29/11/2017.
 */

class HomeFragment : BaseFragment(){

    companion object {
        fun newInstance() = HomeFragment()
    }

    override val viewModelClass: Class<out ViewModel>
        get() = HomeViewModel::class.java

    override val fragmentTag: String
        get() = HomeFragment::class.java.simpleName

    override val fragmentName: String
        get() = getString(R.string.home)

    override val fragmentLayout: Int
        get() = R.layout.fragment_home

}
