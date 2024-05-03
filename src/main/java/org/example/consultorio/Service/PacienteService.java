package org.example.consultorio.Service;

import org.example.consultorio.Model.Paciente;
import org.example.consultorio.Repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente obtenerPacientePorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente actualizarPaciente(Long id, Paciente datosActualizados) {
        Paciente pacienteExistente = obtenerPacientePorId(id);
        if (pacienteExistente != null) {
            pacienteExistente.setNombre(datosActualizados.getNombre());
            pacienteExistente.setCorreoElectronico(datosActualizados.getCorreoElectronico());
            pacienteExistente.setTelefono(datosActualizados.getTelefono());
            pacienteExistente.setDireccion(datosActualizados.getDireccion());
            return pacienteRepository.save(pacienteExistente);
        }
        return null;
    }
}
