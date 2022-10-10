
/**
 * Clase que contiene los objetos del programa que se almacenan en la base de datos
 * @author root
 *@since 10/10/2022
 */
public class ClienteFit {

	/**
	 * Nombre del Cliente fittnes
	 */
	 	private String nombre;
	 	/**
		 * Edad en años del cliente
		 */
	 	private int edad;
	 	/**
		 * Peso en Kilos del cliente
		 */
	 	private double peso;
	 	/**
		 * Altura en cm  del cliente
		 */
	 	private double altura;
	    
	 	/**
	 	 *  Contructor principal con parámetros
	 	 * @param nombre Edad del cliente
	 	 * @param edad Edad del cliente
	 	 * @param altura Altura del cliente ( cm )
	 	 * @param peso Peso del cliente (kg )
	 	 */
		public ClienteFit(String nombre, int edad,  double altura,double peso) {
			super();
			this.nombre = nombre;
			this.edad = edad;
			this.peso = peso;
			this.altura = altura;
		}

		/**
		 * Obtiene el nombre
		 * @return nombre
		 */
		public String getNombre() {
			return nombre;
		}

		/**
		 * Actualiza el nombre
		 * @param nombre nombre del cliente
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		/**
		 * Obtiene la edad
		 * @return edad en años
		 */
		public int getEdad() {
			return edad;
		}
/**
 *  Actualiza la edad
 * @param edad edad en años
 */
		public void setEdad(int edad) {
			this.edad = edad;
		}
		/**
		 * Obtiene el peso 
		 * @return peso en Kg.
		 */
		public double getPeso() {
			return peso;
		}
		/**
		 * Actualiza el peso
		 * @param peso peso en Kg.
		 */
		public void setPeso(double peso) {
			this.peso = peso;
		}
		/**
		 * Obtiene la altura
		 * @return altura en cm.
		 */
		public double getAltura() {
			return altura;
		}
		/**
		 * Actualiza la altura
		 * @param altura altura en  cm.
		 */
		public void setAltura(double altura) {
			this.altura = altura;
		}
	
	    @Override
	/**
	 * Recubrimiento del método toString
	 * 
	 */
	    public String toString() {
	        return "Cliente Fit {" + "nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", altura=" + altura + '}';
	    }
}
