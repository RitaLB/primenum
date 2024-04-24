package com.primenum.primenum.controller

import com.primenum.primenum.model.PrimeCalculation
import com.primenum.primenum.service.PrimeService
import com.primenum.primenum.dto.PrimeRequest
import com.primenum.primenum.dto.PrimeResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = ["http://localhost:5173"])
class PrimeController(private val primeService: PrimeService) {

    @PostMapping("/calculate-primes")
    fun calculatePrimes(@RequestBody request: PrimeRequest): ResponseEntity<out Any> {

        val validationResult = validateInput(request.k)
        if (validationResult != null) {
            return ResponseEntity.badRequest().body(validationResult)
        }

        val number = request.k.toInt()
        val result = primeService.calculatePrimes(number)
        //val result = primeService.calculatePrimes(request.k)
        val resultnum = result.result
        val processingTime = result.calculationTime
        return ResponseEntity.ok(PrimeResponse(resultnum, processingTime))
    }
    private fun validateInput(k: String): String? {
        // Verifica se o valor de 'k' é um número inteiro válido
        if (!k.matches(Regex("\\d+"))) {
            return "Invalid value. There are letters in your input.  Please provide a positive integer."
        }

        // verificating if input numper is a possible positive integer smaller than 2.147.483.647
        try {
            val testNumber = k.toInt()
            if (testNumber < 0) {
                return "Invalid value. Please provide a positive integer."
            }
        } catch (e: Exception){
            return "Invalid value. Please provide a number smaller then 2.147.483.647."
        }
        return null
    }

    @GetMapping("/history")
    fun getHistory(): ResponseEntity<List<PrimeCalculation>> {
        val history = primeService.getHistory()
        return ResponseEntity.ok(history)
    }
}