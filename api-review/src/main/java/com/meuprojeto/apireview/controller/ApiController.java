package com.meuprojeto.apireview.controller;

import com.meuprojeto.apireview.model.ApiEnt;
import com.meuprojeto.apireview.service.ApiEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis")
public class ApiController {

    @Autowired
    private ApiEntityService apiEntityService;

    @PostMapping
    public ResponseEntity<ApiEnt> createApi(@RequestBody ApiEnt api) {
        ApiEnt saved = apiEntityService.createApi(api);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<ApiEnt>> getAllApis() {
        return ResponseEntity.ok(apiEntityService.getAllApis());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiEnt> getApi(@PathVariable Long id) {
        ApiEnt found = apiEntityService.getApiById(id);
        if (found != null) {
            return ResponseEntity.ok(found);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiEnt> updateApi(@PathVariable Long id, @RequestBody ApiEnt api) {
        ApiEnt updated = apiEntityService.updateApi(id, api);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApi(@PathVariable Long id) {
        apiEntityService.deleteApi(id);
        return ResponseEntity.noContent().build();
    }
}
