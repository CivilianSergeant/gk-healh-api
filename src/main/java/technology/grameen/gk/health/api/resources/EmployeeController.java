package technology.grameen.gk.health.api.resources;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import technology.grameen.gk.health.api.entity.Employee;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.projection.EmployeeRestTemplateObject;
import technology.grameen.gk.health.api.requests.EmployeeSyncRequestForAll;
import technology.grameen.gk.health.api.responses.*;
import technology.grameen.gk.health.api.services.EmployeeService;
import technology.grameen.gk.health.api.services.HealthCenterService;

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
    HealthCenterService centerService;

    public EmployeeController(EmployeeService employeeService,HealthCenterService centerService){
        this.employeeService = employeeService;
        this.centerService = centerService;
    }

    @RequestMapping("")
    public ResponseEntity<List<Employee>> list(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @RequestMapping("/add")
    public ResponseEntity<IResponse> addEmployee(@RequestBody Employee req,
                                                @RequestHeader("Authorization") String authorization){
        if(authorization.isEmpty()){
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.UNAUTHORIZED.value(), "Token not exist"),
                    HttpStatus.UNAUTHORIZED);
        }
        Optional<HealthCenter> center = centerService.findById(req.getCenter().getId());

        if(!center.isPresent()){
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    "Sorry! Center/Office not found"),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(),
                    employeeService.addEmployee(req)),HttpStatus.OK);
    }

    @GetMapping("/api-id/{apiEmployeeId}")
    public ResponseEntity<IResponse> getEmployeeByApiEmployeeId(@PathVariable("apiEmployeeId") Long apiEmployeeId){
        return new ResponseEntity<>(new EntityResponse(HttpStatus.OK.value(),
                employeeService.getEmployeeByApiEmployeeId(apiEmployeeId)),HttpStatus.OK);
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
            String result = restTemplate.postForObject(url,requestBody,String.class);
            Map<String,Object> employees = mapper.readValue(result,Map.class);
            return new ResponseEntity<>(new EntityResponse<>(200,employees),HttpStatus.OK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ExceptionResponse(422,"Sorry! try again later"),HttpStatus.OK);
    }
}
