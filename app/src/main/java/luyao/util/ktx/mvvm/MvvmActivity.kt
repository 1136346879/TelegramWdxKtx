package luyao.util.ktx.mvvm

import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_mvvm_demo.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseVMActivity
import luyao.util.ktx.ext.toast

/**
 * Created by luyao
 * on 2019/5/31 16:28
 */
class MvvmActivity : BaseVMActivity<MvvmModel>() {

    override fun providerVMClass() = MvvmModel::class.java

    override fun getLayoutResId() = R.layout.activity_mvvm_demo

    override fun initView() {
        mvvm.setOnClickListener { mViewModel.getMessage() }
        error.setOnClickListener { mViewModel.errorTest() }
    }

    override fun initData() {

    }

    override fun startObserve() {
        super.startObserve()
        mViewModel.run {
            mMessage.observe(this@MvvmActivity, Observer {
                it?.run {
                    toast(it)
                }
            })
        }
    }

    override fun onError(e: Throwable) {
        toast("Occur Error : ${e.message}")
    }
}