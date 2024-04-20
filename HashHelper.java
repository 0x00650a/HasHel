import java.security.*;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.awt.Font;
public class HashHelper extends JFrame {

	/**
	 * 
	 */

	private JPanel contentPane;
	//private String SfromP_1 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashHelper frame = new HashHelper();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public File toHash = null,toHash_1 = null;
	public HashHelper() {
		setTitle("HasherHome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 398, 418);
		panel.setBackground(new Color(87, 255, 214));//   51, 153, 255
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("Spinner.arrowButtonBorder"));
		panel_2.setBounds(0, 24, 398, 247);
		panel_2.setBackground(new Color(87, 255, 214));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMessage = new JLabel("Browse a file:");
		lblMessage.setFont(new Font("Cantarell", Font.BOLD, 13));
		lblMessage.setBounds(228, 12, 126, 25);
		panel_2.add(lblMessage);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(12, 42, 210, 135);
		panel_2.add(textArea);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Fira Code Retina", Font.BOLD, 13));
		btnBrowse.setBounds(251, 42, 90, 25);
		panel_2.add(btnBrowse);
		
		JLabel lblMessage_1 = new JLabel("Message:");
		lblMessage_1.setFont(new Font("Cantarell", Font.BOLD, 13));
		lblMessage_1.setBounds(12, 12, 82, 25);
		panel_2.add(lblMessage_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"MD2", "MD5", "SHA-1", "SHA-256", "SHA-384", "SHA-512"}));
		comboBox.setFont(new Font("Fira Code Retina", Font.BOLD, 13));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(149, 211, 91, 24);
		panel_2.add(comboBox);
		
		JLabel lblHashWith = new JLabel("Hash with:");
		lblHashWith.setFont(new Font("Cantarell", Font.BOLD, 13));
		lblHashWith.setBounds(66, 216, 82, 15);
		panel_2.add(lblHashWith);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(236, 72, 161, 50);
		textPane_1.setBackground(new Color(87, 255, 214));
		textPane_1.setBounds(225, 80, 150, 50);
		panel_2.add(textPane_1);
		
		JButton btnInit_1 = new JButton("Clear");
		btnInit_1.setEnabled(true);
		btnInit_1.setFont(new Font("Fira Code Retina", Font.BOLD, 12));
		btnInit_1.setBounds(12, 177, 74, 25);
		panel_2.add(btnInit_1);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setFont(new Font("Fira Code Retina", Font.BOLD, 13));
		btnGenerate.setBounds(115, 281, 117, 25);
		panel.add(btnGenerate);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Dialog", Font.BOLD, 12));
		textPane.setEditable(false);
		textPane.setBounds(10, 349, 376, 27);
		panel.add(textPane);
		
		JLabel lblGeneratedHashValue = new JLabel("Generated hash value:");
		lblGeneratedHashValue.setFont(new Font("Cantarell", Font.BOLD, 13));
		lblGeneratedHashValue.setBounds(10, 328, 185, 15);
		panel.add(lblGeneratedHashValue);
		
		JLabel lblHashing = new JLabel("Hashing");
		lblHashing.setFont(new Font("Fira Code", Font.BOLD, 13));
		lblHashing.setBounds(151, 10, 64, 15);
		panel.add(lblHashing);
		
		JTextPane txtpnMessageOrFile = new JTextPane();
		txtpnMessageOrFile.setEnabled(false);
		txtpnMessageOrFile.setForeground(new Color(255, 0, 51));
		txtpnMessageOrFile.setEditable(false);
		txtpnMessageOrFile.setBackground(new Color(87, 255, 214));
		txtpnMessageOrFile.setBounds(243, 275, 122, 36);
		panel.add(txtpnMessageOrFile);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 255));
		panel_1.setBounds(400, 0, 398, 418);
		contentPane.add(panel_1);
		
		
