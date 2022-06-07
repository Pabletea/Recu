import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecuTest {


    Examen examen = new Examen();

    // TIP:
    // Para obtener la lista de personas:
    //      examen.personas.getResults()
    // Para obtener una persona:
    //      examen.personas.getResults()[0]

    // TODO: (2,5 puntos) Piensa en que test son necesarios para probar la función "esIrlandes" y realizalos.
    //  Si la persona es null deberá devolver la excepción PersonaNulaException
    //  Si la "nat" no es "IE" pero vive en "Ireland", deberá devolver ErrorEnNacionalidadException
    //  Si la "nat" es "IE" pero no vive en "Ireland", deberá devolver ErrorEnNacionalidadException
    //  Asegurate que el 100% de pasar el test sobre el 100% de las personas disponibles.
    //  esIrlandes deberá devolver "true" si es irlandés. En caso contrario, "false"
    @Test
    public void testEsIrlandes_001() {
        // TODO 2p
        Persona p = examen.gestorDePersonas.getPersonas()[0];
        p.getLocation().setCountry("Ireland");
        Assertions.assertTrue(PersonasFun.Companion.esIrlandes(p));

    }

    @Test
    public void TestEsIrlandes_002(){
    Persona p = null;
    Assertions.assertThrows(PersonaNulaException.class, ()-> PersonasFun.Companion.esIrlandes(p));
    }

    @Test
    public void TestEsIrlandes_003(){
    Persona p = examen.gestorDePersonas.getPersonas()[0];
    p.getLocation().setCountry("Spain");
    p.setNat("IE");
    Assertions.assertThrows(ErrorEnNacionalidadException.class, ()-> PersonasFun.Companion.esIrlandes(p));
    }

    @Test
    public void TestEsIrlandes_004(){
        Persona p = examen.gestorDePersonas.getPersonas()[0];
        p.getLocation().setCountry("Ireland");
        p.setNat("DK");
        Assertions.assertThrows(ErrorEnNacionalidadException.class, ()-> PersonasFun.Companion.esIrlandes(p));
    }

    @Test
    public void TestEsIrlandes_005(){
        Persona p = examen.gestorDePersonas.getPersonas()[1];
        Assertions.assertTrue(PersonasFun.Companion.esIrlandes(p));
    }

    @Test
    public void TestEsIrlandes_006(){
        Persona p = examen.gestorDePersonas.getPersonas()[2];
        Assertions.assertFalse(PersonasFun.Companion.esIrlandes(p));
    }






}
