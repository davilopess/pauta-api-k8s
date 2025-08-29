package br.com.pauta.integration;

import br.com.pauta.exceptions.CpfUnableException;
import br.com.pauta.service.ValidarCpf;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CpfValidationIntegrationTest {
    @Autowired
    private ValidarCpf validarCpf;

    @Test
    void deveLancarExcecaoQuandoApiIndisponivel() {
        String cpfTeste = "99999999999";

        assertThrows(CpfUnableException.class, () -> {
            validarCpf.validar(cpfTeste);
        });
    }
}