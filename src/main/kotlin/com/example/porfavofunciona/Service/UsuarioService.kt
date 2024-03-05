package com.example.porfavofunciona.Service

import com.example.porfavofunciona.Repository.UsuarioRepository
import com.example.porfavofunciona.Repository.Wins_LosesRepository
import com.example.porfavofunciona.Usuario
import com.example.porfavofunciona.Wins_Loses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsuarioService {

    @Autowired
    private val UsuarioRepository : UsuarioRepository? = null
    @Autowired
    private val Wins_LosesRepository: Wins_LosesRepository? = null

    fun addNuevoUsuario(
        nombreUsuario: String?, tipoPeronsajeUsuario: String?, lineaPrincipal:String?
    ): String {
        var resultado: String
        try {
            if (nombreUsuario == "" || tipoPeronsajeUsuario == "" || lineaPrincipal == "" ){
                throw Exception()
            }else{
                val Usuario = Usuario()
                Usuario.nombre = nombreUsuario
                Usuario.tipoPeronsaje = tipoPeronsajeUsuario
                Usuario.lineaPrincipal = lineaPrincipal
                UsuarioRepository!!.save(Usuario)
                resultado = "datos guardados"
            }
        }catch (e:Exception){
            resultado = "no se ha podido guardar"
        }
        return resultado
    }


    fun UpdateUsuario(
        idUser:String?,nombreUsuario: String?, tipoPeronsajeUsuario: String?, lineaPrincipal:String?
    ): String {
        var resultado: String
        try {
            val usuario = getUsuarioById(idUser!!.toInt())
            if (nombreUsuario == "" || tipoPeronsajeUsuario == "" || lineaPrincipal == "" ){
                throw Exception()
            }else{
                val Usuario = Usuario()
                Usuario.nombre = nombreUsuario
                Usuario.tipoPeronsaje = tipoPeronsajeUsuario
                Usuario.lineaPrincipal = lineaPrincipal
                UsuarioRepository!!.save(Usuario)
                resultado = "datos guardados"
            }
        }catch (e:Exception){
            resultado = "no se ha podido guardar"
        }
        return resultado
    }


    fun DeleteUsuario(idUser: String?): String {
        var resultado: String
        try {
            val usuario = getUsuarioById(idUser!!.toInt())
            if (usuario == null || idUser == ""){
                throw Exception()
            }else{
                UsuarioRepository!!.delete(usuario)
                for (winrate in usuario.winrate!!){
                    val Wins_LosesFind = getWins_LosesById(usuario.idUser)
                    if (Wins_LosesFind != null){
                        Wins_LosesRepository!!.delete(Wins_LosesFind)
                    }
                }
                resultado = "Eliminado"
            }
        }catch (e: Exception){
            resultado = "No se ha encontrado el usuario"
        }
        return resultado
    }


    fun getUsuarios(): MutableIterable<Usuario?> {
        return UsuarioRepository!!.findAll()
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
        }else{
            Wins_LosesRepository!!.findByIdWinsLoses(id)
        }
    }
}