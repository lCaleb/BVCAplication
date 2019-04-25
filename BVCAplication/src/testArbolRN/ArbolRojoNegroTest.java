package testArbolRN;



import ARN.ArbolRojoNegro;
import ARN.IArbolOrdenado;

public class ArbolRojoNegroTest extends AbstractArbolOrdenadoTest
{

/*
* (non-Javadoc)
* @see uniandes.cupi2.collections.arbolOrdenado.AbstractArbolOrdenadoTest#instanciarArbol()
*/
@Override
public IArbolOrdenado<Integer> instanciarArbol( )
{
return new ArbolRojoNegro<Integer>( );
}

/*
* (non-Javadoc)
* @see uniandes.cupi2.collections.arbolOrdenado.AbstractArbolOrdenadoTest#instanciarVerificador()
*/
@Override
public IVerificadorEstructuraArbolOrdenado<Integer> instanciarVerificador( )
{
return new VerificadorEstructuraRojoNegro<Integer>( (ARN.ArbolRojoNegro<Integer> )arbol );
}

}





