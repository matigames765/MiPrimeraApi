package com.example.miPrimeraApi.controllers;

import com.example.miPrimeraApi.entities.Pedido;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mp")
public class MercadoPagoController {

    @Value("${codigo.mercadoPago}")
    private String mpToken;

    @PostMapping()
    public String getList(@RequestBody Pedido pedido){
        if (pedido == null){
            return "Error recibiendo pedido";
        }

        String title = "Pedido nro " + pedido.getId();
        int quantity = 1;
        Double price = pedido.getTotal();

        try{
            MercadoPagoConfig.setAccessToken(mpToken);

            List<PreferenceItemRequest> items = new ArrayList<PreferenceItemRequest>();

            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .title(title)
                    .quantity(quantity)
                    .unitPrice(new BigDecimal(price))
                    .currencyId("ARS")
                    .build();

            items.add(itemRequest);


            PreferenceBackUrlsRequest backUrlsRequest = PreferenceBackUrlsRequest.builder()
                    .success("direccion por pago exitoso")
                    .pending("direccion por pago pendiente")
                    .failure("direccion por pago fallido")
                    .build();


            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .backUrls(backUrlsRequest)
                    .build();


            PreferenceClient client = new PreferenceClient();

            Preference preference = client.create(preferenceRequest);

            return preference.getId();
        }catch (MPException | MPApiException mpE){
            return mpE.getMessage();
        }
    }
}
