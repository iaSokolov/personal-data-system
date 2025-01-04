package ru.iasokolov.demo.persdata.model.employee.attr

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "employee_attribute_data")
class EmployeeAttributeData(
    @Id
    @Column(name = "id")
    var id: UUID,

    @Column(name = "company")
    val company: String,
)