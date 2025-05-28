INSERT INTO Paciente (idPaciente, numeroHistoriaMedica, tarjetaSanitaria, numeroSeguridadSocial, nombre, apellido, fechaNacimiento)
VALUES 
    (1, 'HM123', 'TS001', 'SS123', 'Carlos', 'Perez', '1980-01-15'),
    (2, 'HM124', 'TS002', 'SS124', 'Maria', 'Gonzalez', '1975-03-22'),
    (3, 'HM125', 'TS003', 'SS125', 'Luis', 'Martinez', '1990-06-10'),
    (4, 'HM126', 'TS004', 'SS126', 'Ana', 'Lopez', '1985-08-30'),
    (5, 'HM127', 'TS005', 'SS127', 'Jorge', 'Fernandez', '1992-11-05'),
    (6, 'HM128', 'TS006', 'SS128', 'Lucia', 'Sanchez', '1988-12-17');

INSERT INTO Medico (idMedico, nombre, apellido, especialidad, tipoServicio, horarioInicio, horarioFin)
VALUES 
    (1, 'Juan', 'Sierra', 'Medicina Familiar', 'AP', '08:30', '14:00'),
    (2, 'Pedro', 'Gutierrez', 'Pediatría', 'AP', '08:00', '15:00'),
    (3, 'Laura', 'Mendez', 'Urgencias', 'SAC', '15:00', '22:00'),
    (4, 'Ana', 'Garcia', 'Radiología', 'AP', '08:00', '14:30'),
    (5, 'Luis', 'Perez', 'Pediatría', 'SAC', '09:00', '16:00'),
    (6, 'Sara', 'Gomez', 'Urgencias', 'SAC', '15:30', '22:30');

INSERT INTO Cita (idCita, fecha, hora, idPaciente, idMedico)
VALUES 
    (1, '2024-11-01', '09:00', 1, 1),
    (2, '2024-11-01', '09:05', 2, 1),
    (3, '2024-11-01', '09:10', 3, 1),
    (4, '2024-11-01', '10:00', 4, 2),
    (5, '2024-11-01', '10:05', 5, 2),
    (6, '2024-11-01', '16:00', 1, 3);

INSERT INTO HistorialMedico (idHistorial, idPaciente, idMedico, fechaConsulta, sintomas, diagnostico, tratamiento)
VALUES 
    (1, 1, 1, '2024-11-01', 'Dolor de cabeza', 'Migraña', 'Ibuprofeno'),
    (2, 2, 1, '2024-11-01', 'Dolor abdominal', 'Gastritis', 'Omeprazol'),
    (3, 3, 2, '2024-11-01', 'Tos y fiebre', 'Gripe', 'Paracetamol'),
    (4, 4, 2, '2024-11-01', 'Dolor de garganta', 'Faringitis', 'Amoxicilina'),
    (5, 5, 2, '2024-11-01', 'Congestión nasal', 'Resfriado común', 'Descongestionante'),
    (6, 1, 3, '2024-11-01', 'Dolor de pecho', 'Revisión de urgencia', 'Reposo');