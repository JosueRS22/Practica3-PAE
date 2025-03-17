import java.io.*;

public class Eliminar {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Coloque: java Eliminar 'cadena' 'archivo'");
            return;
        }

        String cadena = args[0];
        String nombreArchivo = args[1];

        try {
            File archivo = new File(nombreArchivo);
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = lector.readLine()) != null) {
                contenido.append(linea.replace(cadena, "")).append("\n");
            }
            lector.close();

            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo));
            escritor.write(contenido.toString());
            escritor.close();

            System.out.println("La cadena \"" + cadena + "\" fue eliminada del archivo " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("Error en el archivo: " + e.getMessage());
        }
    }
}