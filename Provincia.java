public class Provincia {
    private String nombre;
    private String clima;
    private String capital;

    public Provincia(String nombre, String clima, String capital) {
        this.nombre = nombre;
        this.clima = clima;
        this.capital = capital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
