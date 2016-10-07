package com.ehealth.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.EndDocument;
import javax.xml.transform.TransformerException;

import com.ehealth.info.ChineseMedicine;
import com.ehealth.info.EHealthRecord;
import com.ehealth.info.PatientInfo;
import com.ehealth.info.WesternMedicine;
import com.ehealth.tools.RTFToXML;

public class Test03 {

	
	public void readAndWriteXML(File src,File dst) throws IOException, BadLocationException, ParserConfigurationException, TransformerException{
		
		File[] fs = src.listFiles(); //数据源文件		
		int index = 0; //序号		
		
		for(File f:fs){
			try {
				if(f != null){
					if(f.isDirectory()){				
						readAndWriteXML(f,dst);
						
					}else{
						/**
						 *  get data from the source file. and write to the xml file 
						 *  
						 */				
						RTFEditorKit rtf = new RTFEditorKit();
						DefaultStyledDocument dsd = new DefaultStyledDocument();
						System.out.println(f);
						rtf.read(new FileInputStream(f), dsd, 0);
						
						String text = new String(dsd.getText(0, dsd.getLength()).getBytes("ISO8859_1"),"GBK");
						System.out.println(text);
						// CLEAR
						rtf = null;
						dsd = null;
						// 解析text	
						String[] strings = parseString(text.trim());
						
						EHealthRecord eHealthRecord = createEhealthRecord(strings);
						System.out.println(eHealthRecord.getChineseMedicines());
					}
					index++;
					
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("[error file] : " + f);
				continue;
			}
		}
	}
	/**
	 *  根据字符解析，生成病例结构对象
	 * @param strings
	 */
	public EHealthRecord createEhealthRecord(String[] strings){
		if(strings == null || strings.length == 0){
			return null;
		}
		
		EHealthRecord eHealthRecord = new EHealthRecord(); // ehealrecord 
		
		PatientInfo patientInfo = new PatientInfo(); // patient info
		
		List<WesternMedicine> westernMedicines = new ArrayList<WesternMedicine>(); // 西药处方
		List<ChineseMedicine> chineseMedicines = new ArrayList<ChineseMedicine>(); // 中药处方
		
		String tmp = "";
		
		// 索引信息
		int addressIndex = 0;
		int contactIndex = 0;
		int westerndiagIndex = 0;
		int chinesediagIndex = 0;
		int processIndex = 0;
		int westernMedicineIndex = 0;
		int chineseMedicineIndex = 0;
		int chineseProcessIndex = 0;
		int checkIndex = 0;
		int projectIndex = 0;
		int assayIndex = 0;
		int doctorIndex = 0;
		
		// 处方有无
		boolean hasWestMedicine = false; // 西药处方
		boolean hasCnMedicine = false;  // 中药处方
		boolean hasProject = false;  // 项目
		boolean hasAssay = false;  // 化验
		boolean hasCheck = false;
		
		// 西药处方	
		String wgroup = ""; // 组
		String wmedicineString = ""; // 名称
		String wspecifications = ""; // 规格
		String wusageString = "";  // 用法
		String wamountString = ""; // 总量
		
		// 遍历索引
		for(int i = 0;i < strings.length; i++){
			if(strings[i].matches("地址.*") && i != 0){
				addressIndex = i;
			}else if (strings[i].matches("联系人.*") && i != 0) {
				addressIndex = i > addressIndex? i : addressIndex;// 联系人和地址顺序颠倒
			}else if (strings[i].matches("西医诊断.*") && i != 0) {
				westerndiagIndex = i;
			}else if (strings[i].matches("中医诊断.*") && i != 0) {
				chinesediagIndex = i;
			}else if (strings[i].matches("处理.*")) {
				processIndex = i;
			}else if (strings[i].matches("西药处方.*") && i != 0) {
				westernMedicineIndex = i;
				hasWestMedicine = true;
			}else if (strings[i].matches("中药处方.*") && i != 0) {
				chineseMedicineIndex = i;
				hasCnMedicine = true;
			}else if ((strings[i].matches("水煎内服.*") || strings[i].matches("煎服.*")) && i != 0) {
				chineseProcessIndex = i;
			}else if (strings[i].matches("检查:.*") && i != 0) {
				checkIndex = i;
				hasCheck = true;
			}else if(strings[i].matches("医师.*") && i != 0){
				doctorIndex = i;
			}
		}
		
		// 处理字符
		for(int i = 0; i < strings.length; i++){
			// 医院
			if(strings[i].matches("医院.*")){
				//医院信息
				tmp = strings[i].substring(3).trim();
				eHealthRecord.setHospital(tmp);
			}else if (strings[i].matches("\\d{4}年\\d{2}月\\d{2}日\\d{2}时\\d{2}分")) {
				//日期
				tmp = strings[i].trim();
				eHealthRecord.setDate(tmp);
			}else if (strings[i].matches("科别.*")) {
				//科别
				tmp = strings[i].substring(3).trim();
				eHealthRecord.setMedicalService(tmp);
			}else if (strings[i].matches("挂号号.*")) {
				// 挂号号
				tmp = strings[i].substring(4).trim();
				eHealthRecord.setRegistrationno(tmp);
			}else if (strings[i].matches("姓名.*")) {
				// 姓名
				tmp = strings[i].substring(3).trim();
				patientInfo.setName(tmp);
			}else if (strings[i].matches("性别.*")) {
				//性别
				tmp = strings[i].substring(3).trim();
				patientInfo.setGender(tmp);
			}else if (strings[i].matches("年龄.*")) {
				//年龄
				tmp = strings[i].substring(3).trim();
				patientInfo.setAge(tmp);
			}else if (strings[i].matches("职业.*")) {
				//职业
				tmp = strings[i].substring(3).trim();
				patientInfo.setProfession(tmp);
			}else if (strings[i].matches("电话.*")) {
				//电话
				tmp = strings[i].substring(3).trim();
				patientInfo.setPhoneNumber(tmp);
			}else if (strings[i].matches("联系人.*")) {
				//联系人
				tmp = strings[i].substring(4).trim();
				patientInfo.setContact(tmp);
			}else if (strings[i].matches("地址.*")) {
				//地址
				tmp = strings[i].substring(3).trim();
				patientInfo.setAddress(tmp);
			}else if (i > addressIndex && i < westerndiagIndex && i != 0) {
				// 病症描述-----多条
				if(i == addressIndex + 1){
					tmp = strings[i].trim();
				}else{
					tmp += strings[i].trim();
				}
				if( i == westerndiagIndex - 1){
					eHealthRecord.setConditionsdescribed(tmp);
				}
			}else if (i == westerndiagIndex && i != 0) {
				// 西医诊断
				tmp = strings[i].substring(5).trim();
				eHealthRecord.setWesterndiagnostics(tmp);
			}else if (i == chinesediagIndex) {
				//中医诊断
				tmp = strings[i].substring(5).trim();
				eHealthRecord.setChinesediagnostics(tmp);
			}else if (i == processIndex && i != 0) {
				// 处理
				tmp = strings[i].substring(3).trim();
				eHealthRecord.setProcessString(tmp);
			}
			
			// 西药处方			
			if(hasWestMedicine){
				int endIndex = (hasCnMedicine? chineseMedicineIndex:((hasCheck?checkIndex:doctorIndex)));
				if (i > westernMedicineIndex && i != 0 && i < endIndex) {
					// 西药处方	
					if(strings[i].matches("\\d+")){
						//组
						wgroup = strings[i].trim();
					}else if (strings[i].matches(".*［.*")) {
						//名称/规格
						String[] maStrings = parseWesternMedicine(strings[i].trim());
						if(maStrings != null && maStrings.length == 2){
							wmedicineString = maStrings[0];
							wspecifications = maStrings[1];
						}
					}else if (strings[i].matches(".*/.*/.*")) {
						// 详细用法
						wusageString = strings[i].trim();
					}else if (strings[i].matches("\\d+盒")) {
						// 数量
						wamountString = strings[i].trim();
						WesternMedicine westernMedicine = new WesternMedicine(wgroup, wmedicineString, wspecifications, wusageString, wamountString);
						westernMedicines.add(westernMedicine);
					}		
				}
			}
			// 中药处方
			if(hasCnMedicine){
				int end = chineseProcessIndex;
				if (i > chineseMedicineIndex && i != 0 && i < end) {
					//中药处方
					ChineseMedicine chineseMedicine = parseChineseMedicine(strings[i]);
					if(chineseMedicine != null){
						chineseMedicines.add(chineseMedicine);
					}
				}
			}
			
			if (i == chineseProcessIndex && i != 0) {
				// 中药处理
				tmp = strings[i].trim();
				eHealthRecord.setChineseProcess(tmp);
			}
			
			//检查
			
			//医师
			if (i == doctorIndex && i != 0) {
				
				tmp = strings[i].substring(3).trim();
				eHealthRecord.setDoctor(tmp);
			}
		}
		
		eHealthRecord.setPatientInfo(patientInfo); // 病人信息
		
		eHealthRecord.setWesternMedicines(westernMedicines); // 西药处方
		
		eHealthRecord.setChineseMedicines(chineseMedicines); // 中药处方
		
		return eHealthRecord;
	}
	
	public static void printArrays(String[] src){
		for(String string : src){
			System.out.println(string + "|");
		}
//		System.out.println();
	}
	
	/**
	 *  parse the text 
	 * @param string
	 * @return
	 */
	public String[] parseString(String string){
		
		String[] strings = string.split("\\s{1,20}|\\n"); // 多个空格或回车
		if(strings == null || strings.length == 0){
			return null;
		}
		String[] results = procStrings(strings); // 处理
		return results;
	}
	
	/**
	 *  字符串整理
	 * @param strings
	 * @return
	 */
	public String[] procStrings(String[] strings){
		String[] results = null;
		//功能：对文本进行处理，完成对文本数据的拼接、去除等操作
		if(strings == null || strings.length == 0){
			return null;
		}
		
		List<String> tmpList = new ArrayList<String>();  // no use
		
		// 1. 对病症文件进行处理
		String addressPattern = "地址.*"; // 地址----西医诊断之间的是病症描述，可能有多段，需要进行拼接
		String contactPattern = "联系人.*";
		String westernDiagPattern = "西医诊断.*"; // 中西医诊断若有多段，则进行拼接
		String chineseDiagPattern = "中医诊断.*";
		String processPattern = "处理.*";
		String westernMedicinePattern = "西药处方.*";
		String chineseMedicinePattern = "中药处方.*";
		
		// 2. 索引
		int addressIndex = 0;  //地址
		int westernDiagIndex = 0; //西医诊断
		int chineseDiagIndex = 0; //中医诊断
		int processIndex = 0;         // 处理：
		int westernMedicineIndex = 0;      // 西药处方
		int chineseMedicineIndex = 0;      // 中药处方
		
		for(int i = 0;i < strings.length; i++){
			if(strings[i].matches(addressPattern) && i != 0){
				addressIndex = i; // 地址
			}else if(strings[i].matches(contactPattern) && i != 0){
				addressIndex = i > addressIndex? i : addressIndex; // 联系人和地址顺序不一致
			}else if(strings[i].matches(westernDiagPattern) && i != 0){
				westernDiagIndex = i; // 西医诊断
			}else if(strings[i].matches(chineseDiagPattern) && i != 0){
				chineseDiagIndex = i; // 中医诊断
			}else if (strings[i].matches(processPattern) && i != 0) {
				processIndex = i; // 处理
			}else if (strings[i].matches(westernMedicinePattern) && i != 0) {
				westernMedicineIndex = i; // 西药处方
			}else if (strings[i].matches(chineseMedicinePattern) && i != 0) {
				chineseMedicineIndex = i; // 中药处方
			}
		}
		// 去掉不符合的病例－－－－必须有中医诊断和中药处方
		if(chineseMedicineIndex == 0){
			return null;
		}else if(chineseDiagIndex == 0){
			return null;
		}
//		System.out.println("west diag:" + westernDiagIndex + "  cndiag:" + chineseDiagIndex);
//		System.out.println("[chinese medicine index:] " + chineseMedicineIndex);
		// 处理文本
		for(int i = 0;i < strings.length; i++){
			if(i == addressIndex + 1 && i != 1){
				// 病症描述
				String diseaseDecription = connectString(strings, i, westernDiagIndex);
				tmpList.add(diseaseDecription.trim());
				i =(westernDiagIndex == 0 ? chineseDiagIndex : westernDiagIndex ) - 1;
				continue;
			}else if (i == westernDiagIndex && i != 0) {
				// 西医诊断
				String westernDescription = connectString(strings, i, chineseDiagIndex);
				tmpList.add(westernDescription.trim());
				i = chineseDiagIndex - 1;
				continue;
				
			}else if (i == chineseDiagIndex && i != 0) {
				//中医诊断
				String chineseDescription = connectString(strings, i, processIndex);
				tmpList.add(chineseDescription.trim());
				i = processIndex - 1;
				continue;
			}else if(i == processIndex && i != 0){
				//处理
				int endIndex = westernMedicineIndex==0?chineseMedicineIndex:westernMedicineIndex;
				
				String processString = connectString(strings, i+1, endIndex);
				tmpList.add(strings[i]+processString.trim());
				
				i = endIndex - 1;
				continue;
			}else{
				tmpList.add(strings[i]);  // 去除空行和------------------------
				continue;
			}
		}
		results = listToArray(tmpList);
		return results;
	}
	
	/**
	 *  list to array
	 * @param list
	 * @return
	 */
	public String[] listToArray(List list){
		String[] results = null;
		int length = list.size();
		if(list == null || length == 0){
			return null;
		}
		
		results = new String[length];
		for(int i = 0;i < length ;i++){
			results[i] = list.get(i).toString();
		}
		
		return results;
	}
	
	/**
	 *  connect the string from array
	 * @param strings
	 * @param start
	 * @param end
	 * @return
	 */
	public String connectString(String[] strings,int start,int end){
		String result = "";
		
		for(int i = start; i < end; i++){
			result += "" + strings[i];
		}
		return result.trim();
	}
	
	/**
	 *  中药信息处理
	 *  	主要处理区分 中药名称/别名/数量
	 *  示例：
	 *   		益智(制益智仁/益智仁)15g
	 *   分析后：
	 *   
	 *   	名称：益智
	 *   	别名1：制益智
	 *   	别名2： 益智仁
	 *   	单位：g
	 *   	数量：15
	 *  
	 * @param string
	 * @return String[] 
	 */
	public ChineseMedicine parseChineseMedicine(String string){
		if(string == "" || string.equals("")){
			return null;
		}
//		System.out.println(string);
		String medicineName = "";
		
		int blackIndex = 0;
		int numberIndex = 0;
		
		char[] medicinechars = string.trim().toCharArray();
		int medicinecharsLen = medicinechars.length;
		if(string.contains("(") || string.contains("（")){
			for(int i = 0; i < medicinecharsLen; i++){
				if((medicinechars[i] == '(' || medicinechars[i] == '（') && blackIndex == 0){
					blackIndex = i;
					
				}
				if(medicinechars[i] > 48 && medicinechars[i] < 57 && numberIndex == 0){
					numberIndex = i;
				}
				
			}
			int end = blackIndex < numberIndex ? blackIndex : numberIndex;
			medicineName = string.substring(0,end);
			
		}else{
			for(int i = 0; i < medicinecharsLen; i++){
				if(medicinechars[i] > 48 && medicinechars[i] < 57 && numberIndex == 0){
					numberIndex = i;
				}
				
			}
			medicineName = string.substring(0, numberIndex);
		}
		ChineseMedicine result = null;
		if(medicineName != "" && !medicineName.equals("")){
			result = new ChineseMedicine(medicineName, null, "", "");
		}
		return result;
	}
	
	
	/**
	 *  西药名称信息处理
	 *  	主要处理西药名称： 药品名称/规格  ：康力欣胶囊［0.5g*36粒/盒］---> 康力欣胶囊   + ［0.5g*36粒/盒］
	 * @param string
	 * @return
	 */
	public String[] parseWesternMedicine(String string){
		if(string == ""){
			return null;
		}
		
		String[] strings = string.split("\\［");
		return strings;
	}
	
	/**
	 * 
	 * @param args
	 * @throws TransformerException 
	 * @throws ParserConfigurationException 
	 * @throws BadLocationException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, BadLocationException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		Test03 fd = new Test03();
		File src = new File("/Users/heermaster/Documents/file/data1");
		File dst = new File("/Users/heermaster/Documents/file/xml1");
		
		System.out.println("begin.....");
		fd.readAndWriteXML(src,dst);
		
		
//		String string = "元胡(醋元胡/玄胡索/延胡)30炒谷芽(炒稻芽)30g";
//		ChineseMedicine chineseMedicine = fd.parseChineseMedicine(string);
//		System.out.println(chineseMedicine.getNameString());
	}

}
