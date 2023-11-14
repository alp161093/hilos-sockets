package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable{
	
	private Socket clienteSocket;
	
	public Servidor(Socket clienteSocket) {
		this.clienteSocket = clienteSocket;
	}
	
	public static void main(String[] args) {
		
		try {
			//creacion de socket
			ServerSocket serverSocket = new ServerSocket(5001); 
			System.out.println("Servidor de Chat iniciado, esperando a cliente.....");
			int i = 0;
			
			while(true) {
				//ya esta a la escucha esperando a que se nos conecte un cliente
				Socket clienteSocket2 = serverSocket.accept();
				//cuado el cliete se ha conectado se salta a la siguiene linea
				System.out.println("Cliente conectado desde " + clienteSocket2.getInetAddress());
				
				i++;
				
				//ahora creamos un hilo para soltar a este cliente en ese hilo para volver a dejar en escuchar al servidor y poder atender a mas de un cliente a la vez
				new Thread(new Servidor(clienteSocket2), "Cliente " + i).start();
				//volvemos al inico del while y estamos esperando a un nuevo cliente
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		String inputLine;
		try {
			System.out.println("Abierto hilo");
			//creamos un buffer de escritura para poder escribir en el cliente
			PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
			//generamos un buffer de lectura para poder leer lo que nos indica el cliente
			BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
			
			out.println("Bienvenido al servidor para cerrar la conexion escriba 'q'");
			out.println("Dime algo");
			
			//nos quedamos a la espera de leer lo que nos dice
			while((inputLine = in.readLine()) != null) {
				System.out.println("Llego esto: " + inputLine);
				
				//para cortar la conexion con el servidor nos salimos cuando llegue "q"
				if(inputLine.equals("q")) {
					clienteSocket.close();
					out.println("Se ha salido del cliente");
					break;
				}
			}
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}