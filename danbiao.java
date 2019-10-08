package fada;

import java.util.*;
public class danbiao {	
	public static void main(String[] args) {
		int m;
		do{
		System.out.println("请选择操作：1、加密   2、解密  0、退出 ");
		Scanner input=new Scanner(System.in);
		m=input.nextInt();
		char[] ZhiHuanBiao=new char['z'+1];                          
		char[] fanZhiHuanBiao=new char['z'+1];   
		if(m!=0)setZhiHuan(ZhiHuanBiao, fanZhiHuanBiao); 		
		switch(m)        //判断m值，执行相应的功能
		{
		case 1: JiaMi(ZhiHuanBiao);break;
		case 2: JieMi(fanZhiHuanBiao);break;
		default:break;
		}}while(m!=0);
		System.out.println("程序结束！");
	}
	private static void JieMi(char[] fanZhiHuanBiao) {
		String jiewen;
		System.out.println("请输入密文");
		Scanner jie=new Scanner(System.in);
		jiewen=jie.nextLine();
		char[] mi=jiewen.toCharArray();
		System.out.println("解密后的明文为：");
		for(int i=0;i<mi.length;i++)                  //直接利用置换表输出密文
		{
		if(mi[i]>='A'&&mi[i]<='z'&&mi[i]!='\0')
				mi[i]=fanZhiHuanBiao[mi[i]];			
			System.out.print(mi[i]);
		}
		System.out.println("");
	}
	private static void JiaMi(char[] zhiHuanBiao) {
		String mingwen;
		System.out.println("请输入明文");
		Scanner jia=new Scanner(System.in);
		mingwen=jia.nextLine();
		char[] ming=mingwen.toCharArray();
		System.out.println("加密后的密文为：");
		for(int i=0;i<ming.length;i++) //直接利用置换表输出密文
		{
			if(ming[i]>='A' && ming[i]<='z')
				ming[i]=zhiHuanBiao[ ming[i]];
			System.out.print(ming[i]);
		}		
	}
	private static void setZhiHuan(char[] zhiHuanBiao, char[] fanZhiHuanBiao) {
		String s;                                            //密钥
		System.out.println("请输入密钥：");	
		Scanner zhihuan=new Scanner(System.in);          //读入密钥
		s=zhihuan.nextLine();   //输出密钥
		System.out.println("置换表为：");
		String s1="";
		String s2="";
		for(int i = 0 ; i < s.length();i++)//对密钥去掉空格和重复的字符
		{
			boolean sign =false; //标志变量
			if((s.charAt(i) >= 'A' && s.charAt(i)<='Z'))
			{   
				for(int j = 0; j < s1.length();j++)
				{
					if(s.charAt(i) == s1.charAt(j))
					{
						sign =true;
						break;
					}
				}
				if(!sign) s1=s1+s.charAt(i);
				else sign =true;
			}
		}
		for(int i = 0 ; i < s.length();i++) //对密钥去掉空格和重复的字符
		{
			boolean sign2 =false; 	//标志变量
			if((s.charAt(i) >= 'a' && s.charAt(i)<='z'))
			{   
				for(int j = 0; j < s2.length();j++)
				{
					if(s.charAt(i) == s2.charAt(j))
					{
						sign2 =true;
						break;
					}
				}
				if(!sign2) s2=s2+s.charAt(i);
				else sign2 =true;
			}
		}
		char ch2='a';
		for(int  i = 'A' ;i <= 'Z'; i++)     //该循环利用密钥得到置换表
		{  
			if(i < 'A' + s2.length())                     //前面直接用s1代替
			{ 
				zhiHuanBiao[i] = s2.charAt(i-'A');	    
			}
			else                                          //后面将剩下的"贴"上去
			{	for(int j = 'A'; j < 'A' + s2.length(); j++)
				{
					if(ch2 == zhiHuanBiao[j])
					{
						ch2++;
						j= 'A';                           //每次都从头开始搜索
						continue;
					}
				}
				zhiHuanBiao[i] = ch2;
			    ch2++;
			}                  
		    System.out.print(zhiHuanBiao[i]+" ");//同时输出置换表		   
		}
		char ch='A';
		System.out.println();
		for(int  i = 'a' ;i <= 'z'; i++)  //该循环利用密钥得到置换表
		{  
			if(i < 'a' + s1.length())    //前面直接用s1代替
			{ 
				zhiHuanBiao[i] = s1.charAt(i-'a');	    
			}
			else            //后面将剩下的"贴"上去
			{				
				for(int j = 'a'; j < 'a' + s1.length(); j++)
				{
					if(ch == zhiHuanBiao[j])
					{
						ch++;
						j= 'a';  //每次都从头开始搜索
						continue;
					}
				}
				zhiHuanBiao[i] = ch;
			    ch++;
			}                  
		    System.out.print(zhiHuanBiao[i]+" ");//同时输出置换表		   
		}
		System.out.println();
		for( int i='A'; i<= 'z'; i++) //该循环利用置换表得到反置换表
		{   if(zhiHuanBiao[i]!='\0')
			fanZhiHuanBiao[ zhiHuanBiao[i]] = (char) i;
		}        
		for( int i='A'; i<= 'Z'; i++)
	   	{  if(fanZhiHuanBiao[i]!='\0')
			System.out.print(fanZhiHuanBiao[i]+" ");	   	   
		}		
		System.out.println();
		for( int i='a'; i<= 'z'; i++)
	   	{  if(fanZhiHuanBiao[i]!='\0')
			System.out.print(fanZhiHuanBiao[i]+" ");	   	   
		}
		System.out.println();
	}
} 
