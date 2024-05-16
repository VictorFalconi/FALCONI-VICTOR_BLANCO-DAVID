package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo> {

    private static final String SQL_GUARDAR="INSERT INTO ODONTOLOGO (NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)";
    private static final String SQL_LISTAR="SELECT * FROM ODONTOLOGO";
    private static final Logger logger= Logger.getLogger(OdontologoDAOH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        try{
            logger.info("proceso de guardado de odontologo iniciado");
            connection = BD.getConnection();
            PreparedStatement psGuardar = connection.prepareStatement(SQL_GUARDAR, PreparedStatement.RETURN_GENERATED_KEYS);
            psGuardar.setString(1, odontologo.getNumeroMatricula());
            psGuardar.setString(2, odontologo.getNombre());
            psGuardar.setString(3, odontologo.getApellido());
            psGuardar.execute();
            ResultSet rs = psGuardar.getGeneratedKeys();
            while(rs.next()) {
                odontologo.setId(rs.getInt(1));
            }
            logger.info("odontologo guardado con exito");
        }catch(Exception e) {
            logger.warn(e.getMessage());
        }
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
        Connection connection = null;
        List<Odontologo> odontologoList = new ArrayList<Odontologo>();
        try {
            logger.info("Iniciado el proceso de listado");
            connection = BD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_LISTAR);
            while(rs.next()) {
                odontologoList.add(new Odontologo(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)));
            }
            logger.info("Listado con exito");

        } catch(Exception e) {
            logger.warn(e.getMessage());
        }
        return odontologoList;
    }
}
