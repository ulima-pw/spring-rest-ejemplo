package pe.edu.ulima.videojuegos.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.ulima.videojuegos.dao.entities.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    @Query("SELECT c FROM CategoriaEntity c WHERE c.nombre=?1")
    CategoriaEntity findByName(String nombre);
}