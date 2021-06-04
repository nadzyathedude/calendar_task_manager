package com.example.calendar_task_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar_task_manager.databinding.ActivityTaskBinding
import org.json.JSONObject
import kotlin.concurrent.timerTask

class TaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskBinding
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding = ActivityTaskBinding.inflate(layoutInflater)
                setContentView(R.layout.activity_task)
               // binding.todayTaskList.adapter = CustomAdapter()
            }

    var jsonObject = JSONObject().put("name", "My First")
        .put("description", "My First Task")
        .put("id", 1)
        .put("date_start", 147600000)
        .put("date_finish", 147610000)
    val Name = jsonObject.getJSONObject("name")
    val Description = jsonObject.getJSONObject("description")
    val Id = jsonObject.getJSONObject("id")
    val Date_start = jsonObject.getJSONObject("date_start")
    val Date_finish = jsonObject.getJSONObject("date_finish")

    /*class CustomAdapter(): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
        val taskName = listOf<String>()
        val id = listOf<Int>()
        val date_start = listOf<Int>()
        val description =listOf<String>()
        val date_finish = listOf<Int>()



        override fun onCreateViewHolder( parent: ViewGroup,viewType: Int): CustomAdapter.MyViewHolder
        {
            val itemView =
                LayoutInflater.from(parent?.context).inflate(R.layout.activity_task, parent, false)

            return TaskActivity.CustomAdapter.ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: CustomAdapter.MyViewHolder, position: Int) {
            holder.taskName.setText(taskName[position])
            holder.id.setText(id)
            holder.date_start.setText(date_start)
            holder.date_finish.setText(date_finish)
        }

        class MyViewHolder (itemView : View){
            super(itemView)
            taskName = bin

        }

        override fun getItemCount(): Int {

        }


    }
*/
   }


