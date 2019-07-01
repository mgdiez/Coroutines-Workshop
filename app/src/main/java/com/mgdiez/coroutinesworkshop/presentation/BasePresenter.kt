package com.mgdiez.coroutinesworkshop.presentation

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter : CoroutineScope {

    private val handler = CoroutineExceptionHandler { _, throwable -> onGenericError(throwable) }
    private val job = Job()
    override val coroutineContext: CoroutineContext = job + handler + Dispatchers.Main

    abstract fun onGenericError(throwable: Throwable)
}
