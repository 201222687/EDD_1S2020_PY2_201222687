/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablahash;

/**
 *
 * @author MALDONADO
 */
public class NodoHash {
    public String codigoProducto;
    public String nombre;
    public String marca;
    public String precio;
    public String rutaImg;
    public int id;
    public ListaHash listaCodigoProductos;
    
      public NodoHash(String codigoProducto, String nombre, String marca, String precio, String rutaImg, int id) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.rutaImg = rutaImg;       
        this.id = id;
        this.listaCodigoProductos = new ListaHash();
    }
    
      
   

 
    
    /**
     * @return the codigoProducto
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the rutaImg
     */
    public String getRutaImg() {
        return rutaImg;
    }

    /**
     * @param rutaImg the rutaImg to set
     */
    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    } 
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the listaCodigoProductos
     */
    public ListaHash getListaCodigoProductos() {
        return listaCodigoProductos;
    }

    /**
     * @param listaCodigoProductos the listaCodigoProductos to set
     */
    public void setListaCodigoProductos(ListaHash listaCodigoProductos) {
        this.listaCodigoProductos = listaCodigoProductos;
    }

    
   
    

    
}
