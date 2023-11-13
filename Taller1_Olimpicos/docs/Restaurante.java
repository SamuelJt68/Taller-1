package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Restaurante {
	
	
	
	public void cargarInformacionRestaurante(String archivo) throws FileNotFoundException,  IOException
	{
		
		List<Producto> productos = new ArrayList<>();
		List<Ingrediente> ingredientes = new ArrayList<>();
		List<Combo> combos = new ArrayList<>();
		String producto = "";
		int precio = 0;
		String descuento = "";
		String combo = "";
		String producto1 = "";
		String gaseosa = "";
		
		BufferedReader br = new BufferedReader(new FileReader(archivo));
		String linea = br.readLine();
		while(linea != null)
		{
			if (archivo == "ingredientes" || archivo == "menu")
			{
				String[] partes = linea.split(";");
				producto = partes[0];
				precio = Integer.parseInt(partes[1]);
			}
			
			Producto elProducto = buscarProducto(productos, producto,precio);
			Ingrediente elIngrediente = buscarIngrediente(ingredientes, producto, precio);
	
			if (archivo == "menu" && elProducto == null)
			{
				elProducto = new Producto(producto, precio);
				productos.add(elProducto);
			}
			

			if (archivo == "ingredientes")
			{
				elIngrediente = new Ingrediente(producto,precio);
				ingredientes.add(elIngrediente);
			}
			
			if (archivo == "combos")
			{
				String[] partes = linea.split(";");
				combo = partes[0];
				descuento = partes[1];
				producto = partes[2];
				producto1 = partes[3];
				gaseosa = partes[4];
				
			}
			
		}
		
		br.close();
	}
	
	private static Producto buscarProducto(List<Producto> productos,  String producto ,int precio)
	{
		Producto elProducto = null;

		for (int i = productos.size() - 1; i >= 0 && elProducto == null; i--)
		{
			Producto unProducto = productos.get(i);
			if (unProducto.darProducto().equals(producto) && unProducto.darPrecio() == precio)
			{
				elProducto = unProducto;
			}
		}

		return elProducto;
	}
	
	private static Ingrediente buscarIngrediente(List<Ingrediente> ingredientes,  String producto ,int precio)
	{
		Ingrediente elIngrediente = null;

		for (int i = productos.size() - 1; i >= 0 && elIngrediente == null; i--)
		{
			Ingrediente unIngrediente = productos.get(i);
			if (unIngrediente.darIngrediente().equals(producto) && unIngrediente.darPrecio() == precio)
			{
				elIngrediente = unIngrediente;
			}
		}

		return elIngrediente;
		
	}
	
	

}
