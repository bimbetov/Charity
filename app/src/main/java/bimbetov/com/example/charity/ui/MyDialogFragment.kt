package bimbetov.com.example.charity.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import bimbetov.com.example.charity.R

class MyDialogFragment : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;

            builder.setView(inflater.inflate(R.layout.dialog, null))
                .setTitle("Для помощи введите сумму")
                .setPositiveButton("Отправить",
                    DialogInterface.OnClickListener { dialog, id ->

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