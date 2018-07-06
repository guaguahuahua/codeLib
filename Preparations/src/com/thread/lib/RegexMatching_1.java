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
		
		//如果模式串中的当前字符的位置
		if(pi+1<pattern.length && pattern[pi+1]=='*') {
			//当前的字符相等
			if(si<str.length && (str[si]==pattern[pi] || pattern[pi]=='.')) {
				return judge(str, si, pattern, pi+2)       //代表0次出现
						|| judge(str, si+1, pattern, pi+2) //代表1次
						|| judge(str, si+1, pattern, pi);  //代表多次
				
			//当前的字符不相等，模式串向后移动2个位置
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
