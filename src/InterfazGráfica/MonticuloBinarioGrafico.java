
package InterfazGráfica;

import java.awt.Graphics;
import javax.swing.JPanel;
import Nodos.MBNodo;

public class MonticuloBinarioGrafico extends JPanel {

    private MBNodo raiz;
    private int diametroNodo = 30;
    private int espacioHorizontal = 100;
    private int espacioVertical = 90;

    public void insertar(Object element, int prioridad) {
        raiz = insertarNodo(raiz, element, prioridad);
    }

    private MBNodo insertarNodo(MBNodo nodo, Object element, int prioridad) {
        if (nodo == null) {
            return new MBNodo(element, prioridad);
        }

        if (prioridad < nodo.getPrioridad()) {
            nodo.setLeftSon(insertarNodo(nodo.getLeftSon(), element, prioridad));
        } else if (prioridad > nodo.getPrioridad()) {
            nodo.setRightSon(insertarNodo(nodo.getRightSon(), element, prioridad));
        }

        return nodo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarNodo(g, raiz, getWidth() / 2, espacioHorizontal, 0);
    }

    private void dibujarNodo(Graphics g, MBNodo nodo, int x, int espacio, int nivel) {
        if (nodo == null) {
            return;
        }

        int y = nivel * espacioVertical + espacio;
        g.drawOval(x - diametroNodo / 2, y - diametroNodo / 2, diametroNodo, diametroNodo);
        g.drawString(nodo.getElement().toString(), x - 6, y + 4);

        if (nodo.getLeftSon() != null) {
            int xIzquierdo = x - espacio / 2;
            int yIzquierdo = y + espacioVertical / 2 - diametroNodo / 2;
            g.drawLine(x, y + diametroNodo / 2, xIzquierdo, yIzquierdo + diametroNodo / 2);
            dibujarNodo(g, nodo.getLeftSon(), xIzquierdo, espacio / 2, nivel + 1);
        }

        if (nodo.getRightSon() != null) {
            int xDerecho = x + espacio / 2;
            int yDerecho = y + espacioVertical / 2 - diametroNodo / 2;
            g.drawLine(x, y + diametroNodo / 2, xDerecho, yDerecho + diametroNodo / 2);
            dibujarNodo(g, nodo.getRightSon(), xDerecho, espacio / 2, nivel + 1);
        }
    }


}