package cal;

import java.util.Random;
import java.util.Scanner;

public class Cal_zfs extends shu{
	public char fh;
	public String shu1;
	public String shu2;
	public String result;
	
	public char getFh() {
		return fh;
	}

	public String getShu1() {
		return shu1;
	}

	public String getShu2() {
		return shu2;
	}

	public Cal_zfs()
	{
		int fzi1;
		int fmu1;
		int fzi2;
		int fmu2;
		char [] fu = new char [4];
		fu[0] = '/';
		fu[1] = '+';
		fu[2] = '-';
		fu[3] = '*';
		fh = fu[new Random().nextInt(4)];
		
		fmu1 = new Random().nextInt(9) + 1;
		fzi1 = new Random().nextInt(9) + 1;
		while (fzi1 > fmu1)
		{
			fzi1 = new Random().nextInt(9) + 1;
		}
		fmu2 = new Random().nextInt(9) + 1;
		fzi2 = new Random().nextInt(9) + 1;
		while (fzi2 > fmu2)
		{
			fzi2 = new Random().nextInt(9) + 1;
		}
		
		int gy = gys(fzi1, fmu1);
		int gy2 = gys(fzi2, fmu2);
		if(fzi1 / gy == fmu1 / gy)
			shu1 = "1";
		else
			shu1 = fzi1 / gy + "/" + fmu1 / gy;
		if(fzi2 / gy2 == fmu2 / gy2)
			shu2 = "1";
		else
			shu2 = fzi2 / gy2 + "/" + fmu2 / gy2;
		
		int fm = 0, fz = 0;
		if(fh == '+')
		{
			fm = fmu1 * fmu2;
			fz = fmu1 * fzi2 + fmu2 * fzi1;
		}
		else if(fh == '-')
		{
			fm = fmu1 * fmu2;
			fz = fmu2 * fzi1 - fmu1 * fzi2;
		}
		else if(fh == '*')
		{
			fm = fmu1 * fmu2;
			fz = fzi1 * fzi2;
		}
		else
		{
			fm = fmu1 * fzi2;
			fz = fzi1 * fmu2;
		}
		
		int g = gys(fz, fm);
		result = fz / g + "/" + fm / g;
	}
	
	public int gys(int s1, int s2)
	{
		int gy = 1;
		for(int i = 1; i <= (s1 < s2 ? s1 : s2); i++)
		{
			if(s1 % i == 0 && s2 % i == 0)
				gy = i;
		}
		return gy;
	}
	
	@SuppressWarnings("resource")
	public String test_zfs() {
		Cal_zfs c = new Cal_zfs();
		System.out.print(c.shu1 + " " + c.fh + " " + c.shu2 + " = ");
		String str = new Scanner(System.in).next();
		if(str.equals(c.result))
			return "对！";
		else
			return "错，正确答案为" + c.result;
	}

}
