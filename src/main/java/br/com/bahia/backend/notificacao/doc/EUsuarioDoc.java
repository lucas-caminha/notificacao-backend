package br.com.bahia.backend.notificacao.doc;

import br.com.bahia.backend.notificacao.dto.EUsuarioCreateDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Tag(name = "Usuario", description = "Endpoints do Usuario")
public interface EUsuarioDoc {

    @Operation(summary = "Buscar um usuário", description = "Faz a busca do usuário. ")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuario retornado!"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    ResponseEntity<EUsuarioDTO> getEUsuario(@PathVariable("id") Integer idEUsuario);

    @Operation(summary = "Cadastrar usuário", description = "Faz cadastro de um novo usuário. ")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Usuário criado!"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    ResponseEntity<EUsuarioDTO> insertEUsuario(@RequestBody EUsuarioCreateDTO eusuarioCreateDTO);

    @Operation(summary = "Atualizar usuário", description = "Faz a atualização do usuário. ")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuário atualizado!"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    ResponseEntity<EUsuarioDTO> updateEUsuario(@PathVariable("id") Integer idEUsuario, @RequestBody EUsuarioUpdateDTO eusuarioUpdateDTO);

    @Operation(summary = "Deletar usuário", description = "Deleta um usuário. ")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuário deletado!"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteEUsuario(@PathVariable("id") Integer idEUsuario);
}
