package bimbetov.com.example.charity.model

class Fund(
    private val fundName: String,
    private val fundImg: String,
    private val city: String,
    private val titleProblem: String,
    private val needAmount: Int,
    private var collectedAmount: Int,
    private val descriptionProblem: String,
    val imageList: List<String>

) {
    fun getFundName(): String {
        return fundName
    }

    fun getFundImg(): String {
        return fundImg
    }

    fun getCity(): String {
        return city
    }

    fun getTitleProblem(): String {
        return titleProblem
    }

    fun getNeedAmount(): Int {
        return needAmount
    }

    fun getCollectedAmount(): Int {
        return collectedAmount
    }

    fun getDescriptionProblem(): String {
        return descriptionProblem
    }

    fun getImgList(): List<String> {
        return imageList
    }
}