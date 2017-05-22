package edu.uestc.msstudio.supermt.cloud.web.controller;

import edu.uestc.msstudio.supermt.cloud.model.User;
import edu.uestc.msstudio.supermt.cloud.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public class UserDataExportController
{
    @Autowired
    private UserRepository userDao;

    @GetMapping("/{id}")
    public HttpEntity<?> getUserByID(@PathVariable Long id)
    {
        User target = userDao.findOne(id);
        if (target != null)
            return ResponseEntity.ok(target);
        else
            return ResponseEntity.status(404).body("There is no target Entity");
    }

    @GetMapping ("/")
    public HttpEntity<?> getUserByName(
            @RequestParam String name,
            @RequestParam (defaultValue = "20") int size,
            @RequestParam (defaultValue = "1") int num,
            @RequestParam (defaultValue = "true") boolean sort)
    {
        Pageable pageable = new PageRequest(num - 1, size, Sort.Direction.ASC,
                "id");
        if (!sort) pageable = new PageRequest(num - 1, size, Sort.Direction
                .DESC, "id");
        Page<User> targets = userDao.findByUsername(pageable, name);
        if (targets.getContent().size() == 0)
            return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(targets);
    }
}