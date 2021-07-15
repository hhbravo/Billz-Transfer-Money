package com.hans.transfermoney.presentation.expense

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.hans.transfermoney.core.Result
import com.hans.transfermoney.domain.expense.ExpenseRepo
import kotlinx.coroutines.Dispatchers

class ExpenseViewModel(private val repo: ExpenseRepo) : ViewModel() {

    fun expense() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.expense()))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}

class ExpenseViewModelFactory(private val repo: ExpenseRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ExpenseRepo::class.java).newInstance(repo)
    }

}