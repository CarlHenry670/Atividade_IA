import java.util.*;

public class Problema {
    Map<String, Estado> estados = new HashMap<>();
    Estado estadoInicial;
    Estado estadoObjetivo;
    Map<String, Integer> heuristicas = new HashMap<>();

    public Problema(Map<String, Map<String, Integer>> mapaRomenia, Map<String, Integer> distancias, String estadoInicial, String estadoObjetivo) {
        mapaRomenia.forEach((nome, vizinhos) -> {
            estados.put(nome, new Estado(nome, vizinhos));
        });
        this.estadoInicial = estados.get(estadoInicial);
        this.estadoObjetivo = estados.get(estadoObjetivo);
        this.heuristicas = distancias;
    }

}