package org.deiv.binarysort.service;

import io.swagger.annotations.*;
import org.deiv.binarysort.bussines.RestBusinnes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.deiv.binarysort.error.bussines.LogicException;
import org.deiv.binarysort.error.client.MalformedInputException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/binarysort")
@Api(value="binarysort", description="Ordena una lista de enteros en base a su representacion binaria (mayor número de '1', mas valor)")
public class BinarySortService {

    @RequestMapping(
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json")
    @ApiOperation(value = "Ordena un array de entrada", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Entrada no valida"),
        }
    )
    public ResponseEntity<?> doPost(@RequestBody() String body)
            throws MalformedInputException, LogicException
    {
        String input = parseRequestBody(body);

        if (input.trim().isEmpty()) {
            return ResponseEntity.ok(buildResponse(null));
        }

        return ResponseEntity.ok(
            buildResponse(
                RestBusinnes.doBinarySort(input)));
    }

    protected String parseRequestBody(String body)
            throws MalformedInputException
    {
        Pattern arrayPattern = Pattern.compile("\\{ *\\\"integer_list\\\": *\\[([0-9, ]*)\\] *\\}");
        Matcher matcher = arrayPattern.matcher(body);

        if (matcher.matches()) {
            return matcher.group(1);
        }

        throw new MalformedInputException();
    }

    protected String buildResponse(Integer[] result)
    {
        return String.format(
            "{ \"result\": %s }",
            result == null ? "[ ]" : Arrays.toString(result));
    }
}
