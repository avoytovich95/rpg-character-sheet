package com.example.darki.rpgcreator.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arbys.rpgcharactersheetmaker.characterSheet.CharacterSheet
import com.example.darki.rpgcreator.R
import kotlinx.android.synthetic.main.fragment_character.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CharacterFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CharacterFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CharacterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var cs: CharacterSheet? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cs = it.getSerializable(ARG_PARAM1) as CharacterSheet
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false).run {
            char_name.text = "Name: ${cs!!.characterName}"
            race.text = "Race: ${cs!!.race}"
            cha_class.text = "Class: ${cs!!.characterClass}"

            lvl.text = "Level: ${cs!!.level}"
            backg.text = "Background: ${cs!!.characterBackground}"
            aline.text = "Alignment: ${cs!!.allignment}"

            xp.text = "XP: ${cs!!.experiace}"
            xpNxt.text = "XP Left: ${cs!!.epxerianceNeeded}"
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
         * @return A new instance of fragment CharacterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: CharacterSheet) =
            CharacterFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}
