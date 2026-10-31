package proyecto_base.services;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class TraductorService {

    private final Map<String, String> diccionario;

    public TraductorService() {
        diccionario = new HashMap<>();
        diccionario.put(".-", "A");
        diccionario.put("-...", "B");
        diccionario.put("-.-.", "C");
        diccionario.put("-..", "D");
        diccionario.put(".", "E");
        diccionario.put("..-.", "F");
        diccionario.put("--.", "G");
        diccionario.put("....", "H");
        diccionario.put("..", "I");
        diccionario.put(".---", "J");
        diccionario.put("-.-", "K");
        diccionario.put(".-..", "L");
        diccionario.put("--", "M");
        diccionario.put("-.", "N");
        diccionario.put("---", "O");
        diccionario.put(".--.", "P");
        diccionario.put("--.-", "Q");
        diccionario.put(".-.", "R");
        diccionario.put("...", "S");
        diccionario.put("-", "T");
        diccionario.put("..-", "U");
        diccionario.put("...-", "V");
        diccionario.put(".--", "W");
        diccionario.put("-..-", "X");
        diccionario.put("-.--", "Y");
        diccionario.put("--..", "Z");
    }

    public String traducirMorse(String codigo) {
        // Normalizamos los espacios si vienen como %20 desde la URL
        codigo = codigo.replace("%20", " ");
        String resultado = "";

        // Separar palabras por 3 espacios
        String[] palabras = codigo.split("   ");

        for (String palabra : palabras) {
            // Separar caracteres por 1 espacio
            String[] caracteres = palabra.split(" ");

            for (String caracter : caracteres) {
                String letra = diccionario.get(caracter);
                if (letra != null) {
                    resultado += letra;
                }
            }
            // Agregar espacio entre palabras traducidas
            resultado += " ";
        }

        return resultado.trim();
    }
}
