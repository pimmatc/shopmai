package com.egci428.a10565.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.egci428.project.Model.Menu
import com.egci428.project.R

class MenuAdapter(private val menuObject: MutableList<Menu>, private val listener: OnItemClickListener):RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return MenuViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return menuObject.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int)
    {
        holder.txtTitle.text = menuObject[position].title
        holder.txtPrice.text = menuObject[position].price.toString()
//        holder.imgView.setImageResource(menuObject[position].img1)
//        val Img = "R.drawable" + menuObject[position].img1
//        holder.imgView.setImage(Img)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    inner class MenuViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var txtTitle = itemView.findViewById<TextView>(R.id.itemTitle)
        var txtPrice = itemView.findViewById<TextView>(R.id.itemPrice)
        var imgView = itemView.findViewById<ImageView>(R.id.imgView)

        init {
            // Set the click listener for the entire item view
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }
            }
        }
    }
}

