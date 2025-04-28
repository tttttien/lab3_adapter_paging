package com.example.adapter

import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONException

data class User(val name: String, val hometown: String) {

    // Secondary constructor to convert JSONObject into a User instance
    constructor(jsonObject: JSONObject) : this(
        name = try {
            jsonObject.getString("name")
        } catch (e: JSONException) {
            e.printStackTrace()
            "" // Default to empty string if "name" is not found
        },
        hometown = try {
            jsonObject.getString("hometown")
        } catch (e: JSONException) {
            e.printStackTrace()
            "" // Default to empty string if "hometown" is not found
        }
    )

    // Companion object for factory method
    companion object {
        // Factory method to convert JSONArray into a list of User objects
        fun fromJson(jsonArray: JSONArray): ArrayList<User> {
            val users = ArrayList<User>()
            for (i in 0 until jsonArray.length()) {
                try {
                    users.add(User(jsonArray.getJSONObject(i)))
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
            return users
        }
    }
}