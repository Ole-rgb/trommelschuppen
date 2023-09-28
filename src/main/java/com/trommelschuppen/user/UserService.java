package com.trommelschuppen.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    JpaRepository<User,Long> userRepository;

    public ResponseEntity<User> findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }
        //user with id not found
        return ResponseEntity.notFound().build();    
    }

    public ResponseEntity<List<User>> getUserswithLimit(Optional<Integer> limit) {
        List<User> usersOptional = userRepository.findAll();//findAllUntilLimit(limit);
        return ResponseEntity.ok(usersOptional);
    }


}
