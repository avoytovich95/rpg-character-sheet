package com.example.darki.rpgcreator.fragments

import android.content.ClipData
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.arbys.rpgcharactersheetmaker.characterSheet.CharacterSheet
import com.arbys.rpgcharactersheetmaker.characterSheet.Item
import com.example.darki.rpgcreator.R
import kotlinx.android.synthetic.main.activity_character_sheet.*
import kotlinx.android.synthetic.main.app_bar_character_sheet.*
import kotlinx.android.synthetic.main.fragment_inventory.view.*
import kotlinx.android.synthetic.main.nav_header_character_sheet.view.*
import kotlinx.android.synthetic.main.list_item.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [InventoryFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [InventoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class InventoryFragment : Fragment() {
    private var items: ArrayList<Item>? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            items = it.getSerializable(ARG_PARAM1) as ArrayList<Item>
        }

        //items.add()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventory, container, false).run {
            val adapter = ArrayAdapter<Item>(this@InventoryFragment.context!!, android.R.layout.simple_spinner_item, items!!.toMutableList())
            sp0!!.adapter = adapter
            sp1!!.adapter = adapter
            sp2!!.adapter = adapter
            this
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
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
         * @return A new instance of fragment InventoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: ArrayList<Item>) =
            InventoryFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}
