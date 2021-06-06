package com.example.calendar_task_manager.task

import org.json.JSONObject

data class Task(
    var id: Int,
    var name: String,
    var description: String,
    var date_start: Long,
    var date_finish: Long,
) {
    companion object {
        private const val ID_JSON_KEY = "id"
        private const val NAME_JSON_KEY = "name"
        private const val DESCRIPTION_JSON_KEY = "description"
        private const val DATE_START_JSON_KEY = "date_start"
        private const val DATE_FINISH_JSON_KEY = "date_finish"

        fun initFromJsonObject(taskJsonObject: JSONObject): Task {
            val id = taskJsonObject.getInt(ID_JSON_KEY)
            val name = taskJsonObject.getString(NAME_JSON_KEY)
            val description = taskJsonObject.getString(DESCRIPTION_JSON_KEY)
            val date_start = taskJsonObject.getLong(DATE_START_JSON_KEY)
            val date_finish = taskJsonObject.getLong(DATE_FINISH_JSON_KEY)
            val task = Task(id, name, description, date_start, date_finish)
            return task
        }
    }

    fun createJsonObject(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put(ID_JSON_KEY, id)
        jsonObject.put(NAME_JSON_KEY, name)
        jsonObject.put(DESCRIPTION_JSON_KEY, description)
        jsonObject.put(DATE_START_JSON_KEY, date_start)
        jsonObject.put(DATE_FINISH_JSON_KEY, date_finish)
        return jsonObject
    }
}