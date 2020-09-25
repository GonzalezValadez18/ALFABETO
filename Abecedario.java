/*Gonzalez Valadez Jose Leonardo
  3S11  
  Abecedario aleatorio y ordenado
*/
package abecedario;
import java.util.Scanner;
public class Abecedario {

    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       int edge=0,chose,pokeball;
       char roster[]=new char[26];
       //Abre bucle do-while que sirve para rotar el menu en las opciones diferentes a finalizarlo
       System.out.println("---***BIENVENIDO A LA PILA ABECEDARIO***---");
       do{
           System.out.println("1...Completar espacios vacios\n"
            + "2...Mostrar datos que hay en la pila\n"
            + "3...Eliminar ultimo elemento de la pila\n"
            + "4...Agregar un dato a la pila\n"
            + "5...Ordenar elementos de la pila alfabeticamente\n"
            + "6...Salir y terminar la ejecucion\n"
       + "\n***Seleccione el numero de la accion que desee realizar***\n");
       //Abre las opciones del menu con sus respectivos atributos y propiedades
       switch(chose=sc.nextInt()){
           case 1:
               //Coloca en los espacios vacios de la pila letras(a-z) de forma aleatoria
               if(edge<=26){
               System.out.println("---Se han rellenado los espacios vacios---\n");
               //por que recorrera la amplitud de la pila sin desbordarse
               for (int i = 0; edge < 26 ; i++) {
               //El metodo MathRandom coloca de asisgnar las letras aleatorias a cada espacio de la pila
               roster[edge]=(char)('a'+Math.random()*26);
               edge++;
               }}
               System.out.println("¿Deseas realizar alguna otra accion?");
               break;
           case 2:
               //Muestra los elementos de la pila mostrando la cima(edge) al principio
               System.out.println("---La pila tiene los siguientes datos--- \n");
               //for encargado de recorrer el arreglo desde el ultimo dato hasta el primero
               for (int i = edge-1 ; i >= 0; i--) {
                   System.out.print("  "+roster[i]);
               }
               System.out.println("\n¿Deseas realizar alguna otra accion?");
               break;
           case 3:
               //"elimina el ultimo dato de la pila"
               //Condicion (if) que detecta si la pila esta vacia
               if(edge>0)
               {
               System.out.println("---El ultimo dato ha sido eliminado de la pila---\n");
               //Se encarga de no mostrar el ultimo valor que tenia la pila
               edge--;
               }else{
                   System.out.println("-LO SIENTO LA PILA NO CONTIENE NINGUN ELEMENTO-");
               }             
               System.out.println("¿Deseas realizar alguna otra accion?");
               break;
           //Opcion de Agrgar un nuevo dato
           case 4:
               //Condicio(if) que evita ingresar mas datos de los que tiene disponibles la pila
               if(edge<26)
               {
               //Sobrescribe un dato manual en la posicion tope
               System.out.println("---Ingresa un caracter a la pila---\n");
               //Agrega manualmente el ususario un dato en la posicion cima(edge)
               roster[edge]=sc.next().charAt(0);
               edge++;
               }else{
                   System.out.println("-LO SIENTO LA PILA ESTA LLENA ELIMINA ALGUN ELEMENTO PARA CONTINUAR-");
               }
               System.out.println("¿Deseas realizar alguna otra accion?");
               break;
           //Opcion de ordenar los datos de m,anera alfabetica    
           case 5:
               System.out.println("---Los elementos de la pila se han ordenado---");
           //For anidados que recorreran el arreglo mediante el metodo burbuja de ordenamiento    
               for (int i = 0; i < 26; i++) {
                   for (int j = 0; j < i; j++) {
                       if (roster[i] < roster[j]) {//Si ultimo dato es menor a dato anterior
                     //Se van recorriendo las posiciones del arreglo de menor a mayor
                           pokeball=roster[i];
                           roster[i]=roster[j];
                           roster[j] = (char) pokeball;
                       }   }}
               System.out.println("¿Deseas realizar alguna otra accion?");
             break;
       }
      //Opciones que finalizan la ejecucion del programa (do-while)
       }while(chose !=6);
    }}
