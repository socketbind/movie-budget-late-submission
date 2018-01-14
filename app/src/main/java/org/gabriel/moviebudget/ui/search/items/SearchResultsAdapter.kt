package org.gabriel.moviebudget.ui.search.items

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_search_result.view.*
import org.gabriel.moviebudget.R
import org.gabriel.moviebudget.model.tmdb.Result

class SearchResultsAdapter : RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>() {

    private var items = listOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_result, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.title.text = item.title
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

        val poster = itemView.result_poster
        val title = itemView.result_title

    }

}