package com.mgdiez.coroutinesworkshop.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newFixedThreadPoolContext

class RickDispatchers {
    val io = Dispatchers.IO
    val main = Dispatchers.Main
    val database = newFixedThreadPoolContext(4, "DB")
}
