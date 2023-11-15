package hilo;

public class Main {

	public static void main(String[] args) {
		/** En este proceso seguramente el mensaje de ""Ha terminado el main puede que sea lo primero en salir porque aunq los hilos esten funcionando
		 * *estan funcionando en paralelo al proceso principal que continua con su ejecucion
		 */
		new ThreadPruebas("hilo 1").start();
		new ThreadPruebas("hilo 2").start();
		
		System.out.println("Ha terminado el main");
		
		
		
		/** En esta parte de codigo lo tenemos funcionando con el la clase 
		 */
		
		

	}

}
