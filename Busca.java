import java.util.*;
public class Busca {
    public static List<No> expandir(No no, Problema problema) {
        List<No> sucessores = new ArrayList<>();
        no.estado.vizinhos.forEach((vizinho, custo) -> {
            Estado estadoVizinho = problema.estados.get(vizinho);
            int custoTotal = no.custo + custo;
            int profundidade = no.profundidade + 1;
            int heuristica = problema.heuristicas.get(vizinho);
            No novoNo = new No(estadoVizinho, no, custoTotal, profundidade, heuristica);
            sucessores.add(novoNo);
        });
        return sucessores;
    }

    public static List<String> reconstruirCaminho(No no) {
        List<String> caminho = new ArrayList<>();
        while (no != null) {
            caminho.add(0, no.estado.nome);
            no = no.pai;
        }
        return caminho;
    }

    public static List<String> buscaEmLargura(Problema problema) {
        Queue<No> fronteira = new LinkedList<>();
        Set<String> explorados = new HashSet<>();
        fronteira.add(new No(problema.estadoInicial, null, 0, 0, problema.heuristicas.get(problema.estadoInicial.nome)));

        while (!fronteira.isEmpty()) {
            No noAtual = fronteira.poll();
            if (noAtual.estado.nome.equals(problema.estadoObjetivo.nome)) {
                return reconstruirCaminho(noAtual);
            }
            explorados.add(noAtual.estado.nome);
            for (No filho : expandir(noAtual, problema)) {
                if (!explorados.contains(filho.estado.nome) && fronteira.stream().noneMatch(n -> n.estado.nome.equals(filho.estado.nome))) {
                    fronteira.add(filho);
                }
            }
        }
        return null;
    }

    public static List<String> buscaEmProfundidade(Problema problema) {
        Stack<No> fronteira = new Stack<>();
        Set<String> explorados = new HashSet<>();
        fronteira.push(new No(problema.estadoInicial, null, 0, 0, problema.heuristicas.get(problema.estadoInicial.nome)));

        while (!fronteira.isEmpty()) {
            No noAtual = fronteira.pop();
            if (noAtual.estado.nome.equals(problema.estadoObjetivo.nome)) {
                return reconstruirCaminho(noAtual);
            }
            if (!explorados.contains(noAtual.estado.nome)) {
                explorados.add(noAtual.estado.nome);
                for (No filho : expandir(noAtual, problema)) {
                    fronteira.push(filho);
                }
            }
        }
        return null;
    }


    // Busca de Custo Uniforme
    public static List<String> buscaDeCustoUniforme(Problema problema) {
        PriorityQueue<No> fronteira = new PriorityQueue<>(Comparator.comparingInt(n -> n.custo));
        fronteira.add(new No(problema.estadoInicial, null, 0, 0, 0));
        Set<String> explorados = new HashSet<>();

        while (!fronteira.isEmpty()) {
            No noAtual = fronteira.poll();
            if (noAtual.estado.nome.equals(problema.estadoObjetivo.nome)) {
                return reconstruirCaminho(noAtual);
            }
            explorados.add(noAtual.estado.nome);
            for (No filho : expandir(noAtual, problema)) {
                if (!explorados.contains(filho.estado.nome) && !fronteira.contains(filho)) {
                    fronteira.add(filho);
                } else if (fronteira.contains(filho) && filho.custo < noAtual.custo) {
                    fronteira.remove(filho);
                    fronteira.add(filho);
                }
            }
        }
        return null;
    }

    // Busca em Profundidade Limitada
    public static List<String> buscaEmProfundidadeLimitada(Problema problema, int limite) {
        Stack<No> fronteira = new Stack<>();
        fronteira.push(new No(problema.estadoInicial, null, 0, 0, problema.heuristicas.get(problema.estadoInicial.nome)));
        Set<String> explorados = new HashSet<>();

        while (!fronteira.isEmpty()) {
            No noAtual = fronteira.pop();
            if (noAtual.estado.nome.equals(problema.estadoObjetivo.nome)) {
                return reconstruirCaminho(noAtual);
            }
            if (noAtual.profundidade <= limite) {
                explorados.add(noAtual.estado.nome);
                for (No filho : expandir(noAtual, problema)) {
                    if (!explorados.contains(filho.estado.nome)) {
                        fronteira.push(filho);
                    }
                }
            }
        }
        return null;
    }

    // Busca em Profundidade Iterativa
    public static List<String> buscaEmProfundidadeIterativa(Problema problema) {
        for (int profundidade = 0; ; profundidade++) {
            List<String> resultado = buscaEmProfundidadeLimitada(problema, profundidade);
            if (resultado != null) {
                return resultado;
            }
        }
    }

    // Busca Gulosa
    public static List<String> buscaGulosa(Problema problema) {
        PriorityQueue<No> fronteira = new PriorityQueue<>(Comparator.comparingInt(n -> n.custoHeuristico));
        fronteira.add(new No(problema.estadoInicial, null, 0, 0, problema.heuristicas.get(problema.estadoInicial.nome)));
        Set<String> explorados = new HashSet<>();

        while (!fronteira.isEmpty()) {
            No noAtual = fronteira.poll();
            if (noAtual.estado.nome.equals(problema.estadoObjetivo.nome)) {
                return reconstruirCaminho(noAtual);
            }
            explorados.add(noAtual.estado.nome);
            for (No filho : expandir(noAtual, problema)) {
                if (!explorados.contains(filho.estado.nome)) {
                    fronteira.add(filho);
                }
            }
        }
        return null;
    }

    // Busca A*
    public static List<String> buscaAestrela(Problema problema) {
        PriorityQueue<No> fronteira = new PriorityQueue<>(Comparator.comparingInt(n -> n.custo + n.custoHeuristico));
        fronteira.add(new No(problema.estadoInicial, null, 0, 0, problema.heuristicas.get(problema.estadoInicial.nome)));
        Set<String> explorados = new HashSet<>();

        while (!fronteira.isEmpty()) {
            No noAtual = fronteira.poll();
            if (noAtual.estado.nome.equals(problema.estadoObjetivo.nome)) {
                return reconstruirCaminho(noAtual);
            }
            explorados.add(noAtual.estado.nome);
            for (No filho : expandir(noAtual, problema)) {
                if (!explorados.contains(filho.estado.nome)) {
                    fronteira.add(filho);
                } else if (fronteira.contains(filho) && filho.custo + filho.custoHeuristico < noAtual.custo + noAtual.custoHeuristico) {
                    fronteira.remove(filho);
                    fronteira.add(filho);
                }
            }
        }
        return null;
    }



}