package bimbetov.com.example.charity.repository

import bimbetov.com.example.charity.model.Fund

class FakeFundRepository : FundRepository{

    private val loveFund = listOf("")
    private val smileFund = listOf("")


    override fun getFund(): List<Fund> {
        return ArrayList<Fund>().apply {
            add(Fund("Благотворительный фонд Любовь","imgLoveFund", 50_000,30_000, loveFund))
            add(Fund("Благотворительный фонд Улыбка","imgSmileFund", 100_000,20_000, smileFund))
        }
    }
}