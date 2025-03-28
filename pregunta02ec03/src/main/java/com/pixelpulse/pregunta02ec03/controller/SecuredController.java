package com.pixelpulse.pregunta02ec03.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SecuredController {
    @GetMapping("/venta")
    public String precioVenta(@RequestParam("nombre") String nomProducto,
                                @RequestParam("precioCompra") double precioCompra,
                                @RequestHeader("Authorization") String token) {
        // Validación del token
        if (token == null || !token.startsWith("Bearer ")){
            return "El token ingresado es inválido - Acceso denegado";
        }

        // Cálculo del margen de utilidad
        double margenUtilidad = (precioCompra >= 50 && precioCompra <= 100) ? precioCompra * 0.25 : precioCompra * 0.30;
        
        // Cálculo del flete
        double flete = (precioCompra > 20) ? 5.0 : 1.5;
        
        // Cálculo del IGV
        double igv = (precioCompra + margenUtilidad + flete) * 0.18;
        
        // Cálculo del precio de venta
        double precioVenta = precioCompra + margenUtilidad + flete + igv;

        // Retorno del resultado correctamente formateado
        return String.format("Producto: %s%nPrecio Venta: S/.%.2f", nomProducto, precioVenta);
    }
}