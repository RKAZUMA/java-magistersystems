
package clase4.listas;

/**
 * Clase Vector3D para Magister Systems
 * @author Julian
 */
public class Vector{
    /**
     * Componente x de un Vector 3D
     */
    public float x;
    /**
     * Componente x de un Vector 3D
     */
    public float y;
    /**
     * Componente x de un Vector 3D
     */
    public float z;
    
    /**
     * Constructor por defecto, componentes en 0
     */
    public Vector(){
        x = y = z = 0;
    }
    /**
     * Constructor sobrecargado, con inicialización de componentes (x,y,z)
     * @param x
     * @param y
     * @param z 
     */
    public Vector(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Retorna el vector de forma "(x,y,z)"
     * @return 
     */
    @Override
    public String toString(){
        return ("("+x+","+y+","+z+")");
    }
    /**
     * Método propio que invierte la instancia del vector
     */
    public void invertir(){
        x = -x;
        y = -y;
        z = -z;
    }
    /**
     * Método propio que multiplica la instancia del vector
     * por una constante
     * @param c 
     */
    public void multiplicarPorConstante(float c){
        x *= c;
        y *= c;
        z *= c;
    }
    /**
     * Método propio que suma la instancia del vector más
     * otro vector
     * @param v 
     */
    public void suma(Vector v){
        x += v.x;
        y += v.y;
        z += v.z;
    }
    /**
     * Método propio que resta la instancia del vector menos
     * otro vector
     * @param v 
     */
    public void resta(Vector v){
        v.invertir();
        suma(v);
    }
    
    /**
     * Método estático que retorna el vector recibido invertido
     * @return 
     */
    public static Vector invertir(Vector v){
        return new Vector(-v.x, -v.y, -v.z);
    }
    /**
     * Método estático que retorna el vector recibido multiplicado
     * por la constante recibida
     * @param v
     * @param c
     * @return 
     */
    public static Vector multiplicarPorConstante(Vector v, float c){
        return new Vector(c*v.x, c*v.y, c*v.z);
    }
    /**
     * Método estático que retorna el vector resultado de la suma
     * de los vectores recibidos
     * @param v1
     * @param v2
     * @return 
     */
    public static Vector suma(Vector v1, Vector v2){
        return new Vector(v1.x + v2.x,
                v1.y + v2.y,
                v1.z + v2.z);
    }
    /**
     * Método estático que retorna la constante resultado del
     * producto punto entre dos vectores
     * @param v1
     * @param v2
     * @return 
     */
    public static float productoPunto(Vector v1, Vector v2){
        return (v1.x*v2.x)+(v1.y*v2.y)+(v1.z*v2.z);
    }
}
