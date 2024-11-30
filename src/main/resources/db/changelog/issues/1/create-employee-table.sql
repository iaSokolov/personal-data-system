CREATE TABLE employee (
	id uuid NOT NULL,
	company varchar(255) NULL,
	deleted bool NULL,
	CONSTRAINT employee_pkey PRIMARY KEY (id)
);