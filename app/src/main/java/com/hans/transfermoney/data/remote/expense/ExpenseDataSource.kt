package com.hans.transfermoney.data.remote.expense

import com.hans.transfermoney.data.model.Expense
import javax.inject.Inject

class ExpenseDataSource @Inject constructor(private val webService: WebService) {

    suspend fun findAll(): List<Expense>  =  webService.expense()
}