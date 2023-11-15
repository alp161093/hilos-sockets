package hilo;
/**En estas clase implementamos Runnable por lo tanto solo tenemos que sobreescribir el metodo run y de esta forma
 * la clase puede heredar de otra clase.
 * 
 * */
public class ThreadPruebaRunnable implements Runnable{
	public void run() {
		for(int i = 0; i < 5; i++) {
			//en esta clase para intentar llegar a obtener el nombre tenemos que hacer referencia de forma estatica a la clase thread con el Thread.currentThread().getName() para obtener el nombre del hilo
			System.out.println("Indice: " + i + " Thread Name: " + Thread.currentThread().getName());
		}
	}
	
	
	public static void main(String[] args) {
		
		new Thread( new ThreadPruebaRunnable(), ("hilo 1")).start();
		new Thread( new ThreadPruebaRunnable(), ("hilo 2")).start();
		
		System.out.println("Ha terminado el main");
		
		
		

	}
}
