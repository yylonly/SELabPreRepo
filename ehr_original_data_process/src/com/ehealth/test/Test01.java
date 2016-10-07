package com.ehealth.test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.ehealth.info.ChineseMedicine;
import com.ehealth.info.EHealthRecord;
import com.ehealth.info.PatientInfo;
import com.ehealth.info.WesternMedicine;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Test01 {
	
	
	/**
     *  convert bsonobject to ehealthrecord
     * @param bSONObject
     * @return 
     */
    public static EHealthRecord toEHealthRecord(Document bSONObject){
        if(bSONObject == null){
            return null;
        }
        ObjectId _id = (ObjectId) bSONObject.get("_id");
        
        Document ehealrecordDocument = (Document) bSONObject.get("ehealthrecord");
        
        Document patientInfoDoc = (Document) ehealrecordDocument.get("patientinfo");
        
        Document medicines = (Document) ehealrecordDocument.get("medicine");
        Document chineseMedicines = (Document) medicines.get("chineseMedicines");
        Document westernMedicines = (Document) medicines.get("westernMedicines");
        
        //诊断doc
        Document diagnostics = (Document) ehealrecordDocument.get("diagnostics");
        String chinesediagnostics = diagnostics.getString("chinesediagnostics");
        String westerndiagnostics = diagnostics.getString("westerndiagnostics");
        
        
        List<Document> cMedicineList = (List<Document>) chineseMedicines.get("chineseMedicine");
//        System.out.println(westernMedicines.get("westernMedicine").getClass());
        
        List<Document> wMedicineList = null;
        Document wMedicine = null;
        
        if(westernMedicines != null){
        	if(westernMedicines.get("westernMedicine") instanceof ArrayList){
            	wMedicineList = (List<Document>) westernMedicines.get("westernMedicine");
            }else{
            	wMedicine = (Document) westernMedicines.get("westernMedicine");
            }
        }
        
        List<ChineseMedicine> chineseMedicinesList = null;// 中药处方
        List<WesternMedicine> westernMedicinesList = null; // 西药处方
        PatientInfo patientInfo = null; //病人信息
        //中药处方
        if(cMedicineList != null && cMedicineList.size() > 0){
        	
        	chineseMedicinesList = new ArrayList<ChineseMedicine>();
        	
        	for(Document doc : cMedicineList){
            	ChineseMedicine c = listToChineseMedicine(doc);
            	if(c != null){
            		chineseMedicinesList.add(c);
            	}
            }
        }
        //西药处方
        if(wMedicineList != null || wMedicine != null){
        	//有西药
        	westernMedicinesList = new ArrayList<WesternMedicine>();
        	if(wMedicine != null){
        		//只有一种西药
        		WesternMedicine westernMedicine = docToWerstenMedicine(wMedicine);
        		westernMedicinesList.add(westernMedicine);
        	}
        	if(wMedicineList != null && wMedicineList.size() > 0){
        		// 多种西药
        		for(Document d : wMedicineList){
        			WesternMedicine w = docToWerstenMedicine(d);
        			westernMedicinesList.add(w);
        		}
        	}
        }
        
        //病人信息
        patientInfo = docToPatientInfo(patientInfoDoc);       
        
        
        if(ehealrecordDocument == null){
            return null;
        }
        
        String dateString = ehealrecordDocument.getString("date"); // 日期
        String doctorString = ehealrecordDocument.getString("doctor"); // 医师
        String medicineservice = ehealrecordDocument.getString("medicineservice"); // 科室
        String process = ehealrecordDocument.getString("process"); // 处理
        long registrationno = ehealrecordDocument.getLong("registrationno"); //  挂号号
        String hospitalString = ehealrecordDocument.getString("hospital");// 医院
        String conditionsdescribed = ehealrecordDocument.getString("conditionsdescribed"); // 病症描述
        
        
        
        EHealthRecord eHealthRecord = new EHealthRecord();
        eHealthRecord.setId(_id.toString());
        eHealthRecord.setDate(dateString);
        eHealthRecord.setDoctor(doctorString);
        eHealthRecord.setMedicalService(medicineservice);
        eHealthRecord.setProcessString(process);
        eHealthRecord.setRegistrationno(String.valueOf(registrationno));
        eHealthRecord.setHospital(hospitalString);
        eHealthRecord.setConditionsdescribed(conditionsdescribed);
        eHealthRecord.setChinesediagnostics(chinesediagnostics);
        eHealthRecord.setWesterndiagnostics(westerndiagnostics);
        
        //病人信息
        eHealthRecord.setPatientInfo(patientInfo);
        // 中医处方
        if(chineseMedicinesList != null && chineseMedicinesList.size() > 0){
        	eHealthRecord.setChineseMedicines(chineseMedicinesList);
        }
        // 西医处方
        if(westernMedicinesList != null && westernMedicinesList.size() > 0){
        	eHealthRecord.setWesternMedicines(westernMedicinesList);
        }
        //诊断信息
        
        
        return eHealthRecord;
    }
    
    /**
     * 
     * @param doc
     * @return
     */
    public static ChineseMedicine listToChineseMedicine(Document doc){
    	if(doc == null){
    		return null;
    	}
    	
    	String nameString = "";
    	int number = 0;
    	String uniString = "";
    	List<String> biasList = new ArrayList<String>();
    	
    	nameString = doc.getString("cname");
    	number = doc.getInteger("number");
    	uniString = doc.getString("unit");
    	
    	//别名
    	for(int i = 1; i < 4;i++){
    		String bString = doc.getString("bias"+i);
    		if(bString == null){
    			break;
    		}
    		biasList.add(bString);
    	}    	
    	
    	ChineseMedicine chineseMedicine = new ChineseMedicine(nameString, biasList, String.valueOf(number), uniString);
    	return chineseMedicine;
    	
    }
    
    /**
     *  doc----> westernmedicine
     * @param doc
     * @return
     */
    public static WesternMedicine docToWerstenMedicine(Document doc){
    	if(doc == null){
    		return null;
    	}
    	String group = String.valueOf(doc.getLong("group"));
    	String wname = doc.getString("wname");;
    	String amount = doc.getString("amount");
    	String usage = doc.getString("usage");
    	String specifications = doc.getString("specifications");
    	
    	WesternMedicine westernMedicine = new WesternMedicine(group, wname, specifications, usage, amount);   	
    	
    	return westernMedicine;
    }
    
    /**
     * Document{{profession=, address=海南省琼机运公, gender=男, phone=, contact=, name=杨务林, age=68岁}
     * @param doc
     * @return
     */
    public static PatientInfo docToPatientInfo(Document doc){
    	if(doc == null){
    		return null;
    	}
    	PatientInfo patientInfo = new PatientInfo();
    	
    	String name = doc.getString("name");
    	String gender = doc.getString("gender");
    	String age = doc.getString("age");
    	String profession = doc.getString("profession");
    	String address = doc.getString("address");
//    	String phone = String.valueOf(doc.getLong("phone"));
//    	String phone = doc.getString("phone");
    	String contact = doc.getString("contact");
    	
    	patientInfo.setName(name);
    	patientInfo.setGender(gender);
    	patientInfo.setAddress(address);
    	patientInfo.setAge(age);
    	patientInfo.setProfession(profession);
//    	patientInfo.setPhoneNumber(phone);
    	patientInfo.setContact(contact);
    	
    	return patientInfo;
    }
    
    /**
     * 
     * @param doc
     * @return
     */
    public static List<String> getChineseMedList(Document doc){
    	if(doc == null){
    		return null;
    	}
    	
    	List<String> resultList = new ArrayList<String>();
    	
    	Document ehealthDocument = (Document) doc.get("ehealthrecord");   	
    	
    	
    	Document medicines = null;
    	if(ehealthDocument.get("medicine") instanceof Document){
    		medicines = (Document) ehealthDocument.get("medicine");
    	}
    	
    	Document chineseMedicines = null;
    	if (medicines != null) {
    		if(medicines.get("chineseMedicines") instanceof Document){
        		chineseMedicines = (Document) medicines.get("chineseMedicines");
        	}
		}else{
			return null;
		} 	
    	
    	
    	List<Document> chineseList = null;
    	
    	if(chineseMedicines != null){
    		if(chineseMedicines.get("chineseMedicine") != null){
        		if(chineseMedicines.get("chineseMedicine") instanceof Document){
            		//
            		Document document = (Document) chineseMedicines.get("chineseMedicine");
            		resultList.add(document.getString("cname"));
            	}else{
            		chineseList = (List<Document>) chineseMedicines.get("chineseMedicine");
            		if(chineseList != null && chineseList.size() > 0){
                		for(Document d : chineseList){
                    		resultList.add(d.getString("cname"));
                    	}
                	}
            	}
        	}else{
        		return null;
        	}
    	}
    	   	
    	return resultList;
    	
    }
    
    public static HashMap<String, Integer> staticsChineseMedicine(List<String> list){
    	if(list == null || list.size() == 0){
    		return null;
    	}
    	
    	HashMap<String, Integer> results = new HashMap<String, Integer>();
    	
    	//统计
    	results.put(list.get(0), 1);
    	System.out.println("[0]" + list.get(0));
    	System.out.println(results.toString());
    	
    	for(int i = 1; i < list.size(); i++){
    		results = statics(list.get(i).trim(),results);
    	}
    	return results;
    } 
    
    public static HashMap<String, Integer> statics(String string,HashMap<String, Integer> tample){
    	
    	boolean flag = false;
    	
    	for(int i=0;i<tample.size();i++){
    		    		
    		if(tample.get(string) != null){
    			// 在里面
    			int count = tample.get(string);
    			count++;
    			tample.remove(string);
    			tample.put(string, count);
    			flag = true;
    			break;
    		}    		
    	}
    	if(!flag){
    		//不在
    		tample.put(string, 1);
    	}
//    	System.out.println(string + ":" + tample.get(string));
    	return tample;
    }
    
    public static List<HashMap<String,Integer>> sortArrayList(List<HashMap<String,Integer>> list){
    	if(list == null || list.size() == 0){
    		return null;
    	}
    	
    	int length = list.size();
    	
    	
    	List<HashMap<String,Integer>> result = new ArrayList<HashMap<String,Integer>>(length);
    	
    	int maxValue = -1;
    	int index = 0;
    	for(int i = 0;i < length;i++){
    		HashMap<String, Integer> m = list.get(i);
    		
    	}
    	
    	
    	return result;
    }
    
    public static HashMap<String,Integer> sortMap(HashMap<String,Integer> map){
        if(map == null){
            return null;
        }
        HashMap<String,Integer> resultMap = new HashMap<String,Integer>();
        
        List<Map.Entry<String, Integer>> listData = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        
        //排序
        Collections.sort(listData, new Comparator<Map.Entry<String, Integer>>(){
        	public int compare(Map.Entry<String,Integer > o1, Map.Entry<String, Integer> o2){
        			return (o2.getValue() - o1.getValue());
        		}
        	}
        );
        
        System.out.println(listData.toString());
        
        int length = listData.size();
        
        for(int i = 0;i < length;i++){
        	resultMap.put(listData.get(i).getKey().toString(), listData.get(i).getValue());
        	System.out.print(listData.get(i).getKey().toString()+":"+listData.get(i).getValue());
        }
        System.out.println("-----sort:"+ resultMap.toString());
        return resultMap;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient client = new MongoClient("localhost",27017);
		
		MongoDatabase database = client.getDatabase("db");
		
		MongoCollection<Document> collection = database.getCollection("ehealth");
//		MongoCursor<Document> cursor = collection.find(new BasicDBObject("ehealthrecord.patientinfo.name",
//				"杨务林")).iterator();
//		
//		while(cursor.hasNext()){
//			EHealthRecord eHealthRecord = toEHealthRecord(cursor.next());
//			System.out.println(eHealthRecord.toString());
//			
//		}
		
//		MongoCursor<Document> cursor1 = collection.find({},{'ehealthrecord.medicine.westernMedicines':1}).iterator();
//		Document document = new Document();
//		document.put("ehealthrecord.medicine.westernMedicines", 1);
		MongoCursor<Document> cursor1 = collection.find().iterator();
		List<String> resList = new ArrayList<String>();
		while(cursor1.hasNext()){
//			System.out.println(cursor1.next());
//			if(getChineseMedList(cursor1.next()) != null){
//				resList.addAll(getChineseMedList(cursor1.next()));
//			}
			List<String> tmp = getChineseMedList(cursor1.next());
			if(tmp != null){
				resList.addAll(tmp);
			}
		}
		System.out.println(resList.size());
		System.out.println(resList.toString());
		
		HashMap<String, Integer> rHashMaps = staticsChineseMedicine(resList);
		HashMap<String, Integer> sort = sortMap(rHashMaps);
		System.out.println(sort.toString());
		
		
			
//			Set set = /
			
		
//		
//		
		client.close();
	}

}
