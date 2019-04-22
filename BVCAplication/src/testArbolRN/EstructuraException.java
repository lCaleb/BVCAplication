package testArbolRN;

/**
* Excepción arrojada al encontrar cualquier anomalía en una estructura.
*/
public class EstructuraException extends Exception
{
// -----------------------------------------------------------------
// Constantes
// ----------------------------------------------------------------- 

/**
* Constante para serialización
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
