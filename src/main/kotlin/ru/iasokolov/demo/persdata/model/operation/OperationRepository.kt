package ru.iasokolov.demo.persdata.model.operation

import org.springframework.data.jpa.repository.JpaRepository

interface OperationRepository: JpaRepository<Operation, Int>