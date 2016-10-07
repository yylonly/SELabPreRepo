package com.ehealth.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.text.BadLocationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.ehealth.tools.RTFToXML;
import com.ehealth.tools.XMLToJSON;

public class MainUI {
	
	private JFrame frame;
	private JFileChooser srcChooser;
	private JButton loadDButton;
	
	private File srcpath;
	private File xmlpath;
	private File jsonpath;
	
	public MainUI(){
		prepareUI();
	}
	
	private void prepareUI(){
		frame = new JFrame("Main UI");
		frame.setSize(800, 600);
		frame.setLayout(null);
		
	}

	private void showUI(){
		
		srcChooser = new JFileChooser();
		srcChooser.setBounds(10, 0, 400, 500);
		srcChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		srcChooser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				srcpath = srcChooser.getCurrentDirectory();
				String dstString = srcpath.getParent() + File.separator + "xml";
				xmlpath = new File(dstString);
				dstString = srcpath.getParent() + File.separator + "json";
				jsonpath = new File(dstString);
			}
		});
		frame.add(srcChooser);
		
		loadDButton = new JButton();
		loadDButton.setText("导入数据库");
		loadDButton.setBounds(500, 20, 100, 40);
		loadDButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RTFToXML fileDirectory = new RTFToXML();
				// xml文件存放位置
				srcpath = srcChooser.getCurrentDirectory();
				String dstString = srcpath.getParent() + File.separator + "xml";
				xmlpath = new File(dstString);
				dstString = srcpath.getParent() + File.separator + "json";
				jsonpath = new File(dstString);
				
				
				if(!xmlpath.exists()){
					xmlpath.mkdir();
				}
				// json文件存放位置
				if(!jsonpath.exists()){
					jsonpath.mkdir();
				}
				
				System.out.println(srcpath + " " + xmlpath + " " + jsonpath);
				//1.生成xml文件
				if(srcpath != null){
					try {
						fileDirectory.readAndWriteXML(srcpath, xmlpath);
					} catch (IOException | BadLocationException
							| ParserConfigurationException
							| TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				//2. 生成json文件
				if(xmlpath != null && jsonpath != null){
					XMLToJSON xmlToJSON = new XMLToJSON();
					try {
						if(xmlToJSON.creatrJSONFile(xmlpath, jsonpath)){
							System.out.println("json file create successed!");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				//3. 将json文件导入到db中---按照文件名称
				File[] jsonFiles = jsonpath.listFiles();
				for(File f : jsonFiles){
					System.out.println(f.getName());
					String collectionNameString = "ehealthrecord" + f.getName().substring(0,f.getName().length()-5);
					System.out.println(collectionNameString);
					try {
						System.out.println(jsonpath + File.separator + f.getName());
						Process p = Runtime.getRuntime().exec("mongoimport -d db -c " + collectionNameString + " " + jsonpath + File.separator + f.getName());
						p.waitFor();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				System.out.println("load successed!");
			}
		});
		frame.add(loadDButton);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainUI mainUI = new MainUI();
		mainUI.showUI();
	}

}
