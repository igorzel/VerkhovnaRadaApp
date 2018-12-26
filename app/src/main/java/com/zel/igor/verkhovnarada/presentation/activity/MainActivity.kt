package com.zel.igor.verkhovnarada.presentation.activity

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zel.igor.verkhovnarada.R
import com.zel.igor.verkhovnarada.data.model.Bill
import com.zel.igor.verkhovnarada.di.DaggerActivityComponent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_bill_status_recycler_item.view.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModeFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainActivityViewModel

    private val billsListAdapter = BillsListAdapter()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        billsList.layoutManager = LinearLayoutManager(this)
        billsList.adapter = billsListAdapter

        DaggerActivityComponent.create().inject(this)
        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(MainActivityViewModel::class.java)

        viewModel.billStatuses().observe(this, Observer {
            Log.d("Result", "There are ${it?.size} items")
            billsListAdapter.submitList(it)
        })

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }


    override fun onResume() {
        super.onResume()

        viewModel.onViewAppeared()
    }
}

private class BillsListAdapter :
    RecyclerView.Adapter<BillsListAdapter.ViewHolder>() {
    var items: MutableList<Bill> = mutableListOf()

    fun submitList(newItems: List<Bill>?) {
        items.clear()
        newItems?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItem(position: Int): Bill {
        return items[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.view_bill_status_recycler_item, parent, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(bill: Bill) {
            itemView.billStatusId.text = bill.number
            itemView.billStatusState.text = bill.status.name
            itemView.billStatusName.text = bill.title
        }
    }
}

//private class BillsListAdapter :
//    ListAdapter<Bill, BillsListAdapter.ViewHolder>(DIFF_CALLBACK) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        return ViewHolder(inflater.inflate(R.layout.view_bill_status_recycler_item, parent, false))
//    }
//
//    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//        viewHolder.bind(getItem(position))
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        fun bind(bill: Bill) {
//            itemView.billStatusId.text = bill.number
//            itemView.billStatusState.text = bill.status.name
//            itemView.billStatusName.text = bill.title
//        }
//    }
//}
//
//val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Bill>() {
//    override fun areItemsTheSame(bill1: Bill, bill2: Bill): Boolean {
//        return bill1.number == bill2.number
//    }
//
//    override fun areContentsTheSame(bill1: Bill, bill2: Bill): Boolean {
//        return bill1.title == bill2.title &&
//                bill1.status == bill2.status &&
//                bill1.url == bill2.url
//    }
//}
