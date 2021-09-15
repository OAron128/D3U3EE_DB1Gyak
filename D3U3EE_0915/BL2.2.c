#include <stdio.h>
#include <stdlib.h>
void pelda_1();

int main()
{
    pelda_1();

return 0;

}

void pelda_1() {
    FILE *fp;
    char ch;
    char fnev[50];
    printf("Adj meg egy Filenev-et: ");
    scanf("%s", fnev);
    fp = fopen(fnev, "w");
    printf("Adj meg egy Szoveget: ");
        while( (ch = getchar()) != '#') {
            putc(ch, fp);
        }
    fclose(fp);
    fp = fopen(fnev, "r");
    while ( (ch = getc(fp)) != EOF ) {
        printf("%c",toupper(ch));
    }
fclose(fp);
}
