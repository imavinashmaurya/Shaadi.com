package com.avinash.shaadi.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.avinash.shaadi.R
import com.avinash.shaadi.data.model.UserResult
import com.avinash.shaadi.data.viewmodel.UserDataViewModel
import com.avinash.shaadi.utility.genericRecyclerview.KRecyclerViewAdapter
import com.avinash.shaadi.utility.genericRecyclerview.KRecyclerViewHolder
import com.avinash.shaadi.utility.genericRecyclerview.KRecyclerViewHolderCallBack
import com.avinash.shaadi.utility.genericRecyclerview.KRecyclerViewItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), ActionListener {
    var userDataViewModel: UserDataViewModel? = null
    var userList: ArrayList<UserResult>? = ArrayList()
    var adapter: KRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        initViewModel()
        setUpRecyclerView()
        observeData()
    }

    private fun initViewModel() {
        userDataViewModel = ViewModelProvider(this).get(UserDataViewModel::class.java)
    }

    private fun apiCall() {
        pbUser?.visibility = View.VISIBLE
        userDataViewModel?.fetchUserData()
    }


    private fun observeData() {
        userDataViewModel?.getUserData()?.observe(this, Observer {
            if (it != null) {
                it.results?.let { it1 -> userDataViewModel?.saveUserDataLocally(it1) }
            }
        })

        userDataViewModel?.getUserDataLocally()?.observe(this, Observer {
            if (it.isNotEmpty()) {
                pbUser?.visibility = View.GONE
                userList?.clear()
                userList?.addAll(it)
                adapter?.notifyDataSetChanged()
            } else {
                apiCall()
            }
        })

    }

    private fun setUpRecyclerView() {
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvUser?.layoutManager = manager
        adapter = userList?.let {
            KRecyclerViewAdapter(this, it, object :
                KRecyclerViewHolderCallBack {
                override fun onCreateViewHolder(@NonNull parent: ViewGroup): KRecyclerViewHolder {
                    val layoutView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.row_user, parent, false)
                    return UserHolder(layoutView, this@MainActivity)
                }

                override fun onHolderDisplayed(
                    @NonNull holder: KRecyclerViewHolder,
                    position: Int
                ) {
                    Log.i("onHolderDisplayed", "Holder Displayed At: $position")
                }
            }, KRecyclerViewItemClickListener { holder, itemObject, itemPosition ->
            })
        }
        rvUser?.adapter = adapter
    }

    override fun acceptDecline(userResult: UserResult, position: Int) {
        userDataViewModel?.updateUserDataLocally(userResult)
    }
}