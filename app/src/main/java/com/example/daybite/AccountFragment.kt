package com.example.daybite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference


class AccountFragment : Fragment() {
    private lateinit var etfName: EditText
    private lateinit var etlName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseFetch : DatabaseReference
    private lateinit var storageRef : StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_account, container, false)

        //etfName = view.findViewById(R.id.firstName)
       // etlName = view.findViewById(R.id.lastName)
       // etEmail = view.findViewById(R.id.regEmail)
       // etPass = view.findViewById(R.id.setPassword)


        auth = FirebaseAuth.getInstance()

        view. findViewById<ImageButton>(R.id.logoutBtn).setOnClickListener {
            //Sign user out of account
            Firebase.auth.signOut()

            //Switch back to Login screen
            val intent = Intent(this@AccountFragment.requireContext(),MainLoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(context, "LogOut Successful",Toast.LENGTH_SHORT).show()
        }

        view.findViewById<Button>(R.id.saveEdit).setOnClickListener {

            /*val firstName = etfName.text.toString()
            val lastName = etlName.text.toString()
            val _email = etEmail.text.toString()
            val _password = etPass.text.toString()
            databaseFetch = FirebaseDatabase.getInstance().getReference("Users")
            val user = UserProfile(firstName,lastName,_email,_password)
            databaseFetch.child(firstName).setValue(user).addOnCompleteListener {

                Toast.makeText(context,"Register Successful", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {

                Toast.makeText(context,"Failed Registration", Toast.LENGTH_SHORT).show()
            }*/
        }
        return view
    }
}