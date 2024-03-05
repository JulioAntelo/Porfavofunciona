package com.example.porfavofunciona.Service

import com.example.porfavofunciona.Repository.UsuarioRepository
import com.example.porfavofunciona.Repository.Wins_LosesRepository
import com.example.porfavofunciona.Usuario
import com.example.porfavofunciona.Wins_Loses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Wins_LosesService {
    @Autowired
    private val Wins_LosesRepository: Wins_LosesRepository? = null
    @Autowired
    private val UsuarioRepository: UsuarioRepository? = null



    fun addNuevoWins_Loses(
        PosibilidadesWin: Int?, idUsuario: Int?
    ): String {
        var resultado: String
        try {
            if (PosibilidadesWin == null || idUsuario == null){
                throw Exception()
            }else{
                val Wins_Loses = Wins_Loses()
                val Usuario = getUsuarioById(idUsuario)
                Wins_Loses.PosibilidadesWin = PosibilidadesWin
                Wins_Loses.Usuario = Usuario
                Wins_LosesRepository!!.save(Wins_Loses)
                resultado = "datos guardados"
            }
        }catch (e:Exception){
            resultado = "no se ha podido guardar"
        }
        return resultado
    }

    fun updateWinsLoses(
        idWins_Loses:String?,PosibilidadesWin:String?
        ): String {
            var resultado: String
            try {
                val Wins_Loses = getWins_LosesById(idWins_Loses!!.toInt())
                if (PosibilidadesWin == null){
                    throw Exception()
                }else{
                    val Wins_Loses = Wins_Loses()
                    Wins_Loses.PosibilidadesWin = PosibilidadesWin.toInt()
                    Wins_LosesRepository!!.save(Wins_Loses)
                    resultado = "datos guardados"
                }
            }catch (e:Exception){
                resultado = "no se ha podido guardar"
            }
            return resultado
    }


    fun getWins_Loses(): MutableIterable<Wins_Loses?> {
        return Wins_LosesRepository!!.findAll()
    }

    fun getUsuarioById(id:Int): Usuario? {
        return if(id== null){
            Usuario()
        }else{
            UsuarioRepository!!.findbyidUser(id)
        }
    }

    fun getWins_LosesById(id:Int?): Wins_Loses? {
        return if(id == null){
            Wins_Loses()
        }else Wins_LosesRepository!!.findByIdWinsLoses(id)

    }
}