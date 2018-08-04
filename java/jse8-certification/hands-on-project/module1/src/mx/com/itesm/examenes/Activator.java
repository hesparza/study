package mx.com.itesm.examenes;
/**
 * ¿Cuál es el resultado del siguiente código? (Elige todas las que apliquen)
 * Respuesta:
 * El código no compilará debido a la línea 13: no se puede implementar un método de una interfaz utilizando una modificarod de acceso más restrictivo
 * El código no compilará debido a la línea 18: nos se puede instanciar una clase abstracta
 *
 * @author hesparza on 7/8/18
 */
interface Activator {int activate();}

abstract class ActivaPrograma implements Activator {
    protected int activate() { return 4; }
}

public class Validador extends ActivaPrograma {
    public static void main(String[] args) {
            ActivaPrograma actv = new ActivaPrograma();
            System.out.println(actv.activate());
        }

    public int activate(int value) { return 2;}
}
