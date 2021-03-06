package org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm;

import java.util.List;

import javax.ejb.Local;

import org.dieschnittstelle.jee.esa.entities.crm.AbstractTouchpoint;

@Local
public interface TouchpointAccessLocal {

	public AbstractTouchpoint createTouchpointAndPointOfSale(AbstractTouchpoint touchpoint) throws ShoppingException;

	public List<AbstractTouchpoint> readAllTouchpoints();
	
}