//		Action wrapper = (Action) new AbstractAction() {
//	        @Override
//	        public void actionPerformed(ActionEvent ae) {
//	            textPane_1.setText(null);
//	        }
//	    };
//	    KeyStroke keyStroke = KeyStroke.getKeyStroke(key);
//        Object actionKey = textArea.getInputMap(JComponent.WHEN_FOCUSED).get(keyStroke);
//        textArea.getActionMap().put(actionKey, wrapper);
        
		

		panel_1.setLayout(null);
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.setFont(new Font("Fira Code Retina", Font.BOLD, 13));
		btnCopy.setBounds(12, 199, 74, 25);
		panel_1.add(btnCopy);
		
		JLabel lblChecking = new JLabel("Checking");
		lblChecking.setFont(new Font("Fira Code", Font.BOLD, 13));
		lblChecking.setBounds(185, 10, 64, 15);
		panel_1.add(lblChecking);
		
		JButton btnGenerate_1 = new JButton("Generate");
		btnGenerate_1.setFont(new Font("Fira Code Retina", Font.BOLD, 13));
		btnGenerate_1.setBounds(151, 269, 117, 25);
		panel_1.add(btnGenerate_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(12, 64, 210, 135);
		panel_1.add(textArea_1);
		
		JLabel lblMessage_1_1 = new JLabel("Message:");
		lblMessage_1_1.setFont(new Font("Cantarell", Font.BOLD, 13));
		lblMessage_1_1.setBounds(12, 33, 82, 25);
		panel_1.add(lblMessage_1_1);
		
		JButton btnBrowse_1 = new JButton("Browse");
		btnBrowse_1.setFont(new Font("Fira Code Retina", Font.BOLD, 13));
		btnBrowse_1.setBounds(250, 64, 90, 25);
		panel_1.add(btnBrowse_1);
		
		JLabel lblMessage_2 = new JLabel("Browse a file:");
		lblMessage_2.setFont(new Font("Cantarell", Font.BOLD, 13));
		lblMessage_2.setBounds(230, 37, 126, 25);
		panel_1.add(lblMessage_2);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setEditable(false);
		textPane_1_1.setBackground(new Color(255, 204, 255));
		textPane_1_1.setBounds(229, 100, 150, 50);
		panel_1.add(textPane_1_1);
		
		JButton btnVerify = new JButton("Verify");
		btnVerify.setFont(new Font("Fira Code Retina", Font.BOLD, 13));
		btnVerify.setBounds(164, 345, 97, 25);
		panel_1.add(btnVerify);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setFont(new Font("Dialog", Font.BOLD, 12));
		textPane_2.setEditable(true);
		textPane_2.setBounds(12, 306, 376, 27);
		panel_1.add(textPane_2);
		
		JLabel lblHashWith_1 = new JLabel("Hash with:");
		lblHashWith_1.setFont(new Font("Cantarell", Font.BOLD, 13));
		lblHashWith_1.setBounds(118, 233, 82, 15);
		panel_1.add(lblHashWith_1);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"MD2", "MD5", "SHA-1", "SHA-256", "SHA-384", "SHA-512"}));
		comboBox_1.setFont(new Font("Fira Code Retina", Font.BOLD, 13));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(201, 228, 91, 24);
		panel_1.add(comboBox_1);
		
		JTextPane txtpnMessageOrFile_1 = new JTextPane();
		txtpnMessageOrFile_1.setForeground(new Color(255, 0, 51));
		txtpnMessageOrFile_1.setEnabled(false);
		txtpnMessageOrFile_1.setEditable(false);
		txtpnMessageOrFile_1.setBackground(new Color(255, 204, 255));
		txtpnMessageOrFile_1.setBounds(269, 264, 122, 36);
		panel_1.add(txtpnMessageOrFile_1);
		
		JButton btnInit = new JButton("Clear");
		btnInit.setFont(new Font("Fira Code Retina", Font.BOLD, 12));
		btnInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.setText("");
				textArea_1.requestFocus();
			}
		});
		btnInit.setBounds(90, 199, 74, 25);
		panel_1.add(btnInit);
		
		JLabel lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Cantarell", Font.BOLD, 15));
		lblResult.setBounds(120, 375, 185, 22);
		panel_1.add(lblResult);
		
		textArea.addKeyListener(new KeyListener(){
		    @Override
		    public void keyPressed(KeyEvent e){
		        if(!(textArea.getText().equals(""))){
		        	toHash = null;
		        	textPane_1.setText(null);
		        	if(txtpnMessageOrFile.isEnabled()) {
		        		txtpnMessageOrFile.setText("");
		        		txtpnMessageOrFile.setEnabled(false);
		        	}
		        	textPane.setText("");
		        	lblResult.setText("");
		        }
		    }

		    @Override
		    public void keyTyped(KeyEvent e) {
		    	if(e.isActionKey() != false) {
		    		if(!(textArea.getText().equals(""))) {
		    		}
		    		textPane_1.setText(null);
		    	}
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		    }
		});

		btnInit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				textPane.setText("");
				textArea.requestFocus();
				//tt.getRootPane().setDe
			}
		});
		
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnBrowse) {
					JFileChooser fileChos = new JFileChooser();
					int resp = fileChos.showOpenDialog(fileChos);
					if(resp == JFileChooser.APPROVE_OPTION) {
						//File file1 = new File(fileChos.getSelectedFile().getAbsolutePath());
						toHash = new File(fileChos.getSelectedFile().getAbsolutePath());
						//System.out.println(file1);
						String filename = fileChos.getSelectedFile().getName();
						String msg = new String(filename+" was selected.");
						int len = msg.length();
						int firstSpc = msg.indexOf(' ');
						if(firstSpc > 20) {
							msg = new String(msg.substring(0, 19)+'\n'+msg.substring(20, len - 1));;
						}
						textPane_1.setText(msg);
						textArea.setText(null);
						textPane.setText("");
						lblResult.setText("");
						if(txtpnMessageOrFile.isEnabled()) {
			        		txtpnMessageOrFile.setText("");
			        		txtpnMessageOrFile.setEnabled(false);
			        	}
					}
				}
			}
		});
		
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(toHash != null) {
					try {
						String hashAlg = comboBox.getSelectedItem().toString();
						MessageDigest digest = MessageDigest.getInstance(hashAlg);
						String ValHash = new String(getFileChecksum(digest,toHash));
						textPane.setText(ValHash);
						//toHash = null;
					}catch(Exception e) {
						System.out.println("Exception: "+e.toString());
					}
				}else if (!(textArea.getText().equals(""))){
					try {
						String texTo = new String(textArea.getText());
						String algoT = comboBox.getSelectedItem().toString();
						//System.out.println(algoT);
						String str = HashThisString(texTo, algoT);
					    textPane.setText(str);
					}catch(Exception e) {
						System.out.println("Exception: "+e.toString());
					}
				}else {
					txtpnMessageOrFile.setEnabled(true);
					txtpnMessageOrFile.setText("message or file required");
					textPane.setText("");
				}
			}
		});


		textArea_1.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	        
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				toHash_1 = null;
	        	textPane_1_1.setText(null);
	        	if(txtpnMessageOrFile_1.isEnabled()) {
	        		txtpnMessageOrFile_1.setText("");
	        		txtpnMessageOrFile_1.setEnabled(false);
	        	}
	        	textPane_2.setText("");
	        	lblResult.setText("");
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    });

		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.setText(textArea.getText());
				textArea_1.requestFocus();
			}
		});
		
		btnBrowse_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnBrowse_1) {
					JFileChooser fileChos = new JFileChooser();
					int resp = fileChos.showOpenDialog(fileChos);
					if(resp == JFileChooser.APPROVE_OPTION) {
						//File file1 = new File(fileChos.getSelectedFile().getAbsolutePath());
						toHash_1 = new File(fileChos.getSelectedFile().getAbsolutePath());
						//System.out.println(file1);
						String filename = fileChos.getSelectedFile().getName();
						String msg = new String(filename+" was selected.");
						int len = msg.length();
						int firstSpc = msg.indexOf(' ');
						if(firstSpc > 20) {
							msg = new String(msg.substring(0, 19)+'\n'+msg.substring(20, len - 1));;
						}
						textPane_1_1.setText(msg);
						textArea_1.setText(null);
						textPane_2.setText("");
						lblResult.setText("");
						//textPane_2.insertIcon();
						if(txtpnMessageOrFile_1.isEnabled()) {
			        		txtpnMessageOrFile_1.setText("");
			        		txtpnMessageOrFile_1.setEnabled(false);
			        	}
					}
				}
			}
		});
		
		btnGenerate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(toHash_1 != null) {
					try {
						String hashAlg = comboBox_1.getSelectedItem().toString();
						MessageDigest digest = MessageDigest.getInstance(hashAlg);
						String ValHash = new String(getFileChecksum(digest,toHash_1));
						textPane_2.setText(ValHash);
						//toHash = null;
					}catch(Exception e) {
						System.out.println("Exception: "+e.toString());
					}
				}else if (!(textArea_1.getText().equals(""))){
					try {
						String texTo = new String(textArea_1.getText());
						String algoT = comboBox_1.getSelectedItem().toString();
						//System.out.println(algoT);
						String str = HashThisString(texTo, algoT);
					    textPane_2.setText(str);
					}catch(Exception e) {
						System.out.println("Exception: "+e.toString());
					}
				}else {
					txtpnMessageOrFile_1.setEnabled(true);
					txtpnMessageOrFile_1.setText("message or file required");
					textPane_2.setText("");
				}
			}
		});
		
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textPane.getText().equalsIgnoreCase(textPane_2.getText())) {
					lblResult.setForeground(new Color(56, 231, 21)); //62, 240, 27   43, 255, 1
					lblResult.setText("They are matched!");
				}
				else {
					lblResult.setForeground(new Color(225, 40, 40 )); //  225, 40, 40 
					lblResult.setText("Not Matched");
				}
			}
		});
		
	}
	
	
	private static String HashThisString(String str, String alg) throws Exception{
			MessageDigest digest = MessageDigest.getInstance(alg);
			digest.update(str.getBytes());
			byte[] bydist = digest.digest();
			StringBuilder toReturn = new StringBuilder();
			for(byte byta : bydist) {
				toReturn.append(String.format("%x", byta));
			}
			return toReturn.toString();
	}
	private static String getFileChecksum(MessageDigest digest, File file) throws IOException
	{
	  //Get file input stream for reading the file content
	  FileInputStream fis = new FileInputStream(file);
	   
	  //Create byte array to read data in chunks
	  byte[] byteArray = new byte[1024];
	  int bytesCount = 0; 
	    
	  //Read file data and update in message digest
	  while ((bytesCount = fis.read(byteArray)) != -1) {
	    digest.update(byteArray, 0, bytesCount);
	  };
	   
	  //close the stream; We don't need it now.
	  fis.close();
	   
	  //Get the hash's bytes
	  byte[] bytes = digest.digest();
	   
	  //This bytes[] has bytes in decimal format;
	  //Convert it to hexadecimal format
	  StringBuilder sb = new StringBuilder();
	  for(int i=0; i< bytes.length ;i++)
	  {
	    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	  }
	   
	  //return complete hash
	   return sb.toString();
	}
}
