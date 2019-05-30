/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.sound.sampled.AudioFileFormat;

/**
 *
 * @author khaled
 */
public class MailApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*final Microphone mic = new Microphone(FLACFileWriter.FLAC);
		//Don't use the below google api key , make your own !!! :) 
		GSpeechDuplex duplex = new GSpeechDuplex("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
		
		duplex.setLanguage("en");
		
		JFrame frame = new JFrame("Jarvis Speech API DEMO");
		frame.setDefaultCloseOperation(3);
		JTextArea response = new JTextArea();
		response.setEditable(false);
		response.setWrapStyleWord(true);
		response.setLineWrap(true);
		
		final JButton record = new JButton("Record");
		final JButton stop = new JButton("Stop");
		stop.setEnabled(false);
		
		record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				new Thread(() -> {
					try {
						duplex.recognize(mic.getTargetDataLine(), mic.getAudioFormat());
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					
				}).start();
				record.setEnabled(false);
				stop.setEnabled(true);
			}
		});
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mic.close();
				duplex.stopSpeechRecognition();
				record.setEnabled(true);
				stop.setEnabled(false);
			}
		});
		JLabel infoText = new JLabel(
				"<html><div style=\"text-align: center;\">Just hit record and watch your voice be translated into text.\n<br>Only English is supported by this demo, but the full API supports dozens of languages.<center></html>",
				
				0);
		frame.getContentPane().add(infoText);
		infoText.setAlignmentX(0.5F);
		JScrollPane scroll = new JScrollPane(response);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), 1));
		frame.getContentPane().add(scroll);
		JPanel recordBar = new JPanel();
		frame.getContentPane().add(recordBar);
		recordBar.setLayout(new BoxLayout(recordBar, 0));
		recordBar.add(record);
		recordBar.add(stop);
		frame.setVisible(true);
		frame.pack();
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		
		duplex.addResponseListener(new GSpeechResponseListener() {
			String old_text = "";
			
			public void onResponse(GoogleResponse gr) {
				String output = "";
				output = gr.getResponse();
				if (gr.getResponse() == null) {
					this.old_text = response.getText();
					if (this.old_text.contains("(")) {
						this.old_text = this.old_text.substring(0, this.old_text.indexOf('('));
					}
					System.out.println("Paragraph Line Added");
					this.old_text = ( response.getText() + "\n" );
					this.old_text = this.old_text.replace(")", "").replace("( ", "");
					response.setText(this.old_text);
					return;
				}
				if (output.contains("(")) {
					output = output.substring(0, output.indexOf('('));
				}
				if (!gr.getOtherPossibleResponses().isEmpty()) {
					output = output + " (" + (String) gr.getOtherPossibleResponses().get(0) + ")";
				}
				System.out.println(output);
				response.setText("");
				response.append(this.old_text);
				response.append(output);
			}
		});*/
        
        launch(args);
    }
}
