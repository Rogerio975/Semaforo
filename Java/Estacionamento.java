package Java;
import java.util.concurrent.Semaphore;

public class Estacionamento {
    // Capacidade máxima de 3 carros
    private static final Semaphore vagas = new Semaphore(3);

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new Carro(i).start();
        }
    }

    static class Carro extends Thread {
        private final int id;

        Carro(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println("Carro " + id + " tentando estacionar.");

                // Adquirindo uma vaga no estacionamento
                vagas.acquire();
                
                System.out.println("Carro " + id + " estacionou.");
                Thread.sleep(3000);  // Simula o tempo de permanência no estacionamento
                
                System.out.println("Carro " + id + " saindo do estacionamento.");
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Liberando a vaga no estacionamento
                vagas.release();
            }
        }
    }
}