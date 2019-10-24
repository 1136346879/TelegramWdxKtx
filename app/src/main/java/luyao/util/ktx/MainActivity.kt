package luyao.util.ktx

import kotlinx.android.synthetic.main.activity_main.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.startKtxActivity
import luyao.util.ktx.mvvm.MvvmActivity
import luyao.util.ktx.ui.ExtActivity
import luyao.util.ktx.ui.LifeCycleActivity
import androidx.core.content.ContextCompat.startActivity
import org.telegram.ui.LaunchActivity
import android.content.Intent
import android.view.View
import android.widget.Toast



class MainActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.activity_main

    override fun initView() {}

    override fun initData() {
        btMvvm.setOnClickListener { startKtxActivity<MvvmActivity>() }
        btExt.setOnClickListener { startKtxActivity<ExtActivity>()}
        lifeCycleBt.setOnClickListener {
            startKtxActivity<LifeCycleActivity>()
        }
        Telegram.setOnClickListener {
            Toast.makeText(application, "去Telegram", Toast.LENGTH_SHORT).show()
            val intent = Intent(application, LaunchActivity::class.java)
            startActivity(intent)
        }
    }
}
