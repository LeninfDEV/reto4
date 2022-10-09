/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicios;

import com.example.demo.Modelo.Reservation;
import com.example.demo.Repositorio.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenin
 */

@Service
public class ReservationService {
  @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll (){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
            return reservationRepository.getReservation(id);       
    }
    
    public Reservation save (Reservation reservation){
        if (reservation.getIdReservation()== null){
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservarion1 = reservationRepository.getReservation(reservation.getIdReservation());
            if(reservarion1.isEmpty()){
                 return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }  

    public boolean deleteReservation(int id){
    Boolean d= getReservation(id).map(reservation ->{
    reservationRepository.delete(reservation);
    return true;
    }).orElse(false);
    return d;
}

    public Reservation update(Reservation reservation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
