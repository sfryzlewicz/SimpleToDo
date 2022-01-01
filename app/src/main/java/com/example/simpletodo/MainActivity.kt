package com.example.simpletodo
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {

    var listOfTasks = mutableListOf<String>()
    lateinit var adapter: TaskItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onLongClickListener = object : TaskItemAdapter.OnLongClickListener{
            override fun onItemLongClicked(position: Int) {
                //remove item from list
                listOfTasks.removeAt(position)
                //Notify adapter of change
                adapter.notifyDataSetChanged()

                saveItems()
            }
        }

        //add button use detection
        //findViewById<Button>(R.id.button).setOnClickListener()

        loadItems()

        //Look up recyclerView in layout and attach adapter to recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = TaskItemAdapter(listOfTasks, onLongClickListener)

        val inputTextField = findViewById<EditText>(R.id.addTaskField)

        recyclerView.adapter = adapter
        //layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        //set up button and input field
        findViewById<Button>(R.id.button).setOnClickListener{
            //Grab inputted text
            val userInputtedTask = inputTextField.text.toString()

            //Add string to listOfTasks and notify adapter
            listOfTasks.add(userInputtedTask)
            adapter.notifyItemInserted(listOfTasks.size-1)

            //Reset text field
            inputTextField.setText("")

            saveItems()
        }
    }
    //Save data that user inputted
    //Save data by writing and reading from a file

    //Get the file we need
    fun getDataFile() : File {
        //every line is going to represent a specific task
        return File(filesDir, "data.txt")
    }

    //Create the items by reading every line in the data file
    fun loadItems(){
        try {
            listOfTasks = FileUtils.readLines(getDataFile(), Charset.defaultCharset())
        } catch(ioException: IOException){
            ioException.printStackTrace()
        }

    }

    //Save items by writing them into our data file
    fun saveItems(){
        try {
            FileUtils.writeLines(getDataFile(), listOfTasks)
        } catch (ioException: IOException){
            ioException.printStackTrace()
        }
    }
}