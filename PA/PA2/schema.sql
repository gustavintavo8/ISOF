DROP TABLE IF EXISTS HistorialMedico;
DROP TABLE IF EXISTS Cita;
DROP TABLE IF EXISTS Paciente;
DROP TABLE IF EXISTS Medico;

CREATE TABLE Paciente (
    idPaciente INTEGER PRIMARY KEY,
    numeroHistoriaMedica VARCHAR(20) UNIQUE NOT NULL,
    tarjetaSanitaria VARCHAR(20) UNIQUE NOT NULL,
    numeroSeguridadSocial VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fechaNacimiento DATE
);

CREATE TABLE Medico (
    idMedico INTEGER PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    especialidad VARCHAR(30),
    tipoServicio VARCHAR(20),
    horarioInicio TIME,
    horarioFin TIME
);

CREATE TABLE Cita (
    idCita INTEGER PRIMARY KEY,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    idPaciente INTEGER,
    idMedico INTEGER,
    FOREIGN KEY (idPaciente) REFERENCES Paciente(idPaciente),
    FOREIGN KEY (idMedico) REFERENCES Medico(idMedico)
);

CREATE TABLE HistorialMedico (
    idHistorial INTEGER PRIMARY KEY,
    idPaciente INTEGER NOT NULL,
    idMedico INTEGER NOT NULL,
    fechaConsulta DATE NOT NULL,
    sintomas TEXT NOT NULL,
    diagnostico TEXT NOT NULL,
    tratamiento TEXT NOT NULL,
    FOREIGN KEY (idPaciente) REFERENCES Paciente(idPaciente),
    FOREIGN KEY (idMedico) REFERENCES Medico(idMedico)
);