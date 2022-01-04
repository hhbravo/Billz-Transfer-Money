package com.hans.transfermoney.di

import com.google.gson.GsonBuilder
import com.hans.transfermoney.core.AppConstants
import com.hans.transfermoney.data.remote.expense.WebService
import com.hans.transfermoney.domain.expense.ExpenseRepo
import com.hans.transfermoney.domain.expense.ExpenseRepoImpl
import com.hans.transfermoney.domain.transaction.TransactionRepo
import com.hans.transfermoney.domain.transaction.TransactionRepoImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideAnalyticsService() = Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    @Singleton
    @Provides
    fun provideWebService(retrofit: Retrofit) = retrofit.create(WebService::class.java)

}

@Module
@InstallIn(ViewModelComponent::class) // Scope our dependencies
abstract class AnalyticsModule {

    @Binds
    abstract fun bindExpense(
        expenseRepoImpl: ExpenseRepoImpl
    ): ExpenseRepo

    @Binds
    abstract fun bindTransaction(
        transactionRepoImpl: TransactionRepoImpl
    ): TransactionRepo
}