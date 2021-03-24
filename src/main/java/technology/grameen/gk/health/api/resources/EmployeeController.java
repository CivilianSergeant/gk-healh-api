package technology.grameen.gk.health.api.resources;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import technology.grameen.gk.health.api.entity.Employee;
import technology.grameen.gk.health.api.projection.EmployeeRestTemplateObject;
import technology.grameen.gk.health.api.requests.EmployeeSyncRequestForAll;
import technology.grameen.gk.health.api.responses.*;
import technology.grameen.gk.health.api.services.EmployeeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @RequestMapping("")
    public ResponseEntity<List<Employee>> list(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @RequestMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee req){
        return new ResponseEntity<>(employeeService.addEmployee(req),HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<IResponse> getEmployees(@RequestHeader("Authorization") String authorization){

        try {
            URL url = new URL("http://training.ghrmplus.com/api/EmployeeInfo/GetEmployeesByFilter");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Authorization", authorization);
            con.setDoOutput(true);
            String jsonInputString = "{\"PageNumber\": 1, \"PageSize\": 200}";
            OutputStream os = con.getOutputStream();
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> map = mapper.readValue(response.toString(), Map.class);
            List<Object> employees = (List<Object>)map.get("Employees");
            return new ResponseEntity<>(new EntityCollectionResponse<>(200,employees),HttpStatus.OK);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new SimpleResponse(422,"No record found"),HttpStatus.OK);
    }

    @GetMapping("/remote-employees")
    public ResponseEntity<IResponse> getRemoteEmployees(@RequestHeader("Authorization") String authorization){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization",authorization);

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String url = "http://training.ghrmplus.com/api/EmployeeInfo/GetEmployeesByFilter";
            String jsonRequest = mapper.writeValueAsString(new EmployeeSyncRequestForAll());
            HttpEntity<String> requestBody = new HttpEntity<String>(jsonRequest,httpHeaders);
            String result = restTemplate.patchForObject(url,requestBody,String.class);
            EmployeeRestTemplateObject employees = mapper.readValue(result,EmployeeRestTemplateObject.class);
            return new ResponseEntity<>(new EntityResponse<>(200,employees),HttpStatus.OK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ExceptionResponse(422,"Sorry! try again later"),HttpStatus.OK);
    }
}
