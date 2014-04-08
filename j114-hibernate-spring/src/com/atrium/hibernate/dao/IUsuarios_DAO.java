package com.atrium.hibernate.dao;

import java.util.List;

import com.atrium.hibernate.Usuarios;

public interface IUsuarios_DAO {

	public void save(Usuarios transientInstance);

	public void delete(Usuarios persistentInstance);

	public Usuarios findById(java.lang.String id);

	public List findByExample(Usuarios instance);

	public List findByProperty(String propertyName, Object value);

	public List findByPassword(Object password);

	public List findByCarpetaDocumentacion(Object carpetaDocumentacion);

	public List findByIdioma(Object idioma);

	public List findAll();

	public Usuarios merge(Usuarios detachedInstance);

	public void attachDirty(Usuarios instance);

	public void attachClean(Usuarios instance);
	
	public Usuarios consultar_UsuarioConRol(String nombre_usuario);

}