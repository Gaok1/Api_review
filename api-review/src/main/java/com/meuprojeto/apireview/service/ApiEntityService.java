package com.meuprojeto.apireview.service;

import com.meuprojeto.apireview.model.ApiEnt;
import com.meuprojeto.apireview.repository.ApiEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiEntityService {

    @Autowired
    private ApiEntityRepository apiEntityRepository;

    public ApiEnt createApi(ApiEnt api) {
        return apiEntityRepository.save(api);
    }

    public List<ApiEnt> getAllApis() {
        return apiEntityRepository.findAll();
    }

    public ApiEnt getApiById(Long id) {
        return apiEntityRepository.findById(id).orElse(null);
    }

    public ApiEnt updateApi(Long id, ApiEnt updatedApi) {
        ApiEnt existingApi = getApiById(id);
        if (existingApi != null) {
            existingApi.setName(updatedApi.getName());
            existingApi.setDescription(updatedApi.getDescription());
            existingApi.setBaseUrl(updatedApi.getBaseUrl());
            return apiEntityRepository.save(existingApi);
        }
        return null;
    }

    public void deleteApi(Long id) {
        apiEntityRepository.deleteById(id);
    }
}
