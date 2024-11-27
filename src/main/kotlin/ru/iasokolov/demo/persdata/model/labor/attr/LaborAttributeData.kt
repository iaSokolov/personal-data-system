package ru.iasokolov.demo.persdata.model.labor.attr

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "labor_attr_data")
class LaborAttributeData(
    @Id
    @Column(name = "id")
    var id: UUID,

    @Column(name = "group_id")
    val groupId: String,
)