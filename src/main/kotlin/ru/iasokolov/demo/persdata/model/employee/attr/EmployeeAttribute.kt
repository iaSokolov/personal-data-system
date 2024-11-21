package ru.iasokolov.demo.persdata.model.employee.attr

import jakarta.persistence.*
import ru.iasokolov.demo.persdata.model.employee.obj.Employee
import java.time.LocalDate
import java.util.UUID

@Entity(name = "EmployeeAttribute")
@Table(name = "employee_attribute")
class EmployeeAttribute(
    @Id
    @Column(name = "id")
    var id: UUID,

    @Column(name = "start_date")
    val startDate: LocalDate,

    @Column(name = "end_date")
    val endDate: LocalDate,

    @Column(name = "deleted")
    val deleted: Boolean = false,

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "employee_id",
        foreignKey = ForeignKey(name = "fk_employee_attr__employee")
    )
    val employee: Employee
)