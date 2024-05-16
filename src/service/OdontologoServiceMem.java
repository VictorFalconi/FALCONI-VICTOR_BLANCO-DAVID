package service;

import dao.OdontologoDAOMem;
import dao.iDao;
import model.Odontologo;

import java.util.List;

public class OdontologoServiceMem {
    private iDao<Odontologo> odontologoiDao;

    public OdontologoServiceMem(){
        odontologoiDao = new OdontologoDAOMem();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoiDao.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologos() {
        return odontologoiDao.buscarTodos();
    }
}
