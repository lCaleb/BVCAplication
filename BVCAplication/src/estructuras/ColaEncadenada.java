package estructuras;

import java.io.Serializable;

/**
 * Implementaci�n de una cola encadenada
 * @param  Tipo de datos que contiene cada nodo de la cola
 */
public class ColaEncadenada<T> implements Serializable
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
 
    /**
   * Constante para la serializaci�n
   */
  private static final long serialVersionUID = 1L;
 
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Primer elemento de la cola encadenada
     */
    protected NodoCola primero;
 
    /**
     * Ultimo elemento de la cola encadenada
     */
    protected NodoCola ultimo;
 
    /**
     * N�mero de elementos de la cola
     */
    protected int numElems;
 
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
 
    /**
     * Constructor de la cola encadenada vac�a. 
 
     * post:  Se construy� una cola vac�a. primero==null, ultimo==null, numElems = 0
 
     */
    public ColaEncadenada( )
    {
        primero = null;
        ultimo = null;
        numElems = 0;
    }
 
    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    /**
     * Retorna la longitud de la cola (n�mero de elementos). 
 
     * post:  Se retorn� la longitud de la cola
.
     * @return El n�mero de elementos de la cola. Entero positivo o cero.
 
     */
    public int darLongitud( )
    {
        return numElems;
    }
 
    /**
     * Retorna el primer elemento y lo elimina de la cola. 
 
     * post:  Se retorn� y elimin� el primer elemento de la cola. Si es el �nico elemento, el primero y el ultimo son null. La cantidad de los elementos se reduce en 1
 
     * @return El primer elemento de la cola. Diferente de null
 
     * @throws ColaVaciaException Si la cola no tiene elementos
 
     */
    public T tomarElemento( ) throws ColaVaciaException
    {
        if( primero == null )
            throw new ColaVaciaException( "No hay elementos en la cola" );
        else
        {
            NodoCola p = primero;
            primero = primero.desconectarPrimero( );
            if( primero == null )
                ultimo = null;
            numElems--;
            return (T) p.darElemento( );
        }
    }
 
    /**
     * Inserta un elemento al final de la cola. 
 
     * post:  Se agreg� el elemento especificado al final de la cola. Si la cola es vac�a, el primer y el ultimo elemento son iguales
 
     * @param elemento El elemento a ser insertado. Diferente de null.
 
     */
    public void insertar( T elemento )
    {
        NodoCola nodo = new NodoCola( elemento );
        if( primero == null )
        {
            primero = nodo;
            ultimo = nodo;
        }
        else
        {
            ultimo = ultimo.insertarDespues( nodo );
        }
        numElems++;
    }
 
    /**
     * Retorna el primer nodo de la cola. Sin eliminarlo
 
     * post:  Se retorn� el primer nodo de la cola.
     * @return El primer nodo de la cola
     */
    public NodoCola darPrimero( )
    {
        return primero;
    }
 
    /**
     * Retorna el �ltimo nodo de la cola. Sin eliminarlo
 
     * post:  Se retorn� el �ltimo nodo de la cola.
 
     * @return El �ltimo nodo de la cola
 
     */
    public NodoCola darUltimo( )
    {
        return ultimo;
    }
 
    /**
     * Indica si la cola se encuentra vac�a (no tiene elementos). 
 
     * post:  Se retorn� true si primero==null o false en caso contrario.
 
     * @return True si primero==null o false en caso contrario
 
     */
    public boolean estaVacia( )
    {
        return primero == null;
    }
 
    /**
     * Convierte la cola a un String. 
 
     * post:  Se retorn� la representaci�n en String de la cola. El String tiene el formato "[numeroElementos]: e1->e2->e3..->en", donde e1, e2, ..., en son los los
     * elementos de la cola y numeroElementos su tama�o. 
 
     * @return La representaci�n en String de la cola
     */
    @Override
    public String toString( )
    {
        String resp = "[" + numElems + "]:";
        for( NodoCola p = primero; p != null; p = p.darSiguiente( ) )
        {
            resp += p.darElemento( ).toString( ) + "->";
        }
        return resp;
    }
}
