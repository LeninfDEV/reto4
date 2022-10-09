/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.ToolInterface;
import com.example.demo.Modelo.Tool;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenin
 */
@Repository
public class ToolRepository {
        @Autowired
    private ToolInterface extensionesCrud;
    
    public List<Tool> getAll(){
        return (List<Tool>) extensionesCrud.findAll();
    }
    
    public Optional <Tool> getTool (int id){
        return extensionesCrud.findById(id);  
    }
    
    public Tool save(Tool tool){
        return extensionesCrud.save(tool);
    }
    public void delete (Tool tool){
    extensionesCrud.delete(tool);
} 
}

