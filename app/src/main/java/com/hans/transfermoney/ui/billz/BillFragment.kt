package com.hans.transfermoney.ui.billz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.hans.transfermoney.R
import com.hans.transfermoney.core.Result
import com.hans.transfermoney.data.remote.expense.ExpenseDataSource
import com.hans.transfermoney.data.remote.expense.RetrofitClient
import com.hans.transfermoney.data.remote.transaction.TransactionDataSource
import com.hans.transfermoney.databinding.FragmentBillBinding
import com.hans.transfermoney.domain.expense.ExpenseRepoImpl
import com.hans.transfermoney.domain.transaction.TransactionRepoImpl
import com.hans.transfermoney.presentation.expense.ExpenseViewModel
import com.hans.transfermoney.presentation.expense.ExpenseViewModelFactory
import com.hans.transfermoney.presentation.transaction.TransactionViewModel
import com.hans.transfermoney.presentation.transaction.TransactionViewModelFactory
import com.hans.transfermoney.ui.billz.adapter.ExpenseAdapter
import com.hans.transfermoney.ui.billz.adapter.TransactionAdapter


class BillFragment : Fragment(R.layout.fragment_bill) {

    private lateinit var binding: FragmentBillBinding

    private val viewModelExpense by viewModels<ExpenseViewModel> {
        ExpenseViewModelFactory(
            ExpenseRepoImpl(
                ExpenseDataSource(
                    RetrofitClient.webservice
                )
            )
        )
    }

    private val viewModelTransaction by viewModels<TransactionViewModel> {
        TransactionViewModelFactory(
            TransactionRepoImpl(
                TransactionDataSource(
                    RetrofitClient.webservice
                )
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBillBinding.bind(view)

        loadTransaction()
        loadExpense()
    }

    private fun loadTransaction() {
        viewModelTransaction.transaction().observe(viewLifecycleOwner) {
            when(it) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d("TRANSACTION", "LOADING");
                }
                is Result.Success -> {
                    val data = it.data
                    Log.d("TRANSACTION", "data ${data}");
                    binding.rvBills.adapter = TransactionAdapter(data)
                    binding.rvBills.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE

                }
                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.e("TRANSACTION", "Ocurrio un error: ${it.exception}")
                    Toast.makeText(
                        requireContext(), "Ocurrio un error: ${it.exception}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun loadExpense() {
        viewModelExpense.expense().observe(viewLifecycleOwner) {
            when (it) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d("BILL", "LOADING");
                }
                is Result.Success -> {
                    val data = it.data
                    Log.d("BILL", "data ${data}");
                    binding.rvPays.adapter = ExpenseAdapter(data)
                    binding.rvPays.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE

                }
                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.e("BILL", "Ocurrio un error: ${it.exception}")
                    Toast.makeText(
                        requireContext(), "Ocurrio un error: ${it.exception}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}