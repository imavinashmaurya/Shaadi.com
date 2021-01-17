package com.avinash.shaadi.utility

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.avinash.shaadi.R
import kotlinx.android.synthetic.main.custom_alert_dialog.*


/**
 * Custom alert dialog
 */
class CustomAlertDialog(context: Context) : Dialog(context) {

    init {
        init()
    }

    /**
     * Call this method for dialog with title, des,
     */
    constructor(
        context: Context,
        title: String,
        desc: String,
        showBothAction: Boolean = true,
        alertDialogButtonClicked: AlertDialogButtonClicked?
    ) : this(context) {
        setData(title, desc, alertDialogButtonClicked)
        if (!showBothAction) {
            setupOnlyOneButton()
        }
    }

    /**
     * Call this method with only one button and title with listener
     */
    constructor(
        context: Context,
        title: String,
        showBothAction: Boolean = true,
        alertDialogButtonClicked: AlertDialogButtonClicked?
    ) : this(context) {
        setData(title, "", alertDialogButtonClicked)
        if (!showBothAction) {
            setupOnlyOneButton()
        }
    }

    private fun init() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        setContentView(R.layout.custom_alert_dialog)
        val window = this.window
        if (window != null) {
            window.setLayout(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    private fun setupOnlyOneButton() {
        btPositive2?.visibility = View.VISIBLE
        clButtons?.visibility = View.GONE
    }

    private fun setData(
        title: String,
        desc: String,
        alertDialogButtonClicked: AlertDialogButtonClicked?
    ) {
        tvTitle?.text = title
        tvDes?.text = desc
        if (title.isEmpty()) {
            tvTitle?.visibility = View.GONE
        }
        if (desc.isEmpty()) {
            tvDes?.visibility = View.GONE
        }

        btNegative.setOnClickListener(View.OnClickListener {
            dismiss()
            alertDialogButtonClicked?.buttonClicked(false)
        })
        btPositive.setOnClickListener(View.OnClickListener {
            dismiss()
            alertDialogButtonClicked?.buttonClicked(true)
        })
        btPositive2.setOnClickListener(View.OnClickListener {
            dismiss()
            alertDialogButtonClicked?.buttonClicked(true)
        })
        show()
    }

    fun changeBackgroundColor(backgroundColor: Int): CustomAlertDialog {
        cvRoot?.setCardBackgroundColor(ContextCompat.getColor(context, backgroundColor))
        return this
    }

    fun changeTitleColor(color: Int): CustomAlertDialog {
        tvTitle?.setTextColor(ContextCompat.getColor(context, color))
        return this
    }

    fun changeDesColor(color: Int): CustomAlertDialog {
        tvDes?.setTextColor(ContextCompat.getColor(context, color))
        return this
    }

    fun changeBothButtonName(positiveButton: String, negativeButton: String): CustomAlertDialog {
        btPositive?.text = positiveButton
        btNegative?.text = negativeButton
        return this
    }

    fun changeButtonName(positiveButton: String): CustomAlertDialog {
        btPositive2?.text = positiveButton
        return this
    }

    fun changeBothButtonColor(positiveColor: Int, negativeColor: Int): CustomAlertDialog {
        btPositive?.setTextColor(ContextCompat.getColor(context, positiveColor))
        btPositive2?.setTextColor(ContextCompat.getColor(context, positiveColor))
        btNegative?.setTextColor(ContextCompat.getColor(context, negativeColor))
        return this
    }

    fun changeButtonColor(positiveColor: Int): CustomAlertDialog {
        btPositive?.setTextColor(ContextCompat.getColor(context, positiveColor))
        btPositive2?.setTextColor(ContextCompat.getColor(context, positiveColor))
        return this
    }

    interface AlertDialogButtonClicked {
        fun buttonClicked(positive: Boolean)
    }

}