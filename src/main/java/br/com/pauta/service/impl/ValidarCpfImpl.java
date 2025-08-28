package br.com.pauta.service.impl;

import br.com.pauta.dto.CpfResponseDTO;
import br.com.pauta.exceptions.CpfUnableException;
import br.com.pauta.service.ValidarCpf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ValidarCpfImpl implements ValidarCpf {
    @Override
    public boolean validar(String cpf) {
        try{
            String uri = "https://user-info.herokuapp.com/users/{cpf}";
            RestTemplate restTemplate = new RestTemplate();

            CpfResponseDTO result = restTemplate.getForObject(uri, CpfResponseDTO.class, cpf);

            return result.getStatus().equals("ABLE_TO_VOTE") ? true : false;
        }catch (Exception e){
            log.error("Erro ao fazer requisição externa para validação de CPF", e);
            throw new CpfUnableException("Erro ao validar CPF");
        }
    }
}
