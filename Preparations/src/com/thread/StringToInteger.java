package com.thread;

/**
 * ���ַ���ת��Ϊ������������Ϸ�����ôֱ�ӷ���0
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
    	//�ж�������
    	boolean negative=false;
    	char c=str.charAt(i);
    	if(c=='+' || c=='-') {
    		if(c=='-') {
    			negative=true;
    		}
    		str=str.substring(1);
    	}
    	
    	//�����ֵĲ��ֽ���ת��
    	for(i=str.length()-1; i>=0; i--) {
    		char c1=str.charAt(i);
    		//���������
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
