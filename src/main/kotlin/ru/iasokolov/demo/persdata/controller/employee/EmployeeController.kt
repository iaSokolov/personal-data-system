package ru.iasokolov.demo.persdata.controller.employee

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.iasokolov.demo.persdata.controller.employee.dto.EmployeeDto
import ru.iasokolov.demo.persdata.model.employee.obj.EmployeeService
import java.util.*

@RestController
@RequestMapping("/employees")
class EmployeeController(
    private val employeeService: EmployeeService
) {
    @GetMapping(value = ["", "/"])
    fun getAll(): ResponseEntity<List<EmployeeDto>> =
        employeeService.getAll()
            .takeIf { it.isNotEmpty() }
            ?.map { EmployeeDto(it) }
            ?.let { ResponseEntity(it, HttpStatus.OK) }
            ?: ResponseEntity(HttpStatus.NOT_FOUND)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): ResponseEntity<EmployeeDto> =
        employeeService.getById(id = id)
            ?.let { ResponseEntity(EmployeeDto(it), HttpStatus.OK) }
            ?: ResponseEntity(HttpStatus.NOT_FOUND)
}