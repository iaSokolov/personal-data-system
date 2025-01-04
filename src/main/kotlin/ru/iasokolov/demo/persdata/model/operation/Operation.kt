package ru.iasokolov.demo.persdata.model.operation

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "operation")
class Operation(
    @Id
    @Column(name = "id")
    var id: Int,

    @Column(name = "operation_id")
    val operationId: UUID,

    @Column(name = "type")
    val type: String,
)