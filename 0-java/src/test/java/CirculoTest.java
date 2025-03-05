import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.digitechfp.curso_ad.Circulo;

public class CirculoTest
{
    @Test
    public void testArea() {
        Circulo circulo = new Circulo(5);
        double resultado = circulo.area();
        assertEquals(78.53981633974483, resultado, 0.0001);
    }

    @Test
    public void testPerimetro() {
        Circulo circulo = new Circulo(5);
        double resultado = circulo.perimetro();
        assertEquals(31.41592653589793, resultado, 0.0001);
    }

    @Test
    public void testDiametro() {
        Circulo circulo = new Circulo(5);
        double resultado = circulo.diametro();
        assertEquals(10.0, resultado, 0.0001);
    }
}
