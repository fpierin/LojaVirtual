package br.usp.each.lojavirtual.sistema;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.RequestInfo;
import br.com.caelum.vraptor.http.route.ResourceNotFoundException;
import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.DefaultResourceNotFoundHandler;
import br.com.caelum.vraptor.resource.HttpMethod;
import br.com.caelum.vraptor.view.Results;
  
@Component  
@RequestScoped  
public class Error404 extends DefaultResourceNotFoundHandler  {  
    private final Router router;  
    private final Result result;  
    public Error404(final Router router, final Result result) {  
        this.router = router;  
        this.result = result;  
    }  
      
    @Override  
    public void couldntFind(final RequestInfo requestInfo) {  
        try {  
            final String uri = requestInfo.getRequestedUri();  
            if (uri.endsWith("/")) {  
                tryMovePermanentlyTo(requestInfo, uri.substring(0, uri.length()-1));  
            } else {  
                tryMovePermanentlyTo(requestInfo, uri + "/");  
            }  
        } catch (final ResourceNotFoundException ex) {  
            super.couldntFind(requestInfo);  
        }  
    }  
  
    @SuppressWarnings("deprecation")
	private void tryMovePermanentlyTo(final RequestInfo requestInfo, final String newUri) {  
        router.parse(newUri, HttpMethod.of(requestInfo.getRequest()), 
            requestInfo.getRequest());  
        result.use(Results.http()).movedPermanentlyTo(newUri);  
    }  
}