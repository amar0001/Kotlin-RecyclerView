package com.example.amarjitkaur.alarmsample


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater!!.inflate(R.layout.fragment_main, container, false) as View

        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView


        recyclerView.layoutManager = LinearLayoutManager(activity)//GridLayoutManager(activity, 2)
        recyclerView.adapter = MyAdapter(activity, getList(), listener ={

            println("${it.title} Clicked")
            val intent: Intent = Intent(context, ActionBarTabbs::class.java);
            intent.putExtra("data", "test")
   context.startActivity(intent)

        } )

        return  view;
    }

    private fun getList(): ArrayList<Item> {
        var list : ArrayList<Item> = ArrayList()
        for  (i in 1..10) { // equivalent of 1 <= i && i <= 10
            println(i)
            list.add(Item(1, "hello"+i, ""))
        }
        return list
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.

         * @param param1 Parameter 1.
         * *
         * @param param2 Parameter 2.
         * *
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
