import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class entity {

	public static void main(String[] args) throws IOException {
		CSVReader.CargarCSV();
		LinkedList A= onevsone.initB();
		entity.Indexi_Entidades(A);
		entity.Indexf_Entidades(A);
		}
				
									
		public static int[] Indexi_Entidades(LinkedList Real1) {
			int num=0;
			int [] Pos_Ini_Ent_Act={};
			int [] Pos_Fin_Ent_Act={};
			
						
			while (Real1.size() > num ) {
				//identificacion de entidades en real  --OJO EL ARCHIVO NO PUEDE TERMINAR EN B O I.
				if (Real1.get(num).equals("B")&& Real1.get(num+1).equals("I")) {
					  int a = 0;
					  int b = num;
					  while(( Real1.get(b+1)).equals("I")){
						 a=a+1;
						 b++;
					  }
					  Pos_Ini_Ent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Ini_Ent_Act, num);
					  Pos_Fin_Ent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Fin_Ent_Act, num+a);
					  
					  
					  }
				if (Real1.get(num).equals("B")&& Real1.get(num+1).equals("O")) {
					  Pos_Ini_Ent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Ini_Ent_Act, num);
					  Pos_Fin_Ent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Fin_Ent_Act, num);
					 
					  }
				if (Real1.get(num).equals("B")&& Real1.get(num+1).equals("B")) {
					  Pos_Ini_Ent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Ini_Ent_Act, num);
					  Pos_Fin_Ent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Fin_Ent_Act, num);
					 
					  }
				
				num++;
			}
			
			System.out.println(org.apache.commons.lang.ArrayUtils.toString(Pos_Ini_Ent_Act));
			return Pos_Ini_Ent_Act;
		}
		
		public static int[] Indexf_Entidades(LinkedList Real1) {
			int num=0;
			int [] Pos_Ini_Ent_Act={};
			int [] Pos_Fin_Ent_Act={};
			
						
			while (Real1.size() > num ) {
				//identificacion de entidades en real  
				if (Real1.get(num).equals("B")&& Real1.get(num+1).equals("I")) {
					  int a = 0;
					  int b = num;
					  while(( Real1.get(b+1)).equals("I")){
						 a=a+1;
						 b++;
					  }
					  Pos_Ini_Ent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Ini_Ent_Act, num);
					  Pos_Fin_Ent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Fin_Ent_Act, num+a);
					  
					  
					  }
				if (Real1.get(num).equals("B")&& Real1.get(num+1).equals("O")) {
					  Pos_Ini_Ent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Ini_Ent_Act, num);
					  Pos_Fin_Ent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Fin_Ent_Act, num);
					 
					  }
				if (Real1.get(num).equals("B")&& Real1.get(num+1).equals("B")) {
					  Pos_Ini_Ent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Ini_Ent_Act, num);
					  Pos_Fin_Ent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Fin_Ent_Act, num);
					 
					  }
				
				num++;
			}
			
			System.out.println(org.apache.commons.lang.ArrayUtils.toString(Pos_Fin_Ent_Act));
			return Pos_Fin_Ent_Act;
		}
		
		public static int[] Index_Noentidades(LinkedList Real1) {
			int num=0;
			int [] Pos_Ini_Noent_Act={};
			while (Real1.size() > num ) {
			if (Real1.get(num).equals("O")) {
			  Pos_Ini_Noent_Act= org.apache.commons.lang.ArrayUtils.add(Pos_Ini_Noent_Act, num);
			  	  
			  }
			num++;
				  	
			}
			return Pos_Ini_Noent_Act;
		}
		public static int[] Index_Total (int[] Index_Entidades, int[] Index_NoEntidades){
			int [] Index_Total={};
			Index_Total=org.apache.commons.lang.ArrayUtils.addAll(Index_Entidades, Index_NoEntidades);
			Arrays.sort(Index_Total);
			return Index_Total;
			
			
		}
}
