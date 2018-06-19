package com.thread;

public class LeftRotateStrings {

    public String LeftRotateString_1(String str,int n) {
    	n=n % str.length();
    	String whole=reverse(str, 0, str.length()-1);
    	System.out.println(whole);
    	String left=reverse(whole, 0, whole.length()-n-1);
    	System.out.println(left);
    	String right=reverse(left, left.length()-n, left.length()-1);
    	System.out.println(right);
    	return right;
    }
    
    public String reverse(String s, int start, int end) {
    	String res="";
    	for(int i=end; i>=start; i--) {
    		res=res+s.charAt(i);
    	}
    	return s.substring(0, start)+res+s.substring(end+1);
    }
    
    public String LeftRotateString(String str,int n) {
    	if(str.equals("")) {
    		return "";
    	}
    	n=n % str.length();
    	String left=str.substring(0, n);
    	String right=str.substring(n);
    	
    	return right+left;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="abcXYZdef";
		LeftRotateStrings lrs=new LeftRotateStrings();
		String res=lrs.LeftRotateString(s, 3);
		System.out.println(res);
	}

}
