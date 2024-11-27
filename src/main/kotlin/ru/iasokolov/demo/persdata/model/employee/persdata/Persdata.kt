package ru.iasokolov.demo.persdata.model.employee.persdata

import jakarta.persistence.*
import ru.iasokolov.demo.persdata.model.common.RecordBase
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "persdata")
@AttributeOverrides(
    value = [AttributeOverride(name = "objectId", column = Column(name = "employee_id"))]
)
class Persdata(
    id: UUID,
    employeeId: UUID,
    startDate: LocalDate,
    endDate: LocalDate,
    opIdMsr: Int,
    opIdIn: Int,
    opIdOut: Int? = null,
    deleted: Boolean = false,
    dataType: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(
        name = "data_id",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "fk_persdata__persdata_data")
    )
    val data: PersdataData
): RecordBase(
    id = id,
    objectId = employeeId,
    startDate = startDate,
    endDate = endDate,
    opIdMsr = opIdMsr,
    opIdIn = opIdIn,
    opIdOut = opIdOut,
    deleted = deleted,
    dataType = dataType
)