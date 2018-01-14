package org.gabriel.moviebudget.ui.search.items

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_search_result.view.*
import org.gabriel.moviebudget.R
import org.gabriel.moviebudget.model.tmdb.Result
import org.gabriel.moviebudget.ui.search.SearchContract

class SearchResultsAdapter(val imagesBaseUrl: String) : RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>() {

    private var items = listOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_result, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.movieId = item.id

        holder.title.text = item.title

        if (item.posterPath != null && item.posterPath.isNotBlank()) {
            Picasso.with(holder.itemView.context).load("$imagesBaseUrl/${item.posterPath}").into(holder.poster)
        } else {
            holder.poster.setImageBitmap(null)
        }
    }

    override fun getItemId(position: Int): Long {
        return items[position].id.toLong()
    }

    override fun getItemCount() = items.size

    fun replaceItems(newItems: List<Result>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var movieId: Int = 0
        val poster = itemView.result_poster
        val title = itemView.result_title

        init {
            itemView.setOnClickListener {
                (itemView.context as? SearchContract.View)?.apply {
                    navigateToDetails(movieId)
                }
            }
        }

    }

}