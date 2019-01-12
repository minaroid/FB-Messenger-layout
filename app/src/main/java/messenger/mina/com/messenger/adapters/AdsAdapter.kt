package messenger.mina.com.messenger.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_ad.view.*
import messenger.mina.com.messenger.R
import messenger.mina.com.messenger.models.AdsModel

class AdsAdapter : RecyclerView.Adapter<AdsAdapter.ViewHolder>() {
    val ads: ArrayList<AdsModel> = ArrayList()

    init {
        ads.add(AdsModel("Restaureant 1", "http://www.villamambrini.com/public/blog/wp-content/uploads/2017/08/lemons.jpg"))
        ads.add(AdsModel("Restaureant 2", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkhTsJ3aOGedwPeI8Is389B2YTfOUrOuYZxyv_0D0XUsuZAYd4"))
        ads.add(AdsModel("Restaureant 3", "https://paolinocapri.com/wp-content/uploads/2017/01/Gusto_022.png"))

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false))
    }

    override fun getItemCount() = ads.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ads[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.im_image!!
        private val title = view.tv_name!!
        private val context = view.context
        private val layoutParams = itemView.layoutParams

        fun bind(adsModel: AdsModel) {
            setTopBottomMargins()
            title.text = adsModel.name
            Glide
                .with(context)
                .load(adsModel.image)
                .into(image)
        }

        private fun setTopBottomMargins() {
            when (adapterPosition) {
                0 -> {
                    val newParams = FrameLayout.LayoutParams(layoutParams.width, layoutParams.height)
                    newParams.setMargins(
                        context.resources.getDimensionPixelOffset(R.dimen.margin_extra),
                        0,
                        0,
                        0
                    )
                    itemView.layoutParams = newParams
                }
                else -> itemView.layoutParams = layoutParams
            }
        }

    }
}