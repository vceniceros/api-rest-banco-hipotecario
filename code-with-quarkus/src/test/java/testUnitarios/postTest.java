package testUnitarios;

import io.smallrye.common.constraint.Assert;
import models.Post;
import org.junit.jupiter.api.Test;

public class postTest {
    @Test
    public void test01SeCreaUnPost(){
        Post post = new Post(1, 1, "post de prueba", "post de prueba");
        Assert.assertNotNull(post);
    }
}
