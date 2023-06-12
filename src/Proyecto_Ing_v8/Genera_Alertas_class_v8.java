package Proyecto_Ing_v8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Genera_Alertas_class_v8 {
	public void procesarArchivoCSV(String nombreArchivo) {//Método que llama a la función de separar datos e imprimir
		Map<String,List<String>> datosSeparados = separarDatosCSV(nombreArchivo);
		//Imprimir los datos separados por componentes
		for(Map.Entry<String,List<String>>entry:datosSeparados.entrySet()) {
			String componente = entry.getKey();
			List<String>datos=entry.getValue();
			System.out.println("Componente: " + componente);
            System.out.println("Datos: " + datos);
            System.out.println();
		}
	}
	
	private Map<String,List<String>> separarDatosCSV(String nombreArchivo){
		//MAP: Key:nombre del componente / Value: lista de los datos correspondientes a ese componente
		Map<String, List<String>> datosSeparados = new HashMap<>();
		 
			//Bucle Try-with-resources
	        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                String[] componentes = linea.split(";");
	                for (int i = 0; i < componentes.length; i++) {
	                    String componente = "Componente " + (i + 1);
	                    List<String> datos = datosSeparados.getOrDefault(componente, new ArrayList<>());
	                    datos.add(componentes[i]);
	                    datosSeparados.put(componente, datos);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return datosSeparados;
	    }
	
	
	
	
}//llave de la clase


