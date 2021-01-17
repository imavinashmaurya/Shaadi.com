package com.avinash.shaadi.ui

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.avinash.shaadi.R
import com.avinash.shaadi.data.model.UserResult
import com.avinash.shaadi.utility.Constant
import com.avinash.shaadi.utility.genericRecyclerview.KRecyclerViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_user.view.*

interface ActionListener {
    fun acceptDecline(userResult: UserResult, position: Int)
}

class UserHolder(itemView: View, private val actionListener: ActionListener?) :
    KRecyclerViewHolder(itemView) {

    override fun setData(context: Context, itemObject: Any) {
        super.setData(context, itemObject)
        if (itemObject is UserResult) {
            setAcceptDeclineView(itemObject,context)
            Glide.with(context).load(itemObject.picture?.large).placeholder(R.drawable.placeholder)
                .into(itemView.ivUser)
            val name =
                "${itemObject.name?.first} ${itemObject.name?.last}"
            itemView.tvName?.text = name
            val location = "${itemObject.location?.city}, ${itemObject.location?.country}"
            itemView.tvLocation?.text = location

            itemView.ivAccept?.setOnClickListener {
                itemObject.acceptedDecline = true
                setAcceptDeclineView(itemObject,context)
                actionListener?.acceptDecline(itemObject, adapterPosition)
            }
            itemView.ivDecline?.setOnClickListener {
                itemObject.acceptedDecline = false
                setAcceptDeclineView(itemObject,context)
                actionListener?.acceptDecline(itemObject, adapterPosition)
            }
        }
    }

    private fun setAcceptDeclineView(userResult: UserResult,context: Context) {
        if (userResult.acceptedDecline != null) {
            itemView.clButtons?.visibility = View.GONE
            itemView.tvMessage?.visibility = View.VISIBLE
            if (userResult.acceptedDecline!!) {
                itemView.tvMessage?.text = Constant.ACCEPTED
                itemView.tvMessage?.setTextColor(ContextCompat.getColor(context,R.color.colorGreen))
            } else {
                itemView.tvMessage?.text = Constant.DECLINE
                itemView.tvMessage?.setTextColor(ContextCompat.getColor(context,R.color.colorRed))
            }
        } else {
            itemView.clButtons?.visibility = View.VISIBLE
            itemView.tvMessage?.visibility = View.GONE
        }
    }
}