package fada;

import java.util.*;
public class danbiao {	
	public static void main(String[] args) {
		int m;
		do{
		System.out.println("��ѡ�������1������   2������  0���˳� ");
		Scanner input=new Scanner(System.in);
		m=input.nextInt();
		char[] ZhiHuanBiao=new char['z'+1];                          
		char[] fanZhiHuanBiao=new char['z'+1];   
		if(m!=0)setZhiHuan(ZhiHuanBiao, fanZhiHuanBiao); 		
		switch(m)        //�ж�mֵ��ִ����Ӧ�Ĺ���
		{
		case 1: JiaMi(ZhiHuanBiao);break;
		case 2: JieMi(fanZhiHuanBiao);break;
		default:break;
		}}while(m!=0);
		System.out.println("���������");
	}
	private static void JieMi(char[] fanZhiHuanBiao) {
		String jiewen;
		System.out.println("����������");
		Scanner jie=new Scanner(System.in);
		jiewen=jie.nextLine();
		char[] mi=jiewen.toCharArray();
		System.out.println("���ܺ������Ϊ��");
		for(int i=0;i<mi.length;i++)                  //ֱ�������û����������
		{
		if(mi[i]>='A'&&mi[i]<='z'&&mi[i]!='\0')
				mi[i]=fanZhiHuanBiao[mi[i]];			
			System.out.print(mi[i]);
		}
		System.out.println("");
	}
	private static void JiaMi(char[] zhiHuanBiao) {
		String mingwen;
		System.out.println("����������");
		Scanner jia=new Scanner(System.in);
		mingwen=jia.nextLine();
		char[] ming=mingwen.toCharArray();
		System.out.println("���ܺ������Ϊ��");
		for(int i=0;i<ming.length;i++) //ֱ�������û����������
		{
			if(ming[i]>='A' && ming[i]<='z')
				ming[i]=zhiHuanBiao[ ming[i]];
			System.out.print(ming[i]);
		}		
	}
	private static void setZhiHuan(char[] zhiHuanBiao, char[] fanZhiHuanBiao) {
		String s;                                            //��Կ
		System.out.println("��������Կ��");	
		Scanner zhihuan=new Scanner(System.in);          //������Կ
		s=zhihuan.nextLine();   //�����Կ
		System.out.println("�û���Ϊ��");
		String s1="";
		String s2="";
		for(int i = 0 ; i < s.length();i++)//����Կȥ���ո���ظ����ַ�
		{
			boolean sign =false; //��־����
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
		for(int i = 0 ; i < s.length();i++) //����Կȥ���ո���ظ����ַ�
		{
			boolean sign2 =false; 	//��־����
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
		for(int  i = 'A' ;i <= 'Z'; i++)     //��ѭ��������Կ�õ��û���
		{  
			if(i < 'A' + s2.length())                     //ǰ��ֱ����s1����
			{ 
				zhiHuanBiao[i] = s2.charAt(i-'A');	    
			}
			else                                          //���潫ʣ�µ�"��"��ȥ
			{	for(int j = 'A'; j < 'A' + s2.length(); j++)
				{
					if(ch2 == zhiHuanBiao[j])
					{
						ch2++;
						j= 'A';                           //ÿ�ζ���ͷ��ʼ����
						continue;
					}
				}
				zhiHuanBiao[i] = ch2;
			    ch2++;
			}                  
		    System.out.print(zhiHuanBiao[i]+" ");//ͬʱ����û���		   
		}
		char ch='A';
		System.out.println();
		for(int  i = 'a' ;i <= 'z'; i++)  //��ѭ��������Կ�õ��û���
		{  
			if(i < 'a' + s1.length())    //ǰ��ֱ����s1����
			{ 
				zhiHuanBiao[i] = s1.charAt(i-'a');	    
			}
			else            //���潫ʣ�µ�"��"��ȥ
			{				
				for(int j = 'a'; j < 'a' + s1.length(); j++)
				{
					if(ch == zhiHuanBiao[j])
					{
						ch++;
						j= 'a';  //ÿ�ζ���ͷ��ʼ����
						continue;
					}
				}
				zhiHuanBiao[i] = ch;
			    ch++;
			}                  
		    System.out.print(zhiHuanBiao[i]+" ");//ͬʱ����û���		   
		}
		System.out.println();
		for( int i='A'; i<= 'z'; i++) //��ѭ�������û���õ����û���
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
