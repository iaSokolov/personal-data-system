package ru.iasokolov.demo.persdata.model.labor.obj

import jakarta.persistence.*
import ru.iasokolov.demo.persdata.model.labor.attr.LaborAttribute
import java.util.*

@Entity(name = "Labor")
@Table(name = "labor")
class Labor(
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: UUID,

    @Column(name = "deleted")
    var deleted: Boolean,

    @Column(name = "employee_id")
    val employeeId: String,

    @OneToMany(
        cascade = [CascadeType.ALL],
        targetEntity = LaborAttribute::class
    )
    var attributes: MutableList<LaborAttribute> = mutableListOf()
)