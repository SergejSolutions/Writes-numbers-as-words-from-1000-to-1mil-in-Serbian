import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frmIspisUnetogBroja;
	private JTextField textField;
	public static List<BrojeviClass> people = new ArrayList<BrojeviClass>();
	public static JLabel labelIspis;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmIspisUnetogBroja.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIspisUnetogBroja = new JFrame();
		frmIspisUnetogBroja.setTitle("Ispis brojeva od 1000 - 1 000 000 recima");
		frmIspisUnetogBroja.setBounds(100, 100, 502, 371);
		frmIspisUnetogBroja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIspisUnetogBroja.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unesite broj : ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(40, 49, 170, 41);
		frmIspisUnetogBroja.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField.setBounds(190, 49, 215, 39);
		frmIspisUnetogBroja.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ispisi");
		
		btnNewButton.setBounds(288, 111, 105, 27);
		frmIspisUnetogBroja.getContentPane().add(btnNewButton);
		
	    labelIspis = new JLabel("");
		labelIspis.setBounds(40, 223, 435, 55);
		frmIspisUnetogBroja.getContentPane().add(labelIspis);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ispisiSlovima(Integer.parseInt(textField.getText()),Double.parseDouble(textField.getText()));
				
			}
		});
		
		
	}
	
	
	
	
	public static void ucitajSlovima() {
		File f = new File("ispisSlovima.txt");
        Scanner sc;
		try {
			sc = new Scanner(f);
			
			 

		        while(sc.hasNextLine()){
		            String line = sc.nextLine();
		            String[] details = line.split(",");
		            String broj1 = details[0];
		            String rec = details[1];
		            
		            BrojeviClass p = new BrojeviClass(broj1,rec);
		            people.add(p);
		        }

		        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void ispisiSlovima(int broj,double decimala) {
		
		
		if(broj <= 1000 || broj > 1000000) {
			JOptionPane.showMessageDialog(null, "Broj mora biti izmedju 1000 i 1 milion");
		}
		
		ucitajSlovima();
		
		int poz = 0 ;
		int min = 0 ;
		int brojilac  = 0 ;
		
		
		
		String h  = "";
		String ceoBroj = "";
		String st = "";
		String d ="";
		String ob = "";
		double zarez = 0 ;
		double zarez1 = 0;
		zarez = decimala - broj;
		zarez1 = zarez*100;
		
		
		
		int brojCifara = String.valueOf(broj).length() ;
		
		
		if(brojCifara == 4) {
		
			int hiljada = 0 ;
			int stotina = 0 ;
			int stotina1 = 0;
			int desetica =0 ; 
			int desetica1 = 0;
			int obicanBroj = 0;
			
			
			
			for(int i = 0 ; i < people.size() ; i++) {
				
				if(broj >= Integer.parseInt(people.get(i).getBroj())) {
	
					
					brojilac = broj-Integer.parseInt(people.get(i).getBroj());
					
					if(i == 0 ) {
						
						min = brojilac;
					}
					
					if(min > brojilac) {
						min = brojilac ;
						poz = i;
					}				
				}
			}
			
			
			h = people.get(poz).getRec();
			hiljada = Integer.parseInt(people.get(poz).getBroj());
			int brojCifara1 = String.valueOf(broj-hiljada).length() ;
			
			
			if(brojCifara1 == 3) {
				
				stotina = broj-hiljada;
				
				for(int i = 0 ; i < people.size() ; i++) {
					
					if(stotina >= Integer.parseInt(people.get(i).getBroj())) {
	
						
						brojilac = stotina-Integer.parseInt(people.get(i).getBroj());
						
						if(i == 0 ) {
							
							min = brojilac;
						}
						
						if(min > brojilac) {
							min = brojilac ;
							poz = i;
						}				
					}
				}
				stotina1 = Integer.parseInt(people.get(poz).getBroj());
				st = people.get(poz).getRec();
				
			
				
				
				
				int brojCifara2 = String.valueOf(stotina-stotina1).length();
				
				
				
				if(brojCifara2 == 2) {
					desetica = stotina - stotina1;
					
					for(int i = 0 ; i < people.size() ; i++) {
						
						if(desetica >= Integer.parseInt(people.get(i).getBroj())) {
	
							
							brojilac = desetica-Integer.parseInt(people.get(i).getBroj());
							
							if(i == 0 ) {
								min = brojilac;
							}
							
							if(min > brojilac) {
								min = brojilac ;
								poz = i;
							}				
						}
						
						
					}
					
					d= people.get(poz).getRec();
					desetica1 = Integer.parseInt(people.get(poz).getBroj());
					
					
					
					obicanBroj = desetica-desetica1;
					
					for(int i = 0 ; i < people.size();i++) {
						if(obicanBroj == Integer.parseInt(people.get(i).getBroj())) {
							ob = people.get(i).getRec();
						}
					}
				
					
				}
				if(brojCifara2 == 1) {
					
					obicanBroj = stotina - stotina1;
					
					for(int i = 0 ; i < people.size();i++) {
						if(obicanBroj == Integer.parseInt(people.get(i).getBroj())) {
							ob = people.get(i).getRec();
						}
					}
					
					
				}
				
				
			}
			
			if(brojCifara1 ==2) {
				
				desetica = broj-hiljada;
				
				for(int i = 0 ; i < people.size() ; i++) {
					
					if(desetica > Integer.parseInt(people.get(i).getBroj())) {
	
						
						brojilac = desetica-Integer.parseInt(people.get(i).getBroj());
						
						if(i == 0 ) {
							min = brojilac;
						}
						
						if(min > brojilac) {
							min = brojilac ;
							poz = i;
						}				
					}
					
					
				}
				d= people.get(poz).getRec();
				desetica1 = Integer.parseInt(people.get(poz).getBroj());
				
		
				
				obicanBroj = desetica-desetica1;
				
				for(int i = 0 ; i < people.size();i++) {
					if(obicanBroj == Integer.parseInt(people.get(i).getBroj())) {
						ob = people.get(i).getRec();
					}
				}
				
				
				
				
			}
			
			if(brojCifara1 == 1) {
				obicanBroj = broj-hiljada;
				for(int i = 0 ; i < people.size();i++) {
					if(obicanBroj == Integer.parseInt(people.get(i).getBroj())) {
						ob = people.get(i).getRec();
					}
				}
				
			}
			
	
			labelIspis.setText("Slovima :  " +h + st + d+ ob );
//			label_40.setText("Slovima :  "+ h + st + d+ ob + " i " + Math.round(zarez1)+"/100" + " dinara");
//			label_91.setText("Slovima :  "+ h + st + d+ ob + " i " + Math.round(zarez1)+"/100" + " dinara");
		}
		
		if(brojCifara == 5) {
			
			int i = 0 ;
			int x[] = new int[5];
			
			int dhiljade = 0 ;
			
			while(broj!=0){
				
				x[i] = broj%10;
				
				broj = broj /10;
				i ++;
			}
			
	
		
			
			String hiljadu = "";
			String stotinu = "";
			
			String ispisHiljada = "";
			
			hiljadu = x[4]+""+x[3];
			stotinu = x[2]+""+x[1]+""+x[0];
			
			
			int hiljaduInt = Integer.parseInt(hiljadu);
			int stotinuInt = Integer.parseInt(stotinu);
			
			
			
			for(int k = 0 ; k < people.size() ; k++) {
				
				if(hiljaduInt >= Integer.parseInt(people.get(k).getBroj())) {
	
					
					brojilac = hiljaduInt-Integer.parseInt(people.get(k).getBroj());
					
					if(k == 0 ) {
						min = brojilac;
						poz = k;
					}
					
					if(min > brojilac) {
						min = brojilac ;
						poz = k;
					}				
				}
				
				
			}
			String hiljadic = "";
			if(min == 0) {
				ispisHiljada = people.get(poz).getRec()+"hiljada";
			}
			else {
				
				
				int desetiDeo =  Integer.parseInt(people.get(poz).getBroj());
				String desetiDeo1 = people.get(poz).getRec();
				
				ispisHiljada = desetiDeo1;
				
				int obicanBrojcic = 0 ;
				
				obicanBrojcic = hiljaduInt-desetiDeo;
				
				for(int t = 0 ; t < people.size();t++) {
					if(obicanBrojcic*1000 == Integer.parseInt(people.get(t).getBroj())) {
						hiljadic = people.get(t).getRec();
					}
				}
				
			}
			
	
			
			/*
			 * 
			 * 
			 * kod odozgo
			 * 
			 * 
			 * 
			 */
	
				String stt1 = "";
				int stt2 = 0;
				
				for(int f = 0 ; f < people.size() ; f++) {
					
					if(stotinuInt >= Integer.parseInt(people.get(f).getBroj())) {
	
						
						brojilac = stotinuInt-Integer.parseInt(people.get(f).getBroj());
						
						if(f == 0 ) {
							
							min = brojilac;
							poz = f;
						}
						
						if(min > brojilac) {
							min = brojilac ;
							poz = f;
						}				
					}
				}
				
				stt2 = Integer.parseInt(people.get(poz).getBroj());
				stt1 = people.get(poz).getRec();
				
			
				
				
				
				int brojCifara2 = String.valueOf(stotinuInt-stt2).length();
			
				
				int ds = 0;
				String ds1 = "";
				int ds2 = 0;
				int brojcanik = 0;
				String brojcanik1 = "";
				int or = 0;
				
				if(brojCifara2 == 2) {
					ds = stotinuInt - stt2;
					
					for(int a = 0 ; a < people.size() ; a++) {
						
						if(ds >= Integer.parseInt(people.get(a).getBroj())) {
	
							
							brojilac = ds-Integer.parseInt(people.get(a).getBroj());
							
							if(a == 0 ) {
								min = brojilac;
								poz  = a;
							}
							
							if(min > brojilac) {
								min = brojilac ;
								poz = a;
							}				
						}
	
					}
					ds1= people.get(poz).getRec();
					ds2 = Integer.parseInt(people.get(poz).getBroj());
					
				
					brojcanik = ds-ds2;
					
					for(int q = 0 ; q < people.size();q++) {
						if(brojcanik == Integer.parseInt(people.get(q).getBroj())) {
							brojcanik1 = people.get(q).getRec();
						}
					}
					
					labelIspis.setText("Slovima :  " +ispisHiljada + ""+ hiljadic + stt1 + ds1 +brojcanik1 );
					//label_40.setText("Slovima :  " +ispisHiljada + ""+ hiljadic + stt1 + ds1 +brojcanik1 +  " i " + Math.round(zarez1)+"/100"+ " dinara");
					//label_91.setText("Slovima :  "+ h + st + d+ ob + " i " + Math.round(zarez1)+"/100" + " dinara");
					
					
				}
				if(brojCifara2 == 1) {
					
					or = stotinuInt - stt2;
					
					for(int v = 0 ; v < people.size();v++) {
						if(or == Integer.parseInt(people.get(v).getBroj())) {
							brojcanik1 = people.get(v).getRec();
						}
					}
					
					
					labelIspis.setText("Slovima :  " +ispisHiljada + ""+ hiljadic + stt1 +brojcanik1 );
					//label_40.setText("Slovima :  " +ispisHiljada + ""+ hiljadic + stt1 +brojcanik1 + " i " + Math.round(zarez1)+"/100" + " dinara");
					//label_91.setText("Slovima :  "+ h + st + d+ ob + " i " + Math.round(zarez1)+"/100" + " dinara");
				
					
					
				}
				
				
	
			
			
			
		}
		
		if(brojCifara == 6) {
			
			int i = 0 ;
			int x[] = new int[6];
			
			int dhiljade = 0 ;
			
			while(broj!=0){
				
				x[i] = broj%10;
				
				broj = broj /10;
				i ++;
			}
			
		
			
			
			String milion = "";
			String bilion = "";
			
			milion = x[5]+"";
			int milion1 = Integer.parseInt(milion);
			
			for(int hf = 0 ; hf < people.size();hf++) {
				if(milion1*100 == Integer.parseInt(people.get(hf).getBroj())) {
					
					bilion = people.get(hf).getRec();
				}
			}
			
			String hiljadu = "";
			String stotinu = "";
			
			String ispisHiljada = "";
			
			
			hiljadu = x[4]+""+x[3];
			stotinu = x[2]+""+x[1]+""+x[0];
			
			
			int hiljaduInt = Integer.parseInt(hiljadu);
			int stotinuInt = Integer.parseInt(stotinu);
			
		
			
			for(int k = 0 ; k < people.size() ; k++) {
				
				if(hiljaduInt >= Integer.parseInt(people.get(k).getBroj())) {
	
					
					brojilac = hiljaduInt-Integer.parseInt(people.get(k).getBroj());
					
					if(k == 0 ) {
						min = brojilac;
						poz = k;
					}
					
					if(min > brojilac) {
						min = brojilac ;
						poz = k;
					}				
				}
				
				
			}
			String hiljadic = "";
			if(min == 0) {
				ispisHiljada = people.get(poz).getRec()+"hiljada";
			}
			else {
				
				
				int desetiDeo =  Integer.parseInt(people.get(poz).getBroj());
				String desetiDeo1 = people.get(poz).getRec();
				
				ispisHiljada = desetiDeo1;
				
				int obicanBrojcic = 0 ;
				
				obicanBrojcic = hiljaduInt-desetiDeo;
				
				for(int t = 0 ; t < people.size();t++) {
					if(obicanBrojcic*1000 == Integer.parseInt(people.get(t).getBroj())) {
						hiljadic = people.get(t).getRec();
					}
				}
			
			}
			
	
			
			/*
			 * 
			 * 
			 * kod odozgo
			 * 
			 * 
			 * 
			 */
	
				String stt1 = "";
				int stt2 = 0;
				
				for(int f = 0 ; f < people.size() ; f++) {
					
					if(stotinuInt >= Integer.parseInt(people.get(f).getBroj())) {
	
						
						brojilac = stotinuInt-Integer.parseInt(people.get(f).getBroj());
						
						if(f == 0 ) {
							
							min = brojilac;
							poz = f;
						}
						
						if(min > brojilac) {
							min = brojilac ;
							poz = f;
						}				
					}
				}
				
				stt2 = Integer.parseInt(people.get(poz).getBroj());
				stt1 = people.get(poz).getRec();
				
			
				
				
				
				int brojCifara2 = String.valueOf(stotinuInt-stt2).length();
				
				
				int ds = 0;
				String ds1 = "";
				int ds2 = 0;
				int brojcanik = 0;
				String brojcanik1 = "";
				int or = 0;
				
				if(brojCifara2 == 2) {
					ds = stotinuInt - stt2;
					
					for(int a = 0 ; a < people.size() ; a++) {
						
						if(ds >= Integer.parseInt(people.get(a).getBroj())) {
	
							
							brojilac = ds-Integer.parseInt(people.get(a).getBroj());
							
							if(a == 0 ) {
								min = brojilac;
								poz  = a;
							}
							
							if(min > brojilac) {
								min = brojilac ;
								poz = a;
							}				
						}
	
					}
					ds1= people.get(poz).getRec();
					ds2 = Integer.parseInt(people.get(poz).getBroj());
					
					
					
					brojcanik = ds-ds2;
					
					for(int q = 0 ; q < people.size();q++) {
						if(brojcanik == Integer.parseInt(people.get(q).getBroj())) {
							brojcanik1 = people.get(q).getRec();
						}
					}
					
					labelIspis.setText("Slovima :  "+ bilion +ispisHiljada + ""+ hiljadic + stt1 + ds1 +brojcanik1 );
					//label_40.setText("Slovima :  "+ bilion +ispisHiljada + ""+ hiljadic + stt1 + ds1 +brojcanik1 + " i " + Math.round(zarez1)+"/100" + " dinara");
					//label_91.setText("Slovima :  "+ h + st + d+ ob + " i " + Math.round(zarez1)+"/100" + " dinara");
				
				}
				if(brojCifara2 == 1) {
					
					or = stotinuInt - stt2;
					
					for(int v = 0 ; v < people.size();v++) {
						if(or == Integer.parseInt(people.get(v).getBroj())) {
							brojcanik1 = people.get(v).getRec();
						}
					}
					
					
					labelIspis.setText("Slovima :  "+ bilion +ispisHiljada + ""+ hiljadic + stt1 +brojcanik1 );
					//label_40.setText("Slovima :  "+bilion +ispisHiljada + ""+ hiljadic + stt1 +brojcanik1 + " i " + Math.round(zarez1)+"/100" + " dinara");
					//label_91.setText("Slovima :  "+ h + st + d+ ob + " i " + Math.round(zarez1)+"/100" + " dinara");
					
					
				}
	
		}

}
	
	
	
	
	
	
	
	
	
}
