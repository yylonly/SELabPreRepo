package com.ehealth.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.json.XML;


public class XMLToJSON {
	
	
	/**
     *  生成 json文件
     * @param src
     * @param dst
     * @return
     * @throws IOException
     */
    public boolean creatrJSONFile(File src,File dst) throws IOException{
           if( src == null || dst == null){
                 return false;
          }
          
           // src :  xml/2009
           //        xml/2010
           //            xml/2011
          File[] srcfiles = src.listFiles();
          
           for(File s : srcfiles){
                File file = s;
                
                String dstNameString = file.getName(); // 2009 2010
                
                XMLToJSON xmlToJSON = new XMLToJSON();
                List<JSONObject> results = xmlToJSON .readAndStoreJSON(file ); // 数据
                if(results == null){
                	continue;
                }
                Writer writer = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(dst + File.separator + dstNameString + ".json" ),"UTF-8" ));
                
                for(JSONObject r: results){
                       if( r != null){
                             writer.write( r.toString()+ "\n");
                      }
                }
                 writer.close();
                System. out.println( "Success!");
          }
           return true;
    }
	
	/**
	 *  功能：
	 *  	xml文件 数据导入到  data.json文件中
	 *  
	 * @param file
	 * @throws IOException 
	 */
	
	public List<JSONObject> readAndStoreJSON(File file) throws IOException{
		
		if(file == null){return null;}
				
		File[] files = file.listFiles(); // files 
		
		if(files == null || files.length == 0){	return null;}
		
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		
		for(File f : files){
			if(f.isDirectory()){
				//readAndStoreJSON(f);
			}else{
				
				String contents = readFile(f);
//				System.out.println("contents:" + contents);
				if(contents == "" || contents.equals("")){
					continue;
				}
				JSONObject jsonObject = parseXMLToJSON(contents);
				
				jsonObjects.add(jsonObject);
			}
		}
		return jsonObjects;
	}
	
	/**
	 *  read file
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public String readFile(File file) throws IOException{
		if(file == null){
			return null;
		}
		
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String contents = "";
		String line = "";
		
		while((line = buffer.readLine()) != null){
			contents += line.trim();
		}
//		System.out.println(contents);
		buffer.close();
		return contents;
	}
	
	/**
	 * 
	 * @param string
	 * @return
	 */
	public JSONObject parseXMLToJSON(String string){
		if(string == null){
			return null;
		}
		
		JSONObject jsonObject = XML.toJSONObject(string.trim());
		
		return jsonObject;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		String[] strings = {"/Users/heermaster/Documents/file/srcxml/2009",
//				"/Users/heermaster/Documents/file/srcxml/2010",
//				"/Users/heermaster/Documents/file/srcxml/2011",
//				"/Users/heermaster/Documents/file/srcxml/2012"};
//		String[] strings = {
//				"/Users/heermaster/Documents/file/srcxml/"
//				};
		String[] strings = {"/Users/heermaster/Documents/file/xml1/2009",
		"/Users/heermaster/Documents/file/xml1/2011",
		"/Users/heermaster/Documents/file/xml1/2012"};
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/heermaster/Documents/file/srcjson/alldata.json"),"UTF-8"));
		for(String s : strings){
			File file = new File(s);
			
			XMLToJSON xmlToJSON = new XMLToJSON();
			List<JSONObject> results = 	xmlToJSON.readAndStoreJSON(file); // 数据
			
//			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/heermaster/Documents/file/srcjson/data" + (index++) +".json"),"UTF-8"));
			if(results == null){
				System.out.println("result is null");
				continue;
			}
			for(JSONObject r:results){
				if(r != null){
					writer.write(r.toString()+"\n");
				}
			}
//			writer.close();
			System.out.println("Success!");
		}
		writer.close();
		
	}
}
