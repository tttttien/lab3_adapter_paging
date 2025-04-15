package com.example.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Construct the data source
        val arrayOfUsers = ArrayList<User>()

        // Populate the data
        arrayOfUsers.add(User("Hung", "Quan 7"))
        arrayOfUsers.add(User("Chau", "An Nhon"))
        arrayOfUsers.add(User("Mai", "Quan 8"))

        // Create the adapter
        val adapter = UsersAdapter(this, arrayOfUsers)

        // Attach the adapter to the ListView
        val listView = findViewById<ListView>(R.id.lvItems)
        listView.adapter = adapter
    }
}