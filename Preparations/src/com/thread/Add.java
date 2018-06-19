package com.thread;

/**
 * 不使用+-/ 求两个数的和
 * @author Administrator
 *
 */
public class Add {

	/**
	 * 使用位与和亦或的运算方式
	 * 亦或可以实现无进位的加法
	 * 位与可以判断当前位是否存在进位的问题
	 * @param num1
	 * @param num2
	 * @return
	 */
    public int Add(int num1, int num2) {
    	
    	int yi=num1 ^ num2;
    	int yu=(num1 & num2)<<1;
    	
    	//如果存在进位
    	while(yu!=0) {
    		int temp=yi ^ yu;
    		yu=(yi & yu)<<1;
    		yi=temp;
    	}
        return yi;
    }
	
    public String toBits(int num) {
    	int bit;
    	String str="";
    	while(num!=0) {
    		bit=num % 2;
    		str=bit+str;
    		num=num>>1;
    	}
    	return str;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=0;
		Add add=new Add();
		res=add.Add(5, 7);
		System.out.println(res);
	}

}
