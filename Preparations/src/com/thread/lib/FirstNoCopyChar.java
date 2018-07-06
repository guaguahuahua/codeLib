package com.thread.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstNoCopyChar {

/*	Map<Character, Integer> map=new HashMap<Character, Integer>();
	char current='#';
	boolean hasOnceChar=false;
	boolean newChar=false;
    //Insert one char from stringstream
    public void Insert(char ch){
    	int times=map.getOrDefault(ch, 0);
	
    	//���û�е�һ������һ�ε��ַ�
    	if(hasOnceChar==false) {
        	if(times==0) {
        		current=ch;
        	}   		
        	hasOnceChar=true;
        	newChar=true;
    	}
    	
    	if(newChar==false) {
        	//�����һ������һ�ε��ַ��ٴγ�����
        	if(hasOnceChar==true && ch==current) {    		
        		current='#';
        		hasOnceChar=false;
        	}
    	}else {
    		newChar=false;
    	}
		map.put(ch, ++times);
    }
    
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
    	
    	return current;
    }*/
	
/*	List<Character> list=new ArrayList<Character>();
	Map<Character, Integer> map=new HashMap<Character, Integer>();
	char current=' ';
	boolean firstNewChar=true;
	int index=1;
	boolean jump=true;
	
    //Insert one char from stringstream
    public void Insert(char ch){
    	//��ȡ���ַ����ִ���
        int times=map.getOrDefault(ch, 0);
        //������ֵ�һ�ε��ַ�û�г���
        if(firstNewChar==true) {
        	if(times==0) {
        		current=ch;
        		firstNewChar=false;
        		jump=true;
        	}
        }
        
        if(times==0) {
        	list.add(ch);
        }
        map.put(ch, times+1);
        //������ַ��ڶ��γ�����
        if(jump==false) {
	        if(ch==current) {
	        	//����Ѱ��һ��ֻ����һ�ε��ַ�
	        	while(index<list.size()) {
	        		char c=list.get(index);
	        		int t=map.get(c);
	        		//������ַ����ֵĴ���Ϊ1
	        		if(t==1) {
	        			current=c;
	        			break;
	        		}
	        		index++;
	        	}
	        	if(index==list.size()) {
	        		current='#';
	        		firstNewChar=true;
	        	}
	        }
        }
        jump=false;
    }
    
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	return current;
    }*/
	
	int index=1;
	int []hashTable=new int[256];
	
    //Insert one char from stringstream
    public void Insert(char ch){
    	if(hashTable[ch]==0) {
    		hashTable[ch]=index;
    	}else if(hashTable[ch]>=1){
    		//Ҳ����˵�ڶ��γ��ֵĻ�
    		hashTable[ch]=-1;
    	}
    	index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
    	char c='#';
    	int minIndex=Integer.MAX_VALUE;
    	for(int i=0; i<256; i++) {
    		if(hashTable[i]>=1 && hashTable[i]<minIndex) {
    			c=(char)i;
    			minIndex=hashTable[i];
    		}
    	}
    	return c;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstNoCopyChar fnc=new FirstNoCopyChar();
//		String s="google";
		String s="BabyBaby";
		for(int i=0; i<s.length(); i++) {
			char ch=s.charAt(i);
			fnc.Insert(ch);
			System.out.println(fnc.FirstAppearingOnce());
		}
	}

}
