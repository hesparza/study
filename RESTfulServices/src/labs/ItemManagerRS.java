/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labs;

import Model.Item;
import Model.dao.pojo.ItemDAO;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author hesparza
 */
@Path("items")
public class ItemManagerRS {
    
    ItemDAO itemDAO;
    
    @POST
    @Path("addItem/{description}")
    public String addItem(@PathParam("description") String description) { 
        Item newItem = itemDAO.add(null, description);
        return Long.toString(newItem.getId());
    }
    
    @POST
    @Path("formAdd/add")
    public String formAdd(@FormParam("description") String description) { 
        Item newItem = itemDAO.add(null, description);
        return Long.toString(newItem.getId());
    }
    
    @DELETE
    @Path("removeItem/{id}")
    public String removeItem(@PathParam("id") long id) { 
        itemDAO.remove(null, id);        
        return "Removed item";
    }
    
    @GET
    @Path("findItem/{id}")
    public Item findItem(@PathParam("id") long id) {         
        return itemDAO.find(null, id);
    }

}
