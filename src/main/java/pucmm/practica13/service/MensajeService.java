package pucmm.practica13.service;

import pucmm.practica13.model.Mensaje;


import java.util.List;

public interface MensajeService {

    void Crear(Mensaje l);
    void Actualizar(Mensaje l);
    void Borrar(Mensaje l);
    void BorrarTodos();
    List<Mensaje> BuscarTodos();
    Mensaje Buscar(long id);

}
