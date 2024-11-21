package ru.iasokolov.demo.persdata.model

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ru.iasokolov.demo.persdata.model.employee.attr.EmployeeAttribute
import ru.iasokolov.demo.persdata.model.employee.attr.EmployeeAttributeRepository
import ru.iasokolov.demo.persdata.model.employee.obj.Employee
import ru.iasokolov.demo.persdata.model.employee.obj.EmployeeRepository
import ru.iasokolov.demo.persdata.model.labor.attr.LaborAttributeRepository
import ru.iasokolov.demo.persdata.model.labor.obj.LaborRepository
import java.time.LocalDate
import java.util.*

@Component
class CLR(
    private val employeeAttributeRepository: EmployeeAttributeRepository,
    private val laborAttributeRepository: LaborAttributeRepository,
    private val laborRepository: LaborRepository,
    private val employeeRepository: EmployeeRepository,
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val firstEmployee = Employee(
            id = UUID.randomUUID(),
            company = "Company",
        )

        val attr1 = EmployeeAttribute(
            id = UUID.randomUUID(),
            startDate = LocalDate.of(1987, 2, 25),
            endDate = LocalDate.of(2000, 12, 31),
            deleted = false,
            employee = firstEmployee
        )

        val attr2 = EmployeeAttribute(
            id = UUID.randomUUID(),
            startDate = LocalDate.of(2021, 1, 1),
            endDate = LocalDate.of(9999, 12, 31),
            deleted = false,
            employee = firstEmployee
        )

        firstEmployee.attributes.add(attr1)
        firstEmployee.attributes.add(attr2)

        employeeRepository.save(firstEmployee)
//        employeeAttributeRepository.save(attr1)
//        employeeAttributeRepository.save(attr2)
    }
}