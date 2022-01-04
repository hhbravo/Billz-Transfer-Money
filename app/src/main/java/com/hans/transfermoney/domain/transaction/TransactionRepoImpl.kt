package com.hans.transfermoney.domain.transaction

import com.hans.transfermoney.data.model.Transaction
import com.hans.transfermoney.data.remote.transaction.TransactionDataSource
import javax.inject.Inject

class TransactionRepoImpl @Inject constructor (
    private val dataSource: TransactionDataSource): TransactionRepo {

    override suspend fun findAll(): List<Transaction> = dataSource.findAll()
}