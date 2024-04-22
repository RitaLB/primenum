package com.primenum.primenum.controller

import com.primenum.primenum.model.PrimeCalculation
import com.primenum.primenum.service.PrimeService
import com.primenum.primenum.dto.PrimeRequest
import com.primenum.primenum.dto.PrimeResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PrimeController(private val primeService: PrimeService) {

    @PostMapping("/calculate-primes")
    fun calculatePrimes(@RequestBody request: PrimeRequest): ResponseEntity<PrimeResponse> {
        //val startTime = System.currentTimeMillis()
        val result = primeService.calculatePrimes(request.k)
        val resultnum = result.result
        val processingTime = result.calculationTime
        //val endTime = System.currentTimeMillis()
        //val processingTime = endTime - startTime
        return ResponseEntity.ok(PrimeResponse(resultnum, processingTime))
    }

    @GetMapping("/history")
    fun getHistory(): ResponseEntity<List<PrimeCalculation>> {
        val history = primeService.getHistory()
        return ResponseEntity.ok(history)
    }
}