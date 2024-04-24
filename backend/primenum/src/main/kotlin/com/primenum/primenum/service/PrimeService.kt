package com.primenum.primenum.service
import com.primenum.primenum.model.PrimeCalculation
import org.springframework.stereotype.Service
import com.primenum.primenum.repository.PrimeCalculationRepository


@Service
class PrimeService(private val primeCalculationRepository: PrimeCalculationRepository) {

    fun calculatePrimes(k: Int): PrimeCalculation {
        val startTime = System.nanoTime()

        val prime = BooleanArray(k) { true }
        prime[0] = false
        prime[1] = false

        var p = 2
        while (p * p < k) {
            if (prime[p]) {
                var i = p * p
                while (i < k) {
                    prime[i] = false
                    i += p
                }
            }
            p++
        }

        var count = 0
        for (i in 2 until k) {
            if (prime[i]) {
                count++
            }
        }

        val result = count

        val endTime = System.nanoTime()
        val processingTime = (endTime - startTime) / 1000000

        val primeCalculation = PrimeCalculation(number = k, result = result, calculationTime = processingTime)
        primeCalculationRepository.save(primeCalculation)

        return primeCalculation
    }


    fun getHistory(): List<PrimeCalculation> {
        return primeCalculationRepository.findAll()
    }
}