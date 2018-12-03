package com.example.darki.rpgcreator.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arbys.rpgcharactersheetmaker.characterSheet.Skills
import com.arbys.rpgcharactersheetmaker.characterSheet.Stats
import com.example.darki.rpgcreator.R
import kotlinx.android.synthetic.main.fragment_stats.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [StatsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [StatsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class StatsFragment: Fragment() {
    // TODO: Rename and change types of parameters
    private var stats: Stats? = null
    private var skills: Skills? = null

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
            stats = it.getSerializable(ARG_PARAM1) as Stats
            skills = it.getSerializable(ARG_PARAM2) as Skills
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false).run {
            this.strength.setText(stats!!.strength.toString())
            this.skillSet1.text = "Athletics: ${skills!!._athletics}"
            this.dexterity.setText(stats!!.dexteity.toString())
            this.skillSet2.text = "Acrobatics: ${skills!!._acrobatic}\n" +
                    "Sleight of Hand: ${skills!!._sleightOfHand}\n" +
                    "Stealth: ${skills!!._stealth}"
            this.constitution.setText(stats!!.constitution.toString())
            this.intelligence.setText(stats!!.intelligence.toString())
            this.skillSet4.text = "Arcana: ${skills!!._arcana}\n" +
                    "History: ${skills!!._history}\n" +
                    "Investigation: ${skills!!._investigation}\n" +
                    "Nature: ${skills!!._nature}\n" +
                    "Religion: ${skills!!._religion}"
            this.wisdom.setText(stats!!.wisdom.toString())
            this.skillSet5.text = "Animal Handling: ${skills!!._animalHandling}\n" +
                    "Insight: ${skills!!._insight}\n" +
                    "Medicine: ${skills!!._medicine}\n" +
                    "Perception: ${skills!!._perception}\n" +
                    "Survival: ${skills!!._survival}"
            this.charisma.setText(stats!!.charisma.toString())
            this.skillSet6.text = "Deception: ${skills!!._deception}\n" +
                    "Intimidation: ${skills!!._intimidation}\n" +
                    "Performance: ${skills!!._performance}\n" +
                    "Persuasion: ${skills!!._persuasion}"

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
         * @return A new instance of fragment StatsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Stats, param2: Skills) =
            StatsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                    putSerializable(ARG_PARAM2, param2)
                }
            }
    }
}
