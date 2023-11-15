package hilo;
/**
 * esta es la clase que hereda del Thread, en la que hay que implemenar el metodo run, y lo que hay dentro de ese metodo es lo qu
 * va a hacer el hilo
 */
public class ThreadPruebas extends Thread
{
	public ThreadPruebas(String prueba) 
	{
		super(prueba);
	}
	
	public void run() 
	{
		for(int i = 0; i < 5; i++) 
		{
			//todo esto es lo que se va a realizar dentro del hilo
			System.out.println(i + " " + getName());
			System.out.println("termino el thread " + getName());
		}
		
	}
}
