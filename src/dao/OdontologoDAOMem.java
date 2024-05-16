package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDAOMem implements iDao<Odontologo> {

    private static Integer contadorId = 1;

    private static final Logger logger= Logger.getLogger(OdontologoDAOMem.class);
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(contadorId);
        contadorId++;
        BD.listaDeOdontologos.add(odontologo);
        logger.info("Odontologo guardado con exito en la lista");
        return odontologo;
    }

    @Override
    public Odontologo buscarPorID(Integer id) {
        return null;
    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Lista de odontologos obtenida con exito");
        return BD.listaDeOdontologos;
    }
}
