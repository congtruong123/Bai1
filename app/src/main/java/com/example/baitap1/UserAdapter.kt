package com.example.baitap1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.fullNameTextView.text = currentUser.fullName
        holder.emailTextView.text = currentUser.email
        holder.phoneNumberTextView.text = currentUser.phoneNumber
        holder.genderTextView.text = currentUser.gender
    }

    override fun getItemCount() = userList.size

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fullNameTextView: TextView = itemView.findViewById(R.id.tvFullName)
        val emailTextView: TextView = itemView.findViewById(R.id.tvEmail)
        val phoneNumberTextView: TextView = itemView.findViewById(R.id.tvPhoneNumber)
        val genderTextView: TextView = itemView.findViewById(R.id.tvGender)
    }
}
