package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MovimientoRepository extends JpaRepository<Movimiento,Long> { List<Movimiento> findAllByOrderByFechaDescIdDesc(); List<Movimiento> findByMetaIdOrderByFechaDesc(Long metaId); }
