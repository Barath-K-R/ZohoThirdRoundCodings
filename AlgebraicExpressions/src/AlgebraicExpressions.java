import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AlgebraicExpressions {
    static ArrayList<String>l=new ArrayList<String>();
    static ArrayList<String>r=new ArrayList<String>();
    static HashMap<String,Integer>lmap=new HashMap<String,Integer>();
    static HashMap<String,Integer>rmap=new HashMap<String,Integer>();
    static String res="";
    
	public static void stringoperation(String []s) {
				//separating in arraylist
		for(int i=0;i<s.length;++i)
		{
			s[i]=s[i].replace("(","");
			s[i]=s[i].replace(")","");
			
			System.out.println("adding "+s[i]);
			stringseparation(s[i],i);
		}
		
		//looping right and left expression for multiplication
		for(int j=0;j<l.size();++j)
		{
			for(int k=0;k<r.size();++k)
			{
				System.out.println("entering number opearation");
				String num=numberoperation(l.get(j),r.get(k));
				if(!(num.charAt(0)=='-'))
					num="+"+num;
				res=res+num;
				System.out.println("res="+res);
				System.out.println("entering variable opearation");
				res=res+variableoperation(l.get(j),r.get(k));
				System.out.println();
				System.out.println("finalres="+res);
				System.out.println();
			}
		}
	}
	
	//string operations
	public static void stringseparation(String s,int i) {
		int start=0,j=0;
		ArrayList<String>temp=new ArrayList<String>();
		for(j=0;j<s.length();++j)
		{
			
			if(s.charAt(j)=='+' || s.charAt(j)=='-')
			{
				
				temp.add(s.substring(start,j));
				start=j;
			}
		}
		temp.add(s.substring(start,j));
		
		if(i==0)
			l=temp;
		else
			r=temp;
		
	}
	
	//number opearations
	public static String numberoperation(String s1,String s2) {
		String lnum="",rnum="",totalnum="";
		
		for(int i=0;i<s1.length();++i)
		{
			if(s1.charAt(i)>='a' && s1.charAt(i)<='z')
			{
				lnum=s1.substring(0,i);
				break;
			}
		}
		for(int i=0;i<s2.length();++i)
		{
			if(s2.charAt(i)>='a' && s2.charAt(i)<='z')
			{
				rnum=s2.substring(0,i);
				break;
			}
		}
		System.out.println("lnum="+lnum);
		System.out.println("rnum="+rnum);
		
		totalnum=Integer.toString(Integer.valueOf(lnum)*Integer.valueOf(rnum));
		System.out.println("totalnum="+totalnum);
		return totalnum;
		
	}
	
	//variable operations
	public static String variableoperation(String s1,String s2) {
		HashMap<String,Integer>temp=new HashMap<String,Integer>(),temp2=new HashMap<String,Integer>();
		lmap=new HashMap<String,Integer>();
		rmap=new HashMap<String,Integer>();
		String res="";
		System.out.println("entering variable operation");
		System.out.println(s1+" "+s2);
		//putting the variables and their count in map
		for(int i=0;i<s1.length();++i)
		{
			if(s1.charAt(i)>='a' && s1.charAt(i)<='z')
			{
				System.out.println(s1.charAt(i));
				if(i!=s1.length()-1 && s1.charAt(i+1)=='^')
				{
					int count=Integer.valueOf(s1.substring(i+2,i+3));
					
					if(!lmap.containsKey(s1.substring(i,i+1))) {
						System.out.println("coutn="+count+lmap.containsKey(s1.substring(i,i+1)));
						lmap.put(s1.substring(i,i+1),count);
					}
				}
				else
				{
					System.out.println("always 1");
					if(!lmap.containsKey(s1.substring(i,i+1)))
					lmap.put(s1.substring(i,i+1),1);
				}
			}
		}
		
		for(int i=0;i<s2.length();++i)
		{
			System.out.println("=="+s2.charAt(i));
			if( s2.charAt(i)>='a' && s2.charAt(i)<='z')
			{
				System.out.println(s2.charAt(i));
				if(i!=s2.length()-1 && s2.charAt(i+1)=='^')
				{
					
					int count=Integer.valueOf(s2.substring(i+2,i+3));
					
					if(!rmap.containsKey(s2.substring(i,i+1))) {
						System.out.println("coutn="+count);
						rmap.put(s2.substring(i,i+1),count);
					}
				}
				else
				{
					System.out.println("always 1");
					if(!rmap.containsKey(s2.substring(i,i+1)))
					rmap.put(s2.substring(i,i+1),1);
					
				}
			}
		}
		
		//map looping for variable multiplication
		int vcount=0;
		if(lmap.size()>rmap.size())
		{
			System.out.println("lmap is greater");
		    temp=lmap;
		    temp2=rmap;
		}
		else if(lmap.size()<rmap.size())
		{
			System.out.println("rmap is greater");
		     temp=rmap;
		     temp2=lmap;
		}
		else
		{
			System.out.println("obviously lmap is greater");
			temp=lmap;
			temp2=rmap;
		}
		
		for(Map.Entry<String,Integer> entry:temp.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
			vcount=entry.getValue();
			
			if(temp2.containsKey(entry.getKey()))
			{
				System.out.println(entry.getKey()+" "+temp2.get(entry.getKey()));
				vcount=vcount+temp2.get(entry.getKey());
				System.out.println("vcount="+vcount);
			}
			
			if(vcount==1)
			{
			res=res+entry.getKey();
			continue;
			}
			res=res+entry.getKey()+"^"+vcount;
			System.out.println("res="+res);
		}
		return res;
		
	}

}
