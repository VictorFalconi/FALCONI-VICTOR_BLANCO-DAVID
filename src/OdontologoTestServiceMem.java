import dao.BD;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoServiceMem;

import java.util.List;

public class OdontologoTestServiceMem {

    @Test
    public void guardarOdontologo() {
        BD.agregarOdontologosLista();

        OdontologoServiceMem odontologoServiceMem = new OdontologoServiceMem();

        Assertions.assertTrue(
                odontologoServiceMem.guardarOdontologo(new Odontologo("DDD111","Marcos","Reina"))
                instanceof Odontologo);
    }

    @Test
    public void listarOdontologos() {
        OdontologoServiceMem odontologoServiceMem = new OdontologoServiceMem();

        Assertions.assertTrue(odontologoServiceMem.listarOdontologos() instanceof List<Odontologo>);
    }
}
