package ru.iasokolov.demo.persdata.model.employee.attr

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EmployeeAttributeRepository: JpaRepository<EmployeeAttribute, UUID>