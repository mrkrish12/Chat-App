package com.krishna.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.krishna.chatapp.utils.ConfigReader;

public class Client {
	Socket socket;
	OutputStream out;
	InputStream in;
	ClientWorker worker;
	JTextArea textarea;
	public Client(JTextArea textarea) throws UnknownHostException, IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket = new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
		out= socket.getOutputStream();
		in = socket.getInputStream();
		this.textarea=textarea;
		readMessages();
//		System.out.println("Client here");
//		System.out.println("Enter messgae send to server");
//		Scanner sc = new Scanner(System.in);
//		String mess = sc.nextLine();
//	OutputStream out = socket.getOutputStream();
//	out.write(mess.getBytes());
//	System.out.println("Message send");
//	sc.close();
//	out.close();
//		socket.close();
		
		
	}
	
	public void sendMessgae(String message) throws IOException {
		message = message +"\n";
		out.write(message.getBytes());
	}
	public void readMessages() {
		worker = new ClientWorker(in, textarea);//calling  a read thread
		worker.start();
	}
}
