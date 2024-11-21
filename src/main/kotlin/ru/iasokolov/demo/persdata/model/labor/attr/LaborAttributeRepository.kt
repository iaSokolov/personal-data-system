package ru.iasokolov.demo.persdata.model.labor.attr

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LaborAttributeRepository: JpaRepository<LaborAttribute, UUID>