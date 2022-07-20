package com.solulab.example.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.solulab.example.adapter.CoinRecyclerViewAdapter
import com.solulab.example.databinding.FragmentHomeBinding
import com.solulab.example.model.Item

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recycler: RecyclerView = binding.recycler
        recycler.layoutManager = GridLayoutManager(this.context!!,3)
        //var adapter = CoinRecyclerViewAdapter(this.context!!, ArrayList())

        homeViewModel.getReponse()
        homeViewModel.coinResponse.observe(viewLifecycleOwner){
            Log.e("response",it.body().toString())

                if(it!=null) {
                    Log.e("response-m",it.body()!!.data.list.size.toString())
                    var adapter = CoinRecyclerViewAdapter(this.context!!,
                        it.body()!!.data.list.filter { item -> item.pictures!=null } as ArrayList<Item>
                    )
                    recycler.adapter = adapter
                    adapter.notifyDataSetChanged()
                }else
            Toast.makeText(context!!, "No Response", Toast.LENGTH_SHORT).show()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}