import random
import time

import pandas as pd

def barraCarga(segundos):
    cont = 0
    while cont < segundos:
        print(".", end=' ')
        cont+=1
        time.sleep(1)

    print("")

def comprobarNumero(numero):
    if numero.isalpha():
        return False
    numero = int(numero)
    if numero > 9 or numero <= 0:
        return False

    return True

def trampeado():
    print("------Trampeado------")
    total = 0
    while total <= 50:
        numero = input("Escribe tu numero aqui\n")
        print("Tu dices " + numero)

        if comprobarNumero(numero):
            barraCarga(2)
            print("El ordenador dice : ", 10-int(numero))
            total = total + (10 - int(numero)) + int(numero)
            print("El total es: ", total)
        else:
            print("Me has introducido mal el numero")
    pass

def jugadaOrdenador():
    numero = random.randint(1, 9)
    print("El ordenador ha jugado el: ", numero)
    return numero

def basico():
    print("------Sin trampear------")

    total = 0
    while total <= 50:

        numero = input("Escribe tu numero aqui\n")
        if comprobarNumero(numero):
            total = total + int(numero)
            print("El total es : ",total)
            barraCarga(2)
            if total > 50:
                print(f"Perdiste {nombre}")
            else:
                numeroOrdenador = jugadaOrdenador()
                total = total + numeroOrdenador
            if total > 50:
                print(f"Ganaste {nombre}")

        print("Yo digo que el siguiente numero es ", total)
    pass

print("INSTRUCCIONES")
print("Cada jugador debe ir sumando un numero del 1 al 9 ")
print("Ganara el que consiga que el otro jugador se pase de 50")
print("!!Comenzamos!!")

nombre = input("Dime tu nombre\n")

print(f"Hola {nombre}")

total = 0

seleccion = input("A: Avanzado\n"
                  "B: Basico\n")

if seleccion == "A":
    trampeado()

elif seleccion == "B":
    basico()






