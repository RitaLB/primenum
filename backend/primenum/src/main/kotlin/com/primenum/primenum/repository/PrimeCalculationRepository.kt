package com.primenum.primenum.repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.primenum.primenum.model.PrimeCalculation

@Repository
interface PrimeCalculationRepository : JpaRepository<PrimeCalculation, Long> {}