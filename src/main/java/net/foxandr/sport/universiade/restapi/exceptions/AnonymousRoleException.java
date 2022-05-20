package net.foxandr.sport.universiade.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "You should enter right login and password")
public class AnonymousRoleException extends RuntimeException {
}
