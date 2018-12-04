package com.example.darki.rpgcreator.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arbys.rpgcharactersheetmaker.characterSheet.Spell
import com.example.darki.rpgcreator.ListAdapter
import com.example.darki.rpgcreator.R
import kotlinx.android.synthetic.main.fragment_spells.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SPellsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SPellsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SPellsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var spells: ArrayList<Spell>? = null
    private var headers: List<String>? = null
    private var spellList: HashMap<String, List<String>>? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            spells = it.getSerializable(ARG_PARAM1) as ArrayList<Spell>
        }
        println(spells)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spells, container, false).run {
            prepareList()
//            println(headers)
//            println(spellList)
            val adapter =
                ListAdapter(this@SPellsFragment.context!!, headers!!, spellList!!)
            spells_list.setAdapter(adapter)
            this
        }
    }

    fun prepareList() {
        headers = ArrayList()
        spellList = HashMap()

        spells!!.forEach { spell ->
//            println(spell)
            (headers as ArrayList<String>) += spell.spellName
            spellList!![spell.spellName] = spell.getAttributesList()
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
         * @return A new instance of fragment SPellsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: ArrayList<Spell>) =
            SPellsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}
