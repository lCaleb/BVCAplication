package testArbolAVL;

import AVL.ElementoExisteException;
import AVL.ElementoNoExisteException;
import AVL.IArbolOrdenado;
import junit.framework.TestCase;

/**
* Clase abstracta usada para probar los metodos de la interfaz IArbolOrdenado.
* @see IArbolOrdenado
*/
public abstract class AbstractArbolOrdenadoTest extends TestCase
{

/**
* Arbol ordenado en el que se quieren hacer las pruebas.
*/
protected IArbolOrdenado<Integer> arbol;

/**
* Número de datos para pruebas
*/
protected int datos;

/**
* Verificador de la estructura sobre la que se quieren hacer las pruebas.
*/
protected IVerificadorEstructuraArbolOrdenado<Integer> verificador;

/**
* Instancia un arbol ordenado.
* @return Un arbol ordenado.
*/
public abstract IArbolOrdenado<Integer> instanciarArbol( );

/**
* Instancia un verificador apropiado para el arbol sobre el que se quieren hacer las pruebas.
* @return Un verificador apropiado para el arbol sobre el que se quieren hacer las pruebas.
*/
public abstract IVerificadorEstructuraArbolOrdenado<Integer> instanciarVerificador( );

/**
* Crea un arbol vacio.
*/
public void setupEscenario1( )
{
arbol = instanciarArbol( );
verificador = instanciarVerificador( );
datos = 20000;
}

/**
* Crea un árbol ordenado con datos desde 0 hasta 19.999 ingresados aleatoreamente
*/
public void setupEscenario2( )
{
// Agregar números aleatorios y verificar la estructura en cada paso
setupEscenario1( ); 

try
{
	
	 
for( int i = 0; i < datos; i++ )
{
Integer elem;
do
{
elem = ( int ) ( Math.random( ) * datos );
} while( arbol.buscar( elem ) != null );
arbol.insertar( elem );
}
verificador.verificarEstructura( );
}
catch( ElementoExisteException e )
{
// Esto no debería suceder
fail( );
}
catch( EstructuraException e )
{
e.printStackTrace( );
fail( e.getMessage( ) );
}
}

/**
* Prubas para el método Insertar
*/
public void testAgregar( )
{
setupEscenario1( );
try
{
for( int i = 0; i < datos; i++ )
{
Integer elem;
do
{
elem = ( int ) ( Math.random( ) * datos );
} while( arbol.buscar( elem ) != null );
arbol.insertar( elem );
assertNotNull( "El elemento " + elem + " no fue agregado", arbol.buscar( elem ) );
assertEquals( "El nodo no fue agregado", i + 1, arbol.darPeso( ) );
verificador.verificarEstructura( );
}
}
catch( ElementoExisteException e )
{
// Esto no deberí a suceder
fail( e.getMessage( ) );
}
catch( EstructuraException e )
{
e.printStackTrace( );
fail( e.getMessage( ) );
}
}

/**
* Pruebas para el método de eliminar.
*/
public void testEliminar( )
{
// Eliminar datos aleatorios de un árbol
setupEscenario2( ); 

try
{
for( int i = 0; i < datos; i++ )
{
Integer elem;
do
{
elem = ( int ) ( Math.random( ) * datos );
} while( arbol.buscar( elem ) == null );

arbol.eliminar( elem );

assertNull( "El elemento " + elem + " no fue eliminado", arbol.buscar( elem ) );
assertEquals( "El nodo no fue agregado", datos - ( i + 1 ), arbol.darPeso( ) );
verificador.verificarEstructura( );
}
}
catch( ElementoNoExisteException e )
{
// Esto no debería suceder
fail( );
}
catch( EstructuraException e )
{
e.printStackTrace( );
fail( e.getMessage( ) );
}
}

}
