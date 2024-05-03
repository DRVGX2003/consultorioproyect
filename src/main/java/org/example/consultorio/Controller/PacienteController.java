package org.example.consultorio.Controller;

import jakarta.persistence.SqlResultSetMapping;
import org.example.consultorio.Model.Paciente;
import org.example.consultorio.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteService.obtenerTodosLosPacientes();
    }

    @GetMapping("/{id}")
    public Paciente obtenerPacientePorId(@PathVariable Long id) {
        return pacienteService.obtenerPacientePorId(id);
    }

    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping("/{id}")
    public Paciente actualizarPaciente(@PathVariable Long id, @RequestBody Paciente datosActualizados) {
        return pacienteService.actualizarPaciente(id, datosActualizados);
    }

    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
    }
}

