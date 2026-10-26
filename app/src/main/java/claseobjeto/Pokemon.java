package claseobjeto;

public class Pokemon {
    private static int nextid = 0;

    private int id;
    private String nombre;
    private int hp;
    private int defensa;
    private int velocidad;

    private TipoPokemon tipo;

    public Pokemon(String nombre, int hp, int defensa, int velocidad, TipoPokemon tipo) {
        this.id = nextid;
        this.nombre = nombre;
        this.hp = hp;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipo = tipo;
        nextid++;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }
}
