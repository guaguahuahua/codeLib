package com.thread.lib;

public class RegexMatching {

	public boolean match_1(char[] str, char[] pattern) {

		if (str.length == 0 && pattern.length != 0) {

			if (1 < pattern.length) {
				if (pattern[1] == '*') {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		int up = 0;
		int down = 0;
		while (up < str.length && down < pattern.length) {
			if (str[up] == pattern[down]) {
				up++;

				if (up >= str.length) {
					while (pattern[up] == '*') {
						up++;
					}

					if (up >= pattern.length) {
						return true;
					} else {
						return false;
					}
				}

				// 如果上下字符不相等
			} else {
				// 如果模式串是一个*号
				if (pattern[down] == '*') {
					int index = down - 1;
					// 如果*号前面存在一个字符
					if (index >= 0) {
						while (up < str.length && (pattern[index] == str[up] || str[up] == '.')) {
							up++;
						}

						// 模式串非法
					} else {
						return false;
					}
				} else if (pattern[down] == '.' || str[up] == '.') {
					up++;
				}

			}
			down++;
		}

		if (up < str.length) {
			return false;
		}
		return true;
	}

	public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {

		if (strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		if (strIndex != str.length && patternIndex == pattern.length) {
			return false;
		}
		//模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
		if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
			
			//如果模式串*号前和str上下字符是相同的
			if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
				return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
						|| matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
						|| matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配多个
			//如果字符不相同
			} else {
				return matchCore(str, strIndex, pattern, patternIndex + 2);
			}
		}
		
		//模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
		if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		}
		
		return false;
	}
	
    public boolean match(char[] str, char[] pattern){
    	if(str==null || pattern==null) {
    		return false;
    	}
		return matchCore(str, 0, pattern, 0);
    }
	

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aaa";
		String s2 = "ab*ac*a";

		RegexMatching rm = new RegexMatching();
		boolean res = rm.match(s1.toCharArray(), s2.toCharArray());
		System.out.println(res);
	}

}
