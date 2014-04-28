package com.atrium.hibernate.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.atrium.hibernate.Proveedores;

/**
 	* A data access object (DAO) providing persistence and search support for Proveedores entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.atrium.hibernate.Proveedores
  * @author MyEclipse Persistence Tools 
 */
public class ProveedoresDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(ProveedoresDAO.class);
		//property constants
	public static final String NOMBRE_PROVEEDOR = "nombreProveedor";
	public static final String CIF_PROVEEDOR = "cifProveedor";
	public static final String NOMBRE_COMERCIAL_PROVEEDOR = "nombreComercialProveedor";
	public static final String CALLE_PROVEEDOR = "calleProveedor";
	public static final String CIUDAD_PROVEEDOR = "ciudadProveedor";
	public static final String CP_PROVEEDOR = "cpProveedor";
	public static final String PROVINCIA_PROVEEDOR = "provinciaProveedor";
	public static final String TELEFONO_PROVEEDOR = "telefonoProveedor";
	public static final String FAX_PROVEEDOR = "faxProveedor";
	public static final String EMAIL_PROVEEDOR = "emailProveedor";
	public static final String OBSERVACIONES_PROVEEDOR = "observacionesProveedor";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Proveedores transientInstance) {
        log.debug("saving Proveedores instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Proveedores persistentInstance) {
        log.debug("deleting Proveedores instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Proveedores findById( java.lang.Long id) {
        log.debug("getting Proveedores instance with id: " + id);
        try {
            Proveedores instance = (Proveedores) getHibernateTemplate()
                    .get("com.atrium.hibernate.Proveedores", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Proveedores instance) {
        log.debug("finding Proveedores instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Proveedores instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Proveedores as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNombreProveedor(Object nombreProveedor
	) {
		return findByProperty(NOMBRE_PROVEEDOR, nombreProveedor
		);
	}
	
	public List findByCifProveedor(Object cifProveedor
	) {
		return findByProperty(CIF_PROVEEDOR, cifProveedor
		);
	}
	
	public List findByNombreComercialProveedor(Object nombreComercialProveedor
	) {
		return findByProperty(NOMBRE_COMERCIAL_PROVEEDOR, nombreComercialProveedor
		);
	}
	
	public List findByCalleProveedor(Object calleProveedor
	) {
		return findByProperty(CALLE_PROVEEDOR, calleProveedor
		);
	}
	
	public List findByCiudadProveedor(Object ciudadProveedor
	) {
		return findByProperty(CIUDAD_PROVEEDOR, ciudadProveedor
		);
	}
	
	public List findByCpProveedor(Object cpProveedor
	) {
		return findByProperty(CP_PROVEEDOR, cpProveedor
		);
	}
	
	public List findByProvinciaProveedor(Object provinciaProveedor
	) {
		return findByProperty(PROVINCIA_PROVEEDOR, provinciaProveedor
		);
	}
	
	public List findByTelefonoProveedor(Object telefonoProveedor
	) {
		return findByProperty(TELEFONO_PROVEEDOR, telefonoProveedor
		);
	}
	
	public List findByFaxProveedor(Object faxProveedor
	) {
		return findByProperty(FAX_PROVEEDOR, faxProveedor
		);
	}
	
	public List findByEmailProveedor(Object emailProveedor
	) {
		return findByProperty(EMAIL_PROVEEDOR, emailProveedor
		);
	}
	
	public List findByObservacionesProveedor(Object observacionesProveedor
	) {
		return findByProperty(OBSERVACIONES_PROVEEDOR, observacionesProveedor
		);
	}
	

	public List findAll() {
		log.debug("finding all Proveedores instances");
		try {
			String queryString = "from Proveedores";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Proveedores merge(Proveedores detachedInstance) {
        log.debug("merging Proveedores instance");
        try {
            Proveedores result = (Proveedores) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Proveedores instance) {
        log.debug("attaching dirty Proveedores instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Proveedores instance) {
        log.debug("attaching clean Proveedores instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ProveedoresDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ProveedoresDAO) ctx.getBean("ProveedoresDAO");
	}
}