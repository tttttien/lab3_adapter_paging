package com.example.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Construct the data source
        val jsonArray = JSONArray("[{\"name\":\"Hung\",\"hometown\":\"Quan 7\"},{\"name\":\"Chau\",\"hometown\":\"An Nhon\"}]")
        val users = User.fromJson(jsonArray)

        // Create the adapter
        val adapter = UsersAdapter(this, users)

        // Attach the adapter to the ListView
        val listView = findViewById<ListView>(R.id.lvItems)
        listView.adapter = adapter
    }
}