package testArbolRN;

/**
* Interface que debe implementar cualquier verificador de estructura.
* @param <T> Tipo de datos a guardar en la estructura que se quiere verificar.
*/
public interface IVerificadorEstructuraArbolOrdenado<T extends Comparable<? super T>>
{
/**
* Verifica que la estructura cumpla con su invariante.
* @throws EstructuraException Si se encuentra cualquier anomalía en la estructura.
*/
public void verificarEstructura( ) throws EstructuraException;
}
