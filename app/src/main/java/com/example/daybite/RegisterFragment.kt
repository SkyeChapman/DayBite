package com.example.daybite

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.example.daybite.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.StorageReference

class RegisterFragment : Fragment() {

    private lateinit var fName: EditText
    private lateinit var lName: EditText
    private lateinit var regEmail: EditText
    private lateinit var regPass: EditText
    private lateinit var cfnPass: EditText
    private lateinit var regAge : EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseRef : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment - Switch Screens!
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        //Read/find Edit text from ID
        fName = view.findViewById(R.id.firstName)
        lName = view.findViewById(R.id.lastName)
        regEmail = view.findViewById(R.id.regEmail)
        regPass = view.findViewById(R.id.setPassword)
        regAge = view.findViewById(R.id.age)
        cfnPass = view.findViewById(R.id.confirmPass)

        //initialization
        auth = FirebaseAuth.getInstance()
        databaseRef = FirebaseDatabase.getInstance().reference



        //Button click listeners
        view.findViewById<Button>(R.id.nextBTN).setOnClickListener {
            emptyFormRegister()
        }

        view.findViewById<Button>(R.id.cancel_button).setOnClickListener {
            val intent = Intent(this@RegisterFragment.requireContext(),MainLoginActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    //check empty form
    private fun emptyFormRegister()
    {
        val warning = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_baseline_warning_24)
        warning?.setBounds(0,0,warning.intrinsicWidth, warning.intrinsicHeight)

        //Check if field is empty
        when {
            TextUtils.isEmpty(fName.text.toString().trim()) -> {
                fName.setError("Please enter First Name", warning)
            }
            TextUtils.isEmpty(lName.text.toString().trim()) -> {
                lName.setError("Please enter Last Name", warning)
            }
            TextUtils.isEmpty(regEmail.text.toString().trim()) -> {
                regEmail.setError("Please enter a valid email address", warning)
            }
            TextUtils.isEmpty(regPass.text.toString().trim()) -> {
                regPass.setError("Must enter password", warning)
            }
            TextUtils.isEmpty(cfnPass.text.toString().trim()) -> {
                cfnPass.setError("Must enter password", warning)
            }
            regEmail.text.toString().isNotEmpty()&&
                    regPass.text.toString().isNotEmpty()&&
                    cfnPass.text.toString().isNotEmpty()->
            {
                if(regEmail.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")))
                {
                    if(regPass.text.toString().length>=6)
                    {
                        if(regPass.text.toString() == cfnPass.text.toString())
                        {
                            val email: String = regEmail.text.toString().trim(){it <= ' '}
                            val password: String = regPass.text.toString().trim(){it <= ' '}

                            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {

                                        val firstName = fName.text.toString()
                                        val lastName = lName.text.toString()
                                        val _email = regEmail.text.toString()
                                        val _age = regAge.text.toString().toInt()
                                        val _password = regPass.text.toString()

                                        //get auth instance and initialize
                                        auth = FirebaseAuth.getInstance()
                                        val uid = auth.currentUser?.uid
                                        databaseRef = FirebaseDatabase.getInstance().getReference("Users")
                                        val userProfile = UserProfile(firstName,lastName,_email,_password,_age)
                                        if(uid != null )
                                        {

                                            databaseRef.child(uid).setValue(userProfile).addOnCompleteListener {
                                                if(it.isSuccessful){
                                                    val firbaseUser: FirebaseUser = task.result!!.user!!

                                                    //switch to next screen
                                                    val navReg = activity as Navigator
                                                    navReg.fragNavigation(RegInterestFragment(),false)
                                                }
                                                else{
                                                    Toast.makeText(context,"Error!!!",Toast.LENGTH_SHORT).show()
                                                }
                                            }
                                        }
                                    }
                                }
                        }
                        else
                        {
                            cfnPass.setError("Passwords do not match", warning)
                        }
                    }
                    else
                    {
                        regPass.setError("Must be at least 6 Character's",warning)
                    }
                }
                else
                {
                    regEmail.setError("Please enter a Valid email address", warning)
                }
            }
        }
    }
}