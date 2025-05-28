package triangleTests;

import triangle.Triangle;
import junit.framework.TestCase;

public class TriangleTest extends TestCase {

	public void testEquilatero() {
		/* Condiciones de la prueba:
		 * - Los tres lados son iguales (3, 3, 3).
		 * - Debería identificarse como un triángulo equilátero.
		 */
		Triangle t = new Triangle(3, 3, 3);
		assertEquals("Equilatero", t.getTriangleType());
	}

	public void testNotEquilatero() {
		/* Condiciones de la prueba:
		 * - Dos lados son iguales, pero el tercero es diferente (2, 3, 3).
		 * - Debería identificarse como un triángulo isósceles.
		 */
		Triangle t = new Triangle(2, 3, 3);
		assertEquals("Isosceles", t.getTriangleType());
	}

	public void testIsosceles() {
		/* Condiciones de la prueba:
		 * - Dos lados son iguales (5, 5, 3).
		 * - Debería identificarse como un triángulo isósceles.
		 */
		Triangle t = new Triangle(5, 5, 3);
		assertEquals("Isosceles", t.getTriangleType());
	}

	public void testEscaleno() {
		/* Condiciones de la prueba:
		 * - Ningún lado es igual a otro (4, 5, 6).
		 * - Debería identificarse como un triángulo escaleno.
		 */
		Triangle t = new Triangle(4, 5, 6);
		assertEquals("Escaleno", t.getTriangleType());
	}

	public void testRectangulo() {
		/* Condiciones de la prueba:
		 * - Satisface el teorema de Pitágoras (3, 4, 5).
		 * - Debería identificarse como un triángulo rectángulo.
		 */
		Triangle t = new Triangle(3, 4, 5);
		assertEquals("Rectangulo", t.getTriangleType());
	}

	public void testTrianguloLadosNegativos() {
		/* Condiciones de la prueba:
		 * - Uno de los lados es negativo (-3, 4, 5).
		 * - No debería considerarse un triángulo válido.
		 */
		Triangle t = new Triangle(-3, 4, 5);
		assertEquals("Invalido", t.getTriangleType());
	}

	public void testTrianguloLadosCero() {
		/* Condiciones de la prueba:
		 * - Uno de los lados es cero (0, 4, 5).
		 * - No debería considerarse un triángulo válido.
		 */
		Triangle t = new Triangle(0, 4, 5);
		assertEquals("Invalido", t.getTriangleType());
	}

	public void testTrianguloLadoDemasiadoLargo() {
		/* Condiciones de la prueba:
		 * - La suma de dos lados es menor o igual que el tercer lado (1, 2, 3).
		 * - No debería considerarse un triángulo válido.
		 */
		Triangle t = new Triangle(1, 2, 3);
		assertEquals("Invalido", t.getTriangleType());
	}

	public void testTrianguloLadosSumaIgual() {
		/* Condiciones de la prueba:
		 * - La suma de dos lados es igual al tercer lado (5, 5, 10).
		 * - No debería considerarse un triángulo válido.
		 */
		Triangle t = new Triangle(5, 5, 10);
		assertEquals("Invalido", t.getTriangleType());
	}

	public void testTrianguloIsoscelesRectangulo() {
		/* Condiciones de la prueba:
		 * - Los lados cumplen el teorema de Pitágoras y dos lados son iguales (5, 5, √50).
		 * - Debería identificarse como un triángulo rectángulo, no isósceles.
		 */
		Triangle t = new Triangle(5, 5, Math.sqrt(50));
		assertEquals("Rectangulo", t.getTriangleType()); // Este podría fallar.

		//En el método getTriangleType(), la condición para identificar un triángulo isósceles 
		//está antes que la condición para identificar un triángulo rectángulo, esto provoca 
		//que los triángulos que cumplen ambas condiciones se clasifiquen incorrectamente como isósceles.
	}

	public void testTrianguloRectanguloLadosGrandes() {
		/* Condiciones de la prueba:
		 * - Los lados son muy grandes (1e10, 1e10, 1.41421356e10).
		 * - Cumplen el teorema de Pitágoras.
		 * - Debería identificarse como un triángulo rectángulo.
		 */
		Triangle t = new Triangle(1e10, 1e10, 1.41421356e10);
		assertEquals("Rectangulo", t.getTriangleType()); // Podría fallar por precisión y falla por el metodo getTriangleType() seguramente.
	}

	public void testTrianguloRectanguloConDecimales() {
		/* Condiciones de la prueba:
		 * - Los lados cumplen el teorema de Pitágoras, pero con decimales (0.3, 0.4, 0.5).
		 * - Debería identificarse como un triángulo rectángulo.
		 */
		Triangle t = new Triangle(0.3, 0.4, 0.5);
		assertEquals("Rectangulo", t.getTriangleType()); // Este podría fallar.
	}

	public void testTrianguloIsoscelesPrecision() {
		/* Condiciones de la prueba:
		 * - Dos lados son casi iguales, pero no exactamente (5.0, 5.0, 5.0000001).
		 * - Debería identificarse como un triángulo isósceles.
		 */
		Triangle t = new Triangle(5.0, 5.0, 5.0000001);
		assertEquals("Isosceles", t.getTriangleType()); // Podría fallar.
	}

	public void testTrianguloOverflow() {
		/* Condiciones de la prueba:
		 * - Los lados son extremadamente grandes (Double.MAX_VALUE / 2, etc.).
		 * - Debería identificarse correctamente según su tipo.
		 */
		double maxSide = Double.MAX_VALUE / 2;
		Triangle t = new Triangle(maxSide, maxSide, maxSide - 1);
		assertEquals("Equilatero", t.getTriangleType()); // Podría fallar debido a overflow.
	}

	public void testTrianguloEscalenoCondicionesExtremas() {
		/* Condiciones de la prueba:
		 * - Lados que apenas cumplen las condiciones de validez (1.0, 1.0, 1.9999999).
		 * - Debería identificarse correctamente como un triángulo isósceles.
		 */
		Triangle t = new Triangle(1.0, 1.0, 1.9999999);
		assertEquals("Isosceles", t.getTriangleType()); // Podría fallar por precisión.
	}


}
