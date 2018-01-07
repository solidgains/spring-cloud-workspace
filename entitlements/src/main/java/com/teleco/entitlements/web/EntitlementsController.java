package com.teleco.entitlements.web;

import com.teleco.entitlements.model.Entitlement;
import com.teleco.entitlements.service.EntitlementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntitlementsController {

    @Autowired
    private EntitlementsService entitlementsService;

    /*
    Note: zuul will return the exception thrown here, and will only return the fallback once the circuit is open
     */
    @RequestMapping(value = "/entitlements", method = RequestMethod.GET)
    public List<Entitlement> entitlements(@RequestParam(required = false) String accountId/*, @RequestParam(required = false) String serverError*/) {

/*        if (accountId == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        else if (serverError.equals("true"))
            throw new HttpServerErrorException(HttpStatus.SERVICE_UNAVAILABLE);*/

        return entitlementsService.retrieveEntitlements(accountId);
    }

/*    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ClientSideException extends RuntimeException {
        public ClientSideException() {
            super("client passed in an invalid account id");
        }
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public class ServerSideException extends RuntimeException {
        public ServerSideException() {
            super("internal server error");
        }
    }*/
}
