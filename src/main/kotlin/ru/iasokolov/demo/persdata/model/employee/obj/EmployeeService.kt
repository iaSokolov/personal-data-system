package ru.iasokolov.demo.persdata.model.employee.obj

import com.fasterxml.uuid.Generators
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository
) {
    fun getById(id: UUID): Employee? =
        employeeRepository.findByIdOrNull(id)

    fun getAll(): List<Employee> =
        employeeRepository.findAll()

    fun create() = Employee(
        id = Generators.timeBasedEpochGenerator().generate(),
        deleted = false,
        attributes = mutableListOf()
    )

    @Transactional
    fun save(employee: Employee): Employee = employeeRepository.save(employee)
}