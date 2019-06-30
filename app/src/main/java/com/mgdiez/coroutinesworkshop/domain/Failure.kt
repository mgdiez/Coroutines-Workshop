package com.mgdiez.coroutinesworkshop.domain

sealed class Failure {
    data class Error(val value: Exception) : Failure()
}
