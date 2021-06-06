package com.example.calendar_task_manager.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class Storage(context: Context) {
    private val sharedPreferencesKey = "storage"
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(sharedPreferencesKey, 0)

    fun saveString(string: String, key: String) {
        sharedPreferences.edit {
            putString(key, string)
        }
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }
}