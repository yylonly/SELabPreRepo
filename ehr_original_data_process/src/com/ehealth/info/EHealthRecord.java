package com.ehealth.info;

import java.util.List;

public class EHealthRecord {

	/**
	 *  电子病历类
	 *  	主要包括：	1、医院信息
	 *  				2、病人信息
	 *  				3、病症描述
	 *  				4、中西医诊断
	 *  				5、处理/处方
	 *  
	 */
	
	private String id;
	
	/*
	 * 时间批次
	 */
	private String batchString;
	
	
	
	/*
	 * 挂号号
	 */
	private String registrationno;
	
	/*
	 * 医院
	 */
	private String hospital;
	
	/*
	 * 科别
	 */
	private String medicalservice;
	
	/*
	 * 时间
	 */
	private String date;
	
	/*
	 * 病人基本信息 
	 */
	private PatientInfo patientInfo;	
	/*
	 *病症描述 
	 */
	private String conditionsdescribed;
	/*
	 *中西医诊断 
	 */
	private String westerndiagnostics;//西医诊断
	private String chinesediagnostics;//中医诊断
	
	/*
	 * 处理/处方
	 */
	private String procesString; // 处理
	
	private List<WesternMedicine> westernMedicines;// 西药处方
	
	private List<ChineseMedicine> chineseMedicines;// 中药处方
	
	private String chineseProcess; // 中药处理
	
	/*
	 * 医师
	 */
	private String doctor;
	
	
	
	public EHealthRecord(){
//		patientInfo = new PatientInfo(nameString, ageString, genderString, prof, phone, cont, addr)
	}
	
	/**
	 *  toString()
	 */
	public String toString(){
		String result = "";
		
		// 1、医院信息
		
		result = "hospital: " + this.hospital + "\n" +
				 "date: " + this.date + "\n" +
				 "medicalservice: " + this.medicalservice + "\n";				 
		
		
		// 2、病人信息
		if(this.patientInfo != null){
			result += "[patientinfo]:\n" + this.patientInfo.toString() + "\n";
		}
		
		// 3、病症描述
		result += "conditionsdescribed: " + this.conditionsdescribed + "\n";
		// 4、中西医诊断
		result += "westerndiagnostics: " + this.westerndiagnostics + "\n";
		result += "chinesediagnostics: " + this.chinesediagnostics + "\n";
		// 5、处理
		result += "process: " + this.procesString + "\n";		
		// 6、中西医处方
		//   6.1 西药处方
		if(this.westernMedicines != null && this.westernMedicines.size() > 0){
			result += "[westernMedicines]:\n";
			for(WesternMedicine w : westernMedicines){
				result += w.toString() + "\n";
			}
		}
		//   6.2 中药处方
//		System.out.println("[chinese medicine size]:" + this.chineseMedicines.size());
		if(this.chineseMedicines != null && this.chineseMedicines.size() > 0){
			result += "[chineseMedicines]:\n";
			for(ChineseMedicine c : this.chineseMedicines){
				if(c != null){
					result += c.toString() + "\n";
//					System.out.println(c.toString());
				}
			}
		}
		
		// 7、中药处方操作
		result += "chineseprocess:\n" + this.chineseProcess + "\n";
		
		// 8. doctor
		result += "doctor: " + this.doctor;	
		
		return result;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String idString){
		this.id = idString;
	}
	
	public String getRegistrationno(){
		return this.registrationno;
	}
	public void setRegistrationno(String string){
		this.registrationno = string;
	}
	
	public String getHospital(){
		return this.hospital;
	}
	public void setHospital(String string){
		this.hospital = string;
	}
	public String getMedicalservice(){
		return this.medicalservice;
	}
	public void setMedicalService(String string){
		this.medicalservice = string;
	}
	public String getDate(){
		return this.date;
	}
	public void setDate(String string){
		this.date = string;
	}
	public PatientInfo getPatientInfo(){
		return this.patientInfo;
	}
	public void setPatientInfo(PatientInfo pi){
		this.patientInfo = pi;
	}
	public String getConditionsdescribed(){
		return this.conditionsdescribed;
	}
	public void setConditionsdescribed(String string){
		this.conditionsdescribed = string;
	}
	public String getWesterndiagnostics(){
		return this.westerndiagnostics;
	}
	public void setWesterndiagnostics(String string){
		this.westerndiagnostics = string;
	}
	
	public String getChinesediagnostics(){
		return this.chinesediagnostics;
	}
	public void setChinesediagnostics(String string){
		this.chinesediagnostics = string;
	}
	public String getProcessString(){
		return this.procesString;
	}
	public void setProcessString(String string){
		this.procesString = string;
	}
	public List<WesternMedicine> getWesternMedicines(){
		return this.westernMedicines;
	}
	public void setWesternMedicines(List<WesternMedicine> list){
		this.westernMedicines = list;
	}
	public List<ChineseMedicine> getChineseMedicines(){
		return this.chineseMedicines;
	}
	public void setChineseMedicines(List<ChineseMedicine> list){
		this.chineseMedicines = list;
	}
	
	public String getChineseProcess(){
		return this.chineseProcess;
	}
	public void setChineseProcess(String string){
		this.chineseProcess = string;
	}
	
	public String getDoctor(){
		return this.doctor;
	}
	public void setDoctor(String string){
		this.doctor = string;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getBatchString() {
		return batchString;
	}

	public void setBatchString(String batchString) {
		this.batchString = batchString;
	}

}
