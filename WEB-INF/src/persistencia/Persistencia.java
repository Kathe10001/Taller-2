package persistencia;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import valueObjects.VOPersistencia;

public class Persistencia {

	//Metodo respaldare
	public void respaldar (VOPersistencia persistencia) throws IOException{

		try {
			// Abro el archivo y creo un flujo de comunicaci�n hacia �l
			FileOutputStream file = new FileOutputStream("respaldo.dat"); //debemos crear el archivo?
			ObjectOutputStream object = new ObjectOutputStream(file);
			// Escribo el VO con las colecciones en el archivo a trav�s del flujo
			object.writeObject(persistencia);
			object.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	//Metodo recuperar
	public VOPersistencia recuperar () throws Exception {
		try {
			// Abro el archivo y creo un flujo de comunicaci�n hacia �l
			FileInputStream file = new FileInputStream("respaldo.dat");
			ObjectInputStream object = new ObjectInputStream(file);
			// Leo el VO con las colecciones desde el archivo a trav�s del flujo
			VOPersistencia persistencia = (VOPersistencia) object.readObject();
			object.close();
			file.close();
			return persistencia;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
