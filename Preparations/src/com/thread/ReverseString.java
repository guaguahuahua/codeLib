package com.thread;

public class ReverseString {

    public String ReverseSentence(String str) {
    	if(str.equals(" ")) {
    		return " ";
    	}
    	if(str.equals("")) {
    		return "";
    	}
    	if(str.trim().equals("")) {
    		return str;
    	}
    	String []words=str.split("\\s+");
    	String s="";
    	for(int i=words.length-1; i>=0; i--) {
    		s=s+words[i]+" ";
    	}
    	String res=s.substring(0, s.length()-1);
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s="student am i";
		String s="";
		ReverseString rs=new ReverseString();				
		String res=rs.ReverseSentence(s);
		System.out.println(res);
		
//		System.out.println(s.substring(0, s.length()-1));
	}

}
