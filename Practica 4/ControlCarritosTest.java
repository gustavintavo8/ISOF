package carritoTests;

import bussinesObjects.*;
import control.*;
import junit.framework.TestCase;

public class ControlCarritosTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCarritoOferta() {
		/* Condiciones de la prueba:
		 * - El producto está en el catálogo.
		 * - Está en oferta con un valor de 95.
		 * - El carrito ya tiene productos por valor de 100. */
		Catalogo cat = new Catalogo(true);
		ControlOfertas conOfer = new ControlOfertas(true, 95);
		ControlCarritos conCarritos = new ControlCarritos(cat, conOfer);

		Carrito car = new Carrito(100.00);
		Producto pro = new Producto("0001", 9, 100.00);

		assertEquals(0, conCarritos.introducirProducto(pro, 1, car));
		assertEquals(195.00, car.getTotal());
	}

	public void testProductoNoEnCatalogo() {
		/* Condiciones de la prueba:
		 * - El producto no está en el catálogo. */
		Catalogo cat = new Catalogo(false);
		ControlOfertas conOfer = new ControlOfertas(false, 0);
		ControlCarritos conCarritos = new ControlCarritos(cat, conOfer);

		Carrito car = new Carrito(50.00);
		Producto pro = new Producto("0002", 10, 20.00);

		assertEquals(101, conCarritos.introducirProducto(pro, 2, car));
		assertEquals(50.00, car.getTotal());
	}

	public void testStockInsuficiente() {
		/* Condiciones de la prueba:
		 * - El producto está en el catálogo.
		 * - No hay suficiente stock disponible. */
		Catalogo cat = new Catalogo(true);
		ControlOfertas conOfer = new ControlOfertas(false, 0);
		ControlCarritos conCarritos = new ControlCarritos(cat, conOfer);

		Carrito car = new Carrito(0.00);
		Producto pro = new Producto("0003", 5, 30.00);

		assertEquals(102, conCarritos.introducirProducto(pro, 6, car));
		assertEquals(0.00, car.getTotal());
	}

	public void testProductoSinOferta() {
		/* Condiciones de la prueba:
		 * - El producto está en el catálogo.
		 * - No está en oferta. */
		Catalogo cat = new Catalogo(true);
		ControlOfertas conOfer = new ControlOfertas(false, 0);
		ControlCarritos conCarritos = new ControlCarritos(cat, conOfer);

		Carrito car = new Carrito(0.00);
		Producto pro = new Producto("0004", 10, 50.00);

		assertEquals(0, conCarritos.introducirProducto(pro, 2, car));
		assertEquals(100.00, car.getTotal());
	}

	public void testProductoEnOferta() {
		/* Condiciones de la prueba:
		 * - El producto está en el catálogo.
		 * - Está en oferta con un valor de 80.
		 * - El stock es suficiente para la cantidad requerida (10 unidades disponibles, se solicitan 2).
		 * - El carrito ya tiene un total acumulado de 100.
		 */
		Catalogo cat = new Catalogo(true);
		ControlOfertas conOfer = new ControlOfertas(true, 80.00);
		ControlCarritos conCarritos = new ControlCarritos(cat, conOfer);

		Carrito car = new Carrito(100.00);
		Producto pro = new Producto("0003", 10, 100.00);

		assertEquals(0, conCarritos.introducirProducto(pro, 2, car));
		assertEquals(260.00, car.getTotal());
	}

	public void testCarritoConOfertaYStockExacto() {
		/* Condiciones de la prueba:
		 * - El producto está en el catálogo.
		 * - Está en oferta con un valor de 80.
		 * - El stock es exacto a la cantidad requerida. */
		Catalogo cat = new Catalogo(true);
		ControlOfertas conOfer = new ControlOfertas(true, 80);
		ControlCarritos conCarritos = new ControlCarritos(cat, conOfer);

		Carrito car = new Carrito(0.00);
		Producto pro = new Producto("0005", 3, 100.00);

		assertEquals(0, conCarritos.introducirProducto(pro, 3, car));
		assertEquals(240.00, car.getTotal());
	}

	public void testActualizacionStock() {
		/* Condiciones de la prueba:
		 * - El producto está en el catálogo.
		 * - No está en oferta.
		 * - El stock inicial es 5.
		 * - Se solicitan 3 unidades.
		 */

		Catalogo cat = new Catalogo(true);
		ControlOfertas conOfer = new ControlOfertas(false, 0); // Sin oferta.
		ControlCarritos conCarritos = new ControlCarritos(cat, conOfer);

		Carrito car = new Carrito(0.00);
		Producto pro = new Producto("0005", 5, 20.00); // Stock inicial: 5.

		// Introducir el producto en el carrito.
		assertEquals(0, conCarritos.introducirProducto(pro, 3, car));

		// Decrementar el stock en 3 unidades.
		cat.decrementarStock(pro, 3);

		// Comprobar que el stock del producto se reduce correctamente.
		assertEquals(2, pro.getStock());

		//No se reduce correctamente ya que el metodo decrementarStock() no hace nada.
	}

	public void testPrecioOferta() {
		/* Condiciones de la prueba:
		 * - El producto está en oferta y su precio de oferta es 15.
		 * - El producto tiene un precio original de 20.
		 * - Se debe devolver el precio de oferta cuando el producto está en oferta.
		 */
		ControlOfertas conOfer = new ControlOfertas(true, 15.00);  // Producto en oferta.
		Producto pro = new Producto("0005", 3, 20.00);  // Precio original: 20.

		// Comprobar que se devuelve el precio de oferta.
		assertEquals(15.00, conOfer.precioOferta(pro));  // El precio de oferta debería ser 15.
	}

	public void testPrecioOriginalCuandoNoHayOferta() {
		/* Condiciones de la prueba:
		 * - El producto no está en oferta.
		 * - El precio original es 20.
		 * - Se debe devolver el precio original cuando no hay oferta.
		 */
		ControlOfertas conOfer = new ControlOfertas(false, 15.00);  // Producto sin oferta.
		Producto pro = new Producto("0005", 3, 20.00);  // Precio original: 20.

		// Comprobar que se devuelve el precio original.
		assertEquals(20.00, conOfer.precioOferta(pro));  // El precio original debería ser 20.

		//La logica del programa en este caso está mal, ya que da igual si el producto está en oferta o no. Te coge el precio en oferta que tenga
	}


	public void testStockInsuficienteNoDecrementar() {
		/* Condiciones de la prueba:
		 * - El producto está en el catálogo.
		 * - Hay 3 unidades en stock, pero se solicitan 5 unidades.
		 * - No debería permitir decrementar el stock si no hay suficientes unidades.
		 */
		Catalogo cat = new Catalogo(true);  // El catálogo tiene productos.
		Producto pro = new Producto("0005", 3, 20.00);  // Stock inicial: 3.

		// Intentar introducir 5 unidades, pero el stock es insuficiente.
		Carrito car = new Carrito(0.00);
		ControlOfertas conOfer = new ControlOfertas(false, 0);
		ControlCarritos conCarritos = new ControlCarritos(cat, conOfer);

		int result = conCarritos.introducirProducto(pro, 5, car);

		// Comprobar que no se añadió el producto al carrito y que el stock no cambió.
		assertEquals(102, result);  // Error de stock insuficiente
		assertEquals(3, pro.getStock());  // El stock no debe haber cambiado.
	}

	public void testCarritoVacioOBorde() {
		/* Condiciones de la prueba:
		 * - Intentar añadir 0 productos.
		 * - Total acumulado cercano a 0. */
		Catalogo cat = new Catalogo(true);
		ControlOfertas conOfer = new ControlOfertas(false, 0);
		ControlCarritos conCarritos = new ControlCarritos(cat, conOfer);

		Carrito car = new Carrito(0.00);
		Producto pro = new Producto("0015", 10, 1.00);

		assertEquals(0, conCarritos.introducirProducto(pro, 0, car)); // Añadir 0 productos.
		assertEquals(0.00, car.getTotal());
	}

	public void testOperacionesConsecutivas() {
		/* Condiciones de la prueba:
		 * - Añadir múltiples productos consecutivamente.
		 * - Validar total acumulado y stock reducido. */
		Catalogo cat = new Catalogo(true);
		ControlOfertas conOfer = new ControlOfertas(false, 0);
		ControlCarritos conCarritos = new ControlCarritos(cat, conOfer);

		Carrito car = new Carrito(0.00);
		Producto pro1 = new Producto("0016", 10, 50.00);
		Producto pro2 = new Producto("0017", 5, 30.00);

		assertEquals(0, conCarritos.introducirProducto(pro1, 2, car));
		assertEquals(0, conCarritos.introducirProducto(pro2, 3, car));

		assertEquals(190.00, car.getTotal()); // Total acumulado: 100 + 90.
	}


	public void testConcurrencia() throws InterruptedException {
		/* Condiciones de la prueba:
		 * - Simular acceso concurrente al carrito.
		 * - Validar total acumulado y stock reducido. */
		Catalogo cat = new Catalogo(true);
		ControlOfertas conOfer = new ControlOfertas(false, 0);
		ControlCarritos conCarritos = new ControlCarritos(cat, conOfer);

		Carrito car = new Carrito(0.0);
		Producto pro = new Producto("0018", 10, 20.0);

		Thread t1 = new Thread(() -> conCarritos.introducirProducto(pro, 5, car));
		Thread t2 = new Thread(() -> conCarritos.introducirProducto(pro, 3, car));

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		assertEquals(160.0, car.getTotal());
		assertEquals(2, pro.getStock());

		//No se esta calculando bien el método car.getTotal() ya que no se está manejando bien el hecho
		//de que se acceda de forma concurrente o paralela
	}

}
