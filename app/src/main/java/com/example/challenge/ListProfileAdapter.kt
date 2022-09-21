package com.example.challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListProfileAdapter(private val listUser: ArrayList<User>) :
    RecyclerView.Adapter<ListProfileAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val ( username, name, company, photo, location, repository, following, followers) = listUser[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvUsername.text = username
        holder.tvCompany.text = company
        holder.tvLocation.text = location
        holder.tvRepository.text = repository
        holder.tvFollowing.text = following
        holder.tvFollowers.text = followers

    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_profile)
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvCompany : TextView = itemView.findViewById(R.id.tv_company)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_username)
        var tvLocation : TextView = itemView.findViewById(R.id.tv_location)
        var tvRepository : TextView = itemView.findViewById(R.id.tv_repository)
        var tvFollowing : TextView = itemView.findViewById(R.id.tv_following)
        var tvFollowers : TextView = itemView.findViewById(R.id.tv_followers)

    }


    }
