package com.example.apiFront.services;

import com.example.apiFront.dtos.CursoRequestDTO;
import com.example.apiFront.dtos.CursoResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CursoService {

    private final String API_URL = "http://localhost:8080/cursos";

    public List<CursoResponseDTO> listarCursos() {
        RestTemplate restTemplate = new RestTemplate();

        CursoResponseDTO[] resposta = restTemplate.getForObject(API_URL, CursoResponseDTO[].class);

        return resposta != null ? Arrays.asList(resposta) : List.of();
    }

    public void criarCurso(CursoRequestDTO cursoDTO) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(API_URL, cursoDTO, CursoResponseDTO.class);
    }

    public CursoResponseDTO buscarCursoPorId(UUID id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "/" + id;
        return restTemplate.getForObject(url, CursoResponseDTO.class);
    }

    public void atualizarCurso(UUID id, CursoRequestDTO cursoDTO) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "/" + id;
        restTemplate.put(url, cursoDTO);
    }


    public void deletarCurso(UUID id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "/" + id;
        restTemplate.delete(url);
    }
}