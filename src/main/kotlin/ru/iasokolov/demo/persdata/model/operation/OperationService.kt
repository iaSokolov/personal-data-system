package ru.iasokolov.demo.persdata.model.operation

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OperationService(
    private val repository: OperationRepository
) {
    fun getById(id: Int): Operation? = repository.findByIdOrNull(id)

    fun save(operation: Operation): Operation = repository.save(operation)
}