/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author jimmy
 */
public class Usuario {
    private String CodigoUsuario;
    private String NombreUsuario;
    private String ApellidosUsuario;
    private String EmailUsuario;
    private String DireccionUsuario;
    private String TelefonoUsuario;
    private String UserNameUsuario;
    private String ClaveUsuario;
    private String TipoUsuario;
    private String EstadoUsuario;

    public Usuario() {
    }
    
    public Usuario(String CodigoUsuario, String NombreUsuario, String ApellidosUsuario, String EmailUsuario, String DireccionUsuario, String TelefonoUsuario, String UserNameUsuario, String ClaveUsuario, String TipoUsuario, String EstadoUsuario) {
        this.CodigoUsuario = CodigoUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ApellidosUsuario = ApellidosUsuario;
        this.EmailUsuario = EmailUsuario;
        this.DireccionUsuario = DireccionUsuario;
        this.TelefonoUsuario = TelefonoUsuario;
        this.UserNameUsuario = UserNameUsuario;
        this.ClaveUsuario = ClaveUsuario;
        this.TipoUsuario = TipoUsuario;
        this.EstadoUsuario = EstadoUsuario;
    }
    
    /**
     * @return the CodigoUsuario
     */
    public String getCodigoUsuario() {
        return CodigoUsuario;
    }

    /**
     * @param CodigoUsuario the CodigoUsuario to set
     */
    public void setCodigoUsuario(String CodigoUsuario) {
        this.CodigoUsuario = CodigoUsuario;
    }

    /**
     * @return the NombreUsuario
     */
    public String getNombreUsuario() {
        return NombreUsuario;
    }

    /**
     * @param NombreUsuario the NombreUsuario to set
     */
    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    /**
     * @return the ApellidosUsuario
     */
    public String getApellidosUsuario() {
        return ApellidosUsuario;
    }

    /**
     * @param ApellidosUsuario the ApellidosUsuario to set
     */
    public void setApellidosUsuario(String ApellidosUsuario) {
        this.ApellidosUsuario = ApellidosUsuario;
    }

    /**
     * @return the EmailUsuario
     */
    public String getEmailUsuario() {
        return EmailUsuario;
    }

    /**
     * @param EmailUsuario the EmailUsuario to set
     */
    public void setEmailUsuario(String EmailUsuario) {
        this.EmailUsuario = EmailUsuario;
    }

    /**
     * @return the DireccionUsuario
     */
    public String getDireccionUsuario() {
        return DireccionUsuario;
    }

    /**
     * @param DireccionUsuario the DireccionUsuario to set
     */
    public void setDireccionUsuario(String DireccionUsuario) {
        this.DireccionUsuario = DireccionUsuario;
    }

    /**
     * @return the TelefonoUsuario
     */
    public String getTelefonoUsuario() {
        return TelefonoUsuario;
    }

    /**
     * @param TelefonoUsuario the TelefonoUsuario to set
     */
    public void setTelefonoUsuario(String TelefonoUsuario) {
        this.TelefonoUsuario = TelefonoUsuario;
    }

    /**
     * @return the UserNameUsuario
     */
    public String getUserNameUsuario() {
        return UserNameUsuario;
    }

    /**
     * @param UserNameUsuario the UserNameUsuario to set
     */
    public void setUserNameUsuario(String UserNameUsuario) {
        this.UserNameUsuario = UserNameUsuario;
    }

    /**
     * @return the ClaveUsuario
     */
    public String getClaveUsuario() {
        return ClaveUsuario;
    }

    /**
     * @param ClaveUsuario the ClaveUsuario to set
     */
    public void setClaveUsuario(String ClaveUsuario) {
        this.ClaveUsuario = ClaveUsuario;
    }

    /**
     * @return the TipoUsuario
     */
    public String getTipoUsuario() {
        return TipoUsuario;
    }

    /**
     * @param TipoUsuario the TipoUsuario to set
     */
    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    /**
     * @return the EstadoUsuario
     */
    public String getEstadoUsuario() {
        return EstadoUsuario;
    }

    /**
     * @param EstadoUsuario the EstadoUsuario to set
     */
    public void setEstadoUsuario(String EstadoUsuario) {
        this.EstadoUsuario = EstadoUsuario;
    }
    
    
    
}
