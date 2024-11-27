package ru.iasokolov.demo.persdata

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ru.iasokolov.demo.persdata.model.employee.attr.EmployeeAttribute
import ru.iasokolov.demo.persdata.model.employee.attr.EmployeeAttributeData
import ru.iasokolov.demo.persdata.model.employee.attr.EmployeeAttributeRepository
import ru.iasokolov.demo.persdata.model.employee.obj.Employee
import ru.iasokolov.demo.persdata.model.employee.obj.EmployeeRepository
import java.time.LocalDate
import java.util.*

@Component
class CLR(
    private val employeeRepository: EmployeeRepository,
    private val employeeAttributeRepository: EmployeeAttributeRepository,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val employeeId = UUID.randomUUID()
        val employee = Employee(
            id = employeeId,
            company = "TestCompany",
            deleted = false,
            attributes = mutableListOf()
        )

        val dataPeriodData = EmployeeAttributeData(
            id = UUID.randomUUID(),
            value = "Data from period"
        )

        val attrOldPeriod = EmployeeAttribute(
            id = UUID.randomUUID(),
            employeeId = employeeId,
            dataType = "1",
            opIdMsr = 1,
            opIdIn = 1,
            startDate = LocalDate.of(1987, 2, 25),
            endDate = LocalDate.of(9999, 12, 31),
            deleted = true,
            data = dataPeriodData
        )

        val attrNewPeriod = EmployeeAttribute(
            id = UUID.randomUUID(),
            employeeId = employeeId,
            dataType = "1",
            opIdMsr = 2,
            opIdIn = 2,
            startDate = LocalDate.of(1987, 2, 25),
            endDate = LocalDate.of(2025, 12, 31),
            deleted = false,
            data = dataPeriodData
        )

        employee.attributes.add(attrOldPeriod)
        employee.attributes.add(attrNewPeriod)

        employeeRepository.save(employee)
    }
}