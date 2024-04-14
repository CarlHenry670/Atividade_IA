import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> mapaRomenia = new HashMap<>();
        mapaRomenia.put("Arad", Map.of("Sibiu", 140, "Zerind", 75, "Timisoara", 118));
        mapaRomenia.put("Zerind", Map.of("Arad", 75, "Oradea", 71));
        mapaRomenia.put("Oradea", Map.of("Zerind", 71, "Sibiu", 151));
        mapaRomenia.put("Sibiu", Map.of("Arad", 140, "Oradea", 151, "Fagaras", 99, "Rimnicu Vilcea", 80));
        mapaRomenia.put("Timisoara", Map.of("Arad", 118, "Lugoj", 111));
        mapaRomenia.put("Lugoj", Map.of("Timisoara", 111, "Mehadia", 70));
        mapaRomenia.put("Mehadia", Map.of("Lugoj", 70, "Drobeta", 75));
        mapaRomenia.put("Drobeta", Map.of("Mehadia", 75, "Craiova", 120));
        mapaRomenia.put("Craiova", Map.of("Drobeta", 120, "Rimnicu Vilcea", 146, "Pitesti", 138));
        mapaRomenia.put("Rimnicu Vilcea", Map.of("Sibiu", 80, "Craiova", 146, "Pitesti", 97));
        mapaRomenia.put("Fagaras", Map.of("Sibiu", 99, "Bucharest", 211));
        mapaRomenia.put("Pitesti", Map.of("Rimnicu Vilcea", 97, "Craiova", 138, "Bucharest", 101));
        mapaRomenia.put("Bucharest", Map.of("Fagaras", 211, "Pitesti", 101, "Giurgiu", 90, "Urziceni", 85));
        mapaRomenia.put("Giurgiu", Map.of("Bucharest", 90));
        mapaRomenia.put("Urziceni", Map.of("Bucharest", 85, "Vaslui", 142, "Hirsova", 98));
        mapaRomenia.put("Hirsova", Map.of("Urziceni", 98, "Eforie", 86));
        mapaRomenia.put("Eforie", Map.of("Hirsova", 86));
        mapaRomenia.put("Vaslui", Map.of("Iasi", 92, "Urziceni", 142));
        mapaRomenia.put("Iasi", Map.of("Vaslui", 92, "Neamt", 87));
        mapaRomenia.put("Neamt", Map.of("Iasi", 87));

        Map<String, Integer> distancias = new HashMap<>();

        distancias.put("Arad", 366);
        distancias.put("Zerind", 374);
        distancias.put("Oradea", 380);
        distancias.put("Sibiu", 253);
        distancias.put("Timisoara", 329);
        distancias.put("Lugoj", 244);
        distancias.put("Mehadia", 241);
        distancias.put("Drobeta", 242);
        distancias.put("Craiova", 160);
        distancias.put("Rimnicu Vilcea", 193);
        distancias.put("Fagaras", 176);
        distancias.put("Pitesti", 100);
        distancias.put("Bucharest", 0);
        distancias.put("Giurgiu", 77);
        distancias.put("Urziceni", 80);
        distancias.put("Hirsova", 151);
        distancias.put("Eforie", 161);
        distancias.put("Vaslui", 199);
        distancias.put("Iasi", 226);
        distancias.put("Neamt", 234);

        Problema problema = new Problema(mapaRomenia, distancias, "Arad", "Bucharest");

    }
}