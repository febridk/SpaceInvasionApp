package id.febridk.spaceinvasion.ui.corona

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import id.febridk.spaceinvasion.R
import id.febridk.spaceinvasion.data.model.Corona
import id.febridk.spaceinvasion.databinding.ItemCoronaBinding
import id.febridk.spaceinvasion.ui.base.BaseAdapter

class CoronaAdaptor(val context: Context) : BaseAdapter<Corona>(R.layout.item_corona) {
    override fun onBind(binding: ViewDataBinding?, data: Corona) {
        val mBinding = binding as ItemCoronaBinding
//        Glide.with(context).load("https://www.masakapahariini.com/wp-content/uploads/2019/12/semur-kambing-giling-kacang-merah-400x240.jpg").into(mBinding.itemPoster)
    }

    override fun onClick(binding: ViewDataBinding?, data: Corona) {
        val intent = Intent(context, CoronaActivity::class.java)
        intent.putExtra(CoronaActivity.OPEN_CORONA, data)
        context.startActivity(intent)
    }

}