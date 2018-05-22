package com.swdegao.quartz.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.swdegao.quartz.entity.ScadaDevice;

public class StringUtils {
	
	/**
	 * 拼接所有字符串
	 * @param col
	 * @param separator
	 * @return
	 */
	public static StringBuffer join(Collection<ScadaDevice> col,String separator) {
		StringBuffer string = new StringBuffer();
		for(int i=0;i<col.size();i++) {
			ScadaDevice sDevice = (ScadaDevice)col.toArray()[i];
			string.append(sDevice.getUserTerminals());
			if(i<col.size()-1) {
				string.append(separator);
			}
		}
		return string;
	}
	
	/**
	 * 
	 * @param col
	 * @param separator
	 * @param size 一个字符串用几个子字符串拼接而成
	 * @return
	 * @throws Exception 
	 */
	public static List<StringBuffer> joinToList(Collection<ScadaDevice> col,String separator,int size) throws Exception {
		List<StringBuffer> list = new ArrayList<StringBuffer>();
		if(size==0 || col.size()<=size) {
			StringBuffer string = new StringBuffer();
			for(int i=0;i<col.size();i++) {
				ScadaDevice sDevice = (ScadaDevice)col.toArray()[i];
				string.append(sDevice.getUserTerminals());
				if(i<col.size()-1) {
					string.append(separator);
				}
			}
			list.add(string);
			return list;
		}else if(col.size()>size){
			int temp = col.size()%size ==0 ? col.size()/size : col.size()/size+1;
			for(int i=0;i<temp;i++) {
				StringBuffer string = new StringBuffer();
				for(int j=size*i;j<col.size()-size*(temp-1-i);j++) {
					ScadaDevice sDevice = (ScadaDevice)col.toArray()[j];
					string.append(sDevice.getUserTerminals());
					if(j<col.size()-size*(temp-1-i)-1) {
						string.append(separator);
					}
				}
				list.add(string);
			}
		}else if(size<0){
			 throw new Exception("输入size不能小于0");
		}
		
		return list;
	}
}
