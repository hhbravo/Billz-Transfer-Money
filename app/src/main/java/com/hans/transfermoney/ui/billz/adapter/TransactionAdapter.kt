package com.hans.transfermoney.ui.billz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hans.transfermoney.core.BaseViewHolder
import com.hans.transfermoney.data.model.Transaction
import com.hans.transfermoney.databinding.TransactionItemViewBinding

class TransactionAdapter(private val transactions: List<Transaction>): RecyclerView.Adapter<BaseViewHolder<*>>() {


    override fun getItemCount(): Int =  transactions.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemViewBinding = TransactionItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TransactionAdapter.TransactionViewHolder(itemViewBinding, parent.context )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
            when(holder) {
                is TransactionAdapter.TransactionViewHolder -> holder.bin(transactions[position])
            }
    }

    private class TransactionViewHolder(
        val binding: TransactionItemViewBinding,
        val context: Context
    ): BaseViewHolder<Transaction>(binding.root) {

        override fun bin(item: Transaction) {
            binding.tvClient.text = item.customer
            binding.tvCode.text = item.code
            binding.tvCustomer.text = item.destination
        }

    }

}