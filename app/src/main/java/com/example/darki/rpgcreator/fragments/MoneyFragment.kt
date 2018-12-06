package com.example.darki.rpgcreator.fragments

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arbys.rpgcharactersheetmaker.characterSheet.Money
import com.example.darki.rpgcreator.ListAdapter
import com.example.darki.rpgcreator.R
import kotlinx.android.synthetic.main.fragment_money.view.*

private const val ARG_PARAM1 = "param1"


class MoneyFragment : Fragment() {
    private var money: Money? = null
    private var headers: List<String>? = null
    private var valueList: HashMap<String, List<String>>? = null

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            money = it.getSerializable(ARG_PARAM1) as Money
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_money, container, false).run {
            coins.setText("${money!!.coins}gp")
            prepareList()
            val adapter =
                ListAdapter(this@MoneyFragment.context!!, headers!!, valueList!!)
            valuable_list.setAdapter(adapter)
            this
        }
    }

    fun prepareList() {
        headers = ArrayList()
        valueList = HashMap()

        for (x in money!!.valuables.asIterable()) {
            println("${x.key}: ${x.value}")
            (headers as ArrayList<String>) += x.key
            valueList!![x.key] = x.value.toList()
        }
        println(headers)
        println(valueList)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MoneyFragment.OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MoneyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Money) =
            MoneyFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }


}
