package cal;
import java.util.Random;
import java.util.Scanner;

public class Calcu extends shu{
	
	public char fh;
	public int shu1;
	public int shu2;
	public int result;
	
	public char getFh() {
		return fh;
	}
	public int getShu1() {
		return shu1;
	}
	public int getShu2() {
		return shu2;
	}
	
	public Calcu()
	{
		char [] fu = new char [4];
		fu[0] = '/';
		fu[1] = '+';
		fu[2] = '-';
		fu[3] = '*';
		fh = fu[new Random().nextInt(3) + 1];
		shu1 = new Random().nextInt(99) + 1;
		shu2 = new Random().nextInt(99) + 1;
		
		if(fh == '+')
			result = shu1 + shu2;
		else if(fh == '-')
			result = shu1 - shu2;
		else if(fh == '*')
			result = shu1 * shu2;
		else
		result = shu1 / shu2;
	}
	
	@SuppressWarnings("resource")
	public String test_zs() {
		Calcu c = new Calcu();
		System.out.print(c.shu1 + " " + c.fh + " " + c.shu2 + " = ");
		int str = new Scanner(System.in).nextInt();
		if(str == c.result)
			return "对！";
		else
			return "错，正确答案为" + c.result;
	}

}
