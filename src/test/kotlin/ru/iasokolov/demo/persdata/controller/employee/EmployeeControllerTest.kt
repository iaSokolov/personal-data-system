package ru.iasokolov.demo.persdata.controller.employee

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.jdbc.Sql
import ru.iasokolov.demo.persdata.controller.employee.dto.EmployeeDto

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {
    companion object {
        const val URL = "/employees"

        @BeforeAll
        @Sql(
            statements = ["DELETE FROM employee"],
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
        )
        @JvmStatic
        fun deleteOldEmployees() { }
    }

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    @DisplayName("employees/{id} for non-existent record should return 404")
    fun getById_nonExistentRecord_return404() {
        val response: ResponseEntity<EmployeeDto> = restTemplate.getForEntity(
            "$URL/01943131-47fb-7c76-9430-d8487169c026",
            EmployeeDto::class.java
        )

        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertNull(response.body)
    }

    @Test
    @Sql(
        statements = ["INSERT INTO employee (id, deleted) VALUES('0194311e-dcb7-73a1-bb69-3d9fb67b607b', false)"],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Sql(
        statements = ["DELETE FROM employee"],
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
    )
    @DisplayName("employees/{id} for exist record should return 200")
    fun getById_existRecord_return200() {
        val response: ResponseEntity<EmployeeDto> = restTemplate.getForEntity(
            "$URL/0194311e-dcb7-73a1-bb69-3d9fb67b607b",
            EmployeeDto::class.java
        )

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals("0194311e-dcb7-73a1-bb69-3d9fb67b607b", response.body?.id?.toString())
    }

    @Test
    @DisplayName("employees/ for non-existent records should return 404")
    fun employees_nonExistentRecord_return404() {
        val response = restTemplate.getForEntity(URL, listOf<EmployeeDto>().javaClass)

        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertNull(response.body)
    }

    @Test
    @Sql(
        statements = [
            "INSERT INTO employee (id, deleted) VALUES('0194311e-dcb7-73a1-bb69-3d9fb67b607b', false)",
            "INSERT INTO employee (id, deleted) VALUES('019431aa-7b8a-72ce-84a2-c6f749d62160', false)",
        ],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Sql(
        statements = ["DELETE FROM employee"],
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
    )
    @DisplayName("employees/ for exist record should return 200")
    fun employees_existRecord_return200() {
        val response = restTemplate.getForEntity(URL, Array<EmployeeDto>::class.java)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(2, response.body?.size)
    }
}