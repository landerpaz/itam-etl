package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.rule.ComputeEngineRule;
import com.example.demo.service.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final Gson gson = new Gson();

    @PostMapping
    public String createUser(@RequestBody User user) {
        userRepository.save(user);
        return "User created successfully!";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) throws Exception {
        //computeEngineRule.basicValidationGcp();

        try {

            //TODO : (IMPORTANANT) check the impact of creating objects dynamically and number of instances, any jvm heap memory issue. 
            //Also check the possibilities of setting instance limit
            //increase the core and memory size of pods
            //scale up more pods in zones and regions
            //put the below logic in delegate / bc and make it async, api will just invoke the delegate in async way and send response back to 
            //Main class which can be in different hydra service (kafka consumer). set time out in the rule api service (ex 5 seconds) so that 
            //consumer is not required to wait for long time incase rule api service is too busy as more instances are created for compute engine rule class
            //consumer service has to update the status of the couchbase staging document as "in progress" if it gets success response from rule service
            // "failed" for timeout, on failure response, just proceed to next record as failure record for system error will be taken care later.
            // rule service will update the final status as success or exceptio nmessage in couchbase document.
            //do the high load testing (IMPORTNANT)


            // Class name as a string
            //get the class names and method names via parameter to constructor
            String className = "com.example.demo.rule.GCPComputeEngineRuleImpl";
            String methodName1 = "basicValidationGcp";
            String methodName2 = "relationshipValidationGcp";
            String methodName3 = "dataMappingGcp";

            // Load the class dynamically
            Class<?> clazz = Class.forName(className);

            // Create a new instance using the default constructor
            Object obj = clazz.getDeclaredConstructor().newInstance();
            
            System.out.println(obj.getClass().getName());

            // Get the method reference (assuming no parameters)
            Method method1 = clazz.getDeclaredMethod(methodName1);
            Method method2 = clazz.getDeclaredMethod(methodName2);
            Method method3 = clazz.getDeclaredMethod(methodName3);

            // Invoke the method on the instance
            method1.invoke(obj);
            method2.invoke(obj);
            method3.invoke(obj);


            //performance code for method invocation
            // MethodHandles.Lookup lookup = MethodHandles.lookup();
            // MethodHandle handle = lookup.findVirtual(MyClass.class, "myMethod", MethodType.methodType(void.class));
            // handle.invoke(instance);


        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error creating object: " + e.getMessage());
        }

        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @GetMapping("/external")
    public String fetchExternalData() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        String response = restTemplate.getForObject(url, String.class);
        return gson.toJson(response);
    }
}

