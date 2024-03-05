package com.example.porfavofunciona.Repository

import com.example.porfavofunciona.Usuario
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : CrudRepository<Usuario? , Int?> {
        fun findbyidUser(idUser:Int): Usuario?
}
