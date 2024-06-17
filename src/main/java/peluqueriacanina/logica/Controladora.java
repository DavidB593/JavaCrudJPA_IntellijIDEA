package peluqueriacanina.logica;

import java.util.List;
import peluqueriacanina.persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis=new ControladoraPersistencia();

    public void guardar(String nombreMascota, String nombreDuenio, String alergico) {
        
        Duenio duenio=new Duenio();
        duenio.setNombreDuenio(nombreDuenio);
        
        Mascota masco=new Mascota();
        masco.setNombreMascota(nombreMascota);
        masco.setAlergico(alergico);
        masco.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio,masco);
        
        
    }

    public List<Mascota> traerMascotas() {
        
        return controlPersis.traerMascotas();
    
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMascota,
            String nombreDuenio, String alergico) {
        
        masco.setNombreMascota(nombreMascota);
        masco.setAlergico(alergico);
        
        //modifico mascota
        controlPersis.modificarMascota(masco);
        
        //asignar nuevos valores del duenio
        Duenio duenio = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        duenio.setNombreDuenio(nombreDuenio);
        
        //llamar al modificar duenio
        this.modificarDuenio(duenio);
        
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
    
}

