package com.primenum.primenum.service
import com.primenum.primenum.model.PrimeCalculation
import org.springframework.stereotype.Service
import com.primenum.primenum.repository.PrimeCalculationRepository


@Service
class PrimeService(private val primeCalculationRepository: PrimeCalculationRepository) {

    fun calculatePrimes(k: Int): PrimeCalculation {
        val startTime = System.currentTimeMillis()

        //  π(x) algorithm implementation:
        val result = k * 2

        val endTime = System.currentTimeMillis()
        val processingTime = endTime - startTime
        // Saving result on history
        val primeCalculation = PrimeCalculation(number = k, result = result, calculationTime = processingTime )
        primeCalculationRepository.save(primeCalculation)

        return primeCalculation
    }

    fun getHistory(): List<PrimeCalculation> {
        return primeCalculationRepository.findAll()
    }
}