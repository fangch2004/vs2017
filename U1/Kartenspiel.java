public class Kartenspiel { 

public static void main(String[] args) { 

           int gesamt[] = {12, 13, 2, 8, 3, 9, 11, 11, 4, 5, 6, 12, 7, 5, 6, 8, 13, 14, 11, 

                          14, 9, 13, 10, 4, 5, 13, 7, 11, 8, 10, 12, 6, 14, 2, 9, 4, 

                           5, 3, 6, 7, 8, 9, 10, 14, 2, 3, 4, 7, 10, 2, 3, 12}, 

           sp1[]  = new int[24], 

           sp2[]= new int[24]; 

           int k=0; 

           int anzahl1=0,anzahl2=0; 

           for (int i = 0; i < 47; i=i+2,k++ ){ 

                  sp1[k]=gesamt[i]; 

                  sp2[k]=gesamt[i+1]; 

                  if (sp1[k]>sp2[k]) 
                  
                  anzahl1=anzahl1+2; 

                  else if (sp1[k]<sp2[k])
                  
                  anzahl2=anzahl2+2; 

                  else
                  { 

                  anzahl1++;anzahl1++; 

                  } 

 } 

 for (int i = 0; i < 24; i++) 
 
 System.out.println(sp1[i]); 

 for (int i = 0; i < 24; i++) 
 
 System.out.println(sp2[i]); 

 if (anzahl1>anzahl2) 
 
 System.out.println("Erster Spieler"); 

 else if (anzahl1<anzahl2) 
 
 System.out.println("Zweiter Spieler"); 

 else 
 
 System.out.println("Unentschieden"); 

} 

 

} 

 

