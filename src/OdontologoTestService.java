import dao.BD;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

public class OdontologoTestService {

    @Test
    public void guardarOdontologo() {
        BD.crearTablas();
        Odontologo odontologo = new Odontologo("ABC3212", "Jose", "Rojas");
        OdontologoService odontologoService = new OdontologoService();
        Assertions.assertTrue(odontologoService.guardarOdontologo(odontologo) instanceof Odontologo);
    }

    @Test
    public void listarOdontologos() {
        OdontologoService odontologoService = new OdontologoService();
        Assertions.assertTrue(odontologoService.listarOdontologos() instanceof List<Odontologo>);
    }
}
