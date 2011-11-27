package br.usp.each.lojavirtual.fabricas;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class FabricaDeCriacaoDeSessionFactory implements ComponentFactory<SessionFactory> {

	private SessionFactory sessionFactory;
	
	@PostConstruct
	public void buildSessionFactory() {
		this.sessionFactory = new FabricaDeSessionFactory().build();  
	}

	public SessionFactory getInstance() {
	  return sessionFactory;
	}	
	
	@PreDestroy
	public void closeSessionFactory() {
		this.sessionFactory.close();
	}



}
