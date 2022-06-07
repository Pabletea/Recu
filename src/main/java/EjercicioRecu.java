public class EjercicioRecu {

    // TODO Completa todas las funciones que aparecen en este fichero.
    //  Realiza todos los test que prueben esas funciones
    public GestorDePersonas gestorDePersonas;

    public EjercicioRecu() {
        gestorDePersonas = ObtenerPersonasRequest.Companion.get();
    }

    /**
     * Devuelve todas las personas que viven en España : location - city.
     *
     * @return Devuelve todas las personas que viven en España : location - city.
     */
    public Persona[] personasQueVivenEnSpain() {
        // TODO 1p
        Persona[] out = new Persona[gestorDePersonas.getPersonas().length];
        int encontrados = 0;


        for (Persona p : gestorDePersonas.getPersonas()) {
            if (p.getLocation().getCountry().contentEquals("Spain")) {
                out[encontrados] = p;
                encontrados++;
            }

        }
        Persona[] out2 = new Persona[encontrados];

        System.arraycopy(out, 0, out2, 0, encontrados);

        return out2;

    }

    /**
     * @param personas array de personas sobre el que debes buscar
     * @return Devuelve todas las personas que viven en España : location - city.
     */
    public Persona[] personasQueVivenEnSpain(Persona[] personas) {
        // TODO 1p
        return gestorDePersonas.getPersonas();
    }

    /**
     * @return Devuelve a la persona más vieja de todas (age)
     */
    public Persona personaMasVieja() {
        // TODO 1p
        Persona[] out = new Persona[1];
        int cont = 0;

        for (Persona p : gestorDePersonas.getPersonas()) {
            if (gestorDePersonas.getPersonas()[cont].getRegistered().getAge() > p.getRegistered().getAge()) {
                out[0] = p;

            }

        }

        return out[0];
    }


    /**
     * @return personas array de personas sobre el que debes buscar
     * @throws NoHayViejosException si todas las personas tienen menos de 18 años
     * @throws PersonaNulaException si alguna de las personas fuera null
     */
    public Persona edadDelMasViejo(Persona[] personas) throws NoHayViejosException, PersonaNulaException {
        // TODO 1p
        int encontrados = 0;
        int cont_null = 0;

        for (Persona p : personas) {
            if (p.getRegistered().getAge() < 18) {
                encontrados++;
            } else if (p == null) {
                throw new PersonaNulaException();
            }
        }

        if (encontrados == gestorDePersonas.getPersonas().length) {
            throw new NoHayViejosException();
        }


        return gestorDePersonas.getPersonas()[0];
    }

    /**
     * @return Devuelve todas las personas que viven en unas coordenadas comprendidas entre:
     * latitud -4 y 0
     * longitug 50 y 60
     */
    public Persona[] personasQueVivenEnCoordenadaFijas() {
        // TODO 1p
        Persona[] out = new Persona[gestorDePersonas.getPersonas().length];
        int encontrados = 0;
        for (Persona p : gestorDePersonas.getPersonas()) {
            if (Float.parseFloat(p.getLocation().getCoordinates().getLatitude()) > -4 && Float.parseFloat(p.getLocation().getCoordinates().getLatitude()) < 0) {
                if (Float.parseFloat(p.getLocation().getCoordinates().getLongitude()) > 50 && Float.parseFloat(p.getLocation().getCoordinates().getLongitude()) < 60) {
                    out[encontrados] = p;
                    encontrados++;
                }
            }
        }

        Persona[] out2 = new Persona[encontrados];

        System.arraycopy(out, 0, out2, 0, encontrados);

        return out2;


    }

    /**
     * @param personas       array de personas sobre el que debes buscar
     * @param latitudMaxima  coordenada sobre la que buscar
     * @param latitudMinima  coordenada sobre la que buscar
     * @param longitudMaxima coordenada sobre la que buscar
     * @param longitudMinima coordenada sobre la que buscar
     * @return Devuelve todas las personas que viven en unas coordenadas comprendidas entre:
     * latitudMaxima y latitudMinima
     * longitudMaxima y longitudMinima
     * @throws PersonaNulaException            si alguna de las personas fuera null
     * @throws CoordenadaIncompatibleException si alguna de las coordenadas tuviera un mínimo superior al máximo
     */
    public Persona[] personasQueVivenEnCoordenadaFijas(Persona[] personas, float latitudMaxima, float latitudMinima, float longitudMaxima, float longitudMinima) throws PersonaNulaException, CoordenadaIncompatibleException {
        // TODO 2p
        Persona[] out = new Persona[personas.length];
        int encontrados = 0;
        for (Persona p : personas) {
            if (p == null) {
                throw new PersonaNulaException();
            }
            if (latitudMinima > latitudMaxima) {
                throw new CoordenadaIncompatibleException();
            } else if (longitudMinima > longitudMaxima) {
                throw new CoordenadaIncompatibleException();
            }


            if (Float.parseFloat(p.getLocation().getCoordinates().getLatitude()) > latitudMinima && Float.parseFloat(p.getLocation().getCoordinates().getLatitude()) < latitudMaxima) {
            } else {

            }
            if (Float.parseFloat(p.getLocation().getCoordinates().getLongitude()) > longitudMinima && Float.parseFloat(p.getLocation().getCoordinates().getLongitude()) < longitudMaxima) {
                out[encontrados] = p;
                encontrados++;
            }
        }


        Persona[] out2 = new Persona[encontrados];

        System.arraycopy(out,0,out2,0,encontrados);

        return out2;


    }
}
