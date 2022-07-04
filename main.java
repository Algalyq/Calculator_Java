
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main{

    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String[] symbols;
		String MDPM = sc.nextLine();
		symbols = MDPM.split(" ");
		
		System.out.print(lengthError(symbols.length));
		if(symbols[1].equals("*")){
			System.out.print(Mult(symbols));
		}else if(symbols[1].equals("/")){
			System.out.print(Div(symbols));
		}else if(symbols[1].equals("+")){
			System.out.print(Plus(symbols));
		}else if(symbols[1].equals("-")){
			System.out.print(Min(symbols));
		}
	}

	static String Mult(String[] arr) throws Exception{
		String A = arr[0], B = arr[2];
        boolean Abool = true, Bbool = true;
		int a = 0, b = 0;
		Abool = A.matches("-?\\d+(\\.\\d+)?");
		Bbool = B.matches("-?\\d+(\\.\\d+)?");

        if(Abool && Bbool){
			a = Integer.parseInt(arr[0]);
			b = Integer.parseInt(arr[2]);
				return Integer.toString(a*b);
		}else if(Abool == false && Bbool == false){
			a = romanToInt(A);
			b = romanToInt(B);
			int c = a * b;
			return intToRoman(c);
			
		}else if(Abool != true || Bbool != true){
			throw new Exception("используются одновременно разные системы счисления");
		}
         return null;   
	}
	static String Div(String[] arr) throws Exception{
		String A = arr[0], B = arr[2];
        boolean Abool = true, Bbool = true;
		int a = 0, b = 0;
		Abool = A.matches("-?\\d+(\\.\\d+)?");
		Bbool = B.matches("-?\\d+(\\.\\d+)?");

        if(Abool && Bbool){
			a = Integer.parseInt(arr[0]);
			b = Integer.parseInt(arr[2]);
				return Integer.toString(a/b);
		}else if(Abool == false && Bbool == false){
			a = romanToInt(A);
			b = romanToInt(B);
			int c = a / b;
			return intToRoman(c);
			
		}else if(Abool != true || Bbool != true){
			throw new Exception("используются одновременно разные системы счисления");
		}
         return null;   
	}
	static String Plus(String[] arr) throws Exception{
		String A = arr[0], B = arr[2];
        boolean Abool = true, Bbool = true;
		int a = 0, b = 0;
		Abool = A.matches("-?\\d+(\\.\\d+)?");
		Bbool = B.matches("-?\\d+(\\.\\d+)?");

        if(Abool && Bbool){
			a = Integer.parseInt(arr[0]);
			b = Integer.parseInt(arr[2]);
				return Integer.toString(a+b);
		}else if(Abool == false && Bbool == false){
			a = romanToInt(A);
			b = romanToInt(B);
			int c = a + b;
			return intToRoman(c);
			
		}else if(Abool != true || Bbool != true){
			throw new Exception("используются одновременно разные системы счисления");
		}
         return null;   
	}
	static String Min(String[] arr) throws Exception{
		String A = arr[0], B = arr[2];
        boolean Abool = true, Bbool = true;
		int a = 0, b = 0;
		Abool = A.matches("-?\\d+(\\.\\d+)?");
		Bbool = B.matches("-?\\d+(\\.\\d+)?");

        if(Abool && Bbool){
			a = Integer.parseInt(arr[0]);
			b = Integer.parseInt(arr[2]);
				return Integer.toString(a-b);
		}else if(Abool == false && Bbool == false){
			a = romanToInt(A);
			b = romanToInt(B);
			
			int c = a - b;
			if(c < 1){
				throw new Exception("в римской системе нет отрицательных чисел");
			}
			return intToRoman(c);
			
			
		}else if(Abool != true || Bbool != true){
			throw new Exception("используются одновременно разные системы счисления");
		}
         return null;   
	}



	static String lengthError(int lengthArr) throws Exception{
		if(lengthArr < 3){
		throw new  Exception("строка не является математической операцией");
		}else if(lengthArr > 3){
		throw new  Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
		}
		return "";
	}


	public static int romanToInt(String s) {
        
		int output = 0;
		 
		 Map<String ,Integer> map = new HashMap<String, Integer>();
		 map.put("I",1);
		 map.put("V",5);
		 map.put("X",10);
		 map.put("L",50);
		 map.put("C",100);
		 map.put("D",500);
		 map.put("M",1000);
		 
		 if(s.length()==0) return 0;
		 if(s.length() ==1) return map.get(String.valueOf(s.charAt(0)));
		 
		 for(int i = 0;i<(s.length()-1);i++){
			 if(map.get(String.valueOf(s.charAt(i)))>=
			 map.get(String.valueOf(s.charAt(i+1)))){
				 output = output + map.get(String.valueOf(s.charAt(i)));
				 }else{
					 output = output - map.get(String.valueOf(s.charAt(i)));
				 }
				 
			 }
		 output = output + map.get(String.valueOf(s.charAt(s.length()-1)));
		 return output;
	 }
	 public static String intToRoman(int num) {
		String s = "";
		String d[][] = {
			{"I","V","X"},
			{"X","L","C"},
			{"C","D","M"},
			{"M"}
		};
		
		int i=0;
		while(num>0){
			String str = getSyntax(num%10);
			
			str = str.replace("a",d[i][0]);
			if(i!=3){                   
				str = str.replace("b",d[i][1]);
				str = str.replace("c",d[i][2]);
			}
			i++;
			s = str + s;
			num=num/10;       
		}
		return s;
	}
	
	public static String getSyntax(int digit){   
		String s="";
		switch(digit){
			case 1: s="a";
				break;
			case 2: s="aa";
				break;
			case 3: s="aaa";
				break;
			case 4: s="ab";
				break;
			case 5: s="b";
				break;
			case 6: s="ba";
				break;
			case 7: s="baa";
				break;
			case 8: s="baaa";
				break;
			case 9: s="ac";
				break;
		}
		
		return s;
	}
	
}


