package ru.iasokolov.demo.persdata.model.labor.attr

import jakarta.persistence.*
import ru.iasokolov.demo.persdata.model.common.RecordBase
import ru.iasokolov.demo.persdata.model.employee.attr.EmployeeAttributeData
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "labor_attr")
@AttributeOverrides(
    value = [AttributeOverride(name = "objectId", column = Column(name = "labor_id"))]
)
class LaborAttribute(
    id: UUID,
    laborId: UUID,
    startDate: LocalDate,
    endDate: LocalDate,
    opIdMsr: Int,
    opIdIn: Int,
    opIdOut: Int? = null,
    deleted: Boolean = false,
    type: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(
        name = "data_id",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "fk_labor_attr__labor_attr_data")
    )
    val data: EmployeeAttributeData,
) : RecordBase(
    id = id,
    objectId = laborId,
    startDate = startDate,
    endDate = endDate,
    opIdMsr = opIdMsr,
    opIdIn = opIdIn,
    opIdOut = opIdOut,
    deleted = deleted,
    type = type
)