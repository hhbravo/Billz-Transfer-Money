package com.hans.transfermoney.ui.billz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hans.transfermoney.core.BaseViewHolder
import com.hans.transfermoney.data.model.Expense
import com.hans.transfermoney.databinding.ExpenseItemViewBinding

class ExpenseAdapter(private val expends: List<Expense>) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun getItemCount(): Int = expends.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemViewBinding = ExpenseItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ExpenseViewHolder(itemViewBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is ExpenseAdapter.ExpenseViewHolder -> holder.bin(expends[position])
        }
    }

    private class ExpenseViewHolder(
        val binding: ExpenseItemViewBinding,
        val context: Context
    ) : BaseViewHolder<Expense>(binding.root) {

        override fun bin(item: Expense) {
            binding.tvExpenseDate.text = item.fecAmount
            binding.tvExpenseAmount.text = item.bill.amount.toString()
            binding.tvExpenseSymbol.text = item.bill.symbol
        }

    }

}