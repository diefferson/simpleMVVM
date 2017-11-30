package br.com.disapps.simplemvvm.ui.login

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import br.com.disapps.simplemvvm.R
import br.com.disapps.simplemvvm.ui.common.BaseActivity

class LoginActivity : BaseActivity<LoginViewModel>() {

    override val mViewModel: LoginViewModel
        get() = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)

    override val activityTag: String
        get() = LoginActivity::class.java.simpleName

    override val activityName: String
        get() = getString(R.string.login)

    override val activityLayout: Int
        get() = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}