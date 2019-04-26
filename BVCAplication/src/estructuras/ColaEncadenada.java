package estructuras;

import java.io.Serializable;

/**
 * Implementación de una cola encadenada
 * @param  Tipo de datos que contiene cada nodo de la cola
 */
public class ColaEncadenada<T> implements Serializable
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
 
    /**
   * Constante para la serialización
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
     * Número de elementos de la cola
     */
    protected int numElems;
 
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
 
    /**
     * Constructor de la cola encadenada vacía. 
 
     * post:  Se construyó una cola vacía. primero==null, ultimo==null, numElems = 0
 
     */
    public ColaEncadenada( )
    {
        primero = null;
        ultimo = null;
        numElems = 0;
    }
 
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Retorna la longitud de la cola (número de elementos). 
 
     * post:  Se retornó la longitud de la cola
.
     * @return El número de elementos de la cola. Entero positivo o cero.
 
     */
    public int darLongitud( )
    {
        return numElems;
    }
 
    /**
     * Retorna el primer elemento y lo elimina de la cola. 
 
     * post:  Se retornó y eliminó el primer elemento de la cola. Si es el único elemento, el primero y el ultimo son null. La cantidad de los elementos se reduce en 1
 
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
 
     * post:  Se agregó el elemento especificado al final de la cola. Si la cola es vacía, el primer y el ultimo elemento son iguales
 
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
 
     * post:  Se retornó el primer nodo de la cola.
     * @return El primer nodo de la cola
     */
    public NodoCola darPrimero( )
    {
        return primero;
    }
 
    /**
     * Retorna el último nodo de la cola. Sin eliminarlo
 
     * post:  Se retornó el último nodo de la cola.
 
     * @return El último nodo de la cola
 
     */
    public NodoCola darUltimo( )
    {
        return ultimo;
    }
 
    /**
     * Indica si la cola se encuentra vacía (no tiene elementos). 
 
     * post:  Se retornó true si primero==null o false en caso contrario.
 
     * @return True si primero==null o false en caso contrario
 
     */
    public boolean estaVacia( )
    {
        return primero == null;
    }
 
    /**
     * Convierte la cola a un String. 
 
     * post:  Se retornó la representación en String de la cola. El String tiene el formato "[numeroElementos]: e1->e2->e3..->en", donde e1, e2, ..., en son los los
     * elementos de la cola y numeroElementos su tamaño. 
 
     * @return La representación en String de la cola
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
