#include<iostream>
using namespace std;

int main()
{
	int a[10000] = { 0, };
	int num1 = 0;
	int num2 = 0;
	int i = 0;
	int p = 0;

	for (i = 1; i < 10000;i++)
	{
		
		if (i < 10)
		{
			a[i+i-1] = i + i;
		}
		else if (i>=10 && i < 100)
		{		
			num1 = i;
			num2 = i;

			for (p = 0; p < 2; p++)
			{
				num1 += num2 % 10;
				num2 /= 10;
			}
			a[num1 - 1] = num1;
		}
		else if (i>=100 && i < 1000)
		{
			num1 = i;
			num2 = i;

			for (p = 0; p < 3; p++)
			{
				num1 += num2 % 10;
				num2 /= 10;
			}
			a[num1 - 1] = num1;
		}
		else
		{
			num1 = i;
			num2 = i;

			for (p = 0; p < 4; p++)
			{
				num1 += num2 % 10;
				num2 /= 10;
			}
			if (num1 < 10000)
			{
				a[num1 - 1] = num1;
			}

		}

	}
	for (i = 1; i <= 10000; i++)
	{
		if (a[i-1] == 0 && i<10000)
		{
			cout << i << endl;
		}
	}

}