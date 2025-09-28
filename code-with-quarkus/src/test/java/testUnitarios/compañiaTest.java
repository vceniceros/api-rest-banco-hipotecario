package testUnitarios;

import io.smallrye.common.constraint.Assert;
import models.Compañia;
import org.junit.jupiter.api.Test;

public class compañiaTest {
    @Test
    public void test01SeCreaUnaCompañia(){
        Compañia compañia = new Compañia("nombre", "catchFrase", "bussinesStrategy");
        Assert.assertNotNull(compañia);
    }
}
