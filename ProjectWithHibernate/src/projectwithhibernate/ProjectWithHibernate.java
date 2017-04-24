/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectwithhibernate;

import Controlador.Operaciones;
import Modelo.InfPersonal;

/**
 *
 * @author fidel.villero
 */
public class ProjectWithHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Operaciones op = new Operaciones();
//        op.guardarData(createObjectInfPersonal());
//        System.out.println("GUARDADO!!!");
        
//        InfPersonal p = op.getData("prueba@prueba.com");
//        op.updateData(p);
//        System.out.println("ACTUALIZADO!!!");
        
        op.deleteData("");
        System.out.println("BORRADO!!!");
    }
    
    private static InfPersonal createObjectInfPersonal(){
        int pais = 1;
        int depto = 1;
        int ciudad = 1;
        InfPersonal p = new InfPersonal();
        p.setAdjuntaArchivo(null);
        p.setApellidos("");
        p.setAsunto("");
        p.setCategoria("");
        p.setCiudad(ciudad);
        p.setComentarios("");
        p.setCorreo("prueba@prueba.com");
        p.setDepto(depto);
        p.setDireccion("");
        p.setDocumento("");
        p.setIdInfPersonal(null);
        p.setNombres("");
        p.setNumCelular("");
        p.setPais(pais);
        p.setTDocumento("");
        p.setTelefono("");
        return p;
    }
}
