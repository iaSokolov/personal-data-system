package ru.iasokolov.demo.persdata.model.employee.obj

import jakarta.persistence.*
import ru.iasokolov.demo.persdata.model.employee.attr.EmployeeAttribute
import java.util.*

@Entity
@Table(name = "employee")
class Employee(
    @Id
    @Column(name = "id")
    var id: UUID,

    @Column(name = "deleted")
    val deleted: Boolean = false,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "employee_id")
    val attributes: MutableList<EmployeeAttribute> = mutableListOf()
)