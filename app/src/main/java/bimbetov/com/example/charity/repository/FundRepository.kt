package bimbetov.com.example.charity.repository

import bimbetov.com.example.charity.model.Fund

interface FundRepository {
    fun getFund(): List<Fund>
}