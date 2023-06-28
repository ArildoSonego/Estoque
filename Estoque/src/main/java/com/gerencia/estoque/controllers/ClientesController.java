package com.gerencia.estoque.controllers;
import com.gerencia.estoque.models.ClientesModel;
import com.gerencia.estoque.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping ("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService servicoClientes;

    @GetMapping
    public ResponseEntity<List<ClientesModel>> buscaTodosClientes() {
        return new ResponseEntity<>(servicoClientes.buscaTodos(), HttpStatus.OK);
    }

    @GetMapping (value = "/{codigoCliente}")
    public ResponseEntity <Object> buscaUmCliente (@PathVariable Integer codigoCliente){
        if (servicoClientes.existeCliente(codigoCliente)) {
            return new ResponseEntity<>(servicoClientes.buscaUm(codigoCliente), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity <Object> incluiCliente (@RequestBody ClientesModel cliente){
        servicoClientes.inclui(cliente);
        return new ResponseEntity<>("Cliente criado com sucesso", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity <Object> alteraCliente (@RequestBody ClientesModel cliente) {
        if (servicoClientes.existeCliente(cliente.getCodigo())) {
            servicoClientes.altera(cliente);
            return new ResponseEntity<>("Cliente alterado com sucesso", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }

    @DeleteMapping (value = "/{codigoCliente}")
    public ResponseEntity <Object> apagaCliente (@PathVariable Integer codigoCliente) {
        if (servicoClientes.existeCliente(codigoCliente)) {
            servicoClientes.exclui(codigoCliente);
            return new ResponseEntity<>("Cliente excluído com sucesso", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Cliente não encontrado", HttpStatus.NOT_FOUND);
        }
    }

}