package com.primenum.primenum.integration

import com.fasterxml.jackson.databind.ObjectMapper
import com.primenum.primenum.dto.PrimeRequest
import com.primenum.primenum.model.PrimeCalculation
import com.primenum.primenum.repository.PrimeCalculationRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
class PrimeControllerIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var primeCalculationRepository: PrimeCalculationRepository

    private val objectMapper = ObjectMapper()

    @BeforeEach
    fun setUp() {
        val primeCalculation = PrimeCalculation(id = 1, number = 10, result = 4, calculationTime = 100)
        `when`(primeCalculationRepository.findAll()).thenReturn(listOf(primeCalculation))
    }

    @Test
    fun `test calculate primes endpoint`() {
        val request = PrimeRequest("10")

        mockMvc.perform(
            post("/api/calculate-primes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.result").value(4))
            .andExpect(jsonPath("$.processingTime").isNumber)
    }

    @Test
    fun `test get history endpoint`() {
        mockMvc.perform(
            get("/api/history")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].number").value(10))
            .andExpect(jsonPath("$[0].result").value(4))
            .andExpect(jsonPath("$[0].calculationTime").isNumber)
    }
}
