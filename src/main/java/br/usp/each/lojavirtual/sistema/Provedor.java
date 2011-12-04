package br.usp.each.lojavirtual.sistema;

import br.com.caelum.vraptor.ComponentRegistry;
import br.com.caelum.vraptor.ioc.spring.SpringProvider;
import br.com.caelum.vraptor.util.hibernate.HibernateTransactionInterceptor;

public class Provedor extends SpringProvider {

    @Override
    public void registerCustomComponents(final ComponentRegistry registry) {
	registry.register(HibernateTransactionInterceptor.class,
		HibernateTransactionInterceptor.class);
    }

}
