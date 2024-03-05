package com.example.porfavofunciona.Repository

import com.example.porfavofunciona.Wins_Loses
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface Wins_LosesRepository : CrudRepository<Wins_Loses? , Int?> {
    fun findByIdWinsLoses(idWins_Loses: Int): Wins_Loses?
}
