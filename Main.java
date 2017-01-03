import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	public static void main (String[] args){
		new Main().setVisible(true);
	}

	private Main() {
		super ("Tutorial - DVD");
		setSize(550,550);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new GridBagLayout());

		JButton button = new JButton("DVD");
		button.addActionListener(this);
		button.setActionCommand("DVD");
		add(button);
		

		
		JButton button1 = new JButton("DVDDD");
		button1.addActionListener(this);
		button1.setActionCommand("SJQ");
		add(button1);

		
		JButton button2 = new JButton("DDVDD");
		button2.addActionListener(this);
		add(button2);
		
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("file");
		JMenuItem newItem = new JMenuItem("New");
		JMenuItem newItem1 = new JMenuItem("bye bye");
		
		bar.add(file);
		file.add(newItem);
		file.addSeparator();
		file.add(newItem1);
		setJMenuBar(bar);
		
		
		//JTextArea text = new JTextArea();
		//add(text);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String name = e.getActionCommand();
		
		
		if(name.equals("SJQ"))
			System.out.println("Second Second");
		if(name.equals("DDVDD"))
			System.out.println("hahaha");
		if(name.equals("DVD")){
			System.out.println("DVD clicked");
			System.exit(0);
		}
	}

}
