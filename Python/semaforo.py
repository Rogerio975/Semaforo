import threading
import time

# Inicializando um semáforo com valor 2
semaforo = threading.Semaphore(2)

def tarefa(id):
    print(f"Thread {id} esperando para acessar o recurso.")
    
    # Adquire o semáforo
    with semaforo:
        print(f"Thread {id} acessando o recurso.")
        time.sleep(2)  # Simula operação
        print(f"Thread {id} liberando o recurso.")

# Criando várias threads
threads = []
for i in range(5):
    t = threading.Thread(target=tarefa, args=(i,))
    threads.append(t)
    t.start()

# Aguarda a execução de todas as threads
for t in threads:
    t.join()