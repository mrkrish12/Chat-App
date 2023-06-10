package com.krishna.chatapp.network;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.krishna.chatapp.utils.ConfigReader;

public class Server {

	ServerSocket serverscoket;
	ArrayList<ServerWorker> workers = new ArrayList<>();
	
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		 serverscoket = new ServerSocket(PORT);
		 System.out.println("server stated and waiting for client");
		 handleClientRequest();
	}
	// to do muti client handshanking
	public void handleClientRequest() throws IOException {
		while(true)
		 {
		 Socket clientsocket =  serverscoket.accept();
		 ServerWorker serverworker = new ServerWorker(clientsocket,this);// to create a new thread
		 workers.add(serverworker);
		 serverworker.start();
		 }
	}
	
	
	/*  Works for single client 
	
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		 serverscoket = new ServerSocket(PORT);
		 System.out.println("Server stated and waiting for response");
		 Socket socket =  serverscoket.accept();
		 System.out.println("clent comes in");
	InputStream in = socket.getInputStream();
	byte arr[] = in.readAllBytes();
	 String str = new String(arr);
	 System.out.println("Message recived from client:"+str);
	 in.close(); 
		 socket.close(); 
		 
	}*/
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        Server server = new Server();
	}

}
