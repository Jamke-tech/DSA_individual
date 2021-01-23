
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.HashMap;


@Api(value = "/covid19", description = "Endpoint to Covid Services")
@Path("/covid19")
public class Covid19ManagerService {

    private Covid19Manager mg19;

    public Covid19ManagerService() {
        this.mg19 = Covid19ManagerImpl.getInstance();
        //añadiremos 2 rebrotes con 2 casos cada brote para que no este vacio
        Brote brote1 = new Brote();
        Caso caso1 = new Caso(14, 2, 2020, "sospechoso");
        Caso caso2 = new Caso(28, 5, 2021, "confirmado");
        mg19.addBrote("1",brote1);
        mg19.addCase("1", caso1);
        mg19.addCase("1", caso2);
        Brote brote2 = new Brote();
        Caso caso3 = new Caso(30, 4, 2020, "confirmado");
        Caso caso4 = new Caso(18, 2, 2020, " no caso");
        mg19.addBrote("2",brote2);
        mg19.addCase("2", caso3);
        mg19.addCase("2", caso4);
    }
    @PUT
    @ApiOperation(value = "Añadir brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response addBrote(@PathParam("id") String id){

        Brote brote = new Brote();
        mg19.addBrote(id,brote);
        if(mg19.mostrarBrotes().get(id)==null) return Response.status(404).build();
        return Response.status(201).build();

    }
    @GET
    @ApiOperation(value = "get all Brotes", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = Brote.class, responseContainer="Hashmap"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mostrarBrotes() {

        HashMap<String,Brote> Brotes= this.mg19.mostrarBrotes();

        GenericEntity<HashMap<String,Brote>> entity = new GenericEntity<HashMap<String,Brote>>(Brotes) {};
        return Response.status(201).entity(entity).build()  ;

    }
    @POST
    @ApiOperation(value = "Añadir caso", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
    })
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCase(@PathParam("id") String id,Caso caso){

        mg19.addCase(id,caso);
        return Response.status(201).entity(caso).build();

    }
    @GET
    @ApiOperation(value = "get all cases from brote X", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = Brote.class, responseContainer="Hashmap"),
            @ApiResponse(code = 404, message = "Key not found"),
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mostrarCasos(@PathParam("id") String id) {

        if(this.mg19.mostrarBrotes().get(id)==null) return Response.status(404).build();
        else{
            ArrayList<Caso> listacasos = this.mg19.mostrarCasos(id);


            GenericEntity<ArrayList<Caso>> entity = new GenericEntity<ArrayList<Caso>>(listacasos) {
            };
            return Response.status(201).entity(entity).build();
        }
  

    }

}




