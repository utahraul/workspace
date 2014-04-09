package com.atrium.controlador;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.spring.Acceso_ApplicationContext;

public class Inicio {

	public static void main(String[] args) {
		// cargar el nuevo look and feel si se puede
		// RECOGEMOS TODOS LOS LOOK DISPONIBLES EN LA VERSION DE JDK
		LookAndFeelInfo tabla_laf[] = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo objeto_aparicencia : tabla_laf) {
			// COMPROBAMOS SI EXISTE NIMBUS
			if (objeto_aparicencia.getName().equals("Nimbus")) {
				try {
					// CARGAMOS NIMBUS CUANDO EXISTA SEGUN LA VERSION DE JDK
					// USADA
					UIManager.setLookAndFeel(objeto_aparicencia.getClassName());
					System.out.println("Cargando nimbus......");
				} catch (Exception ex) {
					System.out.println("error en la carga de nimbus");
				}
			}
		}
		ApplicationContext contexto = new ClassPathXmlApplicationContext(
				"com/atrium/spring/applicationContext.xml");
		
		IVentana ventana = Acceso_ApplicationContext.getBean(IVentana.class);
	}
}
