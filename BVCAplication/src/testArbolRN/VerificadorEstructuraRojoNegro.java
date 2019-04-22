package testArbolRN;

import java.util.LinkedList;
import java.util.List;

import ARN.ArbolRojoNegro;
import ARN.NodoRojoNegro;

/**
* Clase encargada de verificar las propiedades de un arbol rojo-negro.
* 
* @param <T> Tipo de datos a almacenar en el arbol.
* @see ArbolRojoNegro
*/
public class VerificadorEstructuraRojoNegro<T extends Comparable<? super T>> implements IVerificadorEstructuraArbolOrdenado<T>
{

/**
* Arbol sobre el que se quiere hacer la verificación.
*/
private ArbolRojoNegro<T> arbol;

/**
* Constructor de la clase.
* @param arbol Arbol sobre el que se quiere hacer la verificación.
*/
public VerificadorEstructuraRojoNegro( ArbolRojoNegro<T> arbol )
{
this.arbol = arbol;
}

/*
* (non-Javadoc)
* @see uniandes.cupi2.collections.arbolOrdenado.IVerificadorEstructuraArbolOrdenado#verificarEstructura()
*/
public void verificarEstructura( ) throws EstructuraException
{
verificarRaizNegra( );
verificarHijosDeNodoRojo( arbol.darRaiz( ) );
verificarRamas( );
verificarOrden( arbol.darRaiz( ) );
}

/**
* Verifica que la raíz del arbol sea negra.
* @throws EstructuraException Si la raí z del árbol no es negra.
*/
private void verificarRaizNegra( ) throws EstructuraException
{
if( arbol.darRaiz( ) != null && arbol.darRaiz( ).darColor( ) != NodoRojoNegro.NEGRO )
throw new EstructuraException( "La raiz del arbol debe ser negra" );
}

/**
* Verifica que los hijos de nodos rojos sean negros.
* 
* @param nodo Nodo a partir del cual se verifica la propiedad.
* @throws EstructuraException Si se encuentra alguna violación a esta propiedad.
*/
private void verificarHijosDeNodoRojo( NodoRojoNegro<T> nodo ) throws EstructuraException
{
if( nodo == null )
return;
else if( nodo.darColor( ) == NodoRojoNegro.ROJO )
{
if( nodo.darHijoDerecho( ) != null && nodo.darHijoDerecho( ).darColor( ) == NodoRojoNegro.ROJO )
throw new EstructuraException( "Los hijos de los nodos rojos deben ser negros" );
if( nodo.darHijoIzquierdo( ) != null && nodo.darHijoIzquierdo( ).darColor( ) == NodoRojoNegro.ROJO )
throw new EstructuraException( "Los hijos de los nodos rojos deben ser negros" );

}

verificarHijosDeNodoRojo( nodo.darHijoDerecho( ) );
verificarHijosDeNodoRojo( nodo.darHijoIzquierdo( ) );
}

/**
* Verifica que todas las ramas del árbol tenga el mismo número de nodos negros.
* 
* @throws EstructuraException Si se encuentra alguna violación a esta propiedad.
*/
private void verificarRamas( ) throws EstructuraException
{
// Obtener los nodos hojas del arbol
List<NodoRojoNegro<T>> hojas = new LinkedList<NodoRojoNegro<T>>( );
if( arbol.darRaiz( ) != null )
arbol.darRaiz( ).darHojas( hojas );

// Verificar que toda rama tiene el mismo número de nodos negros
int nNegros = -1;
for( NodoRojoNegro<T> hoja : hojas )
{
if( nNegros == -1 )
{
nNegros = contarNodosNegros( hoja );
}
else if( nNegros != contarNodosNegros( hoja ) )
throw new EstructuraException( "Las ramas deben tener el mismo número de nodos negros" );
}
}

/**
* Retorna el número de nodos negros que hay en el camino desde la raiz del árbol hasta el nodo ingresado por parametro.
* 
* @param hoja Nodo hasta el que se quiere llegar con el conteo.
* @return Número de nodos negros que hay en el camino desde la raiz del árbol hasta el nodo ingresado por parametro.
*/
private int contarNodosNegros( NodoRojoNegro<T> hoja )
{
if( hoja == null )
return 0;
return hoja.darColor( ) == NodoRojoNegro.NEGRO ? 1 + contarNodosNegros( hoja.darPadre( ) ) : contarNodosNegros( hoja.darPadre( ) );
}

/**
* Verifica el orden de los nodos.
* 
* @param nodo Nodo a partir del cual se quiere verificar esta propiedad.
* @return <code>true</code> si el orden es valido o <code>false</code> en caso contrario.
* @throws EstructuraException Si se encuentra algún nodo que no cumpla con el orden.
*/
private boolean verificarOrden( NodoRojoNegro<T> nodo ) throws EstructuraException
{
if( nodo == null || nodo.esHoja( ) )
return true;
else if( nodo.darHijoDerecho( ).darInfoNodo( ) != null )
{
if( nodo.darInfoNodo( ).compareTo( nodo.darHijoDerecho( ).darInfoNodo( ) ) > 0 )
throw new EstructuraException( "El orden de los nodos no es correcto" );
else if( !verificarOrden( nodo.darHijoDerecho( ) ) )
throw new EstructuraException( "El orden de los nodos no es correcto" );
}
else if( nodo.darHijoIzquierdo( ).darInfoNodo( ) != null )
{
if( nodo.darInfoNodo( ).compareTo( nodo.darHijoIzquierdo( ).darInfoNodo( ) ) < 0 )
throw new EstructuraException( "El orden de los nodos no es correcto" );
else if( !verificarOrden( nodo.darHijoIzquierdo( ) ) )
throw new EstructuraException( "El orden de los nodos no es correcto" );
}
return true;
}
}
