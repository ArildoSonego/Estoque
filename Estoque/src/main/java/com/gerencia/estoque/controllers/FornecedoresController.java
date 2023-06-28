package com.gerencia.estoque.controllers;
import com.gerencia.estoque.models.FornecedoresModel;
import com.gerencia.estoque.services.FornecedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping ("/fornecedores")
public class FornecedoresController {

    @Autowired
    private FornecedoresService servicoFornecedores;

    @GetMapping
    public ResponseEntity<List<FornecedoresModel>> buscaTodosFornecedores() {
        return new ResponseEntity<>(servicoFornecedores.buscatodos(), HttpStatus.OK);
    }

    @GetMapping (value = "/{codigoFornecedor}")
    public ResponseEntity <Object> buscaUmFornecedor (@PathVariable Integer codigoFornecedor){
        if (servicoFornecedores.existeFornecedor(codigoFornecedor)){
            return new ResponseEntity<>(servicoFornecedores.buscaUm(codigoFornecedor), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Fornecedor não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity <Object> incluiFornecedor (@RequestBody FornecedoresModel fornecedor){
        servicoFornecedores.inclui(fornecedor);
        return new ResponseEntity<>("Fornecedor criado com sucesso", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity <Object> alteraFornecedor (@RequestBody FornecedoresModel fornecedor) {
        if (servicoFornecedores.existeFornecedor(fornecedor.getCodigo())){
            servicoFornecedores.altera(fornecedor);
            return new ResponseEntity<>("Fornecedor alterado com sucesso", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Fornecedor não encontrado", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping (value = "/{codigoFornecedor}")
    public ResponseEntity <Object> apagaFornecedor (@PathVariable Integer codigoFornecedor){
        if (servicoFornecedores.existeFornecedor(codigoFornecedor)){
            servicoFornecedores.exclui(codigoFornecedor);
            return new ResponseEntity<>("Fornecedor excluído com sucesso", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Fornecedor não encontrado", HttpStatus.NOT_FOUND);
    }
}
