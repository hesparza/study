package mx.com.itesm.aplicacionejemplo.dominio;

public class Cliente {

    private Integer id;
    private String apellido;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String estado;
    private String pais;
    private String telefono;
    private String correo;
    private Cuenta cuenta;
    private static int contador;

    public Cliente(String apellido, String nombre, String direccion, String ciudad, String estado, String pais, String telefono, String correo, Cuenta cuenta) {
        this.id = ++contador;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
        this.telefono = telefono;
        this.correo = correo;
        this.cuenta = cuenta;
    }

    public Integer getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
