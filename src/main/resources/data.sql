INSERT INTO licencia_conductor (tipo_licencia, caducidad_licencia)
VALUES ('D', '2027-01-15');

INSERT INTO licencia_conductor (tipo_licencia, caducidad_licencia)
VALUES ('D+E', '2028-05-20');

INSERT INTO licencia_conductor (tipo_licencia, caducidad_licencia)
VALUES ('D', '2026-11-10');

INSERT INTO licencia_conductor (tipo_licencia, caducidad_licencia)
VALUES ('D1', '2029-02-01');

INSERT INTO conductor (nombre, apellidos, fecha_incorporacion, num_empleado, licencia_id, disponible, estado_conductor)
VALUES ('Carlos', 'García Ruiz', '2022-01-15', 'EMP001', 1, 1, 0);

INSERT INTO conductor (nombre, apellidos, fecha_incorporacion, num_empleado, licencia_id, disponible, estado_conductor)
VALUES ('Laura', 'Méndez Alba', '2023-05-20', 'EMP002', 2, 1, 1);

INSERT INTO conductor (nombre, apellidos, fecha_incorporacion, num_empleado, licencia_id, disponible, estado_conductor)
VALUES ('Javier', 'Pérez López', '2021-11-10', 'EMP003', 3, 0, 2);

INSERT INTO conductor (nombre, apellidos, fecha_incorporacion, num_empleado, licencia_id, disponible, estado_conductor)
VALUES ('Elena', 'Sanz Torres', '2024-02-01', 'EMP004', 4, 1, 0);
