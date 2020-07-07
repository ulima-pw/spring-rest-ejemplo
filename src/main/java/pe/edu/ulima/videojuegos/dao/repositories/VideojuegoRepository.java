package pe.edu.ulima.videojuegos.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.ulima.videojuegos.dao.entities.VideojuegoEntity;

public interface VideojuegoRepository extends JpaRepository<VideojuegoEntity, Long>{
    
    
}