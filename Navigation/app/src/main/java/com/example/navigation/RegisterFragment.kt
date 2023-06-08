package com.example.navigation

import android.os.Build.VERSION_CODES
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment(R.layout.fragment_register) {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(
            R.layout.fragment_register,
            container,
            false
        )    // just like setcontentview(R.Layout.Activity_main) but it links this file with the that fragment xml file


        val loginText: TextView = view.findViewById(R.id.regTxtView)
        loginText.setOnClickListener() {
            println("Worked")
            findNavController().navigate(R.id.action_registerFragment3_to_loginFragment)//
        }

        val homeText: TextView = view.findViewById(R.id.homeScreen)
        homeText.setOnClickListener() {
            println("Worked")
            findNavController().navigate(R.id.action_registerFragment3_to_homeScreen)//
        }




        return view
    }


}