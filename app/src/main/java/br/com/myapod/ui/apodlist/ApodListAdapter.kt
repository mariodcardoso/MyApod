package br.com.myapod.ui.apodlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.myapod.R
import br.com.myapod.source.remote.response.ApodResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ApodAdapter(
    private val context: Context,
    private val listApod: List<ApodResponse>,
    private val onApodListener: OnApodListener
) : RecyclerView.Adapter<ApodAdapter.ApodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_card_apod, parent, false)

        return ApodViewHolder(view, onApodListener)

    }

    override fun getItemCount() = listApod.size

    override fun onBindViewHolder(holder: ApodViewHolder, position: Int) {

        Glide.with(context)
            .load(listApod[position].url)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.imgApod)

        holder.txtApod.text = listApod[position].date

    }

    inner class ApodViewHolder(itemView: View, val onApodListener: OnApodListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        val imgApod: ImageView = itemView.findViewById(R.id.card_img_apod)
        val txtApod: TextView = itemView.findViewById(R.id.card_txt_date)

        override fun onClick(v: View?) {
            onApodListener.onApodClick(listApod[adapterPosition])
        }


    }

    interface OnApodListener{
        fun onApodClick(apodItem: ApodResponse)
    }




}
