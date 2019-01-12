package messenger.mina.com.messenger.adapters

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_story.view.*
import messenger.mina.com.messenger.R
import messenger.mina.com.messenger.models.StoryModel

class StoriesAdapter : RecyclerView.Adapter<StoriesAdapter.ViewHolder>() {
    val stories: ArrayList<StoryModel> = ArrayList()

    init {
        stories.add(StoryModel("Your Story", false, false, true, false,R.drawable.user_4))
        stories.add(StoryModel("Your Story", false, false, false, true,R.drawable.user_2))
        stories.add(StoryModel("Mina", true, true, false, false,R.drawable.user_3))
        stories.add(StoryModel("Ayman", true, true, false, false,R.drawable.user_1))
        stories.add(StoryModel("Mai", true, true, false, false,R.drawable.user_2))
        stories.add(StoryModel("Ayman", false, false, false, false,R.drawable.user_4))
        stories.add(StoryModel("Mai", false, false, false, false,R.drawable.user_3))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false))
    }

    override fun getItemCount() = stories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stories[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val backgroundImage = view.cv_background!!
        private val image = view.cv_image!!
        private val onlineView = view.view_online!!
        private val title = view.tv_title!!
        private val context = view.context
        private val layoutParams = itemView.layoutParams

        fun bind(storyModel: StoryModel) {
            setTopBottomMargins()
            if (storyModel.isAddStory) {
                title.text = storyModel.name
                image.visibility = GONE
                onlineView.visibility = GONE
                backgroundImage.setImageResource(R.drawable.add__)
            } else if (storyModel.isYourStory) {
                title.text = storyModel.name
                onlineView.visibility = GONE
                image.setImageResource(R.drawable.food)
            } else {
                title.text = storyModel.name
                if (storyModel.isOnline)
                    onlineView.visibility = VISIBLE
                else
                    onlineView.visibility = GONE
                if (storyModel.isStory) {
                    backgroundImage.setImageResource(R.color.colorBlue)
                    title.setTypeface(null, Typeface.BOLD)
                    title.setTextColor(context.resources.getColor(R.color.colorBlack))
                }
                image.setImageResource(storyModel.image)
            }
        }

        private fun setTopBottomMargins() {
            when (adapterPosition) {
                0 -> {
                    val newParams = FrameLayout.LayoutParams(layoutParams.width, layoutParams.height)
                    newParams.setMargins(
                        context.resources.getDimensionPixelOffset(R.dimen.margin),
                        0,
                        0,
                        0
                    )
                    itemView.layoutParams = newParams
                }
                stories.size - 1 -> {
                    val newParams = FrameLayout.LayoutParams(layoutParams.width, layoutParams.height)
                    newParams.setMargins(
                        0,
                        0,
                        context.resources.getDimensionPixelOffset(R.dimen.margin),
                        0
                    )
                    itemView.layoutParams = newParams
                }
                else -> itemView.layoutParams = layoutParams
            }
        }

    }
}