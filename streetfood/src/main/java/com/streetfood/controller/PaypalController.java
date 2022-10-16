//package com.streetfood.controller;
//
//import com.paypal.api.payments.Links;
//import com.paypal.api.payments.Payment;
//import com.paypal.base.rest.PayPalRESTException;
//import com.streetfood.pojo.Order;
//import com.streetfood.pojo.PaymentDto;
//import com.streetfood.service.impl.PaypalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class PaypalController {
//    @Autowired
//    PaypalService paypalService;
//
//    public static final String SUCCESS_URL = "pay/success";
//    public static final String CANCEL_URL = "pay/cancel";
//
//    @PostMapping("/pay")
//    public String payment(@ModelAttribute("payment") PaymentDto paymentdTO){
//        try {
//            Payment payment = paypalService.createPayment(paymentdTO.getPrice(), paymentdTO.getCurrency(),
//                    paymentdTO.getMethod(),
//                    paymentdTO.getIntent(),
//                    paymentdTO.getDesription(),
//                    "http://localhost:8080/" + CANCEL_URL,
//                    "http://localhost:8080/" + SUCCESS_URL);
//            for (Links links: payment.getLinks()){
//                if (links.getRel().equals("approval_url")){
//                    return "redirect:" +links.getHref();
//                }
//            }
//        } catch (PayPalRESTException e) {
//            throw new RuntimeException(e);
//        }
//        return "redirect:/";
//    }
//
//    @GetMapping(SUCCESS_URL)
//    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerId") String payerId){
//        try {
//            Payment payment = paypalService.excutePayment(paymentId, payerId);
//            if (payment.getState().equals("approved")){
//                return "success";
//            }
//        } catch (PayPalRESTException e) {
//            throw new RuntimeException(e);
//        }
//        return "redirect:/";
//    }
//
//    @GetMapping(CANCEL_URL)
//    public String cancelPay(){
//        return "cancel";
//    }
//}
