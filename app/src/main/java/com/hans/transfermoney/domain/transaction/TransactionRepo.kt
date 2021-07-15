package com.hans.transfermoney.domain.transaction

import com.hans.transfermoney.data.model.Transaction

interface TransactionRepo {

    suspend fun findAll(): List<Transaction>
}