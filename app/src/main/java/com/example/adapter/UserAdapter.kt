package com.example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class UsersAdapter(context: Context, users: List<User>) :
    ArrayAdapter<User>(context, 0, users) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get the user object for this position
        val user = getItem(position)

        // Inflate the layout if convertView is null, otherwise reuse it
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

        // Find the TextView in the layout
        val tvUserInfo = view.findViewById<TextView>(R.id.tvUserInfo)

        // Populate the TextView with the user's name and hometown
        tvUserInfo.text = "${user?.name} from ${user?.hometown}"

        // Return the completed view
        return view
    }
}