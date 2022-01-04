package com.hans.transfermoney.domain.expense

import com.hans.transfermoney.data.model.Expense
import com.hans.transfermoney.data.remote.expense.ExpenseDataSource
import javax.inject.Inject

class ExpenseRepoImpl @Inject constructor(
    private val dataSource: ExpenseDataSource): ExpenseRepo {

    override suspend fun expense(): List<Expense> = dataSource.findAll()

}