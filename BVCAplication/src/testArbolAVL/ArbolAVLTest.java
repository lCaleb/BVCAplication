package testArbolAVL;

import AVL.ArbolAVL;
import AVL.IArbolOrdenado;

/**
* Esta es la clase usada para verificar los métodos de la clase árbol AVL
*/
public class ArbolAVLTest extends AbstractArbolOrdenadoTest
{

/*
* (non-Javadoc)
* @see uniandes.cupi2.collections.arbolOrdenado.AbstractArbolOrdenadoTest#instanciarArbol()
*/
@Override
public IArbolOrdenado<Integer> instanciarArbol( )
{
return new ArbolAVL<Integer>( );
}

/*
* (non-Javadoc)
* @see uniandes.cupi2.collections.arbolOrdenado.AbstractArbolOrdenadoTest#instanciarVerificador()
*/
@Override
public IVerificadorEstructuraArbolOrdenado<Integer> instanciarVerificador( )
{
return new VerificadorEstructuraArbolAVL<Integer>( ( ArbolAVL<Integer> )arbol );
}

}
