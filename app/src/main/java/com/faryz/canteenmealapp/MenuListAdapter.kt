package com.faryz.canteenmealapp

import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Executors

class MenuListAdapter(private val menuList: MutableList<ListMenu>) : RecyclerView.Adapter<MenuListAdapter.ViewHolder>() {
    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.foodTitle)
        val foodImage: ImageView = itemView.findViewById(R.id.foodImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_menu_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listMenu = menuList[position]
        holder.title.text = listMenu.title

        val handler = Handler(Looper.getMainLooper())
        val executor = Executors.newSingleThreadExecutor()

        executor.execute {

            try {
                val `in` = java.net.URL(listMenu.imgUrl).openStream()
                val img = BitmapFactory.decodeStream(`in`)

                handler.post{
                    holder.foodImage.setImageBitmap(img)
                }
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

}
