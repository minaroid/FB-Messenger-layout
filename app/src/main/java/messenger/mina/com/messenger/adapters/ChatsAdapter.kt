package messenger.mina.com.messenger.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.item_ads_recycler.view.*
import kotlinx.android.synthetic.main.item_inbox_recycler.view.*
import kotlinx.android.synthetic.main.item_stories_recycler.view.*
import messenger.mina.com.messenger.R
import messenger.mina.com.messenger.models.Constants

class ChatsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: IntArray = IntArray(5)

    init {
        items[0] = Constants.SEARCH_TYPE
        items[1] = Constants.STORIES_TYPE
        items[2] = Constants.INBOX_TYPE
        items[3] = Constants.ADS_TYPE
        items[4] = Constants.GROUPS_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            Constants.SEARCH_TYPE -> return SearchViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_search,
                    parent,
                    false
                )
            )
            Constants.STORIES_TYPE -> return StoriesViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_stories_recycler,
                    parent,
                    false
                )
            )
            Constants.INBOX_TYPE -> return InboxViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_inbox_recycler,
                    parent,
                    false
                )
            )
            Constants.GROUPS_TYPE -> return GroupsViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_inbox_recycler,
                    parent,
                    false
                )
            )
            Constants.ADS_TYPE -> return AdsViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_ads_recycler,
                    parent,
                    false
                )
            )
            else -> return StoriesViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_search,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StoriesViewHolder) {
            holder.bind()
        }
        if (holder is InboxViewHolder) {
            holder.bind()
        }
        if (holder is GroupsViewHolder) {
            holder.bind()
        }
        if (holder is AdsViewHolder) {
            holder.bind()
        }
    }

    override fun getItemViewType(position: Int) = items[position]

    inner class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view)

    inner class InboxViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val inboxRecycler = view.rv_inbox!!
        fun bind() {
            inboxRecycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            inboxRecycler.adapter = MessagesAdapter()
        }
    }

    inner class GroupsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val inboxRecycler = view.rv_inbox!!
        fun bind() {
            inboxRecycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            inboxRecycler.adapter = GroupsMessagesAdapter()
        }
    }

    inner class AdsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.tv_name
        private val image = view.cv_image
        private val sponsoer = view.tv_sponsoer
        private val description = view.tv_description
        private val previewRecycler = view.rv_ads!!
        fun bind() {
            name.text = "Takeaway foods"
            sponsoer.text = "Sponsored"
            description.text = "Browse Through Hundered's of Restaurants Online. Order Food Online via Otlob! Online Payment. Best Delivery Service"
            image.setImageResource(R.drawable.food)
            previewRecycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
            previewRecycler.adapter = AdsAdapter()
        }
    }

    inner class StoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val storiesRecycler = view.rv_stories!!
        fun bind() {
            storiesRecycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
            storiesRecycler.adapter = StoriesAdapter()
        }
    }

}