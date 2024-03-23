package fontes;

public class Cavalo extends Thread {
    private String nomeCavalo;
    private Corrida corrida;
    private String caractere; // Caractere para representar o cavalo
    private static final int distancia = 100;

    // construtor da classe Cavalo
    public Cavalo(String nomeCavalo, Corrida corrida, String caractere) {
        this.nomeCavalo = nomeCavalo;
        this.corrida = corrida;
        this.caractere = caractere;
    }

    public void run() {
        // for para a corrida do cavalo
        for (int i = 0; i < distancia; i++) {
            try {
                Thread.sleep((long) (Math.random() * 150));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(caractere); // caractere para representar o cavalo
        }

        // sincroniza para garantir que os cavalos passaram na linha de chegada um por
        // vez
        synchronized (this) {
            // informa que tal cavalo cruzou a linha de chegada
            corrida.cruzouLinhaChegada(nomeCavalo);
        }
    }
}
