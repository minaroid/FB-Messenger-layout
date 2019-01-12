package messenger.mina.com.messenger.adapters

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.item_message_group.view.*
import messenger.mina.com.messenger.R
import messenger.mina.com.messenger.models.GroupModel
import messenger.mina.com.messenger.models.MessageModel

class GroupsMessagesAdapter : RecyclerView.Adapter<GroupsMessagesAdapter.ViewHolder>() {
    private val messages: ArrayList<GroupModel> = ArrayList()

    init {
        messages.add(GroupModel("My team", "Hi, mina", "10:35 PM", 2, true, true, "", false, false,R.drawable.user_3,R.drawable.user_1))
        messages.add(
            GroupModel(
                "Tech Team",
                "Hi, my best friend :)",
                "09:35 PM",
                1,
                false,
                false,
                "33m",
                true,
                true,
                R.drawable.user_1,
                R.drawable.user_3
            )
        )
        messages.add(
            GroupModel(
                "My Friends",
                "Hi, Mai how are you ???",
                "20:45 PM",
                2,
                true,
                false,
                "21m",
                true,
                false,
                R.drawable.user_2,
                R.drawable.user_3
            )
        )
        messages.add(
            GroupModel(
                "Team Work",
                "Hi, what about your dream yeasterday ? ",
                "12:35 PM",
                1,
                false,
                true,
                "",
                false, false,R.drawable.user_4,R.drawable.user_3
            )
        )
        messages.add(GroupModel("team 2", "Hi, mina", "10:35 PM", 2, false, true, "", false, true,R.drawable.user_2,R.drawable.user_3))
        messages.add(
            GroupModel(
                "My Team",
                "Hi, my best friend :)",
                "09:35 PM",
                1,
                false,
                false,
                "33m",
                true,
                false ,R.drawable.user_1,R.drawable.user_3
            )
        )
        messages.add(GroupModel("Team 1", "Hi, mina how are you ???", "Thu", 2, true, false, "21m", true, true,R.drawable.user_4,R.drawable.user_3))
        messages.add(
            GroupModel(
                "Team 3",
                "Hi, what about your dream yeasterday ? ",
                "07 Jan",
                1,
                false,
                true,
                "",
                false, false,R.drawable.user_2,R.drawable.user_3
            )
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_message_group, parent, false))
    }

    override fun getItemCount() = messages.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image1 = view.cv_image_1
        private val image2 = view.cv_image_2
        private val name = view.tv_name
        private val messege = view.tv_message
        private val mute = view.im_mute
        private val newIndicator = view.view_new
        private val online = view.view_online
        private val time = view.view_time
        private val messegeTime = view.tv_time
        private val context = view.context

        fun bind(messageModel: GroupModel) {
            image1.setImageResource(messageModel.image)
            image2.setImageResource(messageModel.image2)
            name.text = messageModel.name
            messegeTime.text = ". ${messageModel.time}"
            if (messageModel.sender == 1)
                if (messageModel.message.length > 15)
                    messege.text = "You: ${messageModel.message.substring(0, 15)}"
                else
                    messege.text = "You: ${messageModel.message}"
            else
                if (messageModel.message.length > 15)
                    messege.text = "${messageModel.message.substring(0, 15)}"
                else
                    messege.text = "${messageModel.message}"
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

            if (messageModel.isNew) {
                newIndicator.visibility = View.VISIBLE
                name.setTypeface(null, Typeface.BOLD)
                messege.setTypeface(null, Typeface.BOLD)
                messege.setTextColor(context.resources.getColor(R.color.colorBlack))
            } else {
                newIndicator.visibility = View.GONE
            }
        }

    }
}