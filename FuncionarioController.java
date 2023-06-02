package com.example.demo.controller;

import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.model.Funcionario;
import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nomeservico/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setDataNascimento(funcionarioDTO.getDataNascimento());
        funcionario.setTelefone(funcionarioDTO.getTelefone());
        funcionario.setEndereco(funcionarioDTO.getEndereco());
        funcionario.setSalario(funcionarioDTO.getSalario());

        Funcionario novoFuncionario = funcionarioService.cadastrarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @GetMapping("/{cpf}/calcularSalario")
    public ResponseEntity<Funcionario> calcularNovoSalario(@PathVariable String cpf) {
        Funcionario funcionario = funcionarioService.calcularNovoSalario(cpf);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        }
        return ResponseEntity.notFound().build();
    }
}