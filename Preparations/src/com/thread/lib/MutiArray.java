package com.thread.lib;

public class MutiArray {

    public int[] multiply(int[] A) {
    	if(A.length<=1){
    		return A;
    	}
    	int []left=new int[A.length];
    	int []right=new int[A.length];
    	left[0]=A[0];
    	right[A.length-1]=A[A.length-1];
    	
    	//初始化两个辅助数组
    	for(int i=1; i<A.length; i++) {

    		left[i]=left[i-1]*A[i];
    		int index=A.length-i-1;
    		right[index]=right[index+1]*A[index];
    	}
    	
    	A[0]=right[1];
    	A[A.length-1]=left[left.length-2];
    	
    	//获得乘积数组
    	for(int i=1; i<A.length-1; i++) {
    		A[i]=left[i-1]*right[i+1];
    	}
        return A;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []array= {1, 2, 3, 4, 5, 6};
//		int []array= {1,2,3,4};
//		int []array= {1,2,3};
//		int []array= {1,2};
//		int []array= {1};
		int []array= {};
		MutiArray ma=new MutiArray();
		int []res=ma.multiply(array);
		
		for(int i=0; i<res.length; i++) {
			System.out.println(res[i]);
		}
	}

}
