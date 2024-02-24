package com.example.secondserving.ui.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.secondserving.R
import com.example.secondserving.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordDialog : DialogFragment() {
    private val viewModel: AuthViewModel by viewModels()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val view = layoutInflater.inflate(R.layout.dialog_forgot, null)
        val userEmail = view.findViewById<EditText>(R.id.editBox)

        builder.setView(view)
            .setPositiveButton("Reset",
                DialogInterface.OnClickListener { dialog, id ->
                    viewModel.compareEmail(userEmail.text.toString())

                })
            .setNegativeButton("Cancel",
                DialogInterface.OnClickListener { dialog, id ->
                    getDialog()?.cancel()
                })
        return builder.create()

    }
}