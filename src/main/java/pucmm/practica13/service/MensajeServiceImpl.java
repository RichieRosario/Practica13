package pucmm.practica13.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.practica13.repository.MensajeRepository;
import pucmm.practica13.service.MensajeService;
import pucmm.practica13.model.Mensaje;


import javax.transaction.Transactional;
import java.util.List;

@Service("mensajeService")
@Transactional
public class MensajeServiceImpl implements MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public void Crear(Mensaje l){
        mensajeRepository.save(l);
    }
    public void Actualizar(Mensaje l){
        Crear(l);
    }
    public void Borrar(Mensaje l){
        l.setDeleted(true);
        Actualizar(l);
    }
    public void BorrarTodos(){
        mensajeRepository.deleteAll();
    }
    public List<Mensaje> BuscarTodos(){
        return mensajeRepository.findAll();
    }
    @Override
    public Mensaje Buscar(long id){
        return mensajeRepository.findById(id).get();
    }

    }
