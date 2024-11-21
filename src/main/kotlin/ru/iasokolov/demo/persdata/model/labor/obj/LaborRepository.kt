package ru.iasokolov.demo.persdata.model.labor.obj

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LaborRepository: JpaRepository<Labor, UUID>