package messenger.mina.com.messenger.models

data class GroupModel(
    val name: String,
    val message: String,
    val time: String,
    val sender: Int,
    val isNew: Boolean,
    val isOnline: Boolean,
    val onlineTime: String,
    val isMute: Boolean,
    val isStory: Boolean,
    val image: Int,
    val image2:Int
)
