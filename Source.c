#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

void v(FILE **f)
{
	char mass[50];

	*f = fopen("uloha.txt", "r");
	if (*f == NULL)
	{
		printf("Neotvoreny subor\n");
	}
	else
	{
		while (feof(*f) == 0)
		{
			fgets(mass, 50, *f);
			if (atoi(mass) < 1 || atoi(mass) > 1800)
				printf("Chyba. ID > 1800\n");
			else
			{
				printf("osobne cislo zamestnanca : %s", mass);
			}

			fgets(mass, 50, *f);
			printf("meno priezvisko : %s", mass);

			fgets(mass, 50, *f);
			printf("administrativa/vyrobny pracovnik : %s", mass);

			fgets(mass, 50, *f);
			printf("plat : %s", mass);

			fgets(mass, 50, *f);
			printf("datum : %s", mass);

			fgets(mass, 50, *f);
			printf("\n");
		}
		rewind(*f);
	}
}

void p(FILE **f)
{
	char mass[50];
	int maxY = 0;
	double minTax = 99999999999;
	double tax_1 = 0;

	if (*f == NULL)
	{
		return;
	}
	else
	{
		while (feof(*f) == 0)
		{
			fgets(mass, 50, *f);
			fgets(mass, 50, *f);
			fgets(mass, 50, *f);
			fgets(mass, 50, *f);
			fgets(mass, 50, *f);

			int current = atoi(mass);
			int Y = current % 10000;
			if (Y > maxY)
				maxY = Y;
			fgets(mass, 50, *f);
		}
		rewind(*f);

		while (feof(*f) == 0)
		{
			fgets(mass, 50, *f);
			fgets(mass, 50, *f);
			fgets(mass, 50, *f);
			fgets(mass, 50, *f);
			tax_1 = atof(mass);
			fgets(mass, 50, *f);

			int current = atoi(mass);
			int Y = current % 10000;
			if (Y == maxY && tax_1 < minTax)
				minTax = tax_1;

			fgets(mass, 50, *f);
		}
		printf("%.2f\n", minTax);
	}
	rewind(*f);
}

int GetSize(FILE **f)
{
	char mass[50];
	int size = 0;

	if (*f != NULL)
	{
		while (feof(*f) == 0)
		{
			fgets(mass, 50, *f);
			fgets(mass, 50, *f);
			fgets(mass, 50, *f);
			fgets(mass, 50, *f);
			fgets(mass, 50, *f);
			fgets(mass, 50, *f);
			size++;
		}
		rewind(*f);
	}
	return size;
}

double* n(FILE **f, double* arr)
{
	char mass[50];
	int size = GetSize(&*f);


	if (*f == NULL)
		return;

	if (arr != 0)
	{
		arr = 0;
	}
	arr = (double*)calloc(size, sizeof(double*));

	int i = 0;
	while (feof(*f) == 0)
	{
		fgets(mass, 50, *f);
		fgets(mass, 50, *f);
		fgets(mass, 50, *f);
		fgets(mass, 50, *f);
		arr[i] = atof(mass);
		fgets(mass, 50, *f);
		fgets(mass, 50, *f);
		i++;
	}
	rewind(*f);
	return arr;
}

void r(FILE **f, double* arr)
{
	int i, j, Maxlength = 0;
	int size = GetSize(&*f);
	if (arr == NULL)
	{
		printf("Pole nie je vytvorene\n");
		return;
	}


	for (i = 0; i < size; i++)
	{
		int ThisLength = 0;
		int ValueInt = arr[i];
		while (ValueInt>0)
		{
			ValueInt /= 10;
			ThisLength++;
		}

		if (ThisLength > Maxlength)
			Maxlength = ThisLength;
	}

	for (i = 0; i < size; i++)
	{
		int ThisLength = 0;
		int ValueInt = arr[i];
		while (ValueInt>0)
		{
			ValueInt /= 10;
			ThisLength++;
		}
		int dif = Maxlength - ThisLength;
		for (j = 0; j < dif; j++)
			printf(" ");
		printf("%.2f\n", arr[i]);
	}
}

void h(FILE **f, double* arr)
{
	int i, j;
	int size = GetSize(&*f);
	if (arr == NULL)
	{
		printf("Pole nie je vytvorene\n");
		return;
	}

	for (j = 0; j < 10; j++)
	{
		int result = 0;
		for (i = 0; i < size; i++)
		{
			int value = arr[i];
			while (value > 0)
			{
				int tsufra = value % 10;
				if (j == tsufra)
					result++;
				value /= 10;
			}
		}
		printf("%d %d\n", j, result);
	}
}

