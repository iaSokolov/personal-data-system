package ru.iasokolov.demo.persdata.operation

import mu.KotlinLogging
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.iasokolov.demo.persdata.model.operation.Operation
import ru.iasokolov.demo.persdata.model.operation.OperationService
import java.util.*

@SpringBootTest
class OperationTests {
	private val logger = KotlinLogging.logger {}

	@Autowired
	lateinit var service: OperationService

	@Test
	@DisplayName("Save operation record")
	@Disabled
	fun saveOperation() {
		logger.info { "saveOperation test" }

		val newOperation = Operation(id = 0, operationId = UUID.randomUUID(), type = "1")

		service.save(newOperation)
	}
}

