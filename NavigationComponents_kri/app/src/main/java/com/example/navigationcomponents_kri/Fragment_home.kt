package com.example.navigationcomponents_kri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 */
class Fragment_home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_home,container,false)
        val rb : Button =v.findViewById(R.id.red)
        val bb: Button = v.findViewById(R.id.blue)
        val gb: Button = v.findViewById(R.id.green)
        rb.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_home_to_fragment_red)

        }
        bb.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_home_to_fragment_blue)

        }
        gb.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_home_to_fragment_green)
        }
        return v
    }

}
