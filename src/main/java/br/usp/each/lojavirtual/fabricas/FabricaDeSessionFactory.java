package br.usp.each.lojavirtual.fabricas;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class FabricaDeSessionFactory {
	
	public SessionFactory build(){
		final AnnotationConfiguration configuration = new AnnotationConfiguration().configure();
		return configuration.buildSessionFactory();		
	}

}