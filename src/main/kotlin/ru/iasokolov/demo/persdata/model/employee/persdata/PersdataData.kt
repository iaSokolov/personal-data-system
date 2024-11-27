package ru.iasokolov.demo.persdata.model.employee.persdata

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "persdata_data")
class PersdataData(
    @Id
    @Column(name = "id")
    var id: UUID,

    @Column(name = "first_name")
    val firstName: String,

    @Column(name = "last_name")
    val lastName: String
)