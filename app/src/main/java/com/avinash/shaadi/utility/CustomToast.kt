package com.avinash.shaadi.utility

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.avinash.shaadi.R


class CustomToast() {

    private var mToast: Toast? = null
    private var mContext: Context? = null

    fun setupToastWithImage(context: Context, imageId: Int, message: String): CustomToast {
        context.let { itContext ->
            mContext = itContext
            val inflater =
                itContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.let { itInflater ->
                val view: View =
                    itInflater.inflate(R.layout.custom_toast, null)
                view.let { itView ->
                    mToast = Toast(context)
                    val ivIcon = itView.findViewById<ImageView>(R.id.ivIcon)
                    val tvMessage = itView.findViewById<TextView>(R.id.tvMessage)
                    ivIcon.setImageResource(imageId)
                    tvMessage.text = message
                    mToast?.view = itView
                    show()
                }
            }
        }
        return this
    }

    fun setupShortToast(context: Context, message: String){
        context.let { itContext ->
            mContext = itContext
            Toast.makeText(itContext, message, Toast.LENGTH_SHORT).show()
        }
    }

    fun setupLongToast(context: Context, message: String){
        context.let { itContext ->
            mContext = itContext
            Toast.makeText(itContext, message, Toast.LENGTH_LONG).show()
        }
    }

    fun setupCustomToast(context: Context, message: String): CustomToast {
        context.let { itContext ->
            mContext = itContext
            val inflater =
                itContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.let { itInflater ->
                val view: View =
                    itInflater.inflate(R.layout.custom_toast, null)
                view.let { itView ->
                    mToast = Toast(context)
                    val ivIcon = itView.findViewById<ImageView>(R.id.ivIcon)
                    val tvMessage = itView.findViewById<TextView>(R.id.tvMessage)
                    ivIcon.visibility = View.GONE
                    tvMessage.text = message
                    mToast?.view = itView
                    setRoundedCorner()
                    setBackgroundColor(R.color.toastBackground)
                    show()
                }
            }
        }
        return this
    }


    fun setupErrorToast(context: Context, message: String): CustomToast {
        this.setupToastWithImage(context, R.drawable.ic_exclamation, message)
        this.setGravity(Gravity.BOTTOM)
        this.setBackgroundColor(R.color.toastBackgroundBlack)
        this.setTextColor(R.color.white)
        this.setLongDuration()
        this.setRoundedCorner()
        this.show()
        return this
    }

    private fun show(): CustomToast {
        mToast?.show()
        return this
    }

    fun setShortDuration(): CustomToast {
        mToast?.duration = Toast.LENGTH_SHORT
        return this
    }

    fun setLongDuration(): CustomToast {
        mToast?.duration = Toast.LENGTH_LONG
        return this
    }

    fun setRoundedCorner(): CustomToast {
        val view = mToast?.view
        val background = view?.findViewById<CardView>(R.id.cvRoot)
        background?.radius = 20f
        return this
    }

    fun setBackgroundColor(color: Int): CustomToast {
        val view = mToast?.view
        val background = view?.findViewById<CardView>(R.id.cvRoot)
        mContext?.let { itContext ->
            background?.setCardBackgroundColor(ContextCompat.getColor(itContext, color))
        }
        return this
    }

    fun setTextColor(color: Int): CustomToast {
        val view = mToast?.view
        val tvMessage = view?.findViewById<TextView>(R.id.tvMessage)
        mContext?.let { itContext ->
            tvMessage?.setTextColor(
                ContextCompat.getColor(itContext, color)
            )
        }
        return this
    }

    /**
     * Set the location at which the notification should appear on the screen.
     * @see android.view.Gravity
     * @see #getGravity
     */
    fun setGravity(gravity: Int): CustomToast {
        mToast?.setGravity(gravity, 0, 0)
        return this
    }
}