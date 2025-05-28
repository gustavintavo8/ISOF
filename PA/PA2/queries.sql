-- Consulta 1: Listar las citas de un paciente con el nombre del médico que lo atendio
SELECT 
    Cita.fecha,
    Cita.hora,
    Paciente.nombre AS nombre_paciente,
    Paciente.apellido AS apellido_paciente,
    Medico.nombre AS nombre_medico,
    Medico.apellido AS apellido_medico
FROM
    Cita
JOIN
    Paciente ON Cita.idPaciente = Paciente.idPaciente
JOIN
    Medico ON Cita.idMedico = Medico.idMedico
WHERE
    Cita.idPaciente = 1
ORDER BY
    Cita.fecha, Cita.hora;

-- Consulta 2: Mostrar el historial medico de un paciente con diagnostico y tratamiento
SELECT 
    Paciente.nombre AS nombre_paciente,
    Paciente.apellido AS apellido_paciente,
    HistorialMedico.fechaConsulta,
    HistorialMedico.sintomas,
    HistorialMedico.diagnostico,
    HistorialMedico.tratamiento,
    Medico.nombre AS nombre_medico,
    Medico.apellido AS apellido_medico
FROM 
    HistorialMedico
JOIN 
    Paciente ON HistorialMedico.idPaciente = Paciente.idPaciente
JOIN 
    Medico ON HistorialMedico.idMedico = Medico.idMedico
WHERE 
    HistorialMedico.idPaciente = 1
ORDER BY 
    HistorialMedico.fechaConsulta;


-- Consulta 3: Listar los pacientes que han sido atendidos por un medicoç
SELECT 
    Paciente.nombre AS nombre_paciente,
    Paciente.apellido AS apellido_paciente,
    Medico.nombre AS nombre_medico,
    Medico.apellido AS apellido_medico
FROM
    Cita
JOIN
    Paciente ON Cita.idPaciente = Paciente.idPaciente
JOIN
    Medico ON Cita.idMedico = Medico.idMedico
WHERE
    Cita.idMedico = 1

