package basic_16to8;
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		
		int n;
		Scanner scanner = new Scanner(System.in);
		n=scanner.nextInt();
		
		String[] a= new String[n];
		
		for(int i=0;i<n;i++){
			a[i]=scanner.next();//�����û�����
		}
		
		scanner.close();
		
        for(int i=0;i<n;i++){
        	String strBinary = toBary(a[i]);//��ת��Ϊ������
        	int len = strBinary.length();//��ת����Ķ����Ƴ���
        	if(len%3==1) strBinary = "00" + strBinary;//�úڰ塣����ע��˽�����������������һ�飬����ģ��������3������������ǰ�油��
        	if(len%3==2) strBinary = "0" + strBinary;
        	String strOctal = toOctal(strBinary);
        	System.out.println(strOctal);
        }
	}
	//ʮ������ת�������㷨
	private static String toBary(String strShi){
		int len_strShi = strShi.length();//����
		StringBuffer sBuffer = new StringBuffer();
		for(int i=0;i<len_strShi;i++){
			switch (strShi.charAt(i)) {//��ȡʮ����������ÿһ���ַ���������ת��Ϊ��Ӧ��������
			case '0':sBuffer.append("0000");break;
			case '1':sBuffer.append("0001");break;
			case '2':sBuffer.append("0010");break;
			case '3':sBuffer.append("0011");break;
			case '4':sBuffer.append("0100");break;
			case '5':sBuffer.append("0101");break;
			case '6':sBuffer.append("0110");break;
			case '7':sBuffer.append("0111");break;
			case '8':sBuffer.append("1000");break;
			case '9':sBuffer.append("1001");break;
			case 'A':sBuffer.append("1010");break;
			case 'B':sBuffer.append("1011");break;
			case 'C':sBuffer.append("1100");break;
			case 'D':sBuffer.append("1101");break;
			case 'E':sBuffer.append("1110");break;
			case 'F':sBuffer.append("1111");break;
			default:
				break;
			}
		}
		return sBuffer.toString();
	}
	//������ת��Ϊ�˽����㷨
	private static String toOctal(String strBinary) {
		int len = strBinary.length();
		int k;
		
		StringBuffer sBuffer = new StringBuffer();
		if (strBinary.substring(0, 3).equals("000")) {//����ǰ��λ�ǲ���0������ʹӵ���λ��ʼ��ȡ
			k=3;
			
		} else {
			k=0;
		}
		
		for(int i=k;i<len-2;i+=3){
			switch (strBinary.substring(i,i+3)){
			case "000":sBuffer.append("0");break;
			case "001":sBuffer.append("1");break;
			case "010":sBuffer.append("2");break;
			case "011":sBuffer.append("3");break;
			case "100":sBuffer.append("4");break;
			case "101":sBuffer.append("5");break;
			case "110":sBuffer.append("6");break;
			case "111":sBuffer.append("7");break;
			default:
				break;
			}
		}
		return sBuffer.toString();
	}
 
}
