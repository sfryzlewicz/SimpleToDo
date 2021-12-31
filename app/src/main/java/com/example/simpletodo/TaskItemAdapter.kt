package com.example.simpletodo

import androidx.recyclerview.widget.RecyclerView
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RemoteViews
import android.widget.TextView


//a bridge for displaying instructions on the recycleview class

class TaskItemAdapter(val listOfItems: List<String>): RecyclerView.Adapter<TaskItemAdapter.ViewHolder>()
{

    //Provide a direct reference to each of the views within a data item
    //used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //store refrence to elements in our layout view
        val textView: TextView
        init {
            textView = itemView.findViewById(android.R.id.text1)
        }
    }

    //inflate a layout from XML and return holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        //inflate custom layout
        val contactView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        //return a new holder instance
        return ViewHolder(contactView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        //val contact: Contact = listOfItems.get(position)
        // Set item views based on your views and data model
        //val textView = viewHolder.nameTextView
        //textView.setText(contact.name)
        //val button = viewHolder.messageButton
        //button.text = if (contact.isOnline) "Message" else "Offline"
        //button.isEnabled = contact.isOnline
        val item = listOfItems.get(position)
        holder.textView.text = item
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }
}







