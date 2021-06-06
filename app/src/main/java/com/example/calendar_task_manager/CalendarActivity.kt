package com.example.calendar_task_manager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar_task_manager.databinding.ActivityCalendarBinding
import com.example.calendar_task_manager.databinding.ListItemViewBinding
import com.example.calendar_task_manager.storage.Storage
import com.example.calendar_task_manager.task.Task
import org.json.JSONArray
import java.util.*

class CalendarActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityCalendarBinding.inflate(layoutInflater)
    }
    private val storage by lazy {
        Storage(this)
    }
    private val taskList = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        putDummyTaskListToStorage()
        initTaskListFromStorage()
        initTaskRecyclerView()
    }

    private fun initTaskListFromStorage() {
        val taskListFromStorage = getTaskListFromStorage() ?: return
        taskList.addAll(taskListFromStorage)
    }

    private fun putDummyTaskListToStorage() {
        val taskList = mutableListOf<Task>()
        taskList.add(Task(0, "task 1", "", 0, 0))
        taskList.add(Task(1, "task 2", "", 0, 0))
        val taskListJsonArray = JSONArray()
        for (task in taskList) {
            taskListJsonArray.put(task.createJsonObject())
        }
        storage.saveString(taskListJsonArray.toString(), AppConstants.TASK_LIST_STRING_STORAGE_KEY)
    }

    private fun getTaskListFromStorage(): List<Task>? {
        val tasksJsonString =
            storage.getString(AppConstants.TASK_LIST_STRING_STORAGE_KEY) ?: return null
        val jsonArray = JSONArray(tasksJsonString)
        val taskList = mutableListOf<Task>()
        for (i in 0 until jsonArray.length()) {
            val taskJsonObject = jsonArray.getJSONObject(i)
            val task = Task.initFromJsonObject(taskJsonObject)
            taskList.add(task)
        }
        return taskList
    }

    private fun initTaskRecyclerView() {
        binding.taskList.layoutManager = LinearLayoutManager(this)
        binding.taskList.adapter = TaskAdapter(taskList)
    }

    class TaskAdapter(private var taskList: List<Task>) :
        RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
        override fun getItemCount() = taskList.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
            return TaskViewHolder(ListItemViewBinding.bind(itemView))
        }

        override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
            holder.setTaskName(taskList[position].name)
        }

        class TaskViewHolder(private val binding: ListItemViewBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun setTaskName(name: String) {
                binding.taskText.text = name
            }
        }
    }
}