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
    fun calculatePrimes(@RequestBody request: PrimeRequest): ResponseEntity<PrimeResponse> {

        val result = primeService.calculatePrimes(request.k)
        val resultnum = result.result
        val processingTime = result.calculationTime
        return ResponseEntity.ok(PrimeResponse(resultnum, processingTime))
    }

    @GetMapping("/history")
    fun getHistory(): ResponseEntity<List<PrimeCalculation>> {
        val history = primeService.getHistory()
        return ResponseEntity.ok(history)
    }
}