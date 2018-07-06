package com.thread.lib;

public class StringToNumber {

    public boolean isNumeric(char[] str) {
    	//����
    	for(int i=0; i<str.length; i++) {
    		char c=str[i];
    		if(!(c>='0' && c<='9') && c!='+' && c!='-' && c!='e' && c!='E' && c!='.') {
    			return false;
    		}
    	}    	
    	//�ж��������֯�Ƿ����
    	int i=0; 
    	int dot=0;
    	int chars=0;
    	while(i<str.length) {
    		char c=str[i];
    		//�ж�С����ĸ���
    		if(c=='.') {
    			dot++; 
    			if(dot>1) {
    				return false;
    			}
    			//���С������ָ�����������Ϊ����
    			if(chars!=0) {
    				return false;
    			}
    		}   
    		//�ж������ŵڶ��γ��ֵ�λ��
    		else if(i>0 && (c=='+' || c=='-')) {
    			if(i-1>=0 && str[i-1]!='e' && str[i-1]!='E') {
    				return false;
    			}
    		}
    		//�ж�e���ֵĴ���
    		else if(c=='e' || c=='E') {
    			chars++;
    			if(chars>1) {
    				return false;
    			}   
    			//�ж��Ƿ�Ϊ���һ��Ԫ��
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
