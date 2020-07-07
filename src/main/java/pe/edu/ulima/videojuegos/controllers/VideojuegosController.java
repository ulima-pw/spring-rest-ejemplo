package pe.edu.ulima.videojuegos.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.ulima.videojuegos.dao.entities.CategoriaEntity;
import pe.edu.ulima.videojuegos.dao.entities.VideojuegoEntity;
import pe.edu.ulima.videojuegos.dao.repositories.CategoriaRepository;
import pe.edu.ulima.videojuegos.dao.repositories.VideojuegoRepository;
import pe.edu.ulima.videojuegos.dto.VideojuegoDTO;

@Controller
@RequestMapping(value = "/videojuego")
public class VideojuegosController {

    @Autowired
    private VideojuegoRepository  repository;

    @Autowired
    private CategoriaRepository catRepo;

    // GET: Obtener una instancia
    // Se pasa data por path parameter
    // http://localhost:8080/videojuego/17
    @RequestMapping(value = "/{vid}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public VideojuegoDTO get(@PathVariable(name = "vid") String vid) {
        // Conectarme a la bd y obtener data del videojuego con id id
        System.out.println("Entra aca");
        VideojuegoEntity vj = repository.findById(Long.parseLong(vid)).get();
        VideojuegoDTO dto = new VideojuegoDTO();
        dto.setId(Optional.of(vj.getId()));
        dto.setNombre(vj.getNombre());
        dto.setCategoriaId(vj.getCategoria().getId());
        return dto;
    }

    // GET: Obtener varios videojuegos
    // http://localhost:8080/videojuego
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<VideojuegoDTO> getAll() {
        // Consulta a la bd para obtener todas las instancias
        List<VideojuegoDTO> vjs = new ArrayList<>();
        for (VideojuegoEntity entity : repository.findAll()) {
            VideojuegoDTO vj  = new VideojuegoDTO();
            vj.setId(Optional.of(entity.getId()));
            vj.setNombre(entity.getNombre());
            vj.setCategoriaId(entity.getCategoria().getId());
            vjs.add(vj);
        }
        return vjs;
    }

    // POST: registrar una instancia
    // [Cliente] ---> json [Servidor Backend]
    // http://localhost:8080/videojuego/ POST
    /* 
    {
        "nombre" : "RDR2",
        "categoriaId" : 1
    }
    */

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String post(@RequestBody VideojuegoDTO videojuego) {
        // Guardar en la bd el videojuego (nuevo)
        VideojuegoEntity vjEntity = new VideojuegoEntity();
        vjEntity.setNombre(videojuego.getNombre());

        Optional<CategoriaEntity> opCatEntity = catRepo.findById(videojuego.getCategoriaId());
        if (opCatEntity.isPresent()){
            // Existe una categoria con ese id.
            vjEntity.setCategoria(opCatEntity.get());
            repository.saveAndFlush(vjEntity);
            return "{'error': ''}";
        }else{
            return "{'error': 'No existe categoria'}";
        }
    }

    // PUT: actualizar una instancia
    // http://localhost:8080/videojuego/12 PUT
    /* 
    {
        "nombre" : "LOU2",
        "categoriaId" : 2
    }
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String put(@PathVariable String id, @RequestBody VideojuegoDTO videojuego) {
        Optional<VideojuegoEntity> opVJ = repository.findById(Long.parseLong(id));
        if (opVJ.isPresent()) {
            VideojuegoEntity vj = opVJ.get();
            vj.setNombre(videojuego.getNombre());
            
            Optional<CategoriaEntity> opCat = catRepo.findById(videojuego.getCategoriaId());
            if (opCat.isPresent()) {
                vj.setCategoria(opCat.get());
                repository.saveAndFlush(vj);
                return "{'error' : ''}";
            }else{
                return "{'error' : 'No existe categoria a actualizar'}";
            }
        }else{
            return "{'error' : 'No existe el videojuego'}";
        }
        
    }

    // DELETE: Eliminar una instancia
    // http://localhost:8080/videojuego/17
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String delete(@PathVariable String id) {
        Optional<VideojuegoEntity> opVJ = repository.findById(Long.parseLong(id));
        if (opVJ.isPresent()) {
            repository.delete(opVJ.get());
            repository.flush();
            System.out.println("OK");
            return "{'error' : ''}";
        }else {
            return "{'error' : 'No existe el videojuego a eliminar'}";
        }
    }

    
}