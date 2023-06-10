package com.krishna.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame{
	int couter;
	public UserView() {
		couter =0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setResizable(false);
		setTitle("Login");
		setLocationRelativeTo(null);
		JLabel welcome = new JLabel("Login");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
			Container container =this.getContentPane();
			container.setLayout(null);
			welcome.setBounds(200,70,300,60);
			container.add(welcome);
			JButton button = new JButton("Count");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event){
				couter++;
				welcome.setText("Count"+ couter);
				}
			});
			button.setBounds(100,300,200,50);
			
			container.add(button);
		setVisible(true);
		
          
	}
	
	public static void main(String[] args){
		UserView userview = new UserView();
	}

}
