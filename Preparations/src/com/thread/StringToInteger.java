package com.thread;

/**
 * 将字符串转化为整数，如果不合法，那么直接返回0
 * @author Administrator
 *
 */
public class StringToInteger {

    public int StrToInt(String str) {
    	
    	if(str.trim().equals("")) {
    		return 0;
    	}
    	
    	int res=0;
    	int mi=1;
    	int i=0;
    	//判断正负号
    	boolean negative=false;
    	char c=str.charAt(i);
    	if(c=='+' || c=='-') {
    		if(c=='-') {
    			negative=true;
    		}
    		str=str.substring(1);
    	}
    	
    	//对数字的部分进行转化
    	for(i=str.length()-1; i>=0; i--) {
    		char c1=str.charAt(i);
    		//如果是数字
    		if((c1>='0' && c1<='9')) {
    			
    			int t=c1-'0';
    			res=res+t*mi;    			
    		}else {
    			return 0;
    		}
    		mi=mi*10;
    	}
    	if(negative==true) {
    		return -res;
    	}
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="+1234";
		StringToInteger sti=new StringToInteger();
		int res=sti.StrToInt(str);
		System.out.println(res);
		Integer.parseInt(str);
	}

}
