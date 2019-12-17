package com.example.resource;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.request.vo.UserRegistrationInput;
import com.example.response.vo.UserRegistrationOutput;
import com.example.util.PDFGenerator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/v3")
@Slf4j
public class PdfResource {
	
 //  @Autowired
//	UserRegistrationService  userRegistrationService;
	
	@ApiOperation(value="pdfGeneration", tags = "pdfGeneration")
	@ApiResponses(value= {
	@ApiResponse(code=200,message="Created sussessfully"),
	@ApiResponse(code=401,message="UnAuthorized"),
	@ApiResponse(code=403,message="Forbidden"),
	@ApiResponse(code=404,message="Resource not Found")
	})
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "REQUEST_ID", value = "REQUEST_ID", required = false, dataType = "String", paramType = "header"),
	  //  @ApiImplicitParam(name = "email", value = "User's email", required = false, dataType = "string", paramType = "query"),
	  //  @ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "long", paramType = "query")
	  })
	@RequestMapping( value= "/pdf", produces= MediaType.APPLICATION_PDF_VALUE,consumes= {"application/json"} ,method = RequestMethod.POST)
	public ResponseEntity<InputStreamResource> report(@RequestBody String customers) {
		
		   
		        ByteArrayInputStream bis = PDFGenerator.customerPDFReport(customers);
		 
		        HttpHeaders headers = new HttpHeaders();
		        headers.add("Content-Disposition", "inline; filename=customers.pdf");

		        
		 
		        return ResponseEntity
		                .ok()
		                .headers(headers)
		               .contentType(MediaType.APPLICATION_PDF)
		                .body(new InputStreamResource(bis));
		    }
	
	
	

}
