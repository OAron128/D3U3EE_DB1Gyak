#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Auto {
char rendszam[6];
char tipus[20];
double ar;
};

void main(){
struct Auto autok[2];
FILE *fdata;
int i = 0;
for (i=0; i< 2; i++) {
printf("Kerem a rendszamot:");
scanf("%s",&autok[i].rendszam);
printf("Kerem az auto tipusat(szinet):");
scanf("%s",&autok[i].tipus);
printf("Kerem az auto arat::");
scanf("%d",&autok[i].ar);
}
for(int j=0; j<2;j++){
printf(autok[j].rendszam," ",autok[j].tipus," ",autok[j].ar,"\n");
}

fdata = fopen("Autok.dat", "wb");
for (i=0; i< 2; i++) {
fwrite(&(autok[i]), sizeof(struct Auto),1, fdata);
}
fclose(fdata);

}
int beolvas(int poz){
FILE *fdata;
fdata = fopen("Autok.dat", "rb");
struct Auto aurek;
if (fdata == NULL) {
printf ("file hiba\n");
return;
}
fseek(fdata, (poz-1)* sizeof(struct Auto),0 );
fread(&aurek, sizeof(struct Auto),1, fdata);
printf ("Kerem a rendszam: %s\n", aurek.rendszam);
printf ("Kerem az auto tipusat(szinet): %s\n", aurek.tipus);
printf ("Kerem az auto arat: %d\n", aurek.ar);
fclose(fdata);
}

