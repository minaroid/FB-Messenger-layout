package messenger.mina.com.messenger.adapters

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chauthai.swipereveallayout.ViewBinderHelper
import kotlinx.android.synthetic.main.item_message.view.*
import messenger.mina.com.messenger.R
import messenger.mina.com.messenger.models.MessageModel

class MessagesAdapter : RecyclerView.Adapter<MessagesAdapter.ViewHolder>() {
    private val messages: ArrayList<MessageModel> = ArrayList()
    private val viewBinderHelper = ViewBinderHelper()

    init {
        viewBinderHelper.setOpenOnlyOne(true)

        messages.add(
            MessageModel(
                "Mina George",
                "Hi, minaaaaa....",
                "10:35 PM",
                2,
                true,
                true,
                "",
                false,
                false,
                R.drawable.user_3
            )
        )
        messages.add(
            MessageModel(
                "Ayman Maged",
                "Hi, my best friend :)...?",
                "09:35 PM",
                1,
                false,
                false,
                "33m",
                true,
                true,
                R.drawable.user_2
            )
        )
        messages.add(
            MessageModel(
                "Mai George",
                "Hi, Mai how are you ?????.",
                "20:45 PM",
                2,
                true,
                false,
                "21m",
                true,
                false,
                R.drawable.user_2
            )
        )
        messages.add(
            MessageModel(
                "Mina George",
                "Hi, what about your dream yeasterday ?..... ",
                "12:35 PM",
                1,
                false,
                true,
                "",
                false, false, R.drawable.user_4
            )
        )
        messages.add(
            MessageModel(
                "Mona Sameh",
                "Hi, mina....",
                "10:35 PM",
                2,
                false,
                true,
                "",
                false,
                true,
                R.drawable.user_2
            )
        )
        messages.add(
            MessageModel(
                "Ayman Maged",
                "Hi, my best friend :)...?",
                "09:35 PM",
                1,
                false,
                false,
                "33m",
                true,
                false, R.drawable.user_2
            )
        )
        messages.add(
            MessageModel(
                "Mai George",
                "Hi, mina how are you ???....",
                "Thu",
                2,
                true,
                false,
                "21m",
                true,
                true,
                R.drawable.user_4
            )
        )
        messages.add(
            MessageModel(
                "Mina George",
                "Hi, what about your dream yeasterday ?......... ",
                "07 Jan",
                1,
                false,
                true,
                "",
                false, false, R.drawable.user_2
            )
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false))
    }

    override fun getItemCount() = messages.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.cv_image
        private val name = view.tv_name
        private val message = view.tv_message
        private val mute = view.im_mute
        private val newIndicator = view.view_new
        private val online = view.view_online
        private val time = view.view_time
        private val messageTime = view.tv_time
        private val context = view.context
        private val swipeRevealLayout = view.swipeRevealLayout

        fun bind(messageModel: MessageModel) {
            // ToDO up must add the second param as unique id
            viewBinderHelper.bind(swipeRevealLayout, messageModel.message)
            image.setImageResource(messageModel.image)
            name.text = messageModel.name
            messageTime.text = ". ${messageModel.time}"
            when {
                messageModel.sender == 1 -> message.text = "You: ${messageModel.message}"
                else -> message.text = "${messageModel.message}"
            }
            if (messageModel.isNew)
                newIndicator.visibility = View.VISIBLE
            else
                newIndicator.visibility = View.GONE
            if (messageModel.isMute)
                mute.visibility = View.VISIBLE
            else
                mute.visibility = View.GONE
            if (messageModel.isOnline) {
                online.visibility = View.VISIBLE
                time.visibility = View.GONE
            } else {
                online.visibility = View.GONE
                time.visibility = View.VISIBLE
                time.text = messageModel.onlineTime
            }
            if (messageModel.isStory) {
                image.isActivated = true
            }
            if (messageModel.isNew) {
                newIndicator.visibility = View.VISIBLE
                name.setTypeface(null, Typeface.BOLD)
                message.setTypeface(null, Typeface.BOLD)
                message.setTextColor(context.resources.getColor(R.color.ColorText))
            } else {
                newIndicator.visibility = View.GONE
            }
        }

    }
}