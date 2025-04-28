package com.example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class UsersAdapter(context: Context, users: List<User>) :
    ArrayAdapter<User>(context, 0, users) {

    // ViewHolder class to cache view lookups
    private class ViewHolder {
        lateinit var name: TextView
        lateinit var home: TextView
        lateinit var button: Button
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get the data item for this position
        val user = getItem(position)

        // Check if an existing view is being reused, otherwise inflate the view
        val viewHolder: ViewHolder
        val view: View

        if (convertView == null) {
            // If there's no view to reuse, inflate a brand new view for the row
            viewHolder = ViewHolder()
            view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

            // Cache the view lookup inside the fresh view
            viewHolder.name = view.findViewById(R.id.tvName)
            viewHolder.home = view.findViewById(R.id.tvHome)
            viewHolder.button = view.findViewById(R.id.btButton)

            // Attach the click event handler to the button
            viewHolder.button.setOnClickListener {
                // Access user from the tag (set below)
                val clickedUser = it.tag as User
                Toast.makeText(context, "Clicked on ${clickedUser.name}", Toast.LENGTH_SHORT).show()
            }

            // Cache the ViewHolder object inside the view using setTag
            viewHolder.button.tag = user // Set the user as the tag for the button
            view.tag = viewHolder
        } else {
            // View is being recycled, retrieve the ViewHolder object from tag
            viewHolder = convertView.tag as ViewHolder
            view = convertView
            // Update the tag for the button since the user might have changed
            viewHolder.button.tag = user
        }

        // Populate the data from the data object via the ViewHolder object
        viewHolder.name.text = user?.name
        viewHolder.home.text = user?.hometown

        // Return the completed view to render on screen
        return view
    }
}