package com.example.forecaster.mapper

interface Mapper<R, D> {
    fun mapFrom(type: R): D
}