package Java;
import java.util.concurrent.Semaphore;

public class ExemploSemaforo {
    // Inicializando um semáforo com valor 2 (permite até 2 threads simultâneas)
    private static final Semaphore semaforo = new Semaphore(2);

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(new Tarefa(i));
            t.start();
        }
    }

    static class Tarefa implements Runnable {
        private final int id;

        Tarefa(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread " + id + " tentando acessar o recurso.");
                
                // Adquirindo o semáforo
                semaforo.acquire();
                
                System.out.println("Thread " + id + " acessando o recurso.");
                Thread.sleep(2000); // Simula operação
                System.out.println("Thread " + id + " liberando o recurso.");
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Liberando o semáforo
                semaforo.release();
            }
        }
    }
}