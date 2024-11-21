package ru.iasokolov.demo.persdata.model.employee.obj

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EmployeeRepository: JpaRepository<Employee, UUID>