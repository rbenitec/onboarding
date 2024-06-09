package com.utp.hackaton.onborading.user_service.util;

import com.utp.hackaton.onborading.user_service.entity.EventEntity;
import com.utp.hackaton.onborading.user_service.entity.TestEntity;
import com.utp.hackaton.onborading.user_service.entity.UserEntity;
import com.utp.hackaton.onborading.user_service.model.dto.CreatedUserDto;
import com.utp.hackaton.onborading.user_service.repository.EventRepository;
import com.utp.hackaton.onborading.user_service.repository.TestRepository;
import com.utp.hackaton.onborading.user_service.repository.UserRepository;
import com.utp.hackaton.onborading.user_service.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LoadInfoDB {
    private final UserRepository userRepository;
    private final UserService userService;
    private final TestRepository testRepository;
    private final EventRepository eventRepository;

    @Autowired
    public LoadInfoDB(UserRepository userRepository, TestRepository testRepository, EventRepository eventRepository, UserService userService) {
        this.testRepository = testRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.userService = userService;
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

        /**
         * Load test users
         */

        TestEntity test1 = new TestEntity();
        test1.setTestA(86.30);
        test1.setTestB(75.50);
        test1.setTestC(63.20);
        test1.setTestD(96.32);
        test1.setAverage(84.50);
        test1.setUserId(1);
        testRepository.save(test1);

        TestEntity test2 = new TestEntity();
        test2.setTestA(95.30);
        test2.setTestB(75.50);
        test2.setTestC(89.30);
        test2.setTestD(92.40);
        test2.setAverage(81.20);
        test2.setUserId(2);
        testRepository.save(test2);

        TestEntity test3 = new TestEntity();
        test3.setTestA(95.30);
        test3.setTestB(69.90);
        test3.setTestC(79.89);
        test3.setTestD(99.90);
        test3.setAverage(80.20);
        test3.setUserId(3);
        testRepository.save(test3);

        TestEntity test4 = new TestEntity();
        test4.setTestA(75.40);
        test4.setTestB(60.50);
        test4.setTestC(80.40);
        test4.setTestD(70.40);
        test4.setAverage(71.60);
        test4.setUserId(4);
        testRepository.save(test4);

        TestEntity test5 = new TestEntity();
        test5.setTestA(86.30);
        test5.setTestB(75.50);
        test5.setTestC(63.20);
        test5.setTestD(96.32);
        test5.setAverage(75.60);
        test5.setUserId(5);
        testRepository.save(test5);

        TestEntity test6 = new TestEntity();
        test6.setTestA(86.30);
        test6.setTestB(75.50);
        test6.setTestC(63.20);
        test6.setTestD(96.32);
        test6.setAverage(90.60);
        test6.setUserId(6);
        testRepository.save(test6);

        TestEntity test7 = new TestEntity();
        test7.setTestA(86.30);
        test7.setTestB(75.50);
        test7.setTestC(63.20);
        test7.setTestD(96.32);
        test7.setAverage(92.50);
        test7.setUserId(7);
        testRepository.save(test7);

        TestEntity test8 = new TestEntity();
        test8.setTestA(86.30);
        test8.setTestB(75.50);
        test8.setTestC(63.20);
        test8.setTestD(96.32);
        test8.setAverage(93.60);
        test8.setUserId(8);
        testRepository.save(test8);

        TestEntity test9 = new TestEntity();
        test9.setTestA(86.30);
        test9.setTestB(75.50);
        test9.setTestC(63.20);
        test9.setTestD(96.32);
        test9.setAverage(60.90);
        test9.setUserId(9);
        testRepository.save(test9);

        TestEntity test10 = new TestEntity();
        test10.setTestA(98.60);
        test10.setTestB(95.50);
        test10.setTestC(96.60);
        test10.setTestD(91.50);
        test10.setAverage(96.70);
        test10.setUserId(10);
        testRepository.save(test10);

        loadInfoEvents();
        saveUserForDefault();
    }

    private void saveUserForDefault() {

        CreatedUserDto user = CreatedUserDto.builder()
                .username("u11")
                .password("123")
                .email("u11@utp.edu.pe")
                .names("Rogelio Vargas")
                .avatar("https://st2.depositphotos.com/1007566/12301/v/450/depositphotos_123013306-stock-illustration-avatar-man-cartoon.jpg")
                .campus("AREQUIPA")
                .dni("77777778")
                .build();
        userService.initializeUserAndTest(user);

        CreatedUserDto user1 = CreatedUserDto.builder()
                .username("u12")
                .password("123")
                .email("u13@utp.edu.pe")
                .names("Noemi Trinidad Linares")
                .avatar("https://st2.depositphotos.com/1007566/12301/v/450/depositphotos_123013306-stock-illustration-avatar-man-cartoon.jpg")
                .campus("AREQUIPA")
                .dni("77777778")
                .build();
        userService.initializeUserAndTest(user1);

        CreatedUserDto user2 = CreatedUserDto.builder()
                .username("u13")
                .password("123")
                .email("u13@utp.edu.pe")
                .names("Juana lisboa Moreno")
                .avatar("https://st2.depositphotos.com/1007566/12301/v/450/depositphotos_123013306-stock-illustration-avatar-man-cartoon.jpg")
                .campus("AREQUIPA")
                .dni("77777778")
                .build();
        userService.initializeUserAndTest(user2);
    }

    private void loadInfoEvents() {
        EventEntity event1 = new EventEntity();
        event1.setName("Bienvenida a la UTP");
        event1.setLugar("Auditorio Principal");
        event1.setImagenURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaQaTQ88TnLudIw8nISX-5ERbFmQtaBv9XgA&s");
        event1.setFecha(LocalDate.now());
        event1.setAvailable(1);
        eventRepository.save(event1);

        EventEntity event2 = new EventEntity();
        event2.setName("Taller de Orientación Académica");
        event2.setLugar("Sala de Conferencias B");
        event2.setImagenURL("https://www.bitacorarevista.com/web/wp-content/uploads/WhatsApp-Image-2022-01-27-at-9.56.00-AM-2.jpg");
        event2.setFecha(LocalDate.now());
        event2.setAvailable(1);
        eventRepository.save(event2);

        EventEntity event3 = new EventEntity();
        event3.setName("Tour por el Campus");
        event3.setLugar("Punto de Encuentro en la Entrada Principal");
        event3.setImagenURL("");
        event3.setFecha(LocalDate.now());
        event3.setAvailable(1);
        eventRepository.save(event3);

        EventEntity event4 = new EventEntity();
        event4.setName("Feria de Clubes y Actividades Extracurriculares");
        event4.setLugar("Plaza Central");
        event4.setImagenURL("https://www.bitacorarevista.com/web/wp-content/uploads/WhatsApp-Image-2022-01-27-at-9.56.00-AM-2.jpg");
        event4.setFecha(LocalDate.now());
        event4.setAvailable(1);
        eventRepository.save(event4);

        EventEntity event5 = new EventEntity();
        event5.setName("Sesión Informativa sobre Servicios Estudiantiles");
        event5.setLugar("Auditorio Secundario");
        event5.setImagenURL("https://dvc.com.pe/wp-content/uploads/Ampliacion-UTP-Norte-5.jpg");
        event5.setFecha(LocalDate.now());
        event5.setAvailable(1);
        eventRepository.save(event5);

        EventEntity event6 = new EventEntity();
        event6.setName("Charla sobre Vida Universitaria y Bienestar");
        event6.setLugar("Sala de Conferencias A");
        event6.setImagenURL("https://www.bitacorarevista.com/web/wp-content/uploads/SALA-BIM-960x720.jpg");
        event6.setFecha(LocalDate.now());
        event6.setAvailable(1);
        eventRepository.save(event6);

        EventEntity event7 = new EventEntity();
        event7.setName("Introducción a las Plataformas Digitales de la UTP");
        event7.setLugar("Laboratorio de Computación 1");
        event7.setImagenURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTAbXriiGnfEZQEVAW7D4E-gc0JCD9HxScGwAwToPrEFD0DjrZe5QLdCJ_vZfHLlry9PRU&usqp=CAU");
        event7.setFecha(LocalDate.now());
        event7.setAvailable(1);
        eventRepository.save(event7);

        EventEntity event8 = new EventEntity();
        event8.setName("Taller de Habilidades de Estudio y Gestión del Tiempo");
        event8.setLugar("Sala de Talleres 3");
        event8.setImagenURL("https://img.freepik.com/foto-gratis/orador-masculino-dando-presentacion-salon-taller-universitario-audiencia-o-sala-conferencias_155003-17907.jpg?size=626&ext=jpg&ga=GA1.1.672697106.1714867200&semt=ais");
        event8.setFecha(LocalDate.now());
        event8.setAvailable(1);
        eventRepository.save(event8);

        EventEntity event9 = new EventEntity();
        event9.setName("Reunión con Mentores Académicos");
        event9.setLugar("Aula Magna");
        event9.setImagenURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_bQ750GBLXALuhQbQB3VRhrst6QrnN_anWA&s");
        event9.setFecha(LocalDate.now());
        event9.setAvailable(1);
        eventRepository.save(event9);

        EventEntity event10 = new EventEntity();
        event10.setName("Sesión de Networking con Profesores y Compañeros");
        event10.setLugar("Cafetería Principal");
        event10.setImagenURL("https://cache.marriott.com/content/dam/marriott-renditions/ATLMQ/atlmq-sear-5826-hor-feat.jpg?output-quality=70&interpolation=progressive-bilinear&downsize=1920px:*");
        event10.setFecha(LocalDate.now());
        event10.setAvailable(1);
        eventRepository.save(event10);

    }
}
