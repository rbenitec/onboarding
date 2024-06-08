package com.utp.hackaton.onborading.user_service.util;

import com.utp.hackaton.onborading.user_service.entity.UserEntity;
import com.utp.hackaton.onborading.user_service.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class LoadInfoDB {
    private final UserRepository userRepository;

    @Autowired
    public LoadInfoDB(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void cargarDatosDeUsuarios() {
        // Cargar datos iniciales en la tabla "cambios"
        UserEntity user_1 = new UserEntity();
        user_1.setNames("Roberto Benitez Cruzado");
        user_1.setDni("74258585");
        user_1.setCampus("AREQUIPA");
        user_1.setEmail("u1@utpe.edu.pe");
        user_1.setAvatar("https://img.freepik.com/psd-gratis/ilustracion-3d-avatar-o-perfil-humano_23-2150671116.jpg?w=740&t=st=1717867021~exp=1717867621~hmac=0dabc3144ba925f452070e0fa21e5a38a5e28724abece2a7557667988fc84627");
        user_1.setUsername("u1");
        user_1.setPassword("1000");
        user_1.setCreatedAt(LocalDate.now());
        userRepository.save(user_1);

        UserEntity user_2 = new UserEntity();
        user_2.setNames("Ruben Saul Dominguez");
        user_2.setDni("56455452");
        user_2.setCampus("AREQUIPA");
        user_2.setEmail("u2@utpe.edu.pe");
        user_2.setAvatar("https://img.freepik.com/psd-gratis/ilustracion-3d-avatar-o-perfil-humano_23-2150671161.jpg?w=740&t=st=1717867047~exp=1717867647~hmac=61fa1a60af5dc3a7f33404b1dd16a71872aeb0ed75ee92a742b4bb46216c54d8");
        user_2.setUsername("u2");
        user_2.setPassword("2000");
        user_2.setCreatedAt(LocalDate.now());
        userRepository.save(user_2);

        UserEntity user_3 = new UserEntity();
        user_3.setNames("Jean Pool Guitierrez");
        user_3.setDni("78785454");
        user_3.setCampus("AREQUIPA");
        user_3.setEmail("u3@utpe.edu.pe");
        user_3.setAvatar("https://img.freepik.com/psd-gratis/ilustracion-3d-avatar-o-perfil-humano_23-2150671134.jpg?w=740&t=st=1717867068~exp=1717867668~hmac=25584cde96612cbcf06016f51714f78fb8d5b15353a09c0122151696afec79c8");
        user_3.setUsername("u3");
        user_3.setPassword("3000");
        user_3.setCreatedAt(LocalDate.now());
        userRepository.save(user_3);

        UserEntity user_4 = new UserEntity();
        user_4.setNames("Fabricio Gutierrez");
        user_4.setDni("96636311");
        user_4.setCampus("AREQUIPA");
        user_4.setEmail("u4@utpe.edu.pe");
        user_4.setAvatar("https://img.freepik.com/psd-gratis/ilustracion-3d-avatar-o-perfil-humano_23-2150671151.jpg?w=740&t=st=1717867094~exp=1717867694~hmac=cd92202e8237b6dac4e3b3ec9ff92fc73ac4e64652cae07bdb175550563f6e96");
        user_4.setUsername("u4");
        user_4.setPassword("4000");
        user_4.setCreatedAt(LocalDate.now());
        userRepository.save(user_4);

        UserEntity user_5 = new UserEntity();
        user_5.setNames("Cesar German Matos");
        user_5.setDni("112233445");
        user_5.setCampus("AREQUIPA");
        user_5.setEmail("u5@utpe.edu.pe");
        user_5.setAvatar("https://img.freepik.com/psd-gratis/ilustracion-3d-avatar-o-perfil-humano_23-2150671124.jpg?w=740&t=st=1717867119~exp=1717867719~hmac=a9cbcdc98f724f863c9f51c0fdb34b982b4ec09338f19262fe3afa99e4c8bb7f");
        user_5.setUsername("u5");
        user_5.setPassword("1000");
        user_5.setCreatedAt(LocalDate.now());
        userRepository.save(user_5);

        // Cargar datos iniciales en la tabla "cambios"
        UserEntity user_6 = new UserEntity();
        user_6.setNames("Lorena Quispe Areas");
        user_6.setDni("32125252");
        user_6.setCampus("AREQUIPA");
        user_6.setEmail("u6@utpe.edu.pe");
        user_6.setAvatar("https://img.freepik.com/psd-gratis/ilustracion-3d-avatar-o-perfil-humano_23-2150671132.jpg?t=st=1717867630~exp=1717868230~hmac=29e25192932da35771f0fc58ab5768b12d617b13c9a6e91433e2e5f42e748452");
        user_6.setUsername("u6");
        user_6.setPassword("6000");
        user_6.setCreatedAt(LocalDate.now());
        userRepository.save(user_6);

        UserEntity user_7 = new UserEntity();
        user_7.setNames("Daniela Mendez Gomez");
        user_7.setDni("89562431");
        user_7.setCampus("AREQUIPA");
        user_7.setEmail("u7@utpe.edu.pe");
        user_7.setAvatar("https://img.freepik.com/psd-gratis/ilustracion-3d-avatar-o-perfil-humano_23-2150671128.jpg?w=740&t=st=1717867411~exp=1717868011~hmac=e1444b090f3edbe3fff2399ed017d9ebbb563c9913de413bb5b16f0dadf1e127");
        user_7.setUsername("u7");
        user_7.setPassword("7000");
        user_7.setCreatedAt(LocalDate.now());
        userRepository.save(user_7);

        UserEntity user_8 = new UserEntity();
        user_8.setNames("Maria Castillo Flores");
        user_8.setDni("23232323");
        user_8.setCampus("AREQUIPA");
        user_8.setEmail("u8@utpe.edu.pe");
        user_8.setAvatar("https://img.freepik.com/psd-gratis/ilustracion-3d-avatar-o-perfil-humano_23-2150671118.jpg?w=740&t=st=1717867481~exp=1717868081~hmac=a7bb0bda897c95a2995f451925851168f085ee6a40a13f647aea2a450b37ca8d");
        user_8.setUsername("u8");
        user_8.setPassword("8000");
        user_8.setCreatedAt(LocalDate.now());
        userRepository.save(user_8);

        UserEntity user_9 = new UserEntity();
        user_9.setNames("Fiorella Clemente Mendoza");
        user_9.setDni("98989898");
        user_9.setCampus("AREQUIPA");
        user_9.setEmail("u9@utpe.edu.pe");
        user_9.setAvatar("https://img.freepik.com/psd-gratis/ilustracion-3d-avatar-o-perfil-humano_23-2150671120.jpg?w=740&t=st=1717867543~exp=1717868143~hmac=6acbe8ca709a661eb7f376b899162b6387e56321ab36fd696c51a4b4ab1fd377");
        user_9.setUsername("u9");
        user_9.setPassword("9000");
        user_9.setCreatedAt(LocalDate.now());
        userRepository.save(user_9);

        UserEntity user_10 = new UserEntity();
        user_10.setNames("Liliana Porras Ugarte");
        user_10.setDni("96363322");
        user_10.setCampus("AREQUIPA");
        user_10.setEmail("u10@utpe.edu.pe");
        user_10.setAvatar("https://img.freepik.com/psd-gratis/ilustracion-3d-avatar-o-perfil-humano_23-2150671165.jpg?w=740&t=st=1717867630~exp=1717868230~hmac=388e30dcdac168da1eb7e64eaa7935ec1ea6d1e71138c80ac05aaf905094f194");
        user_10.setUsername("u10");
        user_10.setPassword("1001");
        user_10.setCreatedAt(LocalDate.now());
        userRepository.save(user_10);

    }
}
