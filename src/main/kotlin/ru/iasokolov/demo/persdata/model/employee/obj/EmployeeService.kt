package ru.iasokolov.demo.persdata.model.employee.obj

import com.fasterxml.uuid.Generators
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository
) {
    fun create() = Employee(
        id = Generators.timeBasedEpochGenerator().generate(),
        deleted = false,
        attributes = mutableListOf()
    )

    @Transactional
    fun save(employee: Employee): Employee = employeeRepository.save(employee)
}