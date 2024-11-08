import threading
import time

# Capacidade da sala
capacidade_sala = threading.Semaphore(3)

def entrar_sala(id):
    print(f"Pessoa {id} tentando entrar na sala.")
    capacidade_sala.acquire()
    print(f"Pessoa {id} entrou na sala.")
    time.sleep(3)
    print(f"Pessoa {id} saindo da sala.")
    capacidade_sala.release()

# Criando várias threads
pessoas = []
for i in range(5):
    p = threading.Thread(target=entrar_sala, args=(i,))
    pessoas.append(p)
    p.start()

# Aguarda todas as pessoas saírem da sala
for p in pessoas:
    p.join()