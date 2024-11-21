package ru.iasokolov.demo.persdata.model.employee.obj

import jakarta.persistence.*
import ru.iasokolov.demo.persdata.model.employee.attr.EmployeeAttribute
import java.util.*

@Entity(name = "Employee")
@Table(name = "employee")
class Employee(
    @Id
    @Column(name = "id")
    var id: UUID,

    @Column(name = "company")
    val company: String,

    @Column(name = "deleted")
    val deleted: Boolean = false,

    @OneToMany(
        mappedBy = "employee",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        targetEntity = EmployeeAttribute::class
    )
    val attributes: MutableList<EmployeeAttribute> = mutableListOf()
)