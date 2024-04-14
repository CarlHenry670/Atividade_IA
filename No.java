
public class No {
    Estado estado;
    No pai;
    int custo;
    int profundidade;
    int custoHeuristico;

    public No(Estado estado, No pai, int custo, int profundidade, int custoHeuristico) {
        this.estado = estado;
        this.pai = pai;
        this.custo = custo;
        this.profundidade = profundidade;
        this.custoHeuristico = custoHeuristico;
    }

    
    public Estado getEstado() {
        return estado;
    }

    public No getPai() {
        return pai;
    }

    public int getCusto() {
        return custo;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public int getCustoHeuristico() {
        return custoHeuristico;
    }
}