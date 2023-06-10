package com.krishna.chatapp.network;
// thread == worker here
//public class ServerWorker implements Runnable{

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorker extends Thread{
	 private Socket clientsocket;
	 private InputStream in;
	 private OutputStream out;
	 private Server server;
	 public ServerWorker(Socket clientsocket, Server server) throws IOException {
		this.clientsocket = clientsocket;
		this.server = server;
		in=clientsocket.getInputStream();
		out = clientsocket.getOutputStream();
		System.out.println("new client entered");
	}
	 
	@Override
	public void run() {
		// task to be done
		//read data from client and broadcast data to all
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
		while(true) {
				line = br.readLine();
				if(line.equalsIgnoreCase("quit")) {
					break;
				}
//				out.write(line.getBytes());
			for(ServerWorker serverWorker:server.workers) {
				line=line+"\n";
				serverWorker.out.write(line.getBytes());
				
			}
		}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
			if(br!=null)
			{
				br.close();
			}
			if(in!=null)
			{
				in.close();
			}
			if(out!=null)
			{
				out.close();
			}
			if(clientsocket!=null)
			{
				clientsocket.close();
			}} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
	}

}
