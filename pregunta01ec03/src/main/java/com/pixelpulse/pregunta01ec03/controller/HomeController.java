package com.pixelpulse.pregunta01ec03.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pixelpulse.pregunta01ec03.model.Cliente;
import com.pixelpulse.pregunta01ec03.model.Prestamo;
import com.pixelpulse.pregunta01ec03.model.Rol;
import com.pixelpulse.pregunta01ec03.payload.AutenticacionLogin;
import com.pixelpulse.pregunta01ec03.payload.AutenticacionResponse;
import com.pixelpulse.pregunta01ec03.security.service.MiUserDetailsService;
import com.pixelpulse.pregunta01ec03.security.utils.JwtUtil;
import com.pixelpulse.pregunta01ec03.service.ClienteService;
import com.pixelpulse.pregunta01ec03.service.PrestamoService;
import com.pixelpulse.pregunta01ec03.service.RolService;

@RestController
@RequestMapping("/api")
public class HomeController {

    
    private RolService rolService;
    private ClienteService clienteService;
    private BCryptPasswordEncoder passwordEncoder;
    private AuthenticationManager authManager;
    private MiUserDetailsService miUserDetailsService;
    private JwtUtil jwtUtil;
    private PrestamoService prestamoService;

    public HomeController(RolService rolService, 
        ClienteService clienteService, 
        BCryptPasswordEncoder passwordEncoder, 
        AuthenticationManager authManager,
        MiUserDetailsService miUserDetailsService,
        JwtUtil jwtUtil,
        PrestamoService prestamoService)
    {
        this.clienteService = clienteService;
        this.rolService = rolService;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
        this.miUserDetailsService = miUserDetailsService;
        this.jwtUtil = jwtUtil;
        this.prestamoService = prestamoService;
    }

    @GetMapping("/public")
    public String homePublic(){
        return "Bienvenidos a la Financiera Chiguan – prestamos a los más bajos intereses!";
	}

    @PostMapping("/registrarse")
    public ResponseEntity<?> registrarse(@RequestBody Cliente cliente){
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        Rol rol = rolService.getById(3);
        cliente.agregarRoleALista(rol);
        cliente.setEstado(true);
        clienteService.insert(cliente);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }
    @PostMapping("/iniciar")
    public ResponseEntity<?> iniciarSesion(@RequestBody AutenticacionLogin autLogin) throws Exception{
        //autLogin.getPassword();
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(autLogin.getUsername(), autLogin.getPassword())
            );

        }catch (BadCredentialsException ex){
            throw new Exception("Error en el username o contraseña " + ex.getMessage());
        } 

        final UserDetails userDetails = miUserDetailsService.loadUserByUsername(autLogin.getUsername());
        final String token = jwtUtil.createToken(userDetails);

        // Regresamos el token
        return ResponseEntity.ok(new AutenticacionResponse(token));
    }

    @GetMapping("/prestamo")
    public String validarPrestamo(@RequestParam String token, @RequestParam Long numeroPrestamo) {
        // Extraer el nombre del usuario desde el token
        String nombreCliente = jwtUtil.extraerUsername(token);
        UserDetails userDetails = miUserDetailsService.loadUserByUsername(nombreCliente);
        // Validar el token
        if (!jwtUtil.validarToken(token, userDetails)) {
            return "Token inválido.";
        }
        // Buscar el préstamo en la base de datos
        Prestamo prestamo = prestamoService.getById(numeroPrestamo);

        if (prestamo != null) {
            return "¡¡¡Cliente " + nombreCliente + ", su préstamo de " + prestamo.getImportePrestado() + " ha sido validado y aceptado con éxito!!!";
        }else{
            return "Préstamo no encontrado.";
        }
    }
}
