package com.example.alibaba.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.alibaba.R
import com.example.alibaba.databinding.FragmentAccountBinding

class AccountFragment (val toolbar: androidx.appcompat.widget.Toolbar , val title : TextView): Fragment(){
    private lateinit var binding: FragmentAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(layoutInflater)
        toolbar.setBackgroundResource(R.color.toolbarWhite)
        title.setText(R.string.accountTitle)

        var registerFragment = RegisterFragment()
        val fragmentManager: FragmentManager = getFragmentManager()!!
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.account_register_container, registerFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

        binding.accountAirportInfo.setOnClickListener {
            val intent = Intent(activity!!.baseContext, CitiesActivity::class.java)
            intent.putExtra("state", "origin")
            intent.putExtra("type", "airport")
            startActivity(intent)
        }


        return binding.root
    }

}