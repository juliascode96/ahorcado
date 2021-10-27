package ahorcado;

public class Ahorcado {
    String[] palabra;
    int cantidadLetras;
    int intentos;

    public Ahorcado() {
    }

    public Ahorcado(String[] palabra, int cantidadLetras, int intentos) {
        this.palabra = palabra;
        this.cantidadLetras = cantidadLetras;
        this.intentos = intentos;
    }

    
    
    public String[] getPalabra() {
        return palabra;
    }

    public void setPalabra(String[] palabra) {
        this.palabra = palabra;
    }

    public int getCantidadLetras() {
        return cantidadLetras;
    }

    public void setCantidadLetras(int cantidadLetras) {
        this.cantidadLetras = cantidadLetras;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
    
}

