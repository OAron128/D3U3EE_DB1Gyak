#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main()
{
 FILE *fp1, *fp2;

    char fnev1[25];
    char fnev2[25] = "masolat.txt";
    char ch;
    printf("Filenev: ");
    scanf("%s", fnev1);
    printf("Uzenet: ");
    while( (ch = getchar()) != '#') {
        putc(ch, fp1);
    }

  int pos;
    if ((fp1 = fopen(fnev1, "r")) == NULL)
    {
        printf("\nNem lehet megnyitni a fajlt.");
    }
    else
    {
        printf("\nFajl megnyitva masolasra \n ");
    }
    fp2 = fopen(fnev2, "w");
    fseek(fp1, 0L, SEEK_END);
    pos = ftell(fp1);
    fseek(fp1, 0L, SEEK_SET);
    while (pos--)
    {
        ch = fgetc(fp1);
        fputc(ch, fp2);
    }
    fclose(fp1);
    fclose(fp2);
return 0;
}
