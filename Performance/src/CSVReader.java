import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import com.csvreader.CsvReader;


public class CSVReader {
	public static LinkedList Real = new LinkedList();
	public static LinkedList Pred_Bin = new LinkedList();
	public static LinkedList Pred_Multi = new LinkedList();
	
	public static void main(String[] args) throws Exception {
	}
	
	public static void CargarCSV() throws IOException{
		String fileName = "/home/sistemas/Descargas/VentanaTamano5.csv"; //archivo
		BufferedReader CSVFile = new BufferedReader(new FileReader(fileName)); //objeto de tipo Buffered

		String dataRow = CSVFile.readLine(); //leer linea
		while (dataRow != null) {
		String[] dataArray = dataRow.split(",",3);
		Real.addLast(dataArray[0]);
		Pred_Bin.addLast(dataArray[1]);
		Pred_Multi.addLast(dataArray[2]);
		dataRow = CSVFile.readLine();		
		}
		CSVFile.close();
			}
	
	public static LinkedList getReal() {
		return Real;
	}
	public static LinkedList getPred_bin() {
		return Pred_Bin;
	}
	public static LinkedList getPred_Multi() {
		return Pred_Multi;
	}
		
		} 

