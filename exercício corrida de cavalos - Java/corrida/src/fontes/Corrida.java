package fontes;

public class Corrida {
    private int numCavalos;
    private String[] nomesCavalos;
    private String[] nomesApost;
    private String[] caracteresCavalos; // caracteres para representar cada cavalo
    private Thread[] threadsCavalos;
    private int vencedor = -1;

    // construtor da classe Corrida
    public Corrida(int numCavalos, String[] nomesCavalos, String[] nomesApost, String[] caracteresCavalos) {
        this.numCavalos = numCavalos;
        this.nomesCavalos = nomesCavalos;
        this.nomesApost = nomesApost;
        this.caracteresCavalos = caracteresCavalos;
        this.threadsCavalos = new Thread[numCavalos]; // inicializa o array de threads com o número de cavalos
    }

    public void iniciarCorrida() {
        System.out.println("Inicia a corrida!");

        // for para criar um thread para cada cavalo
        for (int i = 0; i < numCavalos; i++) {
            threadsCavalos[i] = new Thread(new Cavalo(nomesCavalos[i], this, caracteresCavalos[i]));
            threadsCavalos[i].start();
        }

        try {
            for (Thread thread : threadsCavalos) {
                thread.join(); // espera todas as threads terminarem
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (vencedor != -1) {
            System.out.println("\nO vencedor da corrida é o cavalo " + nomesCavalos[vencedor]);
            System.out.println("O apostador vencedor é: " + nomesApost[vencedor]);
        }
    }

    public synchronized void cruzouLinhaChegada(String nomeCavalo) {
        if (vencedor == -1) {
            for (int i = 0; i < numCavalos; i++) {
                if (nomesCavalos[i].equals(nomeCavalo)) {
                    vencedor = i;
                    break;
                }
            }
        }
    }
}
