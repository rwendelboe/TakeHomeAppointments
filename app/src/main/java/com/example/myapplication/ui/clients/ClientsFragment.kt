package com.example.myapplication.ui.clients

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentClientsBinding
import com.example.myapplication.ui.SlotData
import com.example.myapplication.ui.SlotsAdapter

class ClientsFragment : Fragment(), SlotsAdapter.OnItemClickListener {

    private var _binding: FragmentClientsBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var slotsAdapter: SlotsAdapter

    // Hard coded data for the sake of the example
    private val dataList = listOf(
        SlotData("January 3, 2024 from 08:00 AM to 08:15 AM"),
        SlotData("January 3, 2024 from 08:15 AM to 08:30 AM"),
        SlotData("January 17, 2024 from 09:00 AM to 09:15 AM"),
        SlotData("January 25, 2024 from 11:00 AM to 11:15 AM"),
        SlotData("January 29, 2024 from 07:45 AM to 08:00 AM"),
        SlotData("January 30, 2024 from 02:00 PM to 02:15 PM"),
        SlotData("February 4, 2024 from 10:00 AM to 10:15 AM"),
        SlotData("February 12, 2024 from 08:30 AM to 08:45 AM"),
        SlotData("February 21, 2024 from 10:00 AM to 10:15 AM"),
        SlotData("March 28, 2024 from 01:00 PM to 01:15 PM")
    )

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val clientsViewModel =
            ViewModelProvider(this)[ClientsViewModel::class.java]

        _binding = FragmentClientsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.title
        clientsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        recyclerView = binding.slotsRecyclerView
        slotsAdapter = SlotsAdapter(dataList, this)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = slotsAdapter

            // Add a default divider line between items
            val dividerItemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(data: SlotData) {
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setTitle("Confirmation")
        alertDialogBuilder.setMessage("Confirm your appointment for ${data.text}?")
        alertDialogBuilder.setPositiveButton("Confirm") { _, _ ->
            Toast.makeText(requireContext(), "Appointment confirmed for ${data.text}", Toast.LENGTH_SHORT).show()
        }
        alertDialogBuilder.setNegativeButton("Cancel") { _, _ ->
            Toast.makeText(requireContext(), "Appointment canceled", Toast.LENGTH_SHORT).show()
        }
        alertDialogBuilder.show()
    }
}