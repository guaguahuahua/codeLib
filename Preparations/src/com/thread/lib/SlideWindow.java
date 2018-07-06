package com.thread.lib;

import java.util.ArrayList;

/**
 * ʹ�ö�����
 * @author Administrator
 *
 */
public class SlideWindow {

    public ArrayList<Integer> maxInWindows(int [] num, int size){
    	
    	ArrayList<Integer> res=new ArrayList<Integer>();
    	if(num.length<size || num.length==0 || size==0) {
    		return res;
    	}
    	//��ʼ�����ڵ�����
    	int[] sub=new int[size];
    	for(int i=0; i<size; i++) {
    		sub[i]=num[i];
    	}
    	//���Ҫ�滻��Ԫ�ص�λ��
    	int left=0, right=size;
    	
    	while(right<=num.length) {
        	//һ�ζ�����
        	for(int i=(sub.length-1)/2; i>=0; i--) {
            	createHeap(sub, i, sub.length);
        	}
        	//ȡ���������ֵ
        	res.add(sub[0]);
        	if(right>=num.length) {
        		break;
        	}
        	//�����ƶ�
        	int index=find(sub, num[left]);
        	sub[index]=num[right];
        	right++;
        	left++;
    	}    	
        return res;
    }
	
    //�����ѣ���鲻����������������ӵ���������
    public void createHeap(int []num, int pos, int len){
    	
    	int temp=num[pos];
    	int child;
    	for(; 2*pos+1<len; ) {
    		//��ú��ӽڵ�����
    		child=2*pos+1;
    		//��ȡ���ӽڵ��еĽϴ�ֵ
    		if(child+1<len && num[child]<num[child+1]) {
    			child++;
    		}
    		//��ȡ
    		if(temp<num[child]) {
    			num[pos]=num[child];
    		}else {
    			break;
    		}
    		pos=child;
    	}
    	num[pos]=temp;
    }
    
    
    public int find(int []num, int des) {
    	for(int i=0; i<num.length; i++) {
    		if(num[i]==des) {
    			return i;
    		}
    	}
    	return -1;
    } 
    
    //ʹ�ö��ַ��ҵ���Ҫ�滻��Ԫ��
    public int binFind(int []num, int des) {
    	int l=0;
    	int r=num.length-1;
    	int mid;
    	while(l<r) {
    		mid=l+(r-l)/2;
    		if(num[mid]==des) {
    			return mid;
    		}else if(num[mid]<des) {
    			l=mid+1;
    		}else {
    			r=mid-1;
    		}
    	}
    	return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []num={2,3,4,2,6,2,5,1};
		int []num={};
		SlideWindow sw=new SlideWindow();
		ArrayList<Integer> r=sw.maxInWindows(num, 3);
		System.out.println(r);
	}

}
