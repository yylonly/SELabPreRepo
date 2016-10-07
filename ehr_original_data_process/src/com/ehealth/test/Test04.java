package com.ehealth.test;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Test04 {
	
	public static String getPinyinString(String string) throws BadHanyuPinyinOutputFormatCombination{
		if(string == ""){
			return "";
		}
		String pinyin = "";
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE); //小写字符
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE); // 无音标
		format.setVCharType(HanyuPinyinVCharType.WITH_V); // nv
		
		char[] chars = string.toCharArray();
		
		for(char c : chars){
			pinyin += PinyinHelper.toHanyuPinyinStringArray(c, format)[0];
		}
		
		
		return pinyin ;
	}

	public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
		// TODO Auto-generated method stub
		
		String pinString = getPinyinString("冲动");
		System.out.println(pinString);
	}

}
