package com.example.galaxygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class MessagesActivity : AppCompatActivity() {




    private lateinit var messageRecyclerView: RecyclerView
    private lateinit var arrayListOfMessages : ArrayList<messages>



    var isThereNewMessage : Boolean = false



    lateinit var database : FirebaseFirestore

    lateinit var savedMessages : messages


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)


        database = Firebase.firestore



        messageRecyclerView = findViewById(R.id.messageRecyclerView)
        messageRecyclerView.layoutManager = LinearLayoutManager(this)
        messageRecyclerView.setHasFixedSize(true)


        arrayListOfMessages = arrayListOf()













        // Snapshot of messages


        database.collection("users").document("User path")
            .collection("Messages").orderBy("docNumber", Query.Direction.DESCENDING)

            .addSnapshotListener { snapshot, e ->
                if (snapshot != null) {
                    for (document in snapshot.documents) {

                        savedMessages = document.toObject()!!



                        arrayListOfMessages.add(savedMessages)

                        messageRecyclerView.adapter = MyAdapter(arrayListOfMessages)











                    }
                }
            }












    }





}