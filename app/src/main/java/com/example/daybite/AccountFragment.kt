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



//initializations
        user = FirebaseAuth.getInstance().currentUser!!
        database = FirebaseDatabase.getInstance()
        databaseFetch = FirebaseDatabase.getInstance().getReference("Users")
        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()

        getUserProfile()

        view.findViewById<Button>(R.id.cancelEditBTN).setOnClickListener {
            //get orignal information back
            getUserProfile()

            Toast.makeText(context,"No changes were saved",Toast.LENGTH_SHORT).show()
        }

        view. findViewById<ImageButton>(R.id.logoutBtn).setOnClickListener {
            //Sign user out of account
            Firebase.auth.signOut()

            //Switch back to Login screen
            val intent = Intent(this@AccountFragment.requireContext(),MainLoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(context, "LogOut Successful",Toast.LENGTH_SHORT).show()
        }

        bind.saveEditBTN.setOnClickListener {
            //find and edit
            val fName = bind.acctFname.text.toString()
            val lName = bind.acctLname.text.toString()
            val _email = bind.acctEmail.text.toString()
            val _pass = bind.acctPass.text.toString()

            val user = Firebase.auth.currentUser

            editUserProfile(fName,lName,_email,_pass)

            if (user != null) {

                Firebase.auth.updateCurrentUser(user)
                if(_email.isNotEmpty()){
                    user!!.updateEmail(_email)

                    if(_pass.isNotEmpty()){
                        if(_pass.length >= 6){

                            user!!.updatePassword(_pass)
                        }
                        else
                        {
                            Toast.makeText(context,"Password Must Be at Least 6 Characters",Toast.LENGTH_LONG).show()
                        }
                     }
                }
            }
        }

        view.findViewById<RadioButton>(R.id.deactivateBTN).setOnClickListener {
            deactivateUser()
        }
        return view
    }
    private fun editUserProfile(fName: String, lName: String, _email: String, _pass: String) {

        databaseFetch = FirebaseDatabase.getInstance().getReference("Users")
        val user = mapOf<String,String>(
            "firstName" to fName,
            "lastName" to lName,
            "userEmail" to _email,
            "userPassword" to _pass
        )
        databaseFetch.child(uid).updateChildren(user).addOnSuccessListener {
            Toast.makeText(context,"Successfully Updated!!",Toast.LENGTH_SHORT).show()

        }.addOnFailureListener {
            Toast.makeText(context,"Failed To Save",Toast.LENGTH_SHORT).show()
        }
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
                Toast.makeText(context,"Error Loading User Info",Toast.LENGTH_SHORT).show()
            }
        })
    }


    /*private fun profileCamera(){

        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{intent->
            activity?.packageManager?.let{
                intent.resolveActivity(it).also {

                }
            }
        }
    }*/


}