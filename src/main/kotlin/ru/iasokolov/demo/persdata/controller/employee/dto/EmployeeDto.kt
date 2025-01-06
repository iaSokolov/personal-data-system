package ru.iasokolov.demo.persdata.controller.employee.dto

import ru.iasokolov.demo.persdata.model.employee.obj.Employee
import java.util.*

data class EmployeeDto(
    val id: UUID,
    val attr: List<EmployeeAttrDto>
) {
    constructor(employee: Employee) : this(
        id = employee.id,
        attr = employee.attributes.map { EmployeeAttrDto(it) }
    )
}