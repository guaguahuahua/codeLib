package com.thread;

import java.util.ArrayList;

public class JohnsefRing {

    public int LastRemaining_Solution(int n, int m) {
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	//使用辅助数组
    	for(int i=0; i<n; i++) {
    		list.add(i);
    	}
    	int pre=0;
    	while(n>1) {
    		int out=(pre+m) % list.size();
    		out=out-1;
    		if(out<0) {
    			out=list.size()-1;
    		}
    		list.remove(out);
    		pre=out;
    		if(pre>=list.size()) {
    			pre=0;
    		}
    		n--;
    	}
        return list.get(0);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int m=3;
		JohnsefRing jr=new JohnsefRing();
		int res=jr.LastRemaining_Solution(n, m);
		System.out.println(res);
	}
}
