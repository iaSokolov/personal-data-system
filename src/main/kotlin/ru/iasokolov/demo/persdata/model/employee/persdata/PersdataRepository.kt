package ru.iasokolov.demo.persdata.model.employee.persdata

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersdataRepository: JpaRepository<Persdata, UUID>