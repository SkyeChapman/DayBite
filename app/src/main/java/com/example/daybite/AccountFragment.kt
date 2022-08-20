package com.example.daybite

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.daybite.databinding.FragmentAccountBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.fragment_account.*


class AccountFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var user : FirebaseUser
    private lateinit var userProfile : UserProfile
    private lateinit var databaseFetch : DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var storageRef : StorageReference
    private lateinit var imageURI: Uri
    private lateinit var uid : String
    private lateinit var bind : FragmentAccountBinding
    private lateinit var et_Fname:EditText
    private lateinit var et_Lname:EditText
    private lateinit var et_Email:EditText
    private lateinit var et_Password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

       val view =  inflater.inflate(R.layout.fragment_account, container, false)
        bind = view?.let { FragmentAccountBinding.bind(it) }!!

        //find and edit

//initializations
        user = FirebaseAuth.getInstance().currentUser!!
        database = FirebaseDatabase.getInstance()
        databaseFetch = FirebaseDatabase.getInstance().getReference("Users")
        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()

        getUserProfile()

        view.findViewById<Button>(R.id.cancelEditBTN).setOnClickListener {

        }

        view. findViewById<ImageButton>(R.id.logoutBtn).setOnClickListener {
            //Sign user out of account
            Firebase.auth.signOut()

            //Switch back to Login screen
            val intent = Intent(this@AccountFragment.requireContext(),MainLoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(context, "LogOut Successful",Toast.LENGTH_SHORT).show()
        }

        view.findViewById<Button>(R.id.saveEditBTN).setOnClickListener {
            editUserProfile()
        }

        view.findViewById<RadioButton>(R.id.deactivateBTN).setOnClickListener {
            deactivateUser()
        }
        return view
    }
//disable account method
    private fun deactivateUser() {

    val user = Firebase.auth.currentUser!!
    user.delete()

                auth.currentUser?.let { database.getReference().child("Users").child(it.uid).setValue(null)
                    .addOnSuccessListener {
                        auth.currentUser!!.delete().addOnCompleteListener { task->


                            if (task.isSuccessful) {
                                Toast.makeText(context,"Account Deleted",Toast.LENGTH_SHORT).show()

                                //switch back to login screen
                                val intent = Intent(this@AccountFragment.requireContext(),MainLoginActivity::class.java)
                                startActivity(intent)
                            }
                            else{
                                Toast.makeText(context,"Deletion failed",Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }



    private fun uploadUserPic(){
        imageURI = Uri.parse("android.resource://${R.drawable.profile_pic}")
        storageRef = FirebaseStorage.getInstance().getReference("Users/"+auth.currentUser?.uid)
        storageRef.putFile(imageURI).addOnSuccessListener {
            Toast.makeText(context, "Profile Picture Updated!",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {

            Toast.makeText(context, "!Upload Failed!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun getUserProfile(){
        databaseFetch.child(uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                userProfile = snapshot.getValue(UserProfile::class.java)!!

                if(userProfile != null){
                    bind.acctFname.setText(userProfile.firstName)
                    bind.acctLname.setText(userProfile.lastName)
                    bind.acctEmail.setText(userProfile.userEmail)
                    bind.acctPass.setText(userProfile.userPassword)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun editUserProfile(){

        et_Fname = requireView().findViewById(R.id.acct_Fname)
        et_Lname = requireView().findViewById(R.id.acct_Lname)
        et_Email = requireView().findViewById(R.id.acct_Email)
        et_Password = requireView().findViewById(R.id.acct_Pass)

    }


}