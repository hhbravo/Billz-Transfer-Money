package com.hans.transfermoney.data.remote.transaction

import com.hans.transfermoney.data.model.Transaction
import com.hans.transfermoney.data.remote.expense.WebService
import javax.inject.Inject

class TransactionDataSource @Inject constructor(
    private val webService: WebService) {

    suspend fun findAll():List<Transaction> = webService.transaction()
}