package ru.iasokolov.demo.persdata.model.common

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import java.io.Serializable
import java.time.LocalDate
import java.util.*

@MappedSuperclass
abstract class RecordBase(
    @Id
    @Column(name = "id")
    var id: UUID,

    @Column(name = "object_id")
    val objectId: UUID,

    @Column(name = "start_date")
    val startDate: LocalDate,

    @Column(name = "end_date")
    val endDate: LocalDate,

    @Column(name = "deleted")
    var deleted: Boolean,

    @Column(name = "op_id_msr", nullable = false)
    val opIdMsr: Int,

    @Column(name = "op_id_in", nullable = false)
    val opIdIn: Int,

    @Column(name = "op_id_out")
    var opIdOut: Int? = null,

    @Column(name = "type")
    val type: String,
) : Serializable