void u(FILE **f, double* arr)
{
	int i, j;
	int size = GetSize(&*f);
	if (arr == NULL)
	{
		printf("Pole nie je vytvorene\n");
		return;
	}

	for (i = 0; i < size - 1; i++)
	{
		for (j = 0; j < size - i - 1; j++)
		{
			if (arr[i] > arr[i + 1])
			{
				double value = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = value;
			}
		}
	}
}

int A(FILE **f, double* arr, double *newarr)
{
	int k, a, c;
	float i;
	int n = GetSize(&*f);;
	printf("n:%d", n);
	printf("Before:\n");
	for (c = 0; c < n; c++)
		printf("%8.2f\n", arr[c]);

	printf("Enter position(k) and number to insert(i):\n");
	scanf("%d %f", &k, &i);
	if (k <= n) 
	{

		newarr = (double*)malloc((n + 1) * sizeof(double));
		for (a = 0; a < k; a++)
		{
			(newarr)[a] = (arr)[a];
		}
		(newarr)[k] = i;
		for (a = k + 1; a <= n; a++)
		{
			(newarr)[a] = (arr)[a - 1];
		}
		printf("After:\n");
		for (c = 0; c <= n; c++)
		{
			printf("%8.2f\n", newarr[c]);
		}
	}
	else return;
}

int M(FILE **f, double* arr, double *newarr)
{
	int k, a, c;
	int n = GetSize(&*f);
	printf("n:%d", n);
	printf("Before:\n");
	for (c = 0; c < n; c++)
		printf("%8.2f\n", arr[c]);

	printf("Enter position(k):\n");
	scanf("%d", &k);
	if (k <= n-1)
	{
		newarr = (double*)malloc((n - 1) * sizeof(double));
		for (a = 0; a <=n-1; a++)
		{
			if (a < k)
				(newarr)[a] = (arr)[a];
			else if (a == k)
				(newarr)[a] = (arr)[k + 1];
			else if (a > k)
				(newarr)[a] = (arr)[a - 1];
		}
		printf("After:\n");
		for (c = 0; c < n-1; c++)
		{
			printf("%8.2f\n", newarr[c]);
		}
	}
	else return;
	newarr = 0;
}

void F(FILE **f, double* arr)
{
	int i, j;
	int l, m;
	int size = GetSize(&*f);
	int max;
	if (arr == NULL)
	{
		printf("Pole nie je vytvorene\n");
		return;
	}
	max = arr[0];
	for (l=0;l<size;l++)
	{
		if (arr[l] > max)
			max = arr[l];
	}
	int counter=0;
	do
	{
		max /= 10;
		counter++;
	} 
	while (max != 0);
	printf("COUNTER: %d\n", counter);
	counter = counter - 3;
	int delitel = 10;
	for (m=1;m<counter;m++)
	{
		delitel *= 10;
	}
	int result = 0;
	for (j = 0; j < 10; j++)
	{
		
		for (i = 0; i < size; i++)
		{
			int value = arr[i];
			value /= delitel;
			if (value == 0)
				result = 0;
			else
			{
				int tsufra = value % 10;
				if (j == tsufra)
					result++;
			}
		}
		printf("%d %d\n", j, result);
		result = 0;
	}
}

void Z(FILE **f, double* arr, double *newarr)
{
	int k;
	
	int size = GetSize(&*f);
	int a = 0;
	int b = 0;
	int check = n;
	printf("Vvedite delitel\n");
	scanf("%d", &k);
	int i;
	for (i = 0; i < n; i++)
	{
		if (i%k == 0)
			check--;
	}
	printf("razmer novogo: %d\n", check);

	newarr = (double*)malloc(check * sizeof(double));
	int zalupa;
	for (zalupa = 0; zalupa < check; zalupa++)
	{
		if (zalupa%k != 0)
		{
			newarr[a] = arr[b];
			a++;
		}
		else
			b++;
	}
	printf("After:\n");
	int c;
	for (c = 0; c < check; c++)
	{
		printf("%.2f\n", newarr[c]);
	}
}

void main()
{
	char button;
	FILE *f = NULL;
	double* arr = NULL;
	double* newarr = NULL;
	while (scanf("%c", &button))
	{
		switch (button)
		{
		case'A':
			A(&f, arr, newarr);
			break;
		case'M':
			M(&f, arr, newarr);
			break;
		case'Z':
			Z(&f, arr, newarr);
			break;
		case'f':
			F(&f, arr);
			break;
		case 'v':
			v(&f);
			break;
		case 'p':
			p(&f);
			break;
		case 'n':
			arr = n(&f, arr);
			break;
		case 'r':
			r(&f, arr);
			break;
		case 'h':
			h(&f, arr);
			break;
		case 'u':
			u(&f, arr);
			break;
		case 'k':
			arr = 0;
			newarr = 0;
			if (f != NULL)
				fclose(f);
			return;
		}
	}
}

