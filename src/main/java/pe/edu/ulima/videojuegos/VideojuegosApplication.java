package pe.edu.ulima.videojuegos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VideojuegosApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideojuegosApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner createCategorias(CategoriaRepository repo) {
        return new CommandLineRunner(){
        
            @Override
            public void run(String... args) throws Exception {
                repo.save(new CategoriaEntity(null, "Shooter"));
                repo.save(new CategoriaEntity(null, "RPG"));
                repo.flush();
            }
        };
    }

    @Bean
    public CommandLineRunner demo(VideojuegoRepository repoVJ, CategoriaRepository repoCat) {
        return new CommandLineRunner(){
        
            @Override
            public void run(String... args) throws Exception {
                CategoriaEntity shooter =repoCat.findByName("Shooter");

                if (shooter != null){
                    VideojuegoEntity vj1 = new VideojuegoEntity();
                    vj1.setNombre("Valorant");
                    vj1.setCategoria(shooter);
                    VideojuegoEntity vj2 = new VideojuegoEntity();
                    vj2.setNombre("PUBG");
                    vj2.setCategoria(shooter);
                    
                    repoVJ.save(vj1);
                    repoVJ.save(vj2);
                    repoVJ.flush();
                }
            }
        };
    }

    @Bean
    public CommandLineRunner demo2(VideojuegoRepository repoVJ, CategoriaRepository repoCat) {
        return new CommandLineRunner(){
        
            @Override
            public void run(String... args) throws Exception {
                CategoriaEntity shooter = repoCat.findByName("Shooter");
                List<VideojuegoEntity> videojuegos = shooter.getVideojuegos();
                for (VideojuegoEntity vj : videojuegos) {
                    System.out.println(vj.getNombre() + " - " + vj.getCategoria().getNombre() );
                }
            }
        };
    }*/

}
