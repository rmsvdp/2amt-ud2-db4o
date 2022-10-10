		import com.db4o.Db4oEmbedded;
		import com.db4o.ObjectContainer;
		import com.db4o.ObjectSet;
		import java.io.File;

		/**
		 * Conectores : Clase que ilustra el funcionamiento de la librería embebida db4o
		 * @author root
		 *@since  10/10/2022
		 *
		 */
public class Conectores {

	/**
	 * db : Objeto de contenedor de la base de datos
	 * @see <a href = "https://iboxdb.github.io/db4o-gpl-doc/javadoc/com/db4o/package-summary.html"> Documentación de la librería  </a>
	 */
	static ObjectContainer db;
	
	/**
	 *  main : Punto de entrada de la clase
	 * @param args argumentos por línea de comnados (no se utilizan)
	 * @since 10/10/2022
	 */
	public static void main(String[] args) {
        
		ClienteFit p1 = new ClienteFit("Fernando", 30, 1.73, 73);
        ClienteFit p2 = new ClienteFit("Pepe", 30, 1.75, 80);
        ClienteFit p3 = new ClienteFit("Alfredo", 20, 1.9, 90);
        ClienteFit p4 = new ClienteFit("Roberto", 35, 1.70, 70);
        ClienteFit p5 = new ClienteFit("Domingo", 30, 1.73, 80);
	
        File f = new File("personas.db4o");			// Crear fichero con la base de datos
        f.delete();
        
       db = Db4oEmbedded.openFile(f.getAbsolutePath());
        // Sentencias: INSERT
        db.store(p1);
        db.store(p2);
        db.store(p3);
        db.store(p4);
        db.store(p5);
        System.out.println();
        SelectAll();
        // Sentencias:  SELECT (campo1, campo2,...) 
        // null = * ¿0 = *?
        System.out.println("Buscar clientes con edad 30 y peso 80");
        ClienteFit p = new ClienteFit(null, 30, 0,80);
        ObjectSet<ClienteFit> result = db.queryByExample(p);
        System.out.println();
        
        while(result.hasNext()){
            System.out.println(result.next());
        }
        
        // Sentencias: UPDATE
        System.out.println();
        System.out.println("Actualizar peso de Pepe ...");
        ObjectSet<ClienteFit> rs = db.queryByExample(new ClienteFit("Pepe", 30, 1.75, 80));
        System.out.println("Registros encontrados : " + rs.size());
        ClienteFit z = (ClienteFit) rs.next();
        z.setPeso(85);	     // Actualizado en memoria
        db.store(z);			// Actualizado en base de datos
        System.out.println("Nueva lista de Clientes ...");
        SelectAll();
        // Sentencias: DELETE
        System.out.println("Borrar ficha de  Pepe ...");
        ObjectSet<ClienteFit> rs2 = db.queryByExample(new ClienteFit("Pepe", 30, 1.75, 85));
        System.out.println("Registros encontrados : " + rs.size());
        ClienteFit z1 = (ClienteFit) rs2.next();

        db.delete(z1);			// Consolidar en base de datos
        System.out.println("Nueva lista de Clientes ...");
        SelectAll();
        
        db.close();			// Cerrar base de datos
	}

	/**
	 * SelectAll : Método para simular un SELECT * y sacarlo por pantalla
	 */
	public static void SelectAll() {
		
	  
	        ObjectSet<ClienteFit> result = db.queryByExample(null);
	        System.out.println();
	        System.out.println("--------- LISTA DE CLIENTES FITTNESS ------------------------");
	        
	        while(result.hasNext()){
	            System.out.println(result.next());
	        }
	        System.out.println("--------------------------------------------------------");
		
	}
}
