package com.season.winter.firestore

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FireStoreConnectTest {

    fun test() {

        val db = Firebase.firestore

        val user = hashMapOf(
            "first_first" to "Ada_Ada",
            "last_last" to "Lovelace_Lovelace",
            "born_born" to 1815,
        )

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("TAG", "Error adding document", e)
            }
    }

}