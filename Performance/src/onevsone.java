import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.ListIterator;


public class onevsone {

		public static void main(String[] args) throws IOException {
		CSVReader.CargarCSV();
		onevsone.con_matrix(onevsone.RealvsPred(onevsone.initR(),onevsone.initM()));//cambiar Lista de Entrada	
		}
		
		public static LinkedList initR() throws IOException {
		LinkedList Real_L = CSVReader.getReal();
		Real_L.pop();
		return Real_L;
		}
		public static LinkedList initB() throws IOException {
		LinkedList Pred_bin_L = CSVReader.getPred_bin();
		Pred_bin_L.pop();
		return Pred_bin_L;
		}
		public static LinkedList initM() throws IOException {
		LinkedList Pred_Multi_L = CSVReader.getPred_Multi();
		Pred_Multi_L.pop();
		return Pred_Multi_L;
			}
					
		public static int[][] RealvsPred(LinkedList Real1, LinkedList Pred_bin1) {
			int num=0;
			int [][] scores = new int [3][3];
					
			while (Real1.size() > num && Pred_bin1.size() >num) {
				  if (Real1.get(num).equals("B") && Pred_bin1.get(num).equals("B")){
				  scores[0][0]=scores[0][0]+1;
			      }
				  if (Real1.get(num).equals("B") && Pred_bin1.get(num).equals("I")){
					  scores[0][1]=scores[0][1]+1;
				      }
				  if (Real1.get(num).equals("B") && Pred_bin1.get(num).equals("O")){
					  scores[0][2]=scores[0][2]+1;
				      }
				  if (Real1.get(num).equals("I") && Pred_bin1.get(num).equals("B")){
					  scores[1][0]=scores[1][0]+1;
				      }
				  if (Real1.get(num).equals("I") && Pred_bin1.get(num).equals("I")){
					  scores[1][1]=scores[1][1]+1;
				      }
				  if (Real1.get(num).equals("I") && Pred_bin1.get(num).equals("O")){
					  scores[1][2]=scores[1][2]+1;
				      }
				  if (Real1.get(num).equals("O") && Pred_bin1.get(num).equals("B")){
					  scores[2][0]=scores[2][0]+1;
				      }
				  if (Real1.get(num).equals("O") && Pred_bin1.get(num).equals("I")){
					  scores[2][1]=scores[2][1]+1;
				      }
				  if (Real1.get(num).equals("O") && Pred_bin1.get(num).equals("O")){
					  scores[2][2]=scores[2][2]+1;
				      }			  
				  num++;
				 }
			return scores;		
		}
					
		public static void con_matrix (int [][] con_matrix ){
			for (int i = 0; i < con_matrix.length; i++) {
			    for (int j = 0; j < con_matrix[0].length; j++) {
			        System.out.print(con_matrix[i][j] + " " );
			    }
			    System.out.print("\n");
			}
		}
		public static double Precission (int [][] con_matrix, String A){
			double a = con_matrix[0][0];
			double b = con_matrix[1][0];
			double c = con_matrix[2][0];
			
			double Precis = 0;
			if (A=="B"){
			Precis = ( a/(a+b+c));
			}
			if(A=="I"){
			Precis = (double) con_matrix[1][1]/((double) (con_matrix[0][1])+(double)(con_matrix[1][1])+(double) (con_matrix[2][1]));	
			}
			if(A=="O"){
			Precis = (double) con_matrix[2][2]/((double) (con_matrix[0][2])+(double)(con_matrix[1][2])+(double) (con_matrix[2][2]));	
			}			
			return Precis;
			}
		public static double Recall (int[][]con_matrix, String A){
			double Recall = 0;
			if (A=="B"){
				Recall = (double) con_matrix[0][0]/((double) (con_matrix[0][0])+(double) (con_matrix[0][1])+(double) (con_matrix[0][2]));
				}
				if(A=="I"){
				Recall = (double) con_matrix[1][1]/((double) (con_matrix[1][0])+(double)(con_matrix[1][1])+(double) (con_matrix[1][2]));	
				}
				if(A=="O"){
				Recall = (double) con_matrix[2][2]/((double) (con_matrix[2][0])+(double)(con_matrix[2][1])+(double) (con_matrix[2][2]));	
				}			
			return Recall;
			}	
		
}



