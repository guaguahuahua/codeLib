package com.thread;

public class Sum1Ton {

	private int s=0;
    public int Sum_Solution(int n) {
    	
    	boolean flag=(n>0 && (s=n+Sum_Solution(n-1))>0);
    	
        return s;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		Sum1Ton stn=new Sum1Ton();
		int res=stn.Sum_Solution(n);
		System.out.println(res);
	}

}
