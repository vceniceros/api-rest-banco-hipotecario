package testUnitarios;

import io.smallrye.common.constraint.Assert;
import models.Direccion;
import models.Geo;
import org.junit.jupiter.api.Test;

public class direccionTest {
    @Test
    public void test01SeCreaUnaDireccion(){
        Geo geo = new Geo(11.46, 35.48);
        Direccion direccion = new Direccion("calle", "suite", "ciudad", "codigoPostal", geo);
        Assert.assertNotNull(direccion);
    }

    @Test
    public void test02SeCreaUnaDireccionIncluyendoGeoLocalizacion(){
        Geo geo = new Geo(11.46, 35.48);
        Direccion direccion = new Direccion("calle", "suite", "ciudad", "codigoPostal", geo);
        Assert.assertTrue(direccion.obtenerLatitud().equals(11.46) && direccion.obtenerLogitud().equals(35.48));
    }
}
