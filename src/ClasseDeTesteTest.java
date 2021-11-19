import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ClasseDeTesteTest {
    ClasseDeTeste classeDeTeste = new ClasseDeTeste();

    @Test
    public void testCalculaPublic() {
        int result = classeDeTeste.calculaPublic(0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testCalculaPrivate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        ClasseDeTeste classeDeTeste = new ClasseDeTeste();

        Method notificador = ClasseDeTeste.class
                .getDeclaredMethod("calculaPrivate",
                        Integer.class,Integer.class);
        notificador.setAccessible(true);

        Object invoke = notificador.invoke(classeDeTeste, 1,1);

        Assert.assertThat(invoke,is(2));
    }


}
