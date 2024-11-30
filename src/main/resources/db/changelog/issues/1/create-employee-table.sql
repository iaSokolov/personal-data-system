CREATE TABLE employee (
	id uuid NOT NULL,
	deleted bool NULL,
	CONSTRAINT employee_pkey PRIMARY KEY (id)
);