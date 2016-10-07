package com.um.svg.path;
/**
 * Get paths from SVG files and save to files.
 * 
 * @author peterliu
 *
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatePathFromSVG {
	
	/**
	 * Separate source SVG files based on the file path.
	 * @param path
	 * @throws IOException
	 */
	public static void separate(String path) throws IOException{
		
		// Open svg file.
		List<String> pathList = new ArrayList<>();
		String contents = "";
		String copyOfContents = "";
		String line;
		InputStream fis = new FileInputStream(path);
		InputStreamReader reader = new InputStreamReader(fis);
		BufferedReader buffer = new BufferedReader(reader);
		
		// read line of svg contents.
		while((line = buffer.readLine() ) != null){
			contents += " " + line;
		}
		// remove space
		contents = contents.replaceAll("\\s+", " ");
		// copy contents to replace
		copyOfContents = contents;
		// replace path string in cpoy string
		copyOfContents = copyOfContents.replaceAll("<path\\b([\\s\\S]*?)\\/>", "##");
		
		// path pattern
		String pathPattern = "<path\\b([\\s\\S]*?)\\/>";
		// Create a Pattern object
	    Pattern r = Pattern.compile(pathPattern);

	    // Now create matcher object.
	    Matcher m = r.matcher(contents);
	    // get path count
	    int count = 0;
	    while(m.find()){
	    	count++;
	    	pathList.add(m.group(0)); // add all path to path list.
	    }
	    System.out.println(count);
	    
	    // remove repeat path
	    List<String> pathListNoRepeat = new ArrayList<>();
	    for (String pt : pathList) {
	    	// In some svg file, there are repeat path without fill color.
			if (!pt.contains("style=\"fill:none")) {
				pathListNoRepeat.add(pt);
			}
		}
	    
	    FileWriter fileWriter = null;
	    for(int iPath = 0; iPath < pathListNoRepeat.size(); iPath++){
	    	String cont = copyOfContents;
	    	// add path string to svg template file.
	    	cont = cont.replaceFirst("##", pathListNoRepeat.get(iPath));
	    	// remove other placeholders(##)
	    	cont = cont.replaceAll("#{2,}", " ");
	    	// wirte to svg file
			fileWriter = new FileWriter(path.substring(0, path.length()-4) + "_" + (iPath+1) +".svg");
			BufferedWriter writer = new BufferedWriter(fileWriter);
			// write
			writer.write(cont);
			writer.flush();
			writer.close();
			fileWriter.close();
	    }
	    
		if (fis != null) {
			fis.close();
		}
	}


	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// SVG source path
		System.out.println("Separate begin!");
		// separate process
		separate(args[0]);
		
		System.out.println("Separate end!");
	}

}
