package com.example.porfavofunciona

import jakarta.persistence.*

@Entity
class Wins_Loses{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var IdWins_Loses: Int? = null
    var PosibilidadesWin: Int? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    var Usuario : Usuario? = null
}