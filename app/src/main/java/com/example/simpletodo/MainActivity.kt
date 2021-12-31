package com.example.simpletodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val listOfTasks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add button use detection
        //findViewById<Button>(R.id.button).setOnClickListener()
        listOfTasks.add("Do laundry")
        listOfTasks.add("Go for a walk")

        //Look upp recyclerView in layout
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //attach adapter to recyclerVieRecyclerVieww
        val adapter = TaskItemAdapter(listOfTasks)
        recyclerView.adapter = adapter
        //layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}