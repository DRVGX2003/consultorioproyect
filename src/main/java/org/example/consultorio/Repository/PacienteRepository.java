package org.example.consultorio.Repository;
import org.example.consultorio.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
