package com.example.calendar_task_manager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar_task_manager.databinding.ActivityCalendarBinding
import com.example.calendar_task_manager.databinding.ListItemViewBinding

class CalendarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalendarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.taskList.layoutManager = LinearLayoutManager(this)
        binding.taskList.adapter = Adapter(generateFakeValues())
    }

    private  fun generateFakeValues(): List<String>{
        val values = mutableListOf<String>()
        for(i in 1 .. 4){
            values.add("$i task ")
        }
        return values
    }

    class Adapter(private val values: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {


        override fun getItemCount() = values.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView =
                LayoutInflater.from(parent?.context).inflate(R.layout.list_item_view, parent, false)

            return ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView?.text = values[position]
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var textView: TextView? = null

            init {
                textView = itemView.findViewById(R.id.taskText)
            }
        }
    }
}
