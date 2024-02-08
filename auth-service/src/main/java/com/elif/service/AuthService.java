package com.elif.service;

import com.elif.dto.request.RegisterRequestDto;
import com.elif.entity.Auth;
import com.elif.exception.AuthServiceException;
import com.elif.exception.ErrorType;
import com.elif.mapper.AuthMapper;
import com.elif.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public Boolean register(RegisterRequestDto dto){
        //Burda kontrol yapmamız lazım, database'e bakıp böyle bir auth var mı diye username ve password kontrol edilecek
        Auth auth= AuthMapper.INSTANCE.fromRegisterAuthDtoToAuth(dto);

        Optional<Auth> optionalAuth= authRepository.findOptionalByUsernameAndPassword(auth.getUsername(), auth.getPassword());


        if (optionalAuth.isPresent()) {
            throw new AuthServiceException(ErrorType.ERROR_REGISTRATION);
        } else {
            //eger yoksa database'e kaydet
            authRepository.save(auth);
            return true;
        }

    }
}
