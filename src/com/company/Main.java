package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//Elegir un parrafo de texto de cualquier lugar (ej. Periodico de internet) y separar
// las palabras en un array y contar la cantidad de veces que aparece cada palabra en el texto

        String parrafo = "El método split() en Java al igual que en todos los lenguajes de programación, sirve para separar un string o cadena de texto en varios strings. El método usa una expresión regular para separar la cadena de texto o string.";
        //separar las cadenas de String- palabra y guada en array
        String[] palabras = parrafo.split(" ");

        //crear una lista y guardar el array en la lista
        List<String> listaPalabras = new ArrayList<>();
        listaPalabras.addAll(Arrays.asList(palabras));

        //creo mapa para guardar palabra  y numero de repeticiones
        Map<String, Integer> mapParrafo = new HashMap<>();

        //agregar palabras al mapa
        for (String palabra : palabras) {
            if (mapParrafo.containsKey(palabra)) {
                mapParrafo.put(palabra, mapParrafo.get(palabra) + 1);
            } else {
                mapParrafo.put(palabra, 1);
            }
        }

        //recorro mapa con keyset para ver cantidad de repeticiones de cada palabra

        for (String palabra : mapParrafo.keySet()) {
            System.out.println(palabra + " " + mapParrafo.get(palabra));
        }

        //buscar palabramas repetida
        Map.Entry<String, Integer> maxEntry = getMaxEntry(mapParrafo);

    }

    public static Map.Entry<String, Integer> getMaxEntry(Map<String, Integer> map) {
        Map.Entry<String, Integer> maxEntry = null;
        Integer max = Collections.max(map.values());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (null != value && max == value) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }
}
