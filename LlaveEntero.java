/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_B;

/**
 *
 * @author MALDONADO
 */
public class LlaveEntero extends Ordenable {
    private long mLlave ;
    private String fecha;
    private int total;
    private String usuario;
    
    private String titulo;
    private String editorial;
    private String edicion;
    private String categoría;
    private String idioma;
           
    
    
    private String referencia;
      
    
    public LlaveEntero(String referencia,long numeroFactura, String fecha, int total, String usuario, String titulo, String editorial, String edicion,String categoria,String idioma) {
        this.mLlave = numeroFactura;
        this.fecha = fecha;
        this.total = total;
        this.usuario = usuario;
        
        this.titulo=titulo;
        this.editorial=editorial;
        this.edicion=edicion;
        this.categoría=categoria;
        this.idioma= idioma;
        
    }
    
    
    
    

    public LlaveEntero(long pValor) {
        mLlave = pValor;
    }

    public Object getKey() {
        return getmLlave();
    }
    
    public boolean igualA(Ordenable pObjeto) {
        return getmLlave().equals(pObjeto.getKey());
    }

    public boolean menorQue(Ordenable pObjeto) {
        return getmLlave().compareTo((long)pObjeto.getKey()) < 0;
    }
    
    public boolean mayorQue(Ordenable pObjeto) {
        return getmLlave().compareTo((long)pObjeto.getKey()) > 0;
    }
    
    public boolean menorOIgualQue(Ordenable pObjeto) {
        return getmLlave().compareTo((long)pObjeto.getKey()) <= 0;
    }
  
    public boolean mayorOIgualQue(Ordenable pObjeto) {
        return getmLlave().compareTo((long)pObjeto.getKey()) >= 0;
    }
    
    public Ordenable minKey() {
        return new LlaveEntero(Integer.min(0, 0));
    }
    
    public Long getmLlave() {
        return mLlave;
    }

    public void setmLlave(Integer mLlave) {
        this.mLlave = mLlave;
    }

    @Override
    public String getFecha() {
        return fecha;
    }

    @Override
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

   
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }   
    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }
    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the Editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param Editorial the Editorial to set
     */
    public void setEditorial(String Editorial) {
        this.editorial = Editorial;
    }

   
    /**
     * @return the Edicion
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * @param Edicion the Edicion to set
     */
    public void setEdicion(String Edicion) {
        this.edicion = Edicion;
    }

    /**
     * @return the Categoría
     */
    public String getCategoría() {
        return categoría;
    }
 
    /**
     * @param Categoría the Categoría to set
     */
    public void setCategoría(String Categoría) {
        this.categoría = Categoría;
    }

    /**
     * @return the Idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param Idioma the Idioma to set
     */
    public void setIdioma(String Idioma) {
        this.idioma = Idioma;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }
}
