package com.example.saeha.mywrite

/**
 * Created by blue_ on 2018-09-13.
 */
object Model {
    data class Result(val query: Query)
    data class Query(val searchinfo: SearchInfo)
    data class SearchInfo(val totalhits: Int)
}