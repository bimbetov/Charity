package bimbetov.com.example.charity.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import bimbetov.com.example.charity.R
import bimbetov.com.example.charity.databinding.DialogBinding

class MyDialogFragment : DialogFragment() {

    var sendAmount = 0;
    lateinit var binding: DialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;
            binding = DialogBinding.inflate(layoutInflater)

            builder.setView(inflater.inflate(R.layout.dialog, null))
                .setTitle("Для помощи введите сумму")
                .setPositiveButton("Отправить",
                    DialogInterface.OnClickListener { dialog, id ->
                        Log.i("Tag", binding.donationAmount.text.toString())
                        //sendAmount = binding.donationAmount.text.toString()

                        Toast.makeText(activity, "Отправлено", Toast.LENGTH_LONG).show()
                    })
                .setNegativeButton("Отмена",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}