package ru.iasokolov.demo.persdata.employee

import mu.KotlinLogging
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import ru.iasokolov.demo.persdata.model.employee.obj.EmployeeService

@SpringBootTest
class EmployeeServiceTests {
	private val logger = KotlinLogging.logger {}

	@Autowired
	lateinit var service: EmployeeService

	@Test
	@DisplayName("Create employee without attributes")
	fun createEmployee() {
		val employee = service.create()

        Assertions.assertNotNull(employee)
	}

	@Test
	@DisplayName("Save employee without attributes")
	@Sql(statements = ["DELETE FROM employee"])
	fun saveEmployeeWithoutAttributes() {
		val employee = service.save(employee = service.create())

		Assertions.assertNotNull(employee)
	}
}