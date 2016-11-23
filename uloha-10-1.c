// uloha-10-1.c -- Tyzden 10 - Uloha 1
// Vladyslav Ohyr, 23.11.2016 10:16:47

#include <stdio.h>
#include <stdlib.h>

typedef struct shop
{
  char naz[20];
  char vyr[20];
  float mnoz;
  float cena;
  
} SHOP;

void vloz(int i, SHOP *pole)
{
  scanf("%s %s %f %f", &pole[i].naz, &pole[i].vyr, &pole[i].mnoz, &pole[i].cena);
}

void vypis(int i, SHOP *pole)
{
  int cnt;
  for(cnt=0; cnt<=i; cnt++)
  {
  printf("%s, %s, %f, %f\n", pole[i].naz, pole[i].vyr, pole[i].mnoz, pole[i].cena);
  }
}

int main()
{ 
  SHOP *p;
  p = (SHOP*)malloc(sizeof(SHOP));
  int count = 0;
  printf("%d\n",count);
  char button;
  printf("%d\n",count);
  while(button!='q')
  {
  printf("%d\n",count);
  scanf("%s", &button);
  printf("%d\n",count);  
    if(count>0){
      printf("a");
      printf("%d",count);
      p = (SHOP*)realloc(p, count*sizeof(SHOP));
		printf("a");    
    }
  else
  {
  if(button == 'vloz')
  {
    printf("a");
  vloz(count, p);
  }
  else if(button == 'vypis')
  {
    printf("a");
  vypis(count, p);
  }
  }
    count+=1;
  }
  return 0;
}
