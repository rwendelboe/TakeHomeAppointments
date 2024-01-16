package com.example.myapplication.ui.providers

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentProvidersBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ProvidersFragment : Fragment() {

    private var _binding: FragmentProvidersBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val providersViewModel =
            ViewModelProvider(this)[ProvidersViewModel::class.java]

        _binding = FragmentProvidersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textProvidersTitle
        providersViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.selectDateButton.setOnClickListener {
            showDatePickerDialog()
        }

        binding.selectStartTimeButton.setOnClickListener {
            showTimePickerDialog(true)
        }

        binding.selectEndTimeButton.setOnClickListener {
            showTimePickerDialog(false)
        }

        binding.saveButton.setOnClickListener {
            save()
        }

        return root
    }

    private fun showDatePickerDialog() {
        // Get the current date
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a date picker dialog and set the current date as default
        val datePickerDialog = DatePickerDialog(
            requireContext(), { _: DatePicker, y: Int, m: Int, d: Int ->
                binding.textDate.setText(formatDate(y, m, d))
            },
            year, month, day
        )

        // Show the date picker dialog
        datePickerDialog.show()
    }

    private fun formatDate(year: Int, month: Int, day: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

    private fun showTimePickerDialog(isStartTime: Boolean) {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            requireContext(), { _: TimePicker, h: Int, m: Int ->
                if (isStartTime) {
                    binding.textStartTime.setText(formatTime(h, m))
                } else {
                    binding.textEndTime.setText(formatTime(h, m))
                }
            },
            hour, minute, false
        )

        timePickerDialog.show()
    }

    private fun formatTime(hour: Int, minute: Int): String {
        val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
        }
        return timeFormat.format(calendar.time)
    }

    private fun save(){
        // In real scenario we would send the data to our database but for simplicity sake we will just clear the data

        binding.textDate.setText("")
        binding.textStartTime.setText("")
        binding.textEndTime.setText("")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}