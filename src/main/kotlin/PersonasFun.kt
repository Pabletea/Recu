class DocumentoInvalidoException: Exception()
class PassInvalidaException: Exception()

class PersonasFun {

    companion object {

        fun esEspanol(persona: Persona) : Boolean {
            if (persona.id.name != "DNI") return false
            if (persona.id.value != null) return true
            else throw DocumentoInvalidoException()
        }

        fun passSegura(persona: Persona) : Boolean {
            return passSegura(persona.login.password)
        }

        private fun passSegura(pass: String?) : Boolean {
            if (pass.isNullOrBlank()) throw PassInvalidaException()
            val regex = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}\$".toRegex()
            return regex.containsMatchIn(pass)
        }


        fun esIrlandes(persona: Persona?) : Boolean {
            if (persona == null)
                throw PersonaNulaException()
            if (persona.location.country == "Ireland" && persona.nat != "IE" || persona.location.country != "Ireland" && persona.nat == "IE")
                throw ErrorEnNacionalidadException()
            else
                return persona.nat == "IE"
        }
    }


}