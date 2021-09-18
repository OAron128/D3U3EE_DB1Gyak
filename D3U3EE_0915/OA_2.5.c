#include <stdlib.h>
#include <string.h>
#include <stdio.h>

struct ember{
    char azonosito[10];
    char nev[20];
} Szemely[100];

int ossz=0;
int darab = 0;

void sorok(){

    FILE *fp = fopen("szemelyek.bin", "rb");
    char szoveg;

    if(!fp){
        printf("Meg nem letezett a fajl ezert letrehoztam.");
        fp =fopen("autok.bin", "wb");
        fclose(fp);
        exit(0);
    }
    else{
        while (szoveg != EOF){
          szoveg = getc(fp);
          if (szoveg == '\n'){
            darab++;
          }
        }
    }
}

int main(){

    ossz = ossz + darab;
    int bekervmit=0;
    while(bekervmit!=6){

        fflush(stdin);

        printf("\nMit szeretne csinalni?\n\n");
        printf("1. Adat felvetele\n2. Adat torlese\n3. Adat modositasa\n4. Adat listazasa\n5. Kilepes\n\n");
        scanf("%d", &bekervmit);

        switch(bekervmit){
            case 1: felvisz(); break;
            case 2: torol(); break;
            case 3: modosit(); break;
            case 4: mutat(); break;
            case 5: return 0;
            default: printf("Ilyen menupont nincs"); return 0;
        }
    }

    return 0;
}

void felvisz(){

    int szam=0;

    printf("Hany adatot szeretne? ");
    scanf("%d", &szam);

    FILE *fp = fopen("szemelyek.bin", "rb");

    if(fp == NULL)
    {
        fp = fopen("szemelyek.bin","w");
        fclose(fp);
    }


    int i=ossz;

    while(i<ossz+szam){

        printf("Adja meg a szemely azonositojat! ");
        scanf("%s", &Szemely[i].azonosito);

        fflush(stdin);

        printf("Adja meg a szemely nevet! ");
        scanf("%s", &Szemely[i].nev);

        fwrite(&(Szemely[i]), sizeof(struct ember),1, fp);
        fwrite("\n", 1, 1, fp);

        fflush(stdin);

        i++;
    }

    ossz = ossz + i ;

    fclose(fp);
}

void torol(){

    FILE *fp= fopen("szemelyek.bin", "rb");
    FILE *fpp = fopen("szemelyek2.bin", "wb");

    int szam=0;
    printf("Hanyadik elemet szeretne torolni? Eddig az allomanyban %d elem van. ", ossz);
    scanf("%d", &szam);

    szam = szam -1;
    int xd=1;
    char ch = 'A';


    for(int i=0; i<ossz;i++){
        if(szam==0){
            strcpy(Szemely[i].azonosito, Szemely[i+1].azonosito);
            strcpy(Szemely[i].nev, Szemely[i+1].nev);
            if(i!=(szam)){
                fseek(fp, (szam)*sizeof(struct ember),0);
                fwrite(&(Szemely[i+1]), sizeof(struct ember),1, fpp);
            }
        }
        else if(szam!=0){
            strcpy(Szemely[szam].azonosito, Szemely[szam+1].azonosito);
            strcpy(Szemely[szam].nev, Szemely[szam+1].nev);
            if(i!=(szam)){
                fseek(fp, (szam)*sizeof(struct ember),0);
                fwrite(&(Szemely[i+1]), sizeof(struct ember),1, fpp);
            }
        }
    }

    ossz--;

    fclose(fp);
    fclose(fpp);

    remove("szemelyek.bin");
    rename("szemelyek2.bin", "szemelyek.bin");

    printf("\nA %d. rekord torolve lett! ", szam+1);

}

void modosit(){

    FILE *fp = fopen("szemelyek.bin", "rb");

    if(!fp){
        printf("Nem letezik a bin file, inditsa ujra a programot es eloszor vigyen fel adatokat\n");
        exit(0);
    }

    int szam = 0;
    int mit =0;

    printf("Hanyadik elemet szeretne modositani? Az allomanyban %d elem van. ", ossz);
    scanf("%d", &szam);
    printf("Mit szeretne modositani?\n1.Azonositot\n2.Nevet\n");
    scanf("%d", &mit);

    for(int i=0; i<ossz; i++){
        if(i==(szam-1)){
            switch(mit){
                case 1:
                    fflush(stdin);
                    printf("Adjon uj azonositot! ");
                    scanf("%s", &Szemely[i].azonosito);
                    fseek(fp, (szam-1)*sizeof(struct ember),0);
                    fwrite(&(Szemely[szam-1]), sizeof(struct ember),1, fp);
                    break;

                case 2:
                    fflush(stdin);
                    printf("Adjon uj nevet! ");
                    scanf("%s", &Szemely[i].nev);
                    fseek(fp, (szam-1)*sizeof(struct ember),0);
                    fwrite(&(Szemely[szam-1]), sizeof(struct ember),1, fp);
                    break;
                default: printf("nincs ilyen opcio, kilepes..."); exit(0);
            }
        }
    }

}

void mutat(){

    FILE *fp = fopen("szemelyek.bin", "rb");
    int szam=ossz;

    if(fp == NULL){
        printf("nem sikerult megnyitni az allomanyt");
    }
    else{
        fread(&(Szemely[szam]), sizeof(struct ember), 1,fp);
        for(int i=0; i<szam; i++){
            printf("azonosito: %s ", Szemely[i].azonosito);
            printf("nev: %s\n", Szemely[i].nev);
        }
    }

    fclose(fp);

}
