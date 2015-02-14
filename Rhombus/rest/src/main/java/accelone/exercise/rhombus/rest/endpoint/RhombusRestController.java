package accelone.exercise.rhombus.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import accelone.exercise.rhombus.Rhombus;
import accelone.exercise.rhombus.printer.Printer;
import accelone.exercise.rhombus.printer.outputs.Output;
import accelone.exercise.rhombus.printer.outputs.StringOutput;

/**
 * Simple rest class that will return a string rhombus shaped.
 * 
 * @author Gustavo Orsi
 *
 */
@RestController
@RequestMapping("/rhombus")
public class RhombusRestController {

	@Autowired
//	@Qualifier(value = "basicPrinter")
	@Qualifier(value = "betterPrinter")
	private Printer rhombusPrinter;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.TEXT_PLAIN_VALUE })
	public HttpEntity<String> getRhombus(@RequestParam(defaultValue = "64") Integer rhombusHeart) {

		String response;

		// doesn't make sense to autowire this bean because we need to construct it based on the rhombusHeart value.
		try {
			Rhombus rhombus = new Rhombus(rhombusHeart);

			// create an instace of Output. In this case we are interested in putting the rhombus insde a String.
			Output stringOutput = new StringOutput();

			// Convert the rhombus into a String.
			this.rhombusPrinter.prettyPrintConverter(rhombus, stringOutput);

			// return the rhombus as a string value.
			response = stringOutput.toString();

			return new ResponseEntity<String>(response, HttpStatus.OK);
		} catch (IllegalArgumentException ex) {
			response = ex.getMessage();

			return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
		}

	}

}
