package cal;

import java.util.Random;
import java.util.Scanner;

public class Test {
	
	@SuppressWarnings({ "resource", "finally" })
	public static void main(String[] args) {
		int N = 0;
		System.out.print("请输入生成题数：");
		N = new Scanner(System.in).nextInt();
		
		System.out.println("开始答题，请注意分数的最简化");
		shu []c = new shu[N];
		for(int i = 0; i < N; i++)
		{
			int ran = new Random().nextInt(99) + 1;
			if(ran % 2 == 0)
			{
				c[i] = new Calcu();
				for(int j = 0;j < i;j++)
				{
					try{
						if(((Calcu) c[i]).getShu1() == ((Calcu) c[j]).getShu1() && ((Calcu) c[i]).getShu2() == ((Calcu) c[j]).getShu2()
								&& ((Calcu) c[i]).getFh() == ((Calcu) c[j]).getFh())
						{
							c[i] = new Calcu();
							j = 0;
						}
					}
					catch(Exception e)
					{}
					finally{
						continue;
					}
				}
				System.out.println(((Calcu) c[i]).test_zs());
			}
			else
			{
				c[i] = new Cal_zfs();
				for(int j = 0;j < i;j++)
				{
					try{
						if(((Cal_zfs) c[i]).getShu1().equals(((Cal_zfs) c[j]).getShu1())&& ((Cal_zfs) c[i]).getShu2().equals(((Cal_zfs) c[j]).getShu2())
								&& ((Cal_zfs) c[i]).getFh() == ((Cal_zfs) c[j]).getFh())
						{
							c[i] = new Cal_zfs();
							j = 0;
						}
					}
					catch(Exception e)
					{}
					finally{
						continue;
					}
				}
				System.out.println(((Cal_zfs) c[i]).test_zfs());
			}
		}
	}

}

