package com.example.galaxygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
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
    lateinit var auth : FirebaseAuth

    lateinit var savedMessages : messages


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)


        database = Firebase.firestore
        auth = Firebase.auth
        val user = auth.currentUser



        messageRecyclerView = findViewById(R.id.messageRecyclerView)
        messageRecyclerView.layoutManager = LinearLayoutManager(this)
        messageRecyclerView.setHasFixedSize(true)


        arrayListOfMessages = arrayListOf()













        // Snapshot of messages


        if (user != null) {

            database.collection("users").document(user.uid)
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





}