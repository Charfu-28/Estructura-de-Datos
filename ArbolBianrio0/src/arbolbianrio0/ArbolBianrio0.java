package arbolbianrio0;

public class ArbolBianrio0 {

    public static void main(String[] args) {
        NodoArbol raiz = new NodoArbol(7);
        NodoArbol nodo2 = new NodoArbol(12);
        NodoArbol nodo3 = new NodoArbol(15);
        raiz.ramaIzdo(nodo2);
        raiz.ramaDcho(nodo3);
        NodoArbol nodo4 = new NodoArbol(19);
        NodoArbol nodo5 = new NodoArbol(22);
        nodo2.ramaIzdo(nodo4);
        nodo2.ramaDcho(nodo5);
        nodo4.ramaIzdo(new NodoArbol(26));
        nodo4.ramaDcho(new NodoArbol(33));
        nodo5.ramaIzdo(new NodoArbol(29));
        nodo5.ramaDcho(new NodoArbol(41));
        NodoArbol nodo6 = new NodoArbol(17);
        NodoArbol nodo7 = new NodoArbol(16);
        nodo3.ramaIzdo(nodo6);
        nodo3.ramaDcho(nodo7);
        nodo6.ramaIzdo(new NodoArbol(18));
        nodo6.ramaDcho(new NodoArbol(31));
        nodo7.ramaIzdo(new NodoArbol(50));
        //raiz.visitar(); 
        raiz.Mostrar(raiz);
    }
}
