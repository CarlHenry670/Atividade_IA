import java.util.*;

public class Estado {
    String nome;
    Map<String, Integer> vizinhos;

    public Estado(String nome, Map<String, Integer> vizinhos) {
        this.nome = nome;
        this.vizinhos = vizinhos;
    }

    public String getNome() {
        return nome;
    }

    public Map<String, Integer> getVizinhos() {
        return new HashMap<>(vizinhos); 
    }
}