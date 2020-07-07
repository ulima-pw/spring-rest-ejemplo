package pe.edu.ulima.videojuegos.dto;

import java.util.Optional;

public class VideojuegoDTO {
    private Optional<Long> id;
    private String nombre;
    private Long categoriaId;

    public VideojuegoDTO() {
    }

    public Optional<Long> getId() {
        return id;
    }

    public void setId(Optional<Long> id) {
        this.id = id;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}