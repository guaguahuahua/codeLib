package com.thread.lib;

public class RegexMatching_1 {
	
	public boolean match(char []str, char []pattern) {
		
		if(str==null || pattern==null) {
			return true;
		}
		return judge(str, 0, pattern, 0);
	}
	
	public boolean judge(char []str, int si, char []pattern, int pi) {
		
		if(si==str.length && pi==pattern.length) {
			return true;
		}
		
		if(si<str.length && pi==pattern.length) {
			return false;
		}
		
		//���ģʽ���еĵ�ǰ�ַ���λ��
		if(pi+1<pattern.length && pattern[pi+1]=='*') {
			//��ǰ���ַ����
			if(si<str.length && (str[si]==pattern[pi] || pattern[pi]=='.')) {
				return judge(str, si, pattern, pi+2)       //����0�γ���
						|| judge(str, si+1, pattern, pi+2) //����1��
						|| judge(str, si+1, pattern, pi);  //������
				
			//��ǰ���ַ�����ȣ�ģʽ������ƶ�2��λ��
			}else {
				return judge(str, si, pattern, pi+2);
			}
		}
		
		if((si<str.length && pi<pattern.length) && (pattern[pi]==str[si] || pattern[pi]=='.' || str[si]=='.')) {
			return judge(str, si+1, pattern, pi+1);
		}
		
		return false;
	}
}
