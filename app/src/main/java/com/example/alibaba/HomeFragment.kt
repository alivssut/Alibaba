package com.example.alibaba

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class HomeFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        var  registerFragment = RegisterFragment()

        val fragmentManager: FragmentManager = getFragmentManager()!!
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home_register_container, registerFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()


        return root
    }
}