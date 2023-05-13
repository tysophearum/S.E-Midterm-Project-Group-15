package com.example.demo.service.serviceImpl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    public User saveUser(User user, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..") || fileName.isEmpty())
		{
			System.out.println("not a a valid file");
		}

        // if(!user.isEmpty()){
            try {
                user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return userRepository.save(user);
        // }
        // else{
        //     return null;
        // }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }


    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
    
}
