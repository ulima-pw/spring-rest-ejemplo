package pe.edu.ulima.videojuegos.dao.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria", fetch = FetchType.EAGER)
    private List<VideojuegoEntity> videojuegos = new ArrayList<VideojuegoEntity>();

    public CategoriaEntity() {
    }

    public List<VideojuegoEntity> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(List<VideojuegoEntity> videojuegos) {
        this.videojuegos = videojuegos;
    }

    public CategoriaEntity(Long id, String nombre) {
        this.setId(id);
        this.setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}