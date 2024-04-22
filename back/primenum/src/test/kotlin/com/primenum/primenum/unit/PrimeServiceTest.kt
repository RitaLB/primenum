package com.primenum.primenum.unit

import com.primenum.primenum.model.PrimeCalculation
import com.primenum.primenum.repository.PrimeCalculationRepository
import com.primenum.primenum.service.PrimeService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.ArgumentMatchers.anyLong

class PrimeServiceTest {

    @Mock
    lateinit var primeCalculationRepository: PrimeCalculationRepository

    @InjectMocks
    lateinit var primeService: PrimeService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun testCalculatePrimes() {
        // Configuração do mock
        val k = 10
        val expectedResult = PrimeCalculation(number = k, result = k *2, calculationTime = anyLong())

        `when`(primeCalculationRepository.save(expectedResult)).thenReturn(expectedResult)

        // Teste
        val result = primeService.calculatePrimes(k)

        // Assert
        assertEquals(expectedResult, result)
    }
}