import java.io.*;

public class Contar {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Coloque: java Contar 'nombre_archivo'");
            return;
        }

        String nombreArchivo = args[0];

        try {
            File archivo = new File(nombreArchivo);
            BufferedReader lector = new BufferedReader(new FileReader(archivo));

            int numCaracteres = 0;
            int numPalabras = 0;
            int numLineas = 0;
            String linea;

            while ((linea = lector.readLine()) != null) {
                numLineas++;
                numCaracteres += linea.length();
                numPalabras += linea.split("\\s+").length;
            }
            lector.close();

            System.out.println("El archivo tiene");
            System.out.println(numCaracteres + " Caracteres");
            System.out.println(numPalabras + " Palabras");
            System.out.println(numLineas + " Lineas");

        } catch (IOException e) {
            System.out.println("Error en el archivo: " + e.getMessage());
        }
    }
}