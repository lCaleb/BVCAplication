package testArbolRN;

/**
* Excepci�n arrojada al encontrar cualquier anomal�a en una estructura.
*/
public class EstructuraException extends Exception
{
// -----------------------------------------------------------------
// Constantes
// ----------------------------------------------------------------- 

/**
* Constante para serializaci�n
*/
private static final long serialVersionUID = 1L;

// -----------------------------------------------------------------
// Constructores
// -----------------------------------------------------------------

/**
* Constructor de la clase.
*/
public EstructuraException( String msg )
{
super( msg );
}

}
