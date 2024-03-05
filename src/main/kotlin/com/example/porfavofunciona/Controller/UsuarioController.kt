package com.example.porfavofunciona.Controller

import com.example.porfavofunciona.Usuario
import com.example.porfavofunciona.Service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping(path=["/Usuario"])
class UsuarioController {
    @Autowired
    private val UsuarioService: UsuarioService? = null

    @PostMapping(path=["/add"])
    @ResponseBody
    fun addNuevoUsuario(
        @RequestParam nombreUsuario: String?,
        @RequestParam tipopersonaje: String?,
        @RequestParam lineaPrincipal:String?): String {
        return UsuarioService!!.addNuevoUsuario(nombreUsuario,tipopersonaje,lineaPrincipal)
    }

    @GetMapping(path = ["/update"])
    @ResponseBody
    fun UpdateUsuario(
        @RequestParam idUser: String?,
        @RequestParam nombreUsuario: String?,
        @RequestParam tipopersonaje: String?,
        @RequestParam lineaPrincipal:String?): String {
        return UsuarioService!!.UpdateUsuario(idUser,nombreUsuario,tipopersonaje,lineaPrincipal)
    }

    @GetMapping(path = ["/del"])
    @ResponseBody
    fun DeleteUsuario(
        @RequestParam idUser:String):String{
        return UsuarioService!!.DeleteUsuario(idUser)
    }

    @GetMapping(path = ["/all"])
    @ResponseBody
    fun findUsuarios():MutableIterable<Usuario?>{
        return UsuarioService!!.getUsuarios()
    }
}