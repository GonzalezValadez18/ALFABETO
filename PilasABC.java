/*
   Gonzalez Valadez Jose Leonardo
   3S11
 */
// Use \033[35m para poner los resultados y entradas de color morado
package pilasabc;

import java.util.Scanner;

public class PilasABC {
//Se declaran los arreglo de las 3 pilas diferentes

    int edge = 0, lim = 0, guard = 0;
    int pila64[] = new int[1000000];
    int pilamelee[] = new int[1000000];
    int pilabrawl[] = new int[1000000];

    public void Llenar(int dk) {
        //if para determinar si las pilas no estan llenas ya
        if ((edge & lim) < dk) {
            System.out.println("\033[35mLas Pilas A y B se han llenado con numeros aleatorios");
            for (int i = 0; edge < dk; i++) {
                //El metodo MathRandom coloca de asisgnar numeros aleatorios a cada espacio de la pila
                pila64[edge] = (int) (Math.random() * 100);
                edge++;
            }

            for (int i = 0; lim < dk; i++) {
                //El metodo MathRandom coloca de asisgnar numeros aleatorios iniciando en 100 a cada espacio de la pila
                pilamelee[lim] = (int) (100 + Math.random() * 100);
                lim++;
            }
        } else {
            System.out.println("\033[35mLa pila ya esta llena");
        }
        System.out.print("***¿DESEAS REALIZAR ALGUNA OTRA ACCION?***\n");
    }

    public void Mostrar() {
        //if para mostar solo si las pilas estan llenas y si no arroja mensaje
        if ((edge & lim) > 0) {
            System.out.println("\033[35m---La pila A tiene los siguientes datos (1-100)---");
            //for encargado de recorrer el arreglo desde el ultimo dato hasta el primero
            for (int i = edge - 1; i >= 0; i--) {
                System.out.print("\033[35m  " + pila64[i]);
            }
            System.out.println("\n\033[35m---La pila B tiene los siguientes datos (100-200)---");
            for (int i = lim - 1; i >= 0; i--) {
                System.out.print("\033[35m  " + pilamelee[i]);
            }
        } else {
            System.out.print("\033[35mNo hay Pilas A y B que mostrar");
        }
        System.out.print("\n***¿DESEAS REALIZAR ALGUNA OTRA ACCION?***\n");
    }

    public void Vaciar() {
        //if que no vacia las pilas si ya estan vacias
        if ((edge & lim) > 0) {
            //Con esta funcion  reicia los valores de la cima a 0 en los 3 arreglos
            System.out.println("\033[35mSe han vaciado los elementos de las pilas");
            edge = 0;
            lim = 0;
            guard = 0;
        } else {
            System.out.println("\033[35mLa pila esta vacia");
        }
        System.out.print("***¿DESEAS REALIZAR ALGUNA OTRA ACCION?***\n");
    }

    public void Unir(int dk) {
        //if para ver si existen pilas llenas para unir
        if ((edge & lim) > 0) {
            System.out.println("\033[35mSe han unido las pilas");
            //Aqui se crea la pila C sumando los valores de la pila A y B
            for (int i = 0; guard < dk; i++) {
                pilabrawl[i] = (pila64[i] + pilamelee[i]);
                guard++;
            }
        } else {
            System.out.println("\033[35m No hay pilas para unir");
        }
        System.out.print("***¿DESEAS REALIZAR ALGUNA OTRA ACCION?***\n");
    }

    public void MostrarBrawl() {
        //if que condiciona que ya hallan sido creadas las pilas A y B.
        if (guard > 0) {
            System.out.print("\033[35mLos datos de la pila C quedan de esta manera\n");
            //Muestra los datos de la Pila C Iniciando en la cima 
            for (int i = guard - 1; i >= 0; i--) {
                System.out.print("\033[35m  " + pilabrawl[i]);
            }
            System.out.print("\n");
        } else {
            System.out.println("\033[35m No hay Pila C que mostrar");
        }
        System.out.print("***¿DESEAS REALIZAR ALGUNA OTRA ACCION?***\n");
    }
//Inicia el modulo principal

    public static void main(String[] args) {
        Scanner entra = new Scanner(System.in);
        PilasABC Mac = new PilasABC();
        System.out.println("***---BIENVENIDO AL PROGRAMA---***");
        System.out.println("\033[35mIngrese cual sera el ancho de las pilas:");
        int dk = entra.nextInt();

        int chose;
        //Se abre menu do while y switch case.
        do {
            System.out.println("1 Llenar Pila A y B con numeros aleatorios\n"
                    + "2 Mostrar elementos Pila A y B\n"
                    + "3 Vaciar las Pilas A y B\n"
                    + "4 Unir los elementos de la Pila A y B en Pila C\n"
                    + "5 Mostrar el contenido de la Pila C\n"
                    + "5 Finalizar la ejecucion");
            switch (chose = entra.nextInt()) {
                //Cada caso depende del que sea elegido llamara al modulo correspondiente a su funcion.
                case 1:
                    Mac.Llenar(dk);
                    break;
                case 2:
                    Mac.Mostrar();
                    break;
                case 3:
                    Mac.Vaciar();
                    break;
                case 4:
                    Mac.Unir(dk);
                    break;
                case 5:
                    Mac.MostrarBrawl();
                    break;
            }
        } while (chose != 6);

    }
}
