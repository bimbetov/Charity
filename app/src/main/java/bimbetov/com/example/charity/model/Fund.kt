package bimbetov.com.example.charity.model

class Fund(
    private val fundName: String,
    private val fundImg: String,
    private val needAmount: Int,
    private var collectedAmount: Int,
    val imageList: List<String>
) {
    fun getFundName(): String {
        return fundName
    }

    fun getFundImg(): String {
        return fundImg
    }

    fun getNeedAmount(): Int {
        return needAmount
    }

    fun getCollectedAmount(): Int {
        return collectedAmount
    }

    fun getImgList(): List<String> {
        return imageList
    }
}