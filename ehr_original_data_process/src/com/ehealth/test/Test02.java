package com.ehealth.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.Subject;

import com.ehealth.info.ChineseMedicine;

public class Test02 {
	
	

	public static String[] getMedicineName(String string){
		if(string == ""){
			return null;
		}
		
		String[] medicineName = null;
		
		if(string.contains("(") || string.contains("（")){
			//
		}else{
			// 没有别名
		}
		return medicineName;
	}
	
	/**
	 *  解析中药－－－只有名称
	 * @param string
	 */
	public static List<String>  parseChineseMedicine1(String string){
		if(string == ""){
			return null;
		}
		String medicineName = "";
		List<String> medicineList = new ArrayList<String>();
		int start = 0;
		int end = 0;
		
		if(string.contains("(") || string.contains("（")){
			//带有（或者(的
			//数量 ： 1 －－－－－别名或补充，只有一味中药
			
			char[] chars = string.toCharArray();
			int length = chars.length; // 长度
			int biasNumber = 0; // (的数量，判断是否两味中药在一行了
			for(char c : chars ){
				if(c == '(' || c == '（'){
					biasNumber++;
				}
			}
			System.out.println(biasNumber);
			switch (biasNumber) {
			case 1:
				int indexBias = 0; // 第一个(索引
				int indexNumber = 0; // 第一个数字索引
				for(int i = 0; i < length ;i++){
					if(chars[i] == '(' || chars[i] == '（'){
						indexBias = i;
						break;
					}
				}
				for(int i = 0; i < length ;i++){
					if(chars[i] > 48 && chars[i] < 57){
						indexNumber = i;
						break;
					}
				}
				
				if(indexBias > indexNumber && indexBias - indexNumber > 3){
					// 两味中药连在一起
					String first = string.substring(start,indexNumber);
					medicineList.add(first);
					String secondString = string.substring(indexNumber + 3,indexBias);
					medicineList.add(secondString);
				}else{
					System.out.println( indexBias + " " +indexNumber);
					end = indexBias < indexNumber? indexBias : indexNumber ;
//					System.out.println(end);
					medicineList.add(string.substring(start,end));
				}
				break;

			default:
				int firstBias = 0;
				int secondBias = 0;
				int firstNumber = 0;
				int secondNumber = 0;
				for(int i = 0; i < length; i++){
					if((chars[i] == '(' || chars[i] == '（') && firstBias == 0){
						firstBias = i;
					}
					if((chars[i] == '(' || chars[i] == '（') && firstBias != 0){
						secondBias = i;
					}
					if(chars[i] > 48 && chars[i] < 57 && firstNumber == 0){
						firstNumber = i;
					}
					if(chars[i] > 48 && chars[i] < 57 && firstNumber != 0){
						secondNumber = i;
					}
				}
				System.out.println(firstBias + " " + secondBias + " " + firstNumber + " " +secondNumber);
				String tmpString = string.substring(start,(firstBias < firstNumber? firstBias:firstNumber));
				medicineList.add(tmpString);
				tmpString = string.substring(firstNumber+3,(secondBias < secondNumber ? secondBias:secondNumber));
				medicineList.add(tmpString);
				break;
			}
			
			//数量 ： 2---------两味中药 或  一味中药带有补充
			
		}else{
			//不含别名和后缀补充的中药
			char[] chars = string.toCharArray();
			int length = chars.length;
			for(int i = 0; i < length; i++ ){
				if(chars[i] > 48 && chars[i] < 57){
					end = i;
					break;
				}
			}
			medicineName = string.substring(start,end);
			
		}
		
		System.out.println("medicine name: " + medicineList);
		return medicineList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String medicineString = "甘草15g(仙剑)";
//		String medicineString = "甘草15g(仙剑)";
//		String medicineString = "甘草(仙剑)15g";
//		String medicineString = "炒薏苡仁(炒苡仁/炒苡米)30g白花蛇舌草(蛇舌草)30g";
//		String medicineString = "炒薏苡仁30g白花蛇舌草(蛇舌草)30g";
//		String medicineString = "预知子(八月扎、蓣知子）15g石见穿30g";
		String medicineString = "水牛角（水牛角15g（先见）";

//		char[] medicinechar = medicineString.toCharArray();
//		System.out.println(medicinechar[7]);
		List<String> medicinenList = parseChineseMedicine1(medicineString);
		
	}

}
