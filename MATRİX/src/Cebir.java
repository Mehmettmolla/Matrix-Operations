import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;
import jdk.nashorn.internal.ir.ContinueNode;

public class Cebir {
    
    //Determinant bulma fonksiyonu//
public int determinant(int A[][]){
int sonuc1=0;
if(A.length==1){
    sonuc1=A[0][0];
    return sonuc1;
}
if(A.length==2){
    sonuc1=A[0][0]*A[1][1] - A[0][1] *A[1][0];
    return sonuc1;
}
    for(int m=0;m<A[0].length;m++){
        int gecici[][] =new int[A.length-1][A[0].length-1];
        for(int j=1;j<A.length;j++){
            for(int y=0;y<A[0].length;y++){
                if(y<m){
                    gecici[j-1][y]=A[j][y];
                }
                else if(y>m){
                    gecici[j-1][y-1]=A[j][y];
                }
            }
        }
        sonuc1+=A[0][m]*Math.pow(-1,(int)m)*determinant(gecici);
    }
    return sonuc1;
}

   
    public static void main(String[] args) {
         Scanner oku=new Scanner(System.in);
        int i,k,x,y,sa,su,sabit;
        //Matris nesnelerini olusturma//
        int matris[][]=new int[3][3];
        int matrisa[][]=new int[3][3];
        int matrisb[][]=new int[3][3];
        int sonuc[][]=new int[3][3];
        
        System.out.println("-----------------------------------------------------");
        System.out.println("******************* HOSGELDINIZ *******************");
        System.out.println("-----------------------------------------------------");
        System.out.println("");

        System.out.println("Lutfen matrisler uzerinde islem yapabilmek icin once matrisleri giriniz. :)");
        System.out.println("");
        System.out.println("-----1. Matris-----");
        //Matrislerin icini doldurma//
        for(i=0;i<3;i++){
            for(k=0;k<3;k++)
            {
            System.out.printf("%d. satirin %d. elemanini giriniz: ",i+1,k+1);
            matrisa[i][k]=oku.nextInt();
            }
            System.out.println();
        }
         System.out.println("-----2. Matris-----");
        for(i=0;i<3;i++){
            for(k=0;k<3;k++)
            {
            System.out.printf("%d. satirin %d. elemanini giriniz: ",i+1,k+1);
            matrisb[i][k]=oku.nextInt();
            }
            System.out.println();
        }
        System.out.println("MATRIS 1 :");
        //Dolu matrisleri yazdirma//
        for(x=0;x<3;x++){
            for(y=0;y<3;y++){
        
                System.out.print(matrisa[x][y]+"\t");
                
            }
            System.out.println();
        }
        System.out.println("MATRIS 2 :");
        for(x=0;x<3;x++){
            for(y=0;y<3;y++){
        
                System.out.print(matrisb[x][y]+"\t");
                
            }
            System.out.println();
        }
        System.out.println("");
        System.out.println("***********************************");
        System.out.println("Asagidaki islemlerden birini seciniz");
        System.out.println("\n");
        for(;;){
             int secim;
        
        System.out.println(" 1-)  Toplama islemi yapmak icin '1'i seciniz ");
        System.out.println(" 2-)  Cikarma islemi yapmak icin '2'yi seciniz ");
        System.out.println(" 3-)  Girdiginiz matrisler ile carpma islemi yapmak icin '3'u seciniz ");
        System.out.println(" 4-)  1.Matrisi sabit bir sayiyla carpmak icin '4'u seciniz ");
        System.out.println(" 5-)  2.Matrisi sabit sayiyla carpmak icin '5'i seciniz ");
        System.out.println(" 6-)  1. Matrisin determinantini almak icin '6'yi seciniz ");
        System.out.println(" 7-)  2. Matrisin determinantini almak icin '7'yi seciniz ");
        System.out.println(" 8-)  1.Matrisin tersini almak icin '8'i seciniz ");
        System.out.println(" 9-)  2.Matrisin tersini almak icin '9'u seciniz ");
        System.out.println(" 10-) 1.Matrisin involitif olup olmadigini kontrol etmek icin '10'u seciniz ");
        System.out.println(" 11-) 2.Matrisin involitif olup olmadigini kontrol etmek icin '11'i seciniz ");
        System.out.println(" 12-) Farkli bir matris ile islem yapmak icin '12'yi seciniz ");
        System.out.println(" 13-) Cikis icin '13'u seciniz");
        secim=oku.nextInt();
    
        switch(secim)
        
        {
            //Matrisleri toplama islemi yapma//
                case 1:  
                System.out.println("Toplama islemi sonucu :");
                for(sa=0;sa<3;sa++){
                for(su=0;su<3;su++){
                sonuc[sa][su]=matrisa[sa][su]+matrisb[sa][su];
                System.out.printf("%d ",sonuc[sa][su]);
                }
                    System.out.printf("\n");
                }
                System.out.println("\n");
                System.out.println("***********************************");
        break;
        
            //Matrisleri cikarma islemi yapma//
            case 2 :  
               System.out.println("Cikarma islemi sonucu :");
                for(sa=0;sa<3;sa++){
                for(su=0;su<3;su++){
                sonuc[sa][su]= matrisa[sa][su] - matrisb[sa][su];
                System.out.printf("%d ",sonuc[sa][su]);
                }
                    System.out.printf("\n");
                }
                System.out.println("\n");
                 System.out.println("***********************************");
                break;
                
                //Matrisleri carpma islemi yapma//
            case 3:
                System.out.println("Carpma islemi sonucu :");
                for(sa=0;sa<3;sa++){
                for(su=0;su<3;su++){
                sonuc[sa][su]=0;
                for(k=0;k<3;k++){
                sonuc[sa][su]+=matrisa[sa][k]*matrisb[k][su];
                    }
                     System.out.printf("%d ",sonuc[sa][su]);
                    }
                    System.out.printf("\n");
                }
                System.out.println("\n");
                 System.out.println("***********************************");
            break;
            
            //1.matrisi sabit sayi ile carpma//
            case 4:  
                System.out.println("Matrisi carpmak istediginiz sayiyi giriniz: ");
                sabit=oku.nextInt();
                System.out.println("Carpma islemi sonucu :");
                for(sa=0;sa<3;sa++){
                for(su=0;su<3;su++){
                 
                      sonuc[sa][su] =sabit*matrisa[sa][su];
                    
                        System.out.printf("%d ",sonuc[sa][su]);
                    }
                    System.out.printf("\n");
                }
                System.out.println("\n");
                 System.out.println("***********************************");
                break;
                
                //2.matrisi sabit sayi ile carpma//
            case 5: 
                System.out.println("Matrisi carpmak istediginiz sayiyi giriniz: ");
                sabit=oku.nextInt();
                System.out.println("Carpma islemi sonucu :");
                for(sa=0;sa<3;sa++){
                for(su=0;su<3;su++){
                 
                      sonuc[sa][su] =sabit*matrisb[sa][su];
               
                        System.out.printf("%d ",sonuc[sa][su]);
                    }
                    System.out.printf("\n");
                }
                System.out.println("\n");
                 System.out.println("****");
                break;
                
                //1.Matrisin determinantini bulma//
            case 6: 
                
          Cebir d =new Cebir();
          int sonuc1= d.determinant(matrisa);
         
                System.out.println("----------------------------");
                System.out.println("1. Matrisin determinanti: "+ sonuc1);
                System.out.println("----------------------------");
                System.out.println("\n");
                 System.out.println("***********************************");
                break;
                
                //2.Matrisin determinantini bulma//
            case 7:  
                Cebir d1 =new Cebir();
          int sonuc2= d1.determinant(matrisb);
         
                System.out.println("------------------------------");
                System.out.println("2. Matrisin determinanti: "+ sonuc2);
                System.out.println("------------------------------");
                System.out.println("\n");
                 System.out.println("***********************************");
                break;
                
                //1.Matrisin tersini bulma//
            case 8:  
                Cebir d8 = new Cebir();
                if(d8.determinant(matrisa)==0){
                    System.out.println("***********************************");
                    System.out.println("Determinant sifir oldugu icin matrisin tersi hesaplanamaz!!");
                    System.out.println("***********************************");
                    System.out.println("");
                }
                else{
                int matrixInvers[][] = {{matrisa[1][1]*matrisa[2][2]-matrisa[1][2]*matrisa[2][1],matrisa[0][2]*matrisa[2][1]-matrisa[0][1]*matrisa[2][2],matrisa[0][1]*matrisa[1][2]-matrisa[0][2]*matrisa[1][1]},
                                {matrisa[1][2]*matrisa[2][0]-matrisa[1][0]*matrisa[2][2],matrisa[0][0]*matrisa[2][2]-matrisa[0][2]*matrisa[2][0],matrisa[0][2]*matrisa[1][0]-matrisa[0][0]*matrisa[1][2]},
                                {matrisa[1][0]*matrisa[2][1]-matrisa[1][1]*matrisa[2][0],matrisa[0][2]*matrisa[2][0]-matrisa[0][0]*matrisa[2][1],matrisa[0][0]*matrisa[1][1]-matrisa[0][1]*matrisa[1][0]}};
 
       System.out.println("1. Matrisin tersi :");
        for(int row=0; row<3; row++)
        {
            for(int column=0; column<3; column++)
            {
                System.out.printf("%3d",matrixInvers[row][column]);
            }
            System.out.print("\n");
        }
        System.out.println("\n");
         System.out.println("***********************************");}
             break;
             
             //2.Matrisin tersini bulma//
            case 9: 
                Cebir d9 = new Cebir();
                if(d9.determinant(matrisb)==0){
                    System.out.println("********************************************************");
                    System.out.println("Determinant sifir oldugu icin matrisin tersi hesaplanamaz!!");
                    System.out.println("********************************************************");
                    System.out.println("");
                }
                else{
                int matrixInvers1[][] = {{matrisb[1][1]*matrisb[2][2]-matrisb[1][2]*matrisb[2][1],matrisb[0][2]*matrisb[2][1]-matrisb[0][1]*matrisb[2][2],matrisb[0][1]*matrisb[1][2]-matrisb[0][2]*matrisb[1][1]},
                                {matrisb[1][2]*matrisb[2][0]-matrisb[1][0]*matrisb[2][2],matrisb[0][0]*matrisb[2][2]-matrisb[0][2]*matrisb[2][0],matrisb[0][2]*matrisb[1][0]-matrisb[0][0]*matrisb[1][2]},
                                {matrisb[1][0]*matrisb[2][1]-matrisb[1][1]*matrisb[2][0],matrisb[0][2]*matrisb[2][0]-matrisb[0][0]*matrisb[2][1],matrisb[0][0]*matrisb[1][1]-matrisb[0][1]*matrisb[1][0]}};
 
       System.out.println("2. Matrisin tersi :");
        for(int row=0; row<3; row++)
        {
            for(int column=0; column<3; column++)
            {
                System.out.printf("%3d",matrixInvers1[row][column]);
            }
            System.out.print("\n");
        }
        System.out.println("\n");
         System.out.println("***********************************");
                }
                break;
                
                //1. matrisin involutifligini kontrol etme//
            case 10:
                 int matrisBirim[][]={{1,0,0},{0,1,0},{0,0,1}};
                String temp;
                temp="";
                 for(sa=0;sa<3;sa++){
                for(su=0;su<3;su++){
                sonuc[sa][su]=0;
                for(k=0;k<3;k++){
                sonuc[sa][su]+=matrisa[sa][k]*matrisa[k][su];
                    }
                    }
                }
                   for(int q=0;q<3;q++){
                   for(int z=0;z<3;z++){
                if(sonuc[q][z]== matrisBirim[q][z]){
                 temp= "1. matris involitifdir.";
                    }
                else
                 temp= "1.matris involitif degildir.";
                    }
                    }
                   
                 System.out.println("Matris " +temp);
                 System.out.println("\n");
                  System.out.println("***********************************");
                break;  
                
                //2. matrisin involutifligini kontrol etme//
            case 11:
                int matrisBirim1[][]={{1,0,0},{0,1,0},{0,0,1}};
                String temp1;
                temp1="";
                 for(sa=0;sa<3;sa++){
                for(su=0;su<3;su++){
                sonuc[sa][su]=0;
                for(k=0;k<3;k++){
                sonuc[sa][su]+=matrisb[sa][k]*matrisb[k][su];
                    }
                    }
                }
                   for(int q=0;q<3;q++){
                   for(int z=0;z<3;z++){
                if(sonuc[q][z]== matrisBirim1[q][z]){
                 temp1= "2.matris involitifdir.";
                    }
                else
                 temp1= "2.matris involitif degildir.";
                    }
                    }
                   
                 System.out.println("Matris " +temp1);
                 System.out.println("\n");
                  System.out.println("****");
                break;
                
            case 12:
                //Farklı bir matris girisi için islemleri bastan almak//
                
                System.out.println("-----1. Matris-----");
        for(i=0;i<3;i++){
            for(k=0;k<3;k++)
            {
            System.out.printf("%d. satirin %d. elemanini giriniz: ",i+1,k+1);
            matrisa[i][k]=oku.nextInt();
            }
            System.out.println();
        }
         System.out.println("-----2. Matris-----");
        for(i=0;i<3;i++){
            for(k=0;k<3;k++)
            {
            System.out.printf("%d. satirin %d. elemanini giriniz: ",i+1,k+1);
            matrisb[i][k]=oku.nextInt();
            }
            System.out.println();
        }
        System.out.println("MATRIS 1 :");
        for(x=0;x<3;x++){
            for(y=0;y<3;y++){
        
                System.out.print(matrisa[x][y]+"\t");
                
            }
            System.out.println();
        }
        System.out.println("MATRIS 2 :");
        for(x=0;x<3;x++){
            for(y=0;y<3;y++){
        
                System.out.print(matrisb[x][y]+"\t");
                
            }
            System.out.println();
        }
                break;
                
            case 13:
                System.out.println("");
                System.out.println("*********************************************");
                System.out.println("Basarili sekilde cikis yaptiginiz. Tesekkur Ederiz... Y-M");
                System.out.println("*********************************************");
                return;
                
          default:
              System.out.println("");
              System.out.println("***********************************");
              System.out.println("!!! Gecersiz bir sayi girdiniz !!!");
              System.out.println("***********************************");
              System.out.println("Lutfen gecerli bir sayi giriniz.");
              System.out.println("***********************************");
              System.out.println("");
                
        }
    } 
        
    }
    
}