package com.coop.infrastructure.utils;

public class CambioDeCaracteres {
	//cambiar caracteres set y get
		public static String CarateresSetGet(String cadena){
			//de mayus a minus
			String minus=cadena.toLowerCase();
			//caracte que se va quitar
			String[] a = minus.split("_");
			String cad = "";
			for(int i=0;i<a.length;i++){
				char[] caracteres = new String(a[i]).toCharArray();
				caracteres[0] = Character.toUpperCase(caracteres[0]);
				cad=cad + new String(caracteres);
			}
			return new String(cad);
		}
		
		//cambiar caracteres propiedades
		public static String CaracteresProp(String cadena){
			//de mayus a minus
			String minus = cadena.toLowerCase();
			//caracte que se va quitar
			String[] a = minus.split("_");
			String cad = "";
			for(int i = 0; i < a.length;i++){
				char[] caracteres = new String(a[i]).toCharArray();
				caracteres[0] = Character.toUpperCase(caracteres[0]);
				//System.out.println(caracteres);
				cad=cad + new String(caracteres);
			}
			char[] caracteres = cad.toCharArray();
			caracteres[0] = Character.toLowerCase(caracteres[0]);
			return new String(caracteres);
		}
}