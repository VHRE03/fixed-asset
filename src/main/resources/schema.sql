-- Borrar tablas si existen (útil para entorno local)
DROP TABLE IF EXISTS departments CASCADE;
DROP TABLE IF EXISTS employees CASCADE;

-- Crear las tablas
CREATE TABLE departments
(
    id               uuid      NOT NULL,
    "name"           varchar   NOT NULL,
    cost_center_code varchar   NOT NULL,
    created_at       timestamp NOT NULL,
    updated_at       timestamp NOT NULL,
    deleted_at       timestamp,
    CONSTRAINT departments_pkey PRIMARY KEY (id)
);

CREATE TABLE employees
(
    id              uuid      NOT NULL,
    department_id   uuid      NOT NULL,
    employee_number varchar   NOT NULL,
    first_name      varchar   NOT NULL,
    last_name       varchar   NOT NULL,
    email           varchar   NOT NULL,
    created_at      timestamp NOT NULL,
    updated_at      timestamp NOT NULL,
    deleted_at      timestamp,
    CONSTRAINT employees_pkey PRIMARY KEY (id),
    CONSTRAINT employees_department_id_fkey FOREIGN KEY (department_id) REFERENCES departments (id)
);