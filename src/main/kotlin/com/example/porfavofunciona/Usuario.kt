package com.example.demo

import jakarta.persistence.*
@Entity
class Usuario {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   var idUsuario: Int? = null
    var nombre: String? = null
    var tipoPeronsaje: String? = null
    var lineaPrincipal: String? = null
    @OneToMany(mappedBy = "IdWins_Loses", cascade = [CascadeType.ALL])
    var winrate : MutableList<Wins_Loses?> = mutableListOf()
}