CREATE TABLE employee_attribute_data(
	id int4 NOT NULL,
	company varchar(10) NOT NULL,

	CONSTRAINT employee_attribute_data_pkey
	    PRIMARY KEY (id)
);

CREATE TABLE employee_attribute(
	id uuid NOT NULL,
	employee_id uuid NOT NULL,
	start_date date NULL,
	end_date date NULL,
	deleted bool NULL,
	op_id_in int4 NOT NULL,
	op_id_msr int4 NOT NULL,
	op_id_out int4 NOT NULL,
	data_id int4 NOT NULL,

	CONSTRAINT employee_attribute_pkey
	    PRIMARY KEY (id),

	CONSTRAINT employee_attribute__employee_fkey
        FOREIGN KEY(employee_id)
        REFERENCES employee(id),

    CONSTRAINT employee_attribute__employee_attribute_data_fkey
        FOREIGN KEY(data_id)
        REFERENCES employee_attribute_data(id)
);