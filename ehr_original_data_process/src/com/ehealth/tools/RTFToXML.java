package com.ehealth.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ehealth.info.ChineseMedicine;
import com.ehealth.info.EHealthRecord;
import com.ehealth.info.PatientInfo;
import com.ehealth.info.WesternMedicine;

/**
 * 功能：
 *    将RTF格式的电子病例根据相应的XML结构转为XML格式；
 * @author heermaster
 *
 */
public class RTFToXML {
	/**
	 * 
	 * @param src
	 * @return
	 * @throws IOException  
	 * @throws BadLocationException 
	 * @throws TransformerException 
	 * @throws ParserConfigurationException 
	 */
	public void readAndWriteXML(File src,File dst) throws IOException, BadLocationException, ParserConfigurationException, TransformerException{
		
		File[] fs = src.listFiles(); //数据源文件		
		int index = 0; //序号		
		
		for(File f:fs){
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
					String parentString = f.getParent();

					String batchString = "batch：" + parentString.substring(parentString.length()-4,parentString.length()); //批次:时间
					System.out.println(batchString);
					text = batchString + "     " + text;
					// CLEAR
					rtf = null;
					dsd = null;
					
					// 解析text	
					String[] strings = parseString(text.trim());
					
					EHealthRecord eHealthRecord = createEhealthRecord(strings);
					
					String dstPath = dst + File.separator + f.getParentFile().getName();
					File dstpathFile  = new File(dstPath);
					if(!dstpathFile.exists()){
						dstpathFile.mkdirs();
					}
					
					String dstString = dstPath + File.separator +f.getName().substring(0,f.getName().length()-4) + ".xml";
//					System.out.println("dst:" + dstString);
					File dstfFile = new File(dstString);
					
					if(!dstfFile.exists()){
						dstfFile.createNewFile();
					}
					
					if(dstfFile != null){
						if(createXML(eHealthRecord, dstfFile)){
							System.out.println("success");
						}else{
							System.out.println("faild");
						}
					}
				}
				index++;
			}
		}
	}
	
	/**
	 *  parse the text 
	 * @param string
	 * @return
	 */
	public String[] parseString(String string){
		
		String[] strings = string.split("\\s{1,20}|\\n"); // 多个空格或回车
		System.out.println("[batch]:" + strings[0]);
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
		
		// 处理文本
//		System.out.println("[strings length]:" + strings.length);
		
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
				tmpList.add(strings[i].trim());  // 去除空行和------------------------
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
//	public ChineseMedicine parseChineseMedicine(String string){
//		if("".equals(string)){
//			return null;
//		}
////		System.out.println("[string]:" + string);
//		ChineseMedicine result = null;
//		
//		char[] cnmedicines = string.trim().toCharArray();
//		
//		int start = 0;  // ( 的索引
//		int end = 0; // )的索引，若没有，则是数字的索引
//		boolean isEnd = false;
//		boolean hasEnd = false; // 以 )或）结尾
//		boolean hasStart = false; //以（或(开始，防止出现多个
//		int biasCount = 0;// 别名数量
//		int indexNumber = 0;
//		
//		List<Integer> biasIndex = new ArrayList<Integer>();  // 别名索引
//		
//		for(int i = 0; i < cnmedicines.length;i++){
//			if(cnmedicines[i] == '(' || cnmedicines[i] == '（'){
//				if(!hasStart){
//					start = i;
//					biasCount++; // 有别名
//					hasStart = true;
//				}
//			}
//			if(cnmedicines[i] == ')' || cnmedicines[i] == '）' || cnmedicines[i] > 48 && cnmedicines[i] < 57){
//				if(!isEnd){
//					end = i;
//					isEnd = true;
//				}
//			}
//			if(cnmedicines[i] == '/' || cnmedicines[i] == '、'){
//				biasIndex.add(i);
//				biasCount++; // 不止一个别名
//			}
//			if(cnmedicines[i] == ')' || cnmedicines[i] == '）'){
//				// 以 )或）结尾
//				hasEnd = true;
//			}
//			if(cnmedicines[i] > 48 && cnmedicines[i] < 57 && indexNumber == 0){
//				indexNumber = i;
//			}
//		}		
//		// 重组信息
//		// 索引： 0--------->start------->/----->end----->(length-2)------>(length-1)
//		String cnMedicineName = "";
//		List<String> biasNames = new ArrayList<String>(); // bias name
//		String number = "";
//		String unit = "";
//		
//		int length = cnmedicines.length;
//		
//		cnMedicineName = string.trim().substring(0,(hasStart?start:end)); // 需要判断有无别名
//		
//		// 别名处理
//		if(biasCount == 0){
//		}else if(biasCount == 1){
//			// 一个别名
//			if(end == string.length()){
//				String tmp = string.trim().substring(start+1,end);
//				biasNames.add(tmp);
//			}
//			
//		}else if(biasCount > 1){
//			//多个别名
//			for(int i = 0;i<biasCount;i++){
//				if(i == 0){
//					// start -----> [0]
//					String tmp = string.trim().substring(start+1,biasIndex.get(i));
//					biasNames.add(tmp);
//				}else if(i == biasCount-1){
//					String tmp = string.trim().substring(biasIndex.get(i-1)+1,(end == 0? length:end));
//					biasNames.add(tmp);
//				}else{
//					String tmp = string.trim().substring(biasIndex.get(i-1)+1,biasIndex.get(i));
//					biasNames.add(tmp);
//				}
//			}
//		}
//		if(indexNumber < start){
//			number = "0";
//		}else{
//			if((hasEnd? end + 1 : end) < length-2){
//				number = string.trim().substring((hasEnd? end + 1 : end), length-1); // 数量
//			}
//		}
//		
//		
//		unit = string.trim().substring(length-1,length); // 单位
//		
//		result = new ChineseMedicine(cnMedicineName, biasNames, number, unit);
//		return result;
//	}
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
	 *  create xml file 
	 * @param eHealthRecord
	 * @param path   保存xml文件位置
	 * @return
	 * @throws ParserConfigurationException 
	 * @throws FileNotFoundException 
	 * @throws TransformerException 
	 */
	public boolean createXML(EHealthRecord eHealthRecord, File path) throws ParserConfigurationException, FileNotFoundException, TransformerException{
		boolean flag = true;
		if(eHealthRecord == null || path == null){
			return false;
		}
		
		//初始化		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();		
		Document document = db.newDocument();
				
		// 解析病历信息
		// 1、 根节点-----ehealthrecord
		Element root = document.createElement("ehealthrecord");
//		document.appendChild(root);
		
		// 病例批次：时间
		if(eHealthRecord.getBatchString() != ""){
			System.out.println(eHealthRecord.getBatchString());
			Element batch = document.createElement("batch");
			batch.setTextContent(eHealthRecord.getBatchString());;
			root.appendChild(batch);
		}
		
		//2. 医院
		if(eHealthRecord.getHospital()!= ""){
			Element hospital = document.createElement("hospital");
			hospital.setTextContent(eHealthRecord.getHospital());
			root.appendChild(hospital);
		}	
		
		// 3、科别
		if(eHealthRecord.getMedicalservice() != ""){
			Element medicalservice = document.createElement("medicineservice");
			medicalservice.setTextContent(eHealthRecord.getMedicalservice());
			root.appendChild(medicalservice);
		}
		// 4、日期
		if(eHealthRecord.getDate() != ""){
			Element datElement = document.createElement("date");
			datElement.setTextContent(eHealthRecord.getDate());
			root.appendChild(datElement);
		}
		// 5、挂号号
		if(eHealthRecord.getRegistrationno() != ""){
			Element registrationno = document.createElement("registrationno");
			registrationno.setTextContent(eHealthRecord.getRegistrationno());
			root.appendChild(registrationno);
		}
		// 6、医师
		if(eHealthRecord.getDoctor() != ""){
			Element doctor = document.createElement("doctor");
			doctor.setTextContent(eHealthRecord.getDoctor());
			root.appendChild(doctor);
		}
		// 7、病人信息
		if(eHealthRecord.getPatientInfo() != null){
			PatientInfo patientInfo = eHealthRecord.getPatientInfo();
			Element patient = document.createElement("patientinfo");
			
			
			if(patientInfo.getName() != ""){
				// 7.1 姓名
				Element patientname = document.createElement("name");
				patientname.setTextContent(patientInfo.getName());
				patient.appendChild(patientname);
			}
			
			if(patientInfo.getAge() != ""){
				// 7.2 年龄
				Element patientage = document.createElement("age");
				patientage.setTextContent(patientInfo.getAge());
				patient.appendChild(patientage);
			}
			
			if(patientInfo.getGender() != ""){
				//	7.3 性别
				Element patientgender = document.createElement("gender");
				patientgender.setTextContent(patientInfo.getGender());
				patient.appendChild(patientgender);
			}
			
			if(patientInfo.getProfession() != ""){
				//	7.4 职业
				Element profession = document.createElement("profession");
				profession.setTextContent(patientInfo.getProfession());
				patient.appendChild(profession);
			}
			
			if(patientInfo.getPhoneNumber() != ""){
				// 7.5 手机号
				Element phone = document.createElement("phone");
				phone.setTextContent(patientInfo.getPhoneNumber());
				patient.appendChild(phone);
			}
			
			if(patientInfo.getContact() != ""){
				// 7.6 联系人
				Element contact = document.createElement("contact");
				contact.setTextContent(patientInfo.getContact());
				patient.appendChild(contact);
			}
			
			if(patientInfo.getAddress() != ""){
				// 7.7 地址
				Element address = document.createElement("address");
				address.setTextContent(patientInfo.getAddress());
				patient.appendChild(address);
			}		
			
					
			root.appendChild(patient);			
		}
		
		// 8、病症描述
		if(eHealthRecord.getConditionsdescribed() != ""){
			Element condition = document.createElement("conditionsdescribed");
			condition.setTextContent(eHealthRecord.getConditionsdescribed());
			root.appendChild(condition);
		}
		
		// 9、诊断
		if(eHealthRecord.getWesterndiagnostics() != "" ||
				eHealthRecord.getChinesediagnostics() != ""){
			Element diagElement = document.createElement("diagnostics");
			
			// 9.1 西医诊断
			if(eHealthRecord.getWesterndiagnostics() != ""){
				Element wdiag = document.createElement("westerndiagnostics");
				wdiag.setTextContent(eHealthRecord.getWesterndiagnostics());
				diagElement.appendChild(wdiag);
			}
			// 9.2 中医诊断
			if (eHealthRecord.getChinesediagnostics() != "") {
				Element cdiag = document.createElement("chinesediagnostics");
				cdiag.setTextContent(eHealthRecord.getChinesediagnostics());
				diagElement.appendChild(cdiag);
			}					
			root.appendChild(diagElement);
		}	
	
		// 10、处理
		if(eHealthRecord.getProcessString() != ""){
			Element process = document.createElement("process");
			System.out.println("    [process]" + eHealthRecord.getProcessString());
			process.setTextContent(eHealthRecord.getProcessString());
			root.appendChild(process);
		}else{
			System.out.println("    [process]:process is null");
		}
		
		// 11、处方
		if(eHealthRecord.getChineseMedicines() != null || eHealthRecord.getChineseMedicines().size() > 0 || 
				eHealthRecord.getWesternMedicines() != null || eHealthRecord.getWesternMedicines().size() >0){
			
			Element medicine = document.createElement("medicine");
			
			// 11.1 西药处方
			if(eHealthRecord.getWesternMedicines() != null &&
					eHealthRecord.getWesternMedicines().size() > 0){
				
				Element westMedicines = document.createElement("westernMedicines");
				
				for(WesternMedicine w : eHealthRecord.getWesternMedicines()){
					// 组
					Element med = document.createElement("westernMedicine");
					if(w.getGroupString() != ""){
						Element wgroup = document.createElement("group");
						wgroup.setTextContent(w.getGroupString());
						med.appendChild(wgroup);
					}
					// 名称
					if(w.getNameString() != ""){
						Element wname = document.createElement("wname");
						wname.setTextContent(w.getNameString());
						med.appendChild(wname);
					}
					
					// 规格
					if(w.getSpecifications() != ""){
						Element wspecification = document.createElement("specifications");
						wspecification.setTextContent(w.getSpecifications());
						med.appendChild(wspecification);
					}
					// 用法
					if(w.getUsageString() != ""){
						Element wusage = document.createElement("usage");
						wusage.setTextContent(w.getUsageString());
						med.appendChild(wusage);
					}
					// 总量
					if(w.getAmountString() != ""){
						Element wamount = document.createElement("amount");
						wamount.setTextContent(w.getAmountString());
						med.appendChild(wamount);
					}
					westMedicines.appendChild(med);
				}
				medicine.appendChild(westMedicines);
			}
			
			// 11.2 中药处方
			if(eHealthRecord.getChineseMedicines() != null &&
					eHealthRecord.getChineseMedicines().size() > 0){
				
				Element chnMedicines = document.createElement("chineseMedicines");
				
				for(ChineseMedicine c : eHealthRecord.getChineseMedicines()){
					Element cmedicine = document.createElement("chineseMedicine");
					
					if(c != null){
						// 名称
						if(c.getNameString() != ""){
							Element cname = document.createElement("cname");
							cname.setTextContent(c.getNameString());
							cmedicine.appendChild(cname);
						}				
						
						// 别名（多个或0个）
						if(c.getBiasList() != null && c.getBiasList().size() > 0){
							//
							int biascount = c.getBiasList().size();
							for(int i = 0; i < biascount; i++){
								Element bias = document.createElement("bias" + (i + 1));
								bias.setTextContent(c.getBiasList().get(i));
								cmedicine.appendChild(bias);
							}
						}
						
						// 数量
						if(c.getNumberString() != ""){
							Element number = document.createElement("number");
							number.setTextContent(c.getNumberString());
							cmedicine.appendChild(number);
						}
						
						// 单位
						if(c.getUnitString() != ""){
							Element unit = document.createElement("unit");
							unit.setTextContent(c.getUnitString());
							cmedicine.appendChild(unit);
						}
						
						chnMedicines.appendChild(cmedicine);
					}
				}
				
				medicine.appendChild(chnMedicines);
			}
			
			
			root.appendChild(medicine);
		}
		
		// add root
		document.appendChild(root);
		
		if(document == null){
			return !flag;
		}
		// 输出
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		
		DOMSource source = new DOMSource(document);
		
		//文件写入器
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(path));
		StreamResult result = new StreamResult(printWriter);
		
		// 执行写入操作
		transformer.transform(source, result);
		
		printWriter.close();
		
		return flag;
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
			if(strings[i].matches("batch.*")){
				tmp = strings[i].substring(6).trim();
				eHealthRecord.setBatchString(tmp);
			}else if(strings[i].matches("医院.*")){
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
					chineseMedicines.add(chineseMedicine);
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
	
	
	public static void main(String[] args) throws IOException, BadLocationException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
//		File src = new File("D:\\data\\2012\\女性1\\");
		File src = new File("/Users/heermaster/Documents/file/data1");
		File dst = new File("/Users/heermaster/Documents/file/xml1");
		
		RTFToXML fd = new RTFToXML();
		
		System.out.println("begin.....");
		fd.readAndWriteXML(src,dst);
		
	}

}
