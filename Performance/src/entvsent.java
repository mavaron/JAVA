import java.io.IOException;
import java.util.LinkedList;

public class entvsent {
	static int [][] con_matrix_ENT = new int [2][2];
	public static void main(String[] args) throws IOException {
		CSVReader.CargarCSV();
		LinkedList A= onevsone.initR();
		LinkedList B= onevsone.initB();
		LinkedList C= onevsone.initM();		
		int[] D= entity.Indexi_Entidades(A);//modificar para el cambio de matrices
		int[] E= entity.Indexf_Entidades(A);//modificar para el cambio de matrices
		int[] F=entity.Indexi_Entidades(C);//modificar para el cambio de matrices
		int[] G=entity.Indexf_Entidades(C);//modificar para el cambio de matrices
		int[] H=entity.Index_Noentidades(A);//modificar para el cambio de matrices
		int[] I=entity.Index_Noentidades(C);//modificar para el cambio de matrices
		int[] J= entity.Index_Total(D,H);
		onevsone.con_matrix(Ent_RealvsPred(D,E,F,G));
		onevsone.con_matrix(Noent_RealvsPred(H,I));
		entvsent.Comprobacion(con_matrix_ENT, J);
	}
	public static int[][] Ent_RealvsPred(int[] Reali, int [] Realf, int [] Pred_bini, int [] Pred_binf) {
		
		int i =0;
		int j =0;
		
		
		while (i<=Reali.length-1 || j<= Pred_bini.length-1){
			
		if (i<=Reali.length-1 || j<= Pred_bini.length-1)	{
			if (Reali[i]== Pred_bini[j] && Realf[i]== Pred_binf[j] ) {
			con_matrix_ENT[0][0]=con_matrix_ENT[0][0]+1; // Siempre se asegura que existe una entidad de Tipo BII que será reconocida, de lo contrario las posiciones serán distintas.
			i++;
			j++;
			}
		}
		if ( i<=Reali.length-1 || j<= Pred_bini.length-1){
			if (Reali[i] > Pred_bini[j] ){
			j++;
			}
		}
		if ( i<=Reali.length-1 || j<= Pred_bini.length-1) { //Toca validar para la última posición de i
			 if (Reali[i] < Pred_bini[j] ) {
			con_matrix_ENT[0][1]=con_matrix_ENT[0][1]+1;
			i++;
			 }
		}
		if ( i<=Reali.length-1 || j<= Pred_bini.length-1) {
			if (Reali[i]== Pred_bini[j] && Realf[i] != Pred_binf[j] ) {
			con_matrix_ENT[0][1]=con_matrix_ENT[0][1]+1;
			i++;
			j++;
			}
		}
		}		
		return  con_matrix_ENT;
	
	}
	public static int[][] Noent_RealvsPred(int[] RealNE, int [] Pred_biNE) {
		
		int i =0;
		int j =0;
		
		while (i<=RealNE.length-1 && j<= Pred_biNE.length-1){
			
		if (i<=RealNE.length-1 || j<= Pred_biNE.length-1){
			if (RealNE[i]== Pred_biNE[j] ) {
			con_matrix_ENT[1][1]=con_matrix_ENT[1][1]+1; 
			i++;
			j++;
			}
		}
		if ( i<=RealNE.length-1 || j<= Pred_biNE.length-1){
			if (RealNE[i]> Pred_biNE[j]){
			j++;
			}
		}
		if ( i<=RealNE.length-1 || j<= Pred_biNE.length-1) { //Toca validar para la última posición de i
			 if (RealNE[i]< Pred_biNE[j] ) {
			con_matrix_ENT[1][0]=con_matrix_ENT[1][0]+1;
			i++;
			}
		}
		
		}		
		return  con_matrix_ENT;
	
	}

	public static void Comprobacion(int[][] con_matrix_ENT, int[] Index_Total) {
		int a=0;
		for (int i = 0; i < con_matrix_ENT.length; i++) {
		    for (int j = 0; j < con_matrix_ENT[0].length; j++) {
		        a=a+con_matrix_ENT[i][j];
		    }
		}
			if (a==Index_Total.length){
				System.out.println("La cantidad de Entidades clasificadas en la matriz y en la lista son IGUALES");
				}
			else{
				System.out.println("La cantidad de Entidades clasificadas en la matriz y en la lista son DISTINTAS");
			}		
	}
}