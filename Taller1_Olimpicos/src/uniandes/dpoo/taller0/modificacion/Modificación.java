package uniandes.dpoo.taller0.modificacion;

import java.io.IOException;

import uniandes.dpoo.taller0.procesamiento.CalculadoraEstadisticas;
import uniandes.dpoo.taller0.procesamiento.LoaderOlimpicos;

public class Modificación
{
	
	public static void main(String[] args)
	{
		CalculadoraEstadisticas calc = null;
		try {
			calc = LoaderOlimpicos.cargarArchivo("./data/atletas.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(calc.paisConMasMedallistas());
	}

	
}