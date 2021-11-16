package bimbetov.com.example.charity.repository

import bimbetov.com.example.charity.R
import bimbetov.com.example.charity.model.Fund

class FakeFundRepository : FundRepository{

    private val loveFund = listOf("https://sun9-25.userapi.com/impg/6IlBmat0PFv0k7NqpcxyPTOSa19OfpK7elQ8qA/Cu51mmN29ow.jpg?size=1280x720&quality=96&sign=73a1254a3f69af6415d643b371d48cd6&type=album")
    private val imgLoveFund = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ2DrUbc79lWP-HoHWAflwbhtOiTRHJ1ebC54o-ajduo7AanJru&usqp=CAU"
    private val descriptionFedor = R.string.descriptionFedor.toString()


    private val smileFund = listOf("https://sun9-8.userapi.com/impg/tLnuzAqsPA3QI4qz0_XojMvflVl6EcFui4-8HQ/ln5SAh0UEPg.jpg?size=1598x1200&quality=96&sign=bbff1e0567ef90ec29e69a548912491d&type=album")
    private val imgSmileFund = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRyFTP_UjQj48dsHaz15JbHt2FfdWs5e_41AezrpPDbNj3BJAWn&usqp=CAU"
    private val descriptionAlexey = R.string.descriptionAlexey.toString()

    override fun getFund(): List<Fund> {
        return ArrayList<Fund>().apply {
            add(Fund("Благотворительный фонд Любовь",imgLoveFund,
                "Феде нужно пройти обследование чтобы заговорить",
                50_000,30_000, descriptionFedor, loveFund))
            add(Fund("Благотворительный фонд Улыбка",imgSmileFund,
                "Андрей нуждается в протезировании правой кисти!",
                100_000,20_000, descriptionAlexey, smileFund))
        }
    }
}