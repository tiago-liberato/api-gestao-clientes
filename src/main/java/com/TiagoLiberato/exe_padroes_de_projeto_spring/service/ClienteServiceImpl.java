package com.TiagoLiberato.exe_padroes_de_projeto_spring.service;

import com.TiagoLiberato.exe_padroes_de_projeto_spring.exception.ClientAlreadyExists;
import com.TiagoLiberato.exe_padroes_de_projeto_spring.model.Cliente;
import com.TiagoLiberato.exe_padroes_de_projeto_spring.model.Endereco;
import com.TiagoLiberato.exe_padroes_de_projeto_spring.repository.ClienteRepository;
import com.TiagoLiberato.exe_padroes_de_projeto_spring.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    ViaCepService viaCep;

    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void inserir(Cliente cliente) {
        cliente.setId(null);
        cliente.getEndereco().setId(null);
        if(!clienteRepository.existsByCpf(cliente.getCpf())) {
            SalvarClienteComCep(cliente);
        }else{
            throw new ClientAlreadyExists("Cliente já existe");
        }
    }


    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clientebd = clienteRepository.findById(id);
        if(clientebd.isPresent()) {
            cliente.setId(id);
            SalvarClienteComCep(cliente);
        }
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }


    private void SalvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findByCep(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCep.buscarEndereco(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

}