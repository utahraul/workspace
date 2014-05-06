package com.atrium.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Proceso para hacer visible el ApplicationContext de Spring en cualquiera
 * parte del programa.Ademas incluye metodos de conveniencia para la llamada a
 * los bean.<BR>
 * La obtencion del applicationcontext es atraves del comportamiento de la
 * intarface applicationcontextaware de spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 22-4-2013.
 * 
 */
public class Acceso_ApplicationContext implements ApplicationContextAware {

	private static ApplicationContext ctx;

	/**
	 * Recibimos de forma automatica (al crearse el applicationcontext) cuando
	 * se crea el bean.<br/>
	 * Al incorporar la interface ese comportamiento se realiza el paso 4/5 del
	 * ciclo de vida de los bean.
	 * 
	 */
	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		Acceso_ApplicationContext.ctx = ctx;
	}

	/**
	 * Nos permite acceder al ApplicationContext directamente en cualquier
	 * clase de aplicacion.
	 * 
	 * @return
	 */
	public static ApplicationContext getContextoSpring() {
		return ctx;
	}

	/**
	 * Proceso de conveniencia para la obtencion directa del bean.
	 * 
	 * @param objeto
	 *            Id o nombre del objeto que spring tiene que pasar.
	 * @return Objeto creado por spring.
	 */
	public static Object getBean(String objeto) {
		return ctx.getBean(objeto);
	}

	/**
	 * Proceso de conveniencia para la obtencion del bean. En este caso solo
	 * necesitamos dar el class del bean, sin necesidad de añadir el casteo de
	 * la clase.
	 * 
	 * @param spring_bean
	 *            Class del bean solicitado.
	 * @return Objeto pedido.
	 */
	public static <T> T getBean(Class<T> spring_bean) {
		return ctx.getBean(spring_bean);
	}

}

