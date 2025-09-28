package testUnitarios;

import io.smallrye.common.constraint.Assert;
import models.Geo;
import org.junit.jupiter.api.Test;

public class geoTest {
    @Test
    public void test01SeCreaUnaGeo(){
        Geo geo = new Geo(-45.3000, - 48.4888);
        Assert.assertNotNull(geo);
    }
}
