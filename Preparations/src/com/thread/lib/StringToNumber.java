package com.thread.lib;

public class StringToNumber {

    public boolean isNumeric(char[] str) {
    	//过滤
    	for(int i=0; i<str.length; i++) {
    		char c=str[i];
    		if(!(c>='0' && c<='9') && c!='+' && c!='-' && c!='e' && c!='E' && c!='.') {
    			return false;
    		}
    	}    	
    	//判断整体的组织是否合理
    	int i=0; 
    	int dot=0;
    	int chars=0;
    	while(i<str.length) {
    		char c=str[i];
    		//判断小数点的个数
    		if(c=='.') {
    			dot++; 
    			if(dot>1) {
    				return false;
    			}
    			//如果小数点在指数后面出现认为错误
    			if(chars!=0) {
    				return false;
    			}
    		}   
    		//判断正负号第二次出现的位置
    		else if(i>0 && (c=='+' || c=='-')) {
    			if(i-1>=0 && str[i-1]!='e' && str[i-1]!='E') {
    				return false;
    			}
    		}
    		//判断e出现的次数
    		else if(c=='e' || c=='E') {
    			chars++;
    			if(chars>1) {
    				return false;
    			}   
    			//判断是否为最后一个元素
    			if(i==str.length-1) {
    				return false;
    			}
    		}
    		i++;
    	}
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
