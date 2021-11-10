
package proyconect.controlador;

import proyconect.vista.FrmPrincipal;

/**
 *
 * @author Luis Miguel Alamo Hernández
 */
public class ControladorPrincipal {

    FrmPrincipal frm;
    ControllerEvePrincipal ctrlPri;
    
    public ControladorPrincipal() {
        frm = new FrmPrincipal();
        ctrlPri = new ControllerEvePrincipal(frm);
        frm.setVisible(true);
    }        
}
