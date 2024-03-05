package com.example.porfavofunciona.Controller

import com.example.porfavofunciona.Wins_Loses
import com.example.porfavofunciona.Service.Wins_LosesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping(path=["/Wins_Loses"])
class Wins_LosesController {
    @Autowired
    private val Wins_LosesService : Wins_LosesService? = null

    @PostMapping(path=["/add"])
    @ResponseBody
    fun addNuevoWins_Loses(
        @RequestParam PosibilidadesWin: Int?,
        @RequestParam Usuario: Int?): String {
        return Wins_LosesService!!.addNuevoWins_Loses(PosibilidadesWin,Usuario)
    }

    @GetMapping(path = ["/update"])
    @ResponseBody
    fun updateWinsLoses(
        @RequestParam idWins_Loses: String?,
        @RequestParam PosibilidadesWin: String?): String {
        return Wins_LosesService!!.updateWinsLoses(idWins_Loses, PosibilidadesWin)
    }

    @GetMapping(path = ["/all"])
    @ResponseBody
    fun findWins_Loses():MutableIterable<Wins_Loses?>{
        return Wins_LosesService!!.getWins_Loses()
    }
}