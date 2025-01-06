package ru.iasokolov.demo.persdata.controller.employee.dto

import ru.iasokolov.demo.persdata.model.employee.attr.EmployeeAttribute
import java.time.LocalDate
import java.util.*

data class EmployeeAttrDto(
    val id: UUID,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val opIdMsr: Int,
    val opIdIn: Int,
    val opIdOut: Int?,
    val deleted: Boolean,
    val type: String,
    val company: String,
) {
    constructor(attribute: EmployeeAttribute) : this(
        id = attribute.id,
        startDate = attribute.startDate,
        endDate = attribute.endDate,
        opIdMsr = attribute.opIdMsr,
        opIdIn = attribute.opIdMsr,
        opIdOut = attribute.opIdOut,
        deleted = attribute.deleted,
        type = attribute.type,
        company = attribute.data.company,
    )
}