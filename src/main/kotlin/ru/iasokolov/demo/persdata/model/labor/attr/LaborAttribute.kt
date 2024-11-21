package ru.iasokolov.demo.persdata.model.labor.attr

import jakarta.persistence.*
import ru.iasokolov.demo.persdata.model.labor.obj.Labor
import java.time.LocalDate
import java.util.*

@Entity(name = "LaborAttribute")
@Table(name = "labor_attr")
class LaborAttribute(
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: UUID,

    @Column(name = "start_date")
    val startDate: LocalDate,

    @Column(name = "end_date")
    val endDate: LocalDate,

    @Column(name = "deleted")
    val deleted: Boolean,
) {
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "labor_id",
        foreignKey = ForeignKey(name = "fk_labor_attr__labor")
    )
    lateinit var labor: Labor
